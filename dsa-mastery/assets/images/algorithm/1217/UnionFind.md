# Unionfind

> **Original PDF:** [UnionFind.pdf](./UnionFind.pdf) | **Jump to Java Code:** [Project Root](..)

---

2 1 2 3 4 5 3 3 5 5 5 b) Find(3) 5 3 3 4 5 5 a) initial Path Compression 0 1 0 1 2 3 4 2 3 4 1 2 3 4 2 1 2 3 2 2 3 a) Initial b) Union(0, 2) c) Union(4, 2) 2 1 2 1 2 d) Union(3, 1) Union Find 3 4 0 1 0 1 2 3 4 2 3 4 1 1 2 3 4 2 3 4 1 2 2 3 4 2 3 4 a) Initial b) Union(0, 1) c) Union(1, 2)  0 1 2 3 3 4 3 4 d) Union(2, 3) Naive Union 1 2 3 4 5 Graph contains Cycle 1 2 3 4 5 Graph does not contain Cycle 0 1 0 1 2 3 4 2 3 4 1 2 3 4 1 1 1 3 4 3 4 a) Initial b) Union(0, 1) c) Union(1, 2) 1 1 1 1 4 d) Union(2, 3) 2 3 Union by Rank 0 0 0 0 0 parents rank 0 1 0 0 0 0 1 0 0 0 0 1 0 0 0 parents rank rankrank parentsparents 1 1 2 3 4