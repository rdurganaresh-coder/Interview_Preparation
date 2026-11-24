# Core Java Mastery (Multi-Module Maven Project)

A standalone **Java 17 + Maven** multi-module repository covering Core Java fundamentals, Collections, Streams, Concurrency, Design Patterns, and JVM/NIO internals. Every module includes a dedicated `docs/` folder containing structured Markdown study guides.

## Project Structure

| Module | Package | Docs Folder | Focus Area |
| :--- | :--- | :--- | :--- |
| `java-basics` | `com.corejava.basics` | `java-basics/docs/` | Core object-oriented fundamentals, records, sealed hierarchies, immutability, and custom exception design. |
| `java-collections` | `com.corejava.collections` | `java-collections/docs/` | Internal data structures, time complexities, hashing contracts, LRU caching, and custom sorting. |
| `java-streams` | `com.corejava.streams` | `java-streams/docs/` | Lambda expressions, built-in functional interfaces, intermediate vs terminal operations, collectors, and Optional. |
| `multithreading-concurrency` | `com.corejava.concurrency` | `multithreading-concurrency/docs/` | Thread synchronization, Java Memory Model visibility, ExecutorService pools, CompletableFuture, and atomic variables. |
| `design-patterns` | `com.corejava.patterns` | `design-patterns/docs/` | Practical Java implementations of Creational, Structural, and Behavioral patterns grounded in SOLID principles. |
| `jvm-memory-io` | `com.corejava.jvmio` | `jvm-memory-io/docs/` | ClassLoader delegation, Heap vs Stack vs Metaspace, Garbage Collectors, Java NIO.2 file APIs, and Reflection. |

## Build & Run All Tests

```bash
mvn clean test
```
