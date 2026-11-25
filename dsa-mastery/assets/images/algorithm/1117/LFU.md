# Lfu

> **Original PDF:** [LFU.pdf](./LFU.pdf) | **Jump to Java Code:** [Project Root](..)

---

2 1 3 2 1 1 3 2 3 1 2 3 1 4 2 3 1 5 4 2 Initial LFU Cache

```java
Add(1)
Add(2)
Add(3)
Get(1)
Get(3)
Add(4)
Add(5)
```

Cache is empty, capacity = 5 Insert 2 before 1, as they have the same frequency 0 Return 1 and update its frequency to 1 Insert 5 before 4, cache is full 3 1 6 5 4 3 4 1 6 5 Add(6) Insert 6 before 5 and delete 2, as 2 has least frequency and is LRU

```java
Get(4)
```

3 1 2 Return 3, update its frequency to 1 and move to head Get(3) Return 3 and update its frequency to 2 3 4 1 7 6 3 7 4 1 6

```java
Add(7)
Get(7)
```

Insert 7 before 6, set its frequency to 0 and delete 5 
              
0 0 0 0 0 1 0 0 1 1 0 2 1 0 0 2 1 0 0 0 2 1 0 0 0 2 1 1 0 0 2 1 0 2 1 1 0 0 2 1 1 1 0 Value Frequency 3 6 7 4 1 2 1 1 1 1 2 2 1 1 1 3 2 1 1 1 6 3 7 4 1 6 3 7 4 1

```java
Get(6)
Get(6)
Get(6)
```

3 2 1 1 06 3 7 4 8Add(8) Add 1 and set frequency to 0 Insert 4 before 2, as they have the same frequency 0 Return 4, update its frequency to 1 and move it before 1 Return 7, update its frequency to 1 and move it before 4 Return 6, update its frequency to 1 and move it before 7 Return 6, update its frequency to 2 and move it to head Return 6, update its frequency to 3 Insert 8 to tail, set its frequency to 0 and delete 1