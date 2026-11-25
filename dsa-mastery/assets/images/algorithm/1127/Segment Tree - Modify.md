# Segment Tree   Modify

> **Original PDF:** [Segment Tree - Modify.pdf](./Segment Tree - Modify.pdf) | **Jump to Java Code:** [Project Root](..)

---

[0, 4] 
--------- 
min = -1 [0, 2]
--------- 
min = -1 [0, 1]
--------- 
min = -1 [0, 0]
--------- 
min = 4 [1, 1]
--------- 
min = -1 [3, 4]
--------- 
min = 0 
 
[4, 4] 
--------- 
min = 2 [3, 3]
--------- 
min = 0 [2, 2]
--------- 
min = 3 Segment Tree(min) for array [4,-1,3,0,2] [0, 4]
--------- 
min = 0 [0, 2]
--------- 
min = 3 [0, 1]
--------- 
min = 4 [1, 1]
--------- 
min = 5 [3, 4]
--------- 
min = 0 
 
[4, 4] 
--------- 
min = 2 [3, 3]
--------- 
min = 0 [2, 2]
--------- 
min = 3 [0, 0]
--------- 
min = 4 Change -1 to 5 Segment Tree(min) for array [4,5,3,0,2] [0, 4]
--------- 
min = -1 max = 4 sum = 8 [0, 2]
--------- 
min = -1 max = 4 sum = 6 [0, 1]
--------- 
min = -1 max = 4 sum = 3 [0, 0]
--------- 
min = 4 max = 4 sum = 4 [1, 1]
--------- 
min = -1 max = -1 sum = -1 [3, 4]
--------- 
min = 0 max = 2 sum = 2 [4, 4]
--------- 
min = 2 max = 2 sum = 2 [3, 3]
--------- 
min = 0 max = 0 sum = 0 [2, 2]
--------- 
min = 3 max = 3 sum = 3 Segment Tree(min, max, sum) for array [4,-1,3,0,2] Change -1 to 5 Segment Tree(min, max, sum) for array [4,5,3,0,2] [0, 4]
--------- 
min = 0 max = 5 sum = 14
 
[0, 2] 
--------- 
min = 3 max = 5 sum = 12 [0, 1]
--------- 
min = 4 max = 5 sum = 9 [0, 0]
--------- 
min = 4 max = 4 sum = 4 [1, 1]
--------- 
min = 5 max = 5 sum = 5 [3, 4]
--------- 
min = 0 max = 2 sum = 2 [4, 4]
--------- 
min = 2 max = 2 sum = 2 [3, 3]
--------- 
min = 0 max = 0 sum = 0 [2, 2]
--------- 
min = 3 max = 3 sum = 3