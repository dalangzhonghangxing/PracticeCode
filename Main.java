import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

// 使用ReentrantLock
class LockRunnable implements Runnable {
    static int i = 0;

    private ReentrantLock lock;

    private int loopNumber;

    public LockRunnable(ReentrantLock lock, int loopNumber) {
        this.lock = lock;
        this.loopNumber = loopNumber;
    }

    @Override
    public void run() {

        // 将加锁解锁卸载for放在内部，从而让锁的竞争变得激烈
        for (int j = 0; j < loopNumber; j++) {
            try {
                lock.lock();
                this.i++;
            } finally {
                lock.unlock();
            }
        }

    }
}

// 使用AtomicInteger，其底层实现是CAS
class CASRunnable implements Runnable {

    private char c;

    private Semaphore s;

    public CASRunnable(char c, Semaphore s) {
        this.c = c;
        this.s = s;
    }

    @Override
    public void run() {
        try {
            s.acquire();
            System.out.println(c);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            s.release();
        }

    }
}

// 使用AtomicInteger，其底层实现是CAS
class SemaphoreRunnable implements Runnable {

    private char c;

    private Semaphore as;

    private Semaphore rs;

    public SemaphoreRunnable(char c, Semaphore as, Semaphore rs) {
        this.c = c;
        this.as = as;
        this.rs = rs;
    }

    @Override
    public void run() {
        while (true)
            try {
                as.acquire();
                System.out.println(c);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } finally {
                rs.release();
            }

    }
}

public class Main {
    static ReentrantLock lock = new ReentrantLock();
    final static int THREAD_NUMBER = 1000;

    public static void main(String[] args) {
        ExecutorService service = Executors.newScheduledThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                Integer.parseInt("asdf");
            }
        });
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(Integer.parseInt("111"));
            }
        });
        service.shutdown();

    }

    public static void copy(Map<String, Object> target) {
        Map<String, Object> t = new HashMap<String, Object>();
        t.put("a", "a");
        target.put("a", "a");
    }
}