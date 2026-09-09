package com.example.concurrency;

public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        int threadCount = 4;
        int incrementsPerThread = 50_000;

        UnsafeCounter unsafeCounter = new UnsafeCounter();
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    unsafeCounter.increment();
                }
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        int expectedTotal = threadCount * incrementsPerThread;
        System.out.println("Unsafe counter: " + unsafeCounter.getValue());
        System.out.println("Expected total: " + expectedTotal);
        System.out.println("Notice how the final value usually falls short when threads race on the same variable.");
    }

    private static final class UnsafeCounter {
        private int value;

        public void increment() {
            // This operation is not atomic under concurrent access.
            value++;
        }

        public int getValue() {
            return value;
        }
    }
}
