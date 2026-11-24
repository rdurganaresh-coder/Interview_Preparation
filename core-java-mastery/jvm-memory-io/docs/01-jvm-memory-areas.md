# JVM Memory Architecture

## Thread-Shared vs Thread-Private Areas
- **Heap (Shared)**: Stores all object instances and arrays. Divided into:
  - **Young Generation**: Eden space + Survivor spaces (`S0`, `S1`) where Minor GC runs frequently.
  - **Old (Tenured) Generation**: Long-lived objects promoted from Young Gen.
- **Metaspace (Shared, Native Memory)**: Stores class metadata, method bytecode, and runtime constant pools (replaced PermGen in Java 8).
- **JVM Stack (Per-Thread)**: Stores stack frames containing local variables, primitive values, and object references.
