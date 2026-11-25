# Sqrt Decomposition

> **Original PDF:** [Sqrt Decomposition.pdf](./Sqrt Decomposition.pdf) | **Jump to Java Code:** [Project Root](..)

---

9 21 14 Decompose given array into small chunks 3 5 1 5 6 10 4 2 8

```java
Block(Sum)
```

Array 0 1 2 3 4 5 6 7 8 0 1 2 15 21 14 Update Array 3 5 7 5 6 10 4 2 8

```java
Block(Sum)
```

Array 0 1 2 3 4 5 6 7 8 0 1 2 Update(2, 7) : Array[2] = 7, Block[0] = 15 9 21 14 3 5 1 5 6 10 4 2 8

```java
Block(Sum)
```

Array 0 1 2 3 4 5 6 7 8 0 1 2 Query 1: Range is on block boundaries 9 21 14 3 5 1 5 6 10 4 2 8

```java
Block(Sum)
```

Array 0 1 2 3 4 5 6 7 8 0 1 2 Query(3, 8) = Block[1] + Block[2] = 35 Query 2: Range crosses blocks Query(2, 7) = Array[2] + Block[1] + Array[6] + Array[7] = 28