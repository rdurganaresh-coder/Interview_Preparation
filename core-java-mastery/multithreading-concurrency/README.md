# Multithreading & Java Concurrency (`multithreading-concurrency`)

Thread synchronization, Java Memory Model visibility, ExecutorService pools, CompletableFuture, and atomic variables.

## Key Features Covered
- Thread lifecycle states and Runnable vs Callable
- Java Memory Model (JMM): volatile visibility vs synchronized mutual exclusion
- Explicit locking with ReentrantLock and ReadWriteLock
- Thread pools via ExecutorService, FixedThreadPool, and ScheduledExecutorService
- Asynchronous composition with CompletableFuture (supplyAsync, thenCombine, exceptionally)
- Lock-free thread safety with AtomicInteger and LongAdder

## Documentation (`docs/`)
- [`docs/01-jmm-volatile-synchronized.md`](docs/01-jmm-volatile-synchronized.md)
- [`docs/02-executor-service-pools.md`](docs/02-executor-service-pools.md)
- [`docs/03-completable-future.md`](docs/03-completable-future.md)

## Run Module Tests
```bash
mvn test -pl multithreading-concurrency
```
