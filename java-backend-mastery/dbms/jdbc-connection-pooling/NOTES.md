# JDBC & Connection Pooling Notes

- **Pool Sizing Formula:** `connections = ((core_count * 2) + effective_spindle_count)`.
- **PreparedStatement:** Always use parameterized queries to prevent SQL injection and enable query plan caching.
