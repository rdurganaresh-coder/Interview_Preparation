# B. Kuriyama Mirai's Stones

*Rating: 1200 | Tags: dp, implementation, sortings | [https://codeforces.com/problemset/problem/433/B](https://codeforces.com/problemset/problem/433/B)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

stdin

output

stdout

Kuriyama Mirai has killed many monsters and got many (namely *n*) stones. She numbers the stones from 1 to *n*. The cost of the *i*-th stone is *v**i*. Kuriyama Mirai wants to know something about these stones so she will ask you two kinds of questions:

1. She will tell you two numbers, *l* and *r* (1 ≤ *l* ≤ *r* ≤ *n*), and you should tell her ![](https://espresso.codeforces.com/6a950b27de2103bb53df10f9ace817ae3df57fa9.png).
2. Let *u**i* be the cost of the *i*-th cheapest stone (the cost that will be on the *i*-th place if we arrange all the stone costs in non-decreasing order). This time she will tell you two numbers, *l* and *r* (1 ≤ *l* ≤ *r* ≤ *n*), and you should tell her ![](https://espresso.codeforces.com/9830c0af1b3d14c66843c32f7c106c97428b7d2d.png).

For every question you should give the correct answer, or Kuriyama Mirai will say "fuyukai desu" and then become unhappy.

### Input

The first line contains an integer *n* (1 ≤ *n* ≤ 105). The second line contains *n* integers: *v*1, *v*2, ..., *v**n* (1 ≤ *v**i* ≤ 109) — costs of the stones.

The third line contains an integer *m* (1 ≤ *m* ≤ 105) — the number of Kuriyama Mirai's questions. Then follow *m* lines, each line contains three integers *type*, *l* and *r* (1 ≤ *l* ≤ *r* ≤ *n*; 1 ≤ *type* ≤ 2), describing a question. If *type* equal to 1, then you should output the answer for the first question, else you should output the answer for the second one.

### Output

Print *m* lines. Each line must contain an integer — the answer to Kuriyama Mirai's question. Print the answers to the questions in the order of input.

### Examples

Input

```
66 4 2 7 2 732 3 61 3 41 1 6
```

Output

```
24928
```

Input

```
45 5 2 3101 2 42 1 41 1 12 1 42 1 21 1 11 3 31 1 31 4 41 2 2
```

Output

```
10155155521235
```

### Note

Please note that the answers to the questions may overflow 32-bit integer type.
