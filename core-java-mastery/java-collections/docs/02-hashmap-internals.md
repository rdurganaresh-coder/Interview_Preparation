# HashMap Internals & Contracts

## How `HashMap` Works
1. Computes `hashCode()` of the key and applies a secondary spread function to reduce collisions.
2. Maps the hash to a bucket index using `(n - 1) & hash`.
3. Stores entries as linked nodes (`Node<K,V>`).
4. **Java 8+ Optimization**: When a single bucket exceeds `TREEIFY_THRESHOLD` (8 nodes) and table capacity is at least 64, the linked list converts into a balanced **Red-Black Tree**, improving worst-case lookup from $O(n)$ to $O(\log n)$.

## `equals()` and `hashCode()` Contract
- If `a.equals(b)` is `true`, then `a.hashCode() == b.hashCode()` **must** be `true`.
- Always use immutable fields (like `String`, `UUID`, or `Long`) as map keys so the hash never changes after insertion.
