# A. Lineland Mail

*Rating: 900 | Tags: greedy, implementation | [https://codeforces.com/problemset/problem/567/A](https://codeforces.com/problemset/problem/567/A)*


time limit per test

3 seconds

memory limit per test

256 megabytes

input

standard input

output

standard output

All cities of Lineland are located on the *Ox* coordinate axis. Thus, each city is associated with its position *x**i* — a coordinate on the *Ox* axis. No two cities are located at a single point.

Lineland residents love to send letters to each other. A person may send a letter only if the recipient lives in another city (because if they live in the same city, then it is easier to drop in).

Strange but true, the cost of sending the letter is exactly equal to the distance between the sender's city and the recipient's city.

For each city calculate two values ​​*min**i* and *max**i*, where *min**i* is the minimum cost of sending a letter from the *i*-th city to some other city, and *max**i* is the the maximum cost of sending a letter from the *i*-th city to some other city

### Input

The first line of the input contains integer *n* (2 ≤ *n* ≤ 105) — the number of cities in Lineland. The second line contains the sequence of *n* distinct integers *x*1, *x*2, ..., *x**n* ( - 109 ≤ *x**i* ≤ 109), where *x**i* is the *x*-coordinate of the *i*-th city. All the *x**i*'s are distinct and follow in ascending order.

### Output

Print *n* lines, the *i*-th line must contain two integers *min**i*, *max**i*, separated by a space, where *min**i* is the minimum cost of sending a letter from the *i*-th city, and *max**i* is the maximum cost of sending a letter from the *i*-th city.

### Examples

Input

```
4-5 -2 2 7
```

Output

```
3 123 94 75 12
```

Input

```
2-1 1
```

Output

```
2 22 2
```
