package com.learning.threads;

import java.util.concurrent.Executors;

public class VirtualThreadsDemo {
    public static void main(String[] args) {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 1; i <= 5; i++) {
                int taskId = i;
                executor.submit(() -> System.out.println("Running task " + taskId + " on " + Thread.currentThread()));
            }
        }
    }
}
