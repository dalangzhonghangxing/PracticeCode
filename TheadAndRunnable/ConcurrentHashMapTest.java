package TheadAndRunnable;

import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapTest {
    static class key implements Comparable<key> {

        @Override
        public int compareTo(key o) {

            return 0;
        }

        @Override
        public int hashCode() {
            return 1;
        }

    }

    public static void main(String[] args) {
        int n = 100;
        ConcurrentHashMap<key, String> a = new ConcurrentHashMap<>();
        key k = new key();
        for (int i = 0; i < 100; i++) {
            a.put(k, String.valueOf(i));
        }
        a.size();
    }

}
