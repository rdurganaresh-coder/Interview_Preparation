# Entity Associations & Cascade Types

## 1. Bidirectional `@OneToMany` & `@ManyToOne`
* Always make the **`@ManyToOne` side the owning side** (holds the foreign key column).
* Set `mappedBy` on the `@OneToMany` side so Hibernate does not create an extra join table.
* Provide helper methods (`addLesson()`, `removeLesson()`) to keep both sides of the object graph synchronized in memory.

## 2. Default Fetch Types
* `@OneToMany` & `@ManyToMany`: **`FetchType.LAZY`** (recommended).
* `@ManyToOne` & `@OneToOne`: **`FetchType.EAGER`** by default — override to `FetchType.LAZY` to prevent unnecessary joins.
