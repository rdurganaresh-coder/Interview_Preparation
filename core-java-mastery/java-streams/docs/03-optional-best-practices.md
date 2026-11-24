# Optional Best Practices

## Rules for `Optional<T>`
1. **Return type only**: Use `Optional<T>` as a method return type when a value may legitimately be absent. Never use it for fields, method parameters, or collections.
2. **Avoid `.get()` without `.isPresent()`**: Prefer `.orElseThrow()`, `.orElse()`, or `.orElseGet()`.
3. **`orElse` vs `orElseGet`**:
   - `orElse(defaultObj)` **always evaluates** `defaultObj` even when the `Optional` is non-empty.
   - `orElseGet(() -> expensiveCall())` executes the supplier **only** when empty.
