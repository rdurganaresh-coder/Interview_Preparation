# Entity Relationships & Fetching
- Avoid N+1 queries using `JOIN FETCH` or `@EntityGraph`.
- Default to `FetchType.LAZY` on `@OneToMany` and `@ManyToOne` associations.
