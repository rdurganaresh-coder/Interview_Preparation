# 509. Fibonacci Number

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/fibonacci-number/

---

[中文文档](/solution/0500-0599/0509.Fibonacci%20Number/README.md)

## Description

<p>The <b>Fibonacci numbers</b>, commonly denoted <code>F(n)</code> form a sequence, called the <b>Fibonacci sequence</b>, such that each number is the sum of the two preceding ones, starting from <code>0</code> and <code>1</code>. That is,</p>

<pre>
F(0) = 0, F(1) = 1
F(n) = F(n - 1) + F(n - 2), for n &gt; 1.
</pre>

<p>Given <code>n</code>, calculate <code>F(n)</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 2
<strong>Output:</strong> 1
<strong>Explanation:</strong> F(2) = F(1) + F(0) = 1 + 0 = 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> 2
<strong>Explanation:</strong> F(3) = F(2) + F(1) = 1 + 1 = 2.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> 3
<strong>Explanation:</strong> F(4) = F(3) + F(2) = 2 + 1 = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 30</code></li>
</ul>

## Solutions

### Solution 1: Recurrence

> **Thinking**
>
> Fibonacci obeys $F_n = F_{n-1} + F_{n-2}$. Naive recursion recomputes the same subproblems. Even though $n \le 30$, an iterative recurrence is enough.
>
> Roll two variables for consecutive terms and iterate $n$ times. Time is linear and extra space is constant.

We define two variables $a$ and $b$, initially $a = 0$ and $b = 1$.

Next, we perform $n$ iterations. In each iteration, we update the values of $a$ and $b$ to $b$ and $a + b$, respectively.

Finally, we return $a$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the given integer.

#### Java

```java
class Solution {
    public int fib(int n) {
        int a = 0, b = 1;
        while (n-- > 0) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }
}
```

### Solution 2: Matrix Exponentiation

> **Thinking**
>
> Solution 1 is already $O(n)$ and enough here, but the same linear recurrence can be sped up for larger $n$.
>
> $F_n$ is a product of a fixed $2 \times 2$ transition matrix. Fast exponentiation reduces $n$ multiplications to $O(\log n)$. The constant is larger; use it when the same recurrence must scale.

We define $\textit{Fib}(n)$ as a $1 \times 2$ matrix $\begin{bmatrix} F_n & F_{n - 1} \end{bmatrix}$, where $F_n$ and $F_{n - 1}$ are the $n$-th and $(n - 1)$-th Fibonacci numbers, respectively.

We want to derive $\textit{Fib}(n)$ from $\textit{Fib}(n - 1) = \begin{bmatrix} F_{n - 1} & F_{n - 2} \end{bmatrix}$. In other words, we need a matrix $\textit{base}$ such that $\textit{Fib}(n - 1) \times \textit{base} = \textit{Fib}(n)$, i.e.:

$$
\begin{bmatrix}
F_{n - 1} & F_{n - 2}
\end{bmatrix} \times \textit{base} = \begin{bmatrix} F_n & F_{n - 1} \end{bmatrix}
$$

Since $F_n = F_{n - 1} + F_{n - 2}$, the first column of the matrix $\textit{base}$ is:

$$
\begin{bmatrix}
1 \\
1
\end{bmatrix}
$$

The second column is:

$$
\begin{bmatrix}
1 \\
0
\end{bmatrix}
$$

Thus, we have:

$$
\begin{bmatrix} F_{n - 1} & F_{n - 2} \end{bmatrix} \times \begin{bmatrix}1 & 1 \\ 1 & 0\end{bmatrix} = \begin{bmatrix} F_n & F_{n - 1} \end{bmatrix}
$$

We define the initial matrix $\textit{res} = \begin{bmatrix} 1 & 0 \end{bmatrix}$, then $F_n$ is equal to the second element of the first row of the result matrix obtained by multiplying $\textit{res}$ with $\textit{base}^{n}$. We can solve this using matrix exponentiation.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public int fib(int n) {
        int[][] a = {{1, 1}, {1, 0}};
        return pow(a, n)[0][1];
    }

    private int[][] mul(int[][] a, int[][] b) {
        int m = a.length, n = b[0].length;
        int[][] c = new int[m][n];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                for (int k = 0; k < b.length; ++k) {
                    c[i][j] = c[i][j] + a[i][k] * b[k][j];
                }
            }
        }
        return c;
    }

    private int[][] pow(int[][] a, int n) {
        int[][] res = {{1, 0}};
        while (n > 0) {
            if ((n & 1) == 1) {
                res = mul(res, a);
            }
            a = mul(a, a);
            n >>= 1;
        }
        return res;
    }
}
```
