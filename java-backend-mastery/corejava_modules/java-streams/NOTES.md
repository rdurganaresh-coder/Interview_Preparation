# Java Streams Notes

- **Lazy Evaluation:** Intermediate operations (`filter`, `map`, `flatMap`, `sorted`) do not execute until a terminal operation (`collect`, `forEach`, `reduce`, `count`) runs.
- **Single-Use:** A `Stream` cannot be reused after a terminal operation is invoked.
- **Primitive Streams:** Use `IntStream`, `LongStream`, and `DoubleStream` to avoid autoboxing overhead.
