# Java Multithreading & Concurrency Notes

- **Virtual Threads:** Lightweight threads managed by the JVM (`Executors.newVirtualThreadPerTaskExecutor()`), ideal for high-throughput blocking I/O tasks.
- **CompletableFuture:** Enables non-blocking asynchronous pipelines (`thenApply`, `thenCompose`, `allOf`).
- **Synchronization:** Prefer `ReentrantLock`, `ConcurrentHashMap`, and `AtomicInteger` over coarse `synchronized` blocks.
