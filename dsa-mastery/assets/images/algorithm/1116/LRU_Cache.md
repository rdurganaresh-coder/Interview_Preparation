# Lru_Cache

> **Original PDF:** [LRU_Cache.pdf](./LRU_Cache.pdf) | **Jump to Java Code:** [Project Root](..)

---

2 1 3 2 1 1 3 2 3 1 2 4 3 1 2 5 4 3 1 2 Initial LRU Cache

```java
Add(1)
Add(2)
Add(3)
Get(1)
Get(3)
Add(4)
Add(5)
```

Cache is empty, capacity = 5 Always add new element to header Return 1 and move it to header Cache is full 6 5 4 3 1 4 6 5 3 1 Add(6) Add new element 6 and delete the last element 2

```java
Get(4)
```

3 1 2 Return 3 and move it to header Get(3) Return 3, position remains 7 4 6 5 3 8 7 4 6 5

```java
Add(7)
Add(8)
```

Add new element 7 and delete the last element 1 Add new element 8 and delete the last element 3