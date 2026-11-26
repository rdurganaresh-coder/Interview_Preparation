# C. Kefa and Park

*Rating: 1500 | Tags: dfs and similar, graphs, trees | [https://codeforces.com/problemset/problem/580/C](https://codeforces.com/problemset/problem/580/C)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

standard input

output

standard output

Kefa decided to celebrate his first big salary by going to the restaurant.

He lives by an unusual park. The park is a rooted tree consisting of *n* vertices with the root at vertex 1. Vertex 1 also contains Kefa's house. Unfortunaely for our hero, the park also contains cats. Kefa has already found out what are the vertices with cats in them.

The leaf vertices of the park contain restaurants. Kefa wants to choose a restaurant where he will go, but unfortunately he is very afraid of cats, so there is no way he will go to the restaurant if the path from the restaurant to his house contains more than *m* consecutive vertices with cats.

Your task is to help Kefa count the number of restaurants where he can go.

### Input

The first line contains two integers, *n* and *m* (2 ≤ *n* ≤ 105, 1 ≤ *m* ≤ *n*) — the number of vertices of the tree and the maximum number of consecutive vertices with cats that is still ok for Kefa.

The second line contains *n* integers *a*1, *a*2, ..., *a**n*, where each *a**i* either equals to 0 (then vertex *i* has no cat), or equals to 1 (then vertex *i* has a cat).

Next *n* - 1 lines contains the edges of the tree in the format "*x**i* *y**i*" (without the quotes) (1 ≤ *x**i*, *y**i* ≤ *n*, *x**i* ≠ *y**i*), where *x**i* and *y**i* are the vertices of the tree, connected by an edge.

It is guaranteed that the given set of edges specifies a tree.

### Output

A single integer — the number of distinct leaves of a tree the path to which from Kefa's home contains at most *m* consecutive vertices with cats.

### Examples

Input

```
4 11 1 0 01 21 31 4
```

Output

```
2
```

Input

```
7 11 0 1 1 0 0 01 21 32 42 53 63 7
```

Output

```
2
```

### Note

Let us remind you that a tree is a connected graph on *n* vertices and *n* - 1 edge. A rooted tree is a tree with a special vertex called root. In a rooted tree among any two vertices connected by an edge, one vertex is a parent (the one closer to the root), and the other one is a child. A vertex is called a leaf, if it has no children.

Note to the first sample test: ![](https://espresso.codeforces.com/d5a8860bc0e7f2b3af6eb8d282651cf293b2ca73.png) The vertices containing cats are marked red. The restaurants are at vertices 2, 3, 4. Kefa can't go only to the restaurant located at vertex 2.

Note to the second sample test: ![](https://espresso.codeforces.com/4e80ab2e30751bfa146f6b2be04649530164fd0a.png) The restaurants are located at vertices 4, 5, 6, 7. Kefa can't go to restaurants 6, 7.
