# A. Ichihime and Triangle

*Rating: 800 | Tags: constructive algorithms, math | [https://codeforces.com/problemset/problem/1337/A](https://codeforces.com/problemset/problem/1337/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

Ichihime is the current priestess of the Mahjong Soul Temple. She claims to be human, despite her cat ears.

These days the temple is holding a math contest. Usually, Ichihime lacks interest in these things, but this time the prize for the winner is her favorite — cookies. Ichihime decides to attend the contest. Now she is solving the following problem.

![](https://espresso.codeforces.com/460965cc95e110488641a549ff72e6b554689699.webp)

You are given four positive integers $a$, $b$, $c$, $d$, such that $a \leq b \leq c \leq d$.

Your task is to find three integers $x$, $y$, $z$, satisfying the following conditions:

* $a \leq x \leq b$.
* $b \leq y \leq c$.
* $c \leq z \leq d$.
* There exists a triangle with a positive non-zero area and the lengths of its three sides are $x$, $y$, and $z$.

Ichihime desires to get the cookie, but the problem seems too hard for her. Can you help her?

### Input

The first line contains a single integer $t$ ($1 \leq t \leq 1000$)  — the number of test cases.

The next $t$ lines describe test cases. Each test case is given as four space-separated integers $a$, $b$, $c$, $d$ ($1 \leq a \leq b \leq c \leq d \leq 10^9$).

### Output

For each test case, print three integers $x$, $y$, $z$  — the integers you found satisfying the conditions given in the statement.

It is guaranteed that the answer always exists. If there are multiple answers, print any.

### Example

Input

```
4
1 3 5 7
1 5 5 7
100000 200000 300000 400000
1 1 977539810 977539810
```

Output

```
3 4 5
5 5 5
182690 214748 300999
1 977539810 977539810
```

### Note

One of the possible solutions to the first test case:

![](https://espresso.codeforces.com/21cfbbf175bf3960b8919891ab8a62a0fc8344f3.png)

One of the possible solutions to the second test case:

![](https://espresso.codeforces.com/0e86e95a0789a5557b2b155cd1295fd1f5e61bac.png)
