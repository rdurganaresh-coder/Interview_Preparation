package com.corejava.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrencyDemo {

    public static int runAtomicIncrements(int tasks) {
        AtomicInteger counter = new AtomicInteger(0);
        CompletableFuture<?>[] futures = new CompletableFuture[tasks];
        for (int i = 0; i < tasks; i++) {
            futures[i] = CompletableFuture.runAsync(counter::incrementAndGet);
        }
        CompletableFuture.allOf(futures).join();
        return counter.get();
    }

    public static void main(String[] args) {
        System.out.println("Final count: " + runAtomicIncrements(100));
    }
}
