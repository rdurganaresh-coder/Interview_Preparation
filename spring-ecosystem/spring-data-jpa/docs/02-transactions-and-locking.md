# Transactions & Locking
- `@Transactional` manages ACID boundaries via Spring AOP proxies.
- Optimistic locking uses `@Version`; pessimistic locking uses `@Lock(LockModeType.PESSIMISTIC_WRITE)`.
