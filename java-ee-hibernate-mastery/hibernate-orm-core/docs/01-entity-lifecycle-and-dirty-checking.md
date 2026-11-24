# Entity Lifecycle States & Dirty Checking

## 1. The 4 Hibernate Entity States
1. **Transient**: Newly instantiated with `new`; has no database row and is not attached to any `Session`.
2. **Persistent (Managed)**: Associated with an active `Session` (`session.persist()`, `session.find()`). Any field modification is tracked automatically.
3. **Detached**: Was persistent, but its `Session` was closed (`session.close()`) or evicted (`session.evict()`). Changes are not synced until re-attached via `session.merge()`.
4. **Removed**: Scheduled for deletion via `session.remove()`; deleted from DB upon transaction commit.

## 2. Automatic Dirty Checking
* When an entity enters the **Persistent** state, Hibernate takes a snapshot of its property values in the Persistence Context.
* At flush/commit time, Hibernate compares current property values against the snapshot and automatically generates an `UPDATE` SQL statement **only if fields changed**—no explicit `update()` call is required.
