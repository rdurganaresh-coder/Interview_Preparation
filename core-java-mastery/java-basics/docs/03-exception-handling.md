# Exception Handling Best Practices

## Checked vs Unchecked Exceptions
- **Checked (`Exception`)**: Recoverable conditions callers must handle or declare (`IOException`, `SQLException`).
- **Unchecked (`RuntimeException`)**: Programming errors or unrecoverable business rule violations (`IllegalArgumentException`, `NullPointerException`).

## Best Practices
- Catch the most specific exception first rather than generic `Exception`.
- Never swallow exceptions in empty `catch` blocks.
- Always preserve the root cause when wrapping exceptions (`new ServiceException("Failed to load", cause)`).
- Use `try-with-resources` for any `AutoCloseable` resource.
