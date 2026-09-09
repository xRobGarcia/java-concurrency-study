package com.example.concurrency;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ThreadSafeCounterTest {

    @Test
    void incrementShouldMatchExpectedValueAcrossThreads() throws InterruptedException {
        ThreadSafeCounter counter = new ThreadSafeCounter();
        int threadCount = 8;
        int incrementsPerThread = 25_000;
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < incrementsPerThread; j++) {
                    counter.increment();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        assertEquals(threadCount * incrementsPerThread, counter.get());
    }
}
