# Built-In Functional Interfaces (`java.util.function`)

| Interface | Method Signature | Purpose |
| :--- | :--- | :--- |
| **`Predicate<T>`** | `boolean test(T t)` | Filtering and boolean conditions |
| **`Function<T, R>`** | `R apply(T t)` | Transforming input `T` into output `R` |
| **`Consumer<T>`** | `void accept(T t)` | Performing side-effect actions (logging, printing) |
| **`Supplier<T>`** | `T get()` | Lazy object creation or factory providers |
| **`BiFunction<T, U, R>`** | `R apply(T t, U u)` | Combining two inputs into one result |

## Method References
- **Static**: `Integer::parseInt`
- **Bound Instance**: `System.out::println`
- **Unbound Instance**: `String::toLowerCase`
- **Constructor**: `ArrayList::new`
