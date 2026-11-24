# LRU Cache & Custom Comparators

## Building an LRU Cache with `LinkedHashMap`
`LinkedHashMap` supports an `accessOrder = true` constructor flag and an overridable `removeEldestEntry` hook:

```java
public class LruCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public LruCache(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity;
    }
}
```

## Comparator Chaining
```java
Comparator<Employee> byDeptThenSalary = Comparator
    .comparing(Employee::department)
    .thenComparing(Comparator.comparingDouble(Employee::salary).reversed());
```
