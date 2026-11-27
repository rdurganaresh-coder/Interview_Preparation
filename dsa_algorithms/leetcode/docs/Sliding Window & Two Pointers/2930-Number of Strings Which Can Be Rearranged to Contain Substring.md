# 2930. Number of Strings Which Can Be Rearranged to Contain Substring

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/

---

[中文文档](/solution/2900-2999/2930.Number%20of%20Strings%20Which%20Can%20Be%20Rearranged%20to%20Contain%20Substring/README.md)

## Description

<p>You are given an integer <code>n</code>.</p>

<p>A string <code>s</code> is called <strong>good </strong>if it contains only lowercase English characters <strong>and</strong> it is possible to rearrange the characters of <code>s</code> such that the new string contains <code>&quot;leet&quot;</code> as a <strong>substring</strong>.</p>

<p>For example:</p>

<ul>
	<li>The string <code>&quot;lteer&quot;</code> is good because we can rearrange it to form <code>&quot;leetr&quot;</code> .</li>
	<li><code>&quot;letl&quot;</code> is not good because we cannot rearrange it to contain <code>&quot;leet&quot;</code> as a substring.</li>
</ul>

<p>Return <em>the <strong>total</strong> number of good strings of length </em><code>n</code>.</p>

<p>Since the answer may be large, return it <strong>modulo </strong><code>10<sup>9</sup> + 7</code>.</p>

<p>A <strong>substring</strong> is a contiguous sequence of characters within a string.</p>

<div class="notranslate" style="all: initial;">&nbsp;</div>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 4
<strong>Output:</strong> 12
<strong>Explanation:</strong> The 12 strings which can be rearranged to have &quot;leet&quot; as a substring are: &quot;eelt&quot;, &quot;eetl&quot;, &quot;elet&quot;, &quot;elte&quot;, &quot;etel&quot;, &quot;etle&quot;, &quot;leet&quot;, &quot;lete&quot;, &quot;ltee&quot;, &quot;teel&quot;, &quot;tele&quot;, and &quot;tlee&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 10
<strong>Output:</strong> 83943898
<strong>Explanation:</strong> The number of strings with length 10 which can be rearranged to have &quot;leet&quot; as a substring is 526083947580. Hence the answer is 526083947580 % (10<sup>9</sup> + 7) = 83943898.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> A length-$n$ lowercase string must be rearrangeable to contain $\textit{leet}$, i.e. at least one $l$, two $e$, and one $t$. Building counted strings and multiplying by permutations overcounts. Filling positions while tracking whether those three quotas are met uses $n \times 2 \times 3 \times 2$ states.
>
> $\textit{dfs}(i,l,e,t)$ tries “other”, $l$, $e$, or $t$, capping the last three at $1,2,1$. For $n \le 10^5$ the memo size matches the state space.

We design a function $\textit{dfs}(i, l, e, t)$, which represents the number of good strings that can be formed when the remaining string length is $i$, and there are at least $l$ characters 'l', $e$ characters 'e' and $t$ characters 't'. The answer is $\textit{dfs}(n, 0, 0, 0)$.

The execution logic of the function $\textit{dfs}(i, l, e, t)$ is as follows:

If $i = 0$, it means that the current string has been constructed. If $l = 1$, $e = 2$ and $t = 1$, it means that the current string is a good string, return $1$, otherwise return $0$.

Otherwise, we can consider adding any lowercase letter other than 'l', 'e', 't' at the current position, there are 23 in total, so the number of schemes obtained at this time is $\textit{dfs}(i - 1, l, e, t) \times 23$.

We can also consider adding 'l' at the current position, and the number of schemes obtained at this time is $\textit{dfs}(i - 1, \min(1, l + 1), e, t)$. Similarly, the number of schemes for adding 'e' and 't' are $\textit{dfs}(i - 1, l, \min(2, e + 1), t)$ and $\textit{dfs}(i - 1, l, e, \min(1, t + 1))$ respectively. Add them up and take the modulus of $10^9 + 7$ to get the value of $\textit{dfs}(i, l, e, t)$.

