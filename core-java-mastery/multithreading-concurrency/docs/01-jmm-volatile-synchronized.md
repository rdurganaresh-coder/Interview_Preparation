# Java Memory Model, `volatile` & `synchronized`

## Visibility vs Atomicity
- **`volatile`**: Guarantees that writes to a variable are immediately flushed to main memory and visible across all threads, and prevents instruction reordering. It does **not** make compound operations (`count++`) atomic.
- **`synchronized`**: Provides both **mutual exclusion** (only one thread enters the monitor at a time) and **memory visibility** upon monitor exit/entry.

## Avoiding Deadlocks
1. Always acquire multiple locks in a consistent global order.
2. Prefer `ReentrantLock.tryLock(timeout, unit)` when lock contention risks deadlock.
3. Keep critical sections as short as possible.
