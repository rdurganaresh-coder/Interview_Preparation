# Garbage Collection & Memory Leaks

## Common JVM Garbage Collectors
- **G1GC (Default since Java 9)**: Splits the heap into equal-sized regions and prioritizes collecting regions with the most garbage first to meet pause-time goals.
- **ZGC (Low-Latency)**: Performs concurrent compaction with sub-millisecond pause times regardless of heap size.

## Common Java Memory Leak Causes
1. Unbounded static collections (`static List<Object>`).
2. Unclosed I/O streams or database connections.
3. Mutable keys in `HashMap` / `HashSet` that prevent lookup and removal.
4. `ThreadLocal` variables not cleared via `.remove()` in pooled threads.
