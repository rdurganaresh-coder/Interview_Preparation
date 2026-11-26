# A. Hit the Lottery

*Rating: 800 | Tags: dp, greedy | [https://codeforces.com/problemset/problem/996/A](https://codeforces.com/problemset/problem/996/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

standard input

output

standard output

Allen has a LOT of money. He has $n$ dollars in the bank. For security reasons, he wants to withdraw it in cash (we will not disclose the reasons here). The denominations for dollar bills are $1$, $5$, $10$, $20$, $100$. What is the minimum number of bills Allen could receive after withdrawing his entire balance?

### Input

The first and only line of input contains a single integer $n$ ($1 \le n \le 10^9$).

### Output

Output the minimum number of bills that Allen could receive.

### Examples

Input

```
125
```

Output

```
3
```

Input

```
43
```

Output

```
5
```

Input

```
1000000000
```

Output

```
10000000
```

### Note

In the first sample case, Allen can withdraw this with a $100$ dollar bill, a $20$ dollar bill, and a $5$ dollar bill. There is no way for Allen to receive $125$ dollars in one or two bills.

In the second sample case, Allen can withdraw two $20$ dollar bills and three $1$ dollar bills.

In the third sample case, Allen can withdraw $100000000$ (ten million!) $100$ dollar bills.


---

# A. Kefa and First Steps

*Rating: 900 | Tags: brute force, dp, implementation | [https://codeforces.com/problemset/problem/580/A](https://codeforces.com/problemset/problem/580/A)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

standard input

output

standard output

Kefa decided to make some money doing business on the Internet for exactly *n* days. He knows that on the *i*-th day (1 ≤ *i* ≤ *n*) he makes *a**i* money. Kefa loves progress, that's why he wants to know the length of the maximum non-decreasing subsegment in sequence *a**i*. Let us remind you that the subsegment of the sequence is its continuous fragment. A subsegment of numbers is called non-decreasing if all numbers in it follow in the non-decreasing order.

Help Kefa cope with this task!

### Input

The first line contains integer *n* (1 ≤ *n* ≤ 105).

The second line contains *n* integers *a*1,  *a*2,  ...,  *a**n* (1 ≤ *a**i* ≤ 109).

### Output

Print a single integer — the length of the maximum non-decreasing subsegment of sequence *a*.

### Examples

Input

```
62 2 1 3 4 1
```

Output

```
3
```

Input

```
32 2 9
```

Output

```
3
```

### Note

In the first test the maximum non-decreasing subsegment is the numbers from the third to the fifth one.

In the second test the maximum non-decreasing subsegment is the numbers from the first to the third one.


---

# B. Interesting drink

*Rating: 1100 | Tags: binary search, dp, implementation | [https://codeforces.com/problemset/problem/706/B](https://codeforces.com/problemset/problem/706/B)*


time limit per test

2 seconds

memory limit per test

256 megabytes

input

standard input

output

standard output

Vasiliy likes to rest after a hard work, so you may often meet him in some bar nearby. As all programmers do, he loves the famous drink "Beecola", which can be bought in *n* different shops in the city. It's known that the price of one bottle in the shop *i* is equal to *x**i* coins.

Vasiliy plans to buy his favorite drink for *q* consecutive days. He knows, that on the *i*-th day he will be able to spent *m**i* coins. Now, for each of the days he want to know in how many different shops he can buy a bottle of "Beecola".

### Input

The first line of the input contains a single integer *n* (1 ≤ *n* ≤ 100 000) — the number of shops in the city that sell Vasiliy's favourite drink.

The second line contains *n* integers *x**i* (1 ≤ *x**i* ≤ 100 000) — prices of the bottles of the drink in the *i*-th shop.

The third line contains a single integer *q* (1 ≤ *q* ≤ 100 000) — the number of days Vasiliy plans to buy the drink.

Then follow *q* lines each containing one integer *m**i* (1 ≤ *m**i* ≤ 109) — the number of coins Vasiliy can spent on the *i*-th day.

### Output

Print *q* integers. The *i*-th of them should be equal to the number of shops where Vasiliy will be able to buy a bottle of the drink on the *i*-th day.

### Example

Input

```
53 10 8 6 114110311
```

Output

```
0415
```

### Note

On the first day, Vasiliy won't be able to buy a drink in any of the shops.

On the second day, Vasiliy can buy a drink in the shops 1, 2, 3 and 4.

On the third day, Vasiliy can buy a drink only in the shop number 1.

Finally, on the last day Vasiliy can buy a drink in any shop.


---

# A. Cut Ribbon

*Rating: 1300 | Tags: brute force, dp | [https://codeforces.com/problemset/problem/189/A](https://codeforces.com/problemset/problem/189/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

stdin

output

stdout

Polycarpus has a ribbon, its length is *n*. He wants to cut the ribbon in a way that fulfils the following two conditions:

* After the cutting each ribbon piece should have length *a*, *b* or *c*.
* After the cutting the number of ribbon pieces should be maximum.

Help Polycarpus and find the number of ribbon pieces after the required cutting.

### Input

The first line contains four space-separated integers *n*, *a*, *b* and *c* (1 ≤ *n*, *a*, *b*, *c* ≤ 4000) — the length of the original ribbon and the acceptable lengths of the ribbon pieces after the cutting, correspondingly. The numbers *a*, *b* and *c* can coincide.

### Output

Print a single number — the maximum possible number of ribbon pieces. It is guaranteed that at least one correct ribbon cutting exists.

### Examples

Input

```
5 5 3 2
```

Output

```
2
```

Input

```
7 5 5 2
```

Output

```
2
```

### Note

In the first example Polycarpus can cut the ribbon in such way: the first piece has length 2, the second piece has length 3.

In the second example Polycarpus can cut the ribbon in such way: the first piece has length 5, the second piece has length 2.


---

# A. Boredom

*Rating: 1500 | Tags: dp | [https://codeforces.com/problemset/problem/455/A](https://codeforces.com/problemset/problem/455/A)*


time limit per test

1 second

memory limit per test

256 megabytes

input

stdin

output

stdout

Alex doesn't like boredom. That's why whenever he gets bored, he comes up with games. One long winter evening he came up with a game and decided to play it.

Given a sequence *a* consisting of *n* integers. The player can make several steps. In a single step he can choose an element of the sequence (let's denote it *a**k*) and delete it, at that all elements equal to *a**k* + 1 and *a**k* - 1 also must be deleted from the sequence. That step brings *a**k* points to the player.

Alex is a perfectionist, so he decided to get as many points as possible. Help him.

### Input

The first line contains integer *n* (1 ≤ *n* ≤ 105) that shows how many numbers are in Alex's sequence.

The second line contains *n* integers *a*1, *a*2, ..., *a**n* (1 ≤ *a**i* ≤ 105).

### Output

Print a single integer — the maximum number of points that Alex can earn.

### Examples

Input

```
21 2
```

Output

```
2
```

Input

```
31 2 3
```

Output

```
4
```

Input

```
91 2 1 3 2 2 2 2 3
```

Output

```
10
```

### Note

Consider the third test example. At first step we need to choose any element equal to 2. After that step our sequence looks like this [2, 2, 2, 2]. Then we do 4 steps, on each step we choose any element equals to 2. In total we earn 10 points.
