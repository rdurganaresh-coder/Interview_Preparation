# Lru_Data_Structure

> **Original PDF:** [LRU_Data_Structure.pdf](./LRU_Data_Structure.pdf) | **Jump to Java Code:** [Project Root](..)

---

4 next 3 next 1 next 2 next head Data Structure of LRU Cache tail prev prev prevprevhead nextnull tail nullprev head Initialization tail head nextnull tail nullprev

```java
headnull tail nullAdd(1)
```

headnull tail nullAdd(2) 1 nextprev

```java
Add New Elements(size < capacity)
```

headnull tail nullAdd(3) 2 nextprev 1 nextprev 1 nextprev 2 nextprev 3 nextprev next prev next prev next prev Get Element - Get(1) 3 nextprevheadnull tail null2 nextprev 1 1headnull tail nullAfter 3 nextprev 2 nextprev 1 nextprevheadnull tail nullBefore 3 nextprev 2prev headnull tail nullAfter 1 nextprev 3 nextprev Move Before Add Element If Cache Is Full - Add(4) Capacity = 34 nextprev 4 nextprev prevnext prev next next next prevnextprev nextprevnext prev