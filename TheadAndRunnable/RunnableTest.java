package TheadAndRunnable;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class RunnableTest {
    final static CountDownLatch latch = new CountDownLatch(4);
    final static CountDownLatch atomicLatch = new CountDownLatch(4);
    volatile int count = 0;
    AtomicInteger atomicCount = new AtomicInteger(0);

    public static void main(String[] args) {
        Date begin = new Date();
        new RunnableTest().testVolatileAndSynchronized();
        try {
            latch.await();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Date end = new Date();
        System.out.println(end.getTime() - begin.getTime());

        begin = new Date();
        new RunnableTest().testAtomicInteger();
        try {
            atomicLatch.await();
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        end = new Date();
        System.out.println(end.getTime() - begin.getTime());
    }

    public void testVolatileAndSynchronized() {
        Thread thread_0 = getThread("thread_0");
        Thread thread_1 = getThread("thread_1");
        Thread thread_2 = getThread("thread_2");
        Thread thread_3 = getThread("thread_3");
        thread_0.start();
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }

    public void testAtomicInteger() {
        Thread thread_0 = getAtomicThread("thread_0");
        Thread thread_1 = getAtomicThread("thread_1");
        Thread thread_2 = getAtomicThread("thread_2");
        Thread thread_3 = getAtomicThread("thread_3");
        thread_0.start();
        thread_1.start();
        thread_2.start();
        thread_3.start();
    }

    public Thread getThread(String name) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    synchronized (RunnableTest.class) {
                        count++;
//                        System.out.println(Thread.currentThread().getName()
//                                + "\t" + count);
                    }
                }
                latch.countDown();
            }
        });
        thread.setName(name);
        return thread;
    }

    public Thread getAtomicThread(String name) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000000; i++) {
                    atomicCount.incrementAndGet();
                }
                atomicLatch.countDown();
            }
        });
        thread.setName(name);
        return thread;
    }
}
