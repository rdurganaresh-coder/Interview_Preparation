# First-Level vs Second-Level Cache

## 1. First-Level Cache (Session Cache)
* **Enabled by default** and cannot be disabled.
* Scoped to a single `Session` / `EntityManager`.
* Calling `session.find(Course.class, 1L)` twice inside the same transaction executes only **1 SQL `SELECT`**; the second call returns the cached instance from the Persistence Context.

## 2. Second-Level Cache (`SessionFactory` Cache)
* **Disabled by default**; shared across all `Session` instances in a `SessionFactory`.
* Backed by external providers (Ehcache, Caffeine, Redis/Infinispan) via JCache (`@Cacheable`).
* Ideal for read-heavy reference data that rarely changes.
