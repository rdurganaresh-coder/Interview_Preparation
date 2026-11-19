# Java Collections Framework Notes

| Interface | Implementation | Ordering | Nulls | Lookup Complexity |
| :--- | :--- | :--- | :--- | :--- |
| `List` | `ArrayList` | Insertion order | Allowed | `O(1)` index, `O(n)` search |
| `Set` | `HashSet` | Unordered | One null | `O(1)` average |
| `Set` | `TreeSet` | Sorted (Red-Black Tree) | Not allowed | `O(log n)` |
| `Map` | `HashMap` | Unordered | One null key | `O(1)` average |
| `Map` | `LinkedHashMap` | Insertion / Access order | One null key | `O(1)` average |
