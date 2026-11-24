# Skip, Retry & Restartability
- Use `.faultTolerant().skipLimit(5).skip(Exception.class)` to isolate bad records.
- `JobRepository` stores execution state for safe restarts.
