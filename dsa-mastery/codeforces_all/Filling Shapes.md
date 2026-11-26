# A. Filling Shapes

*Rating: 1000 | Tags: dp, math | [https://codeforces.com/problemset/problem/1182/A](https://codeforces.com/problemset/problem/1182/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

You have a given integer $n$. Find the number of ways to fill all $3 \times n$ tiles with the shape described in the picture below. Upon filling, no empty spaces are allowed. Shapes cannot overlap.

 ![](https://espresso.codeforces.com/87c303f887fa1c553f93820abb8e1eee0ee2593a.png) This picture describes when $n = 4$. The left one is the shape and the right one is $3 \times n$ tiles.

### Input

The only line contains one integer $n$ ($1 \le n \le 60$) — the length.

### Output

Print the number of ways to fill.

### Examples

Input

```
4
```

Output

```
4
```

Input

```
1
```

Output

```
0
```

### Note

In the first example, there are $4$ possible cases of filling.

In the second example, you cannot fill the shapes in $3 \times 1$ tiles.
