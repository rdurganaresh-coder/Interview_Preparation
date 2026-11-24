# `ExecutorService` & Thread Pools

Never create raw `new Thread(...)` instances per request in production; reuse worker threads via `ExecutorService`:

- **`Executors.newFixedThreadPool(n)`**: Bounded pool of `n` threads with an unbounded `LinkedBlockingQueue` (ideal for CPU-bound tasks).
- **`Executors.newCachedThreadPool()`**: Creates threads on demand and reuses idle ones (best for short-lived I/O tasks).
- **Custom `ThreadPoolExecutor`**: Always configure explicit `corePoolSize`, `maximumPoolSize`, a bounded `ArrayBlockingQueue`, and a `RejectedExecutionHandler` to prevent `OutOfMemoryError` under traffic spikes.
