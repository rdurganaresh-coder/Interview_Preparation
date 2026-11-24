# JVM Architecture, Memory Management & Java NIO.2 (`jvm-memory-io`)

ClassLoader delegation, Heap vs Stack vs Metaspace, Garbage Collectors, Java NIO.2 file APIs, and Reflection.

## Key Features Covered
- JVM ClassLoader hierarchy (Bootstrap, Platform, Application) and parent delegation
- Runtime Data Areas: Heap (Young/Old Gen), Stack frames, Metaspace, PC Register
- Garbage Collection algorithms: G1GC, ZGC, and avoiding memory leaks
- Modern Java NIO.2 Path, Files, and streaming large files with Files.lines
- Custom runtime annotations and Reflection inspection

## Documentation (`docs/`)
- [`docs/01-jvm-memory-areas.md`](docs/01-jvm-memory-areas.md)
- [`docs/02-garbage-collection.md`](docs/02-garbage-collection.md)
- [`docs/03-nio2-and-reflection.md`](docs/03-nio2-and-reflection.md)

## Run Module Tests
```bash
mvn test -pl jvm-memory-io
```
