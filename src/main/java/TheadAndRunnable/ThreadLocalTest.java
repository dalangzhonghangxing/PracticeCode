package TheadAndRunnable;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> iThreadLocal = new ThreadLocal<Integer>() {
        protected Integer initialValue() {
            return 0;
        };
    };

    public Integer nextValue() {
        iThreadLocal.set(iThreadLocal.get() + 1);
        System.out.println("外面"+Thread.currentThread());
        return iThreadLocal.get();
    }

    static class seqThread extends Thread {
        private ThreadLocalTest t;

        public seqThread(ThreadLocalTest t) {
            this.t = t;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++)
                System.out.println(Thread.currentThread() + " i:"
                        + t.nextValue());
        }
    }

    public static void main(String[] args) {
        ThreadLocalTest t = new ThreadLocalTest();
        seqThread t1 = new seqThread(t);
        seqThread t2 = new seqThread(t);
        seqThread t3 = new seqThread(t);
        seqThread t4 = new seqThread(t);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
