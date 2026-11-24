# Stream Pipelines & Collectors

## Lazy Evaluation
Intermediate operations (`filter`, `map`, `flatMap`) build a pipeline without executing until a **terminal operation** (`collect`, `reduce`, `forEach`) is invoked.

## `map` vs `flatMap`
- **`map`**: One-to-one transformation (`Stream<Order>` $\rightarrow$ `Stream<List<Item>>`).
- **`flatMap`**: One-to-many flattening (`Stream<Order>` $\rightarrow$ `Stream<Item>`).

## Common Collectors
```java
Map<String, List<Employee>> byDepartment = employees.stream()
    .collect(Collectors.groupingBy(Employee::department));

Map<Boolean, List<Integer>> evenOdd = numbers.stream()
    .collect(Collectors.partitioningBy(n -> n % 2 == 0));
```
