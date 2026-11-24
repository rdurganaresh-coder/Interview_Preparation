# Java Collections Framework (`java-collections`)

Internal data structures, time complexities, hashing contracts, LRU caching, and custom sorting.

## Key Features Covered
- ArrayList vs LinkedList memory and Big-O trade-offs
- HashMap bucket hashing, equals/hashCode contract, and Java 8+ treeification
- LinkedHashMap access-order LRU Cache implementation
- TreeMap and PriorityQueue with custom Comparator chaining
- ConcurrentHashMap vs Collections.synchronizedMap
- Unmodifiable collections with List.of, Set.of, and Map.of

## Documentation (`docs/`)
- [`docs/01-list-set-implementations.md`](docs/01-list-set-implementations.md)
- [`docs/02-hashmap-internals.md`](docs/02-hashmap-internals.md)
- [`docs/03-lru-cache-and-sorting.md`](docs/03-lru-cache-and-sorting.md)

## Run Module Tests
```bash
mvn test -pl java-collections
```
