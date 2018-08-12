import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TestReaderWriter {
    volatile int readerCount = 0;
    volatile int writerCount = 0;
    ReentrantLock readerCountLock = new ReentrantLock();
    ReentrantLock writerCountLock = new ReentrantLock();
    Condition hasWriterCondition = writerCountLock.newCondition();

    ReentrantLock resourceLock = new ReentrantLock();

    void read() throws InterruptedException {
        writerCountLock.lock();
        while (writerCount > 0) {
            System.out.println(
                    "前--hasWriterCondition调用await，目前writerCountLock是否加锁:"
                            + writerCountLock.isLocked());
            hasWriterCondition.await();
            System.out.println(
                    "后--hasWriterCondition调用await，目前writerCountLock是否加锁:"
                            + writerCountLock.isLocked());
        }
        writerCountLock.unlock();

        readerCountLock.lock();
        if (readerCount == 0) { // 第一个来读的读者
            resourceLock.lock();
        }
        readerCount++;
        readerCountLock.unlock();
        //
        System.out.println(Thread.currentThread().getId() + " is reading");
        //
        readerCountLock.lock();
        readerCount--;
        if (readerCount == 0) {
            resourceLock.unlock();
        }
        readerCountLock.unlock();
    }

    void write() throws InterruptedException {
        writerCountLock.lock();
        writerCount++;
        writerCountLock.unlock();

        resourceLock.lock();
        System.out.println(Thread.currentThread().getId() + " is writing");
        resourceLock.unlock();

        writerCountLock.lock();
        writerCount--;
        hasWriterCondition.signalAll();
        writerCountLock.unlock();
    }

    public static void main(String[] args) {
        TestReaderWriter testReaderWriter = new TestReaderWriter();
        Runnable writerRunnable = () -> {
            try {
                testReaderWriter.write();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable readerRunnable = () -> {
            try {
                testReaderWriter.read();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ScheduledExecutorService executorService = Executors
                .newScheduledThreadPool(20);
        for (int i = 0; i < 3; i++) {
            executorService.scheduleAtFixedRate(readerRunnable, 0,
                    randomLongBetween(1, 3), TimeUnit.SECONDS);
            executorService.scheduleAtFixedRate(writerRunnable, 0,
                    randomLongBetween(1, 2), TimeUnit.SECONDS);
        }
    }

    /**
     * 返回介于left和right之间的long类型的随机数
     *
     * @param left
     *            小值
     * @param right
     *            大值
     * @return 介于left和right之间的long类型的随机数
     */
    static long randomLongBetween(long left, long right) {
        long result = left + (long) (Math.random() * (right - left));
        System.out.println(result);
        return result;
    }
}
