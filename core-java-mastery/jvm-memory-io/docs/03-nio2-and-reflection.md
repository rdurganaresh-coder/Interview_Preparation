# Java NIO.2 (`java.nio.file`) & Reflection

## NIO.2 Best Practices
- Use `Path.of(...)` instead of legacy `java.io.File`.
- Stream large files lazily with `Files.lines(path)` inside `try-with-resources` rather than loading entire files into memory with `Files.readAllLines(path)`.

## Reflection & Custom Annotations
- Define metadata with `@Retention(RetentionPolicy.RUNTIME)` and `@Target(ElementType.METHOD)`.
- Cache `Method` and `Field` reflection lookups in frameworks because reflective metadata resolution is slower than direct invocation.
