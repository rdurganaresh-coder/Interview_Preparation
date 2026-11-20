package com.mastery.corejava.concurrency;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class VirtualThreadsDemo {

    public List<String> runTasksConcurrently(List<String> inputs) throws Exception {
        try (ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Callable<String>> tasks = inputs.stream()
                    .map(item -> (Callable<String>) () -> "Processed:" + item.toUpperCase())
                    .toList();
            List<String> results = new java.util.ArrayList<>();
            for (Future<String> f : executor.invokeAll(tasks)) {
                results.add(f.get());
            }
            return results;
        }
    }
}
