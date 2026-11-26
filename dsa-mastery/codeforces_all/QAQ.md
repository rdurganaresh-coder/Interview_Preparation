# A. QAQ

*Rating: 800 | Tags: brute force, dp | [https://codeforces.com/problemset/problem/894/A](https://codeforces.com/problemset/problem/894/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

"QAQ" is a word to denote an expression of crying. Imagine "Q" as eyes with tears and "A" as a mouth.

Now Diamond has given Bort a string consisting of only uppercase English letters of length *n*. There is a great number of "QAQ" in the string (Diamond is so cute!).

 ![](https://espresso.codeforces.com/e2ee63ac64a28b997d0d327ee841cea43f8fc0ed.png) illustration by 猫屋 https://twitter.com/nekoyaliu 

Bort wants to know how many subsequences "QAQ" are in the string Diamond has given. Note that the letters "QAQ" don't have to be consecutive, but the order of letters should be exact.

### Input

The only line contains a string of length *n* (1 ≤ *n* ≤ 100). It's guaranteed that the string only contains uppercase English letters.

### Output

Print a single integer — the number of subsequences "QAQ" in the string.

### Examples

Input

```
QAQAQYSYIOIWIN
```

Output

```
4
```

Input

```
QAQQQZZYNOIWIN
```

Output

```
3
```

### Note

In the first example there are 4 subsequences "QAQ": "QAQAQYSYIOIWIN", "QAQAQYSYIOIWIN", "QAQAQYSYIOIWIN", "QAQAQYSYIOIWIN".
