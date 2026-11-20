# JPA & Hibernate Performance Notes

- **N+1 Problem:** Use `@EntityGraph` or `JOIN FETCH` when loading parent-child collections.
- **Read-Only Queries:** Annotate query methods with `@Transactional(readOnly = true)` to skip Hibernate dirty checking.
