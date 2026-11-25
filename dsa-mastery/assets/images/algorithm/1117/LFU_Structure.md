# Lfu_Structure

> **Original PDF:** [LFU_Structure.pdf](./LFU_Structure.pdf) | **Jump to Java Code:** [Project Root](..)

---

next next next next head Data Structure of LFU Cache tail prev prev prevprev head nextnull tail nullprev head Initialization tail head null tail

```java
Add(1)
```

head null tailAdd(2) 1 prev

```java
Add New Element(size < capacity, maximum count = 0)
```

prev prev prev prev 2 0 01max min head nextnull max tail nullprev min next next max next min null max next next min null head null tailAdd(3) 2 prev 3 prev prev next max next next min null prev next nextprev

```java
Add New Element (Cache Is Full)
```

nextprev head null tailBefore 1 prev 3 prev prev next max next next min null head null tailAfter 3 prev prev next max next min null prev next

```java
Add New Element(size < capacity, maximum count > 0)
```

head null tailBefore 4 prev 3 prev prev next max next next min null head null tailAfter 3 prev prev next max next min null prev next prev next prev next prev next Get Element

```java
Get(4)
```

Move Before head null tail3 prev prev next max next min null prev next prev next head null tail3 prev prev next max next min null prev next prev next

```java
Get(4)
```

head null tail4 prev prev next max next min null prev next prev next

```java
Get(4)
```

head null tail4 prev prev next max next min null prev next prev next