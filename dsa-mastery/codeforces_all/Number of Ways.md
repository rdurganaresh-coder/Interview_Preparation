# C. Number of Ways

*Rating: 1700 | Tags: binary search, brute force, data structures, dp, two pointers | [https://codeforces.com/problemset/problem/466/C](https://codeforces.com/problemset/problem/466/C)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

stdin

output

stdout

You've got array *a*[1], *a*[2], ..., *a*[*n*], consisting of *n* integers. Count the number of ways to split all the elements of the array into three contiguous parts so that the sum of elements in each part is the same.

More formally, you need to find the number of such pairs of indices *i*, *j* (2 ≤ *i* ≤ *j* ≤ *n* - 1), that ![](https://espresso.codeforces.com/669a2f09a3b9e143f54b1f1d9fd6b7dddf403680.png).

### Input

The first line contains integer *n* (1 ≤ *n* ≤ 5·105), showing how many numbers are in the array. The second line contains *n* integers *a*[1], *a*[2], ..., *a*[*n*] (|*a*[*i*]| ≤  109) — the elements of array *a*.

### Output

Print a single integer — the number of ways to split the array into three parts with the same sum.

### Examples

Input

```
51 2 3 0 3
```

Output

```
2
```

Input

```
40 1 -1 0
```

Output

```
1
```

Input

```
24 1
```

Output

```
0
```
