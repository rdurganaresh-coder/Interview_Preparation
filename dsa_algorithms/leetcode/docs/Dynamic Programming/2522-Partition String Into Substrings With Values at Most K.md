# 2522. Partition String Into Substrings With Values at Most K

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/partition-string-into-substrings-with-values-at-most-k/

---

[中文文档](/solution/2500-2599/2522.Partition%20String%20Into%20Substrings%20With%20Values%20at%20Most%20K/README.md)

## Description

<p>You are given a string <code>s</code> consisting of digits from <code>1</code> to <code>9</code> and an integer <code>k</code>.</p>

<p>A partition of a string <code>s</code> is called <strong>good</strong> if:</p>

<ul>
	<li>Each digit of <code>s</code> is part of <strong>exactly</strong> one substring.</li>
	<li>The value of each substring is less than or equal to <code>k</code>.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> number of substrings in a <strong>good</strong> partition of</em> <code>s</code>. If no <strong>good</strong> partition of <code>s</code> exists, return <code>-1</code>.</p>

<p><b>Note</b> that:</p>

<ul>
	<li>The <strong>value</strong> of a string is its result when interpreted as an integer. For example, the value of <code>&quot;123&quot;</code> is <code>123</code> and the value of <code>&quot;1&quot;</code> is <code>1</code>.</li>
	<li>A <strong>substring</strong> is a contiguous sequence of characters within a string.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;165462&quot;, k = 60
<strong>Output:</strong> 4
<strong>Explanation:</strong> We can partition the string into substrings &quot;16&quot;, &quot;54&quot;, &quot;6&quot;, and &quot;2&quot;. Each substring has a value less than or equal to k = 60.
It can be shown that we cannot partition the string into less than 4 substrings.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;238182&quot;, k = 5
<strong>Output:</strong> -1
<strong>Explanation:</strong> There is no good partition for this string.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is a digit from <code>&#39;1&#39;</code> to <code>&#39;9&#39;</code>.</li>
	<li><code>1 &lt;= k &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<style type="text/css">.spoilerbutton {display:block; border:dashed; padding: 0px 0px; margin:10px 0px; font-size:150%; font-weight: bold; color:#000000; background-color:cyan; outline:0; 
}
.spoiler {overflow:hidden;}
.spoiler > div {-webkit-transition: all 0s ease;-moz-transition: margin 0s ease;-o-transition: all 0s ease;transition: margin 0s ease;}
.spoilerbutton[value="Show Message"] + .spoiler > div {margin-top:-500%;}
.spoilerbutton[value="Hide Message"] + .spoiler {padding:5px;}
</style>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> Split the digit string into substrings whose integer values are at most $k$, using as few pieces as possible. Full partitions are impossible at $n\le 10^5$, but a valid piece is at most the number of digits of $k$ long, so each start extends only a constant number of ways.
>
> Let $\textit{dfs}(i)$ be the fewest pieces from index $i$. Accumulate the value to the right, stop once it exceeds $k$, and take $1+\textit{dfs}(j+1)$ over legal ends. Memoization evaluates each start once; impossibility is $\infty$, reported as $-1$.

We design a function $\textit{dfs}(i)$ to represent the minimum number of partitions starting from index $i$ of string $s$. The answer is $\textit{dfs}(0)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

- If $i \geq n$, it means that it has reached the end of the string, return $0$.
- Otherwise, we enumerate all substrings starting from $i$. If the value of the substring is less than or equal to $k$, then we can take the substring as a partition. Then we can get $\textit{dfs}(j + 1)$, where $j$ is the end index of the substring. We take the minimum value among all possible partitions, add $1$, and that is the value of $\textit{dfs}(i)$.

Finally, if $\textit{dfs}(0) = \infty$, it means there is no good partition, return $-1$. Otherwise, return $\textit{dfs}(0)$.

To avoid repeated calculations, we can use memoization search.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    private Integer[] f;
    private int n;
    private String s;
    private int k;
    private int inf = 1 << 30;

    public int minimumPartition(String s, int k) {
        n = s.length();
        f = new Integer[n];
        this.s = s;
        this.k = k;
        int ans = dfs(0);
        return ans < inf ? ans : -1;
    }

    private int dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        int res = inf;
        long v = 0;
        for (int j = i; j < n; ++j) {
            v = v * 10 + (s.charAt(j) - '0');
            if (v > k) {
                break;
            }
            res = Math.min(res, dfs(j + 1));
        }
        return f[i] = res + 1;
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Enumerating every partition is exponential. The string length can reach $10^5$, and each digit is from $1$ to $9$, so whenever the current digit is at most $k$ the first call always lands on the next index and the chain has depth $n$. A piece cannot grow once its value exceeds $k$, so the fewest pieces from index $i$ depend only on later indices. Let $f[i]$ be that count, with $f[n]=0$, and fill $i$ from $n-1$ down to $0$: accumulate the substring value, update from each end that stays within $k$ using $f[j+1]$, then add one. If $f[0]$ is still at least the sentinel, return $-1$.

We let $f[i]$ be the minimum number of partitions starting from index $i$ of string $s$, with $f[n] = 0$. The answer is $f[0]$.

Scan $i$ from $n - 1$ down to $0$. Accumulate the integer value of the substring starting at $i$, and stop once it exceeds $k$. For each end $j$ whose value is at most $k$, update $f[i]$ with $f[j + 1]$, then add one to $f[i]$.

If $f[0]$ is at least the preset upper bound, there is no good partition and we return $-1$. Otherwise we return $f[0]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int minimumPartition(String s, int k) {
        int n = s.length();
        int inf = 1 << 30;
        int[] f = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        for (int i = n - 1; i >= 0; --i) {
            long v = 0;
            for (int j = i; j < n; ++j) {
                v = v * 10 + (s.charAt(j) - '0');
                if (v > k) {
                    break;
                }
                f[i] = Math.min(f[i], f[j + 1]);
            }
            ++f[i];
        }
        return f[0] < inf ? f[0] : -1;
    }
}
```