To avoid repeated calculations, we can use memoization search.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    private final int mod = (int) 1e9 + 7;
    private Long[][][][] f;

    public int stringCount(int n) {
        f = new Long[n + 1][2][3][2];
        return (int) dfs(n, 0, 0, 0);
    }

    private long dfs(int i, int l, int e, int t) {
        if (i == 0) {
            return l == 1 && e == 2 && t == 1 ? 1 : 0;
        }
        if (f[i][l][e][t] != null) {
            return f[i][l][e][t];
        }
        long a = dfs(i - 1, l, e, t) * 23 % mod;
        long b = dfs(i - 1, Math.min(1, l + 1), e, t);
        long c = dfs(i - 1, l, Math.min(2, e + 1), t);
        long d = dfs(i - 1, l, e, Math.min(1, t + 1));
        return f[i][l][e][t] = (a + b + c + d) % mod;
    }
}
```

### Solution 2: Reverse Thinking + Inclusion-Exclusion Principle

> **Thinking**
>
> Method 1 walks the length and spends a linear number of transitions. The complement is shorter: $26^n$ minus strings missing $l$, missing $t$, or having fewer than two $e$, with intersections restored by inclusion-exclusion.
>
> Each set forbids some letters or limits $e$, so fast powers give $25^n$, $24^n$, and the “zero or one $e$” terms. For large $n$ this is leaner than the stepwise DP.

We can consider reverse thinking, that is, calculate the number of strings that do not contain the substring "leet", and then subtract this number from the total.

We divide it into the following cases:

- Case $a$: represents the number of schemes where the string does not contain the character 'l', so we have $a = 25^n$.
- Case $b$: similar to $a$, represents the number of schemes where the string does not contain the character 't', so we have $b = 25^n$.
- Case $c$: represents the number of schemes where the string does not contain the character 'e' or only contains one character 'e', so we have $c = 25^n + n \times 25^{n - 1}$.
- Case $ab$: represents the number of schemes where the string does not contain the characters 'l' and 't', so we have $ab = 24^n$.
- Case $ac$: represents the number of schemes where the string does not contain the characters 'l' and 'e' or only contains one character 'e', so we have $ac = 24^n + n \times 24^{n - 1}$.
- Case $bc$: similar to $ac$, represents the number of schemes where the string does not contain the characters 't' and 'e' or only contains one character 'e', so we have $bc = 24^n + n \times 24^{n - 1}$.
- Case $\textit{abc}$: represents the number of schemes where the string does not contain the characters 'l', 't' and 'e' or only contains one character 'e', so we have $\textit{abc} = 23^n + n \times 23^{n - 1}$.

Then according to the inclusion-exclusion principle, $a + b + c - ab - ac - bc + \textit{abc}$ is the number of strings that do not contain the substring "leet".

The total number $\textit{tot} = 26^n$, so the answer is $\textit{tot} - (a + b + c - ab - ac - bc + \textit{abc})$, remember to take the modulus of $10^9 + 7$.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    private final int mod = (int) 1e9 + 7;

    public int stringCount(int n) {
        long a = qpow(25, n);
        long b = a;
        long c = (qpow(25, n) + n * qpow(25, n - 1) % mod) % mod;
        long ab = qpow(24, n);
        long ac = (qpow(24, n) + n * qpow(24, n - 1) % mod) % mod;
        long bc = ac;
        long abc = (qpow(23, n) + n * qpow(23, n - 1) % mod) % mod;
        long tot = qpow(26, n);
        return (int) ((tot - (a + b + c - ab - ac - bc + abc)) % mod + mod) % mod;
    }

    private long qpow(long a, int n) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return ans;
    }
}
```

### Solution 3: Dynamic Programming

> **Thinking**
>
> A length-$n$ string is good when a rearrangement contains $\textit{leet}$, so the counts of $l$, $e$, and $t$ must reach $1$, $2$, and $1$. Counting those strings by multinomial coefficients overcounts the overlapping cases. The useful state is only the capped counts, $2 \times 3 \times 2$ possibilities, and a string of length $i$ depends only on length $i - 1$.
>
> Recursing on the remaining length chains $n$ calls. For $n \le 10^5$ that overflows the call stack, and storing every layer in a C++ variable-length array puts about $9.6$MB on the stack.
>
> Two layers of $12$ states are enough. The empty string contributes $1$ only to the quota $(1, 2, 1)$. Each longer string appends one of $23$ other letters, or $l$, $e$, or $t$ under those caps. After $n$ characters, the state $(0, 0, 0)$ is the answer.

Let $f(i, l, e, t)$ be the number of strings of length $i$ that already contain at least $l$ letters `'l'`, $e$ letters `'e'`, and $t$ letters `'t'`. The three counts are capped at $1$, $2$, and $1$. The answer is $f(n, 0, 0, 0)$.

For $i = 0$, only $f(0, 1, 2, 1) = 1$. Every other state is $0$.

For $i \ge 1$, the last character is one of the $23$ letters other than `'l'`, `'e'`, and `'t'`, or it is one of those three letters:

$$
f(i, l, e, t) = 23 \cdot f(i - 1, l, e, t) + f(i - 1, \min(1, l + 1), e, t) + f(i - 1, l, \min(2, e + 1), t) + f(i - 1, l, e, \min(1, t + 1))
$$

Each value is reduced modulo $10^9 + 7$. Layer $i$ reads only layer $i - 1$, so the implementation keeps two arrays of $12$ states.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string.

#### Java

```java
class Solution {
    public int stringCount(int n) {
        final int mod = (int) 1e9 + 7;
        long[][][] f = new long[2][3][2];
        f[1][2][1] = 1;
        for (int i = 0; i < n; ++i) {
            long[][][] g = new long[2][3][2];
            for (int l = 0; l < 2; ++l) {
                for (int e = 0; e < 3; ++e) {
                    for (int t = 0; t < 2; ++t) {
                        long a = f[l][e][t] * 23;
                        long b = f[Math.min(1, l + 1)][e][t];
                        long c = f[l][Math.min(2, e + 1)][t];
                        long d = f[l][e][Math.min(1, t + 1)];
                        g[l][e][t] = (a + b + c + d) % mod;
                    }
                }
            }
            f = g;
        }
        return (int) f[0][0][0];
    }
}
```
