# List & Set Implementations

## Time Complexity Comparison
| Collection | Get by Index | Insert (End) | Insert (Middle) | Search (`contains`) |
| :--- | :--- | :--- | :--- | :--- |
| **`ArrayList`** | $O(1)$ | $O(1)$ amortized | $O(n)$ | $O(n)$ |
| **`LinkedList`** | $O(n)$ | $O(1)$ | $O(1)$ (with iterator) | $O(n)$ |
| **`HashSet`** | N/A | $O(1)$ | N/A | $O(1)$ |
| **`TreeSet`** | N/A | $O(\log n)$ | N/A | $O(\log n)$ |

## Key Takeaways
- Prefer `ArrayList` over `LinkedList` in almost all cases due to CPU cache locality and lower per-element memory overhead.
- Use `EnumSet` when storing enum values—it uses a compact bit-vector internally.
