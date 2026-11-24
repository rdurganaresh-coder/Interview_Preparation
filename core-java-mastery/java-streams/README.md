# Java Streams & Functional Programming (`java-streams`)

Lambda expressions, built-in functional interfaces, intermediate vs terminal operations, collectors, and Optional.

## Key Features Covered
- Core Functional Interfaces: Predicate, Function, Consumer, Supplier, UnaryOperator
- Intermediate lazy operations: filter, map, flatMap, distinct, sorted, peek
- Terminal operations: collect, reduce, findFirst, anyMatch, count
- Advanced Collectors: groupingBy, partitioningBy, summarizingDouble, toMap
- Safe null-handling pipelines with Optional (map, flatMap, orElseGet)
- Parallel stream pitfalls and stateless lambda rules

## Documentation (`docs/`)
- [`docs/01-functional-interfaces.md`](docs/01-functional-interfaces.md)
- [`docs/02-stream-pipelines-collectors.md`](docs/02-stream-pipelines-collectors.md)
- [`docs/03-optional-best-practices.md`](docs/03-optional-best-practices.md)

## Run Module Tests
```bash
mvn test -pl java-streams
```
