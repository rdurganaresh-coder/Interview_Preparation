# 2369. Check if There is a Valid Partition For The Array

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/

---

[中文文档](/solution/2300-2399/2369.Check%20if%20There%20is%20a%20Valid%20Partition%20For%20The%20Array/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code>. You have to partition the array into one or more <strong>contiguous</strong> subarrays.</p>

<p>We call a partition of the array <strong>valid</strong> if each of the obtained subarrays satisfies <strong>one</strong> of the following conditions:</p>

<ol>
	<li>The subarray consists of <strong>exactly</strong> <code>2,</code> equal elements. For example, the subarray <code>[2,2]</code> is good.</li>
	<li>The subarray consists of <strong>exactly</strong> <code>3,</code> equal elements. For example, the subarray <code>[4,4,4]</code> is good.</li>
	<li>The subarray consists of <strong>exactly</strong> <code>3</code> consecutive increasing elements, that is, the difference between adjacent elements is <code>1</code>. For example, the subarray <code>[3,4,5]</code> is good, but the subarray <code>[1,3,5]</code> is not.</li>
</ol>

<p>Return <code>true</code><em> if the array has <strong>at least</strong> one valid partition</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [4,4,4,5,6]
<strong>Output:</strong> true
<strong>Explanation:</strong> The array can be partitioned into the subarrays [4,4] and [4,5,6].
This partition is valid, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,1,2]
<strong>Output:</strong> false
<strong>Explanation:</strong> There is no valid partition for this array.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Memoization Search

> **Thinking**
>
> A partition uses two equals, three equals, or three consecutive increases. $n \le 10^5$ makes naive recursion overlap. Validity from index $i$ depends only on the suffix.
>
> Memoize $\textit{dfs}(i)$: try a legal block of length $2$ or $3$ and jump to its end. Past $n$ is success.

We design a function $\textit{dfs}(i)$, which represents whether there is a valid partition starting from index $i$. So the answer is $\textit{dfs}(0)$.

The execution process of the function $\textit{dfs}(i)$ is as follows:

- If $i \ge n$, return $\textit{true}$.
- If the elements at index $i$ and $i+1$ are equal, we can choose to make $i$ and $i+1$ a subarray, and recursively call $\textit{dfs}(i+2)$.
- If the elements at index $i$, $i+1$ and $i+2$ are equal, we can choose to make $i$, $i+1$ and $i+2$ a subarray, and recursively call $\textit{dfs}(i+3)$.
- If the elements at index $i$, $i+1$ and $i+2$ increase by $1$ in turn, we can choose to make $i$, $i+1$ and $i+2$ a subarray, and recursively call $\textit{dfs}(i+3)$.
- If none of the above conditions are met, return $\textit{false}$, otherwise return $\textit{true}$.

That is:

$$
dfs(i) = \textit{OR}
\begin{cases}
\textit{true},&i \ge n\\
dfs(i+2),&i+1 < n\ \text{and}\ \textit{nums}[i] = \textit{nums}[i+1]\\
dfs(i+3),&i+2 < n\ \text{and}\ \textit{nums}[i] = \textit{nums}[i+1] = \textit{nums}[i+2]\\
dfs(i+3),&i+2 < n\ \text{and}\ \textit{nums}[i+1] - \textit{nums}[i] = 1\ \text{and}\ \textit{nums}[i+2] - \textit{nums}[i+1] = 1
\end{cases}
$$

To avoid repeated calculations, we use the method of memoization search.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    private int n;
    private int[] nums;
    private Boolean[] f;

    public boolean validPartition(int[] nums) {
        n = nums.length;
        this.nums = nums;
        f = new Boolean[n];
        return dfs(0);
    }

    private boolean dfs(int i) {
        if (i >= n) {
            return true;
        }
        if (f[i] != null) {
            return f[i];
        }
        boolean a = i + 1 < n && nums[i] == nums[i + 1];
        boolean b = i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2];
        boolean c = i + 2 < n && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1;
        return f[i] = ((a && dfs(i + 2)) || ((b || c) && dfs(i + 3)));
    }
}
```

### Solution 2: Dynamic Programming

> **Thinking**
>
> Solution 1 fills a suffix table from the end. The same three blocks can be written on prefixes: $f[i]$ means the first $i$ elements form a valid partition, taken from $f[i-2]$ or $f[i-3]$.
>
> Fill left to right. The answer is $f[n]$. Time stays $O(n)$.

Solution 1 already decides each suffix from the end. Here we decide each prefix instead, using the same three blocks.

Let $f[i]$ represent whether there is a valid partition for the first $i$ elements of the array. Initially, $f[0] = \textit{true}$, and the answer is $f[n]$.

The state transition equation is as follows:

$$
f[i] = \textit{OR}
\begin{cases}
\textit{true},&i = 0\\
f[i-2],&i-2 \ge 0\ \text{and}\ \textit{nums}[i-1] = \textit{nums}[i-2]\\
f[i-3],&i-3 \ge 0\ \text{and}\ \textit{nums}[i-1] = \textit{nums}[i-2] = \textit{nums}[i-3]\\
f[i-3],&i-3 \ge 0\ \text{and}\ \textit{nums}[i-1] - \textit{nums}[i-2] = 1\ \text{and}\ \textit{nums}[i-2] - \textit{nums}[i-3] = 1
\end{cases}
$$

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[0] = true;
        for (int i = 1; i <= n; ++i) {
            boolean a = i - 2 >= 0 && nums[i - 1] == nums[i - 2];
            boolean b = i - 3 >= 0 && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3];
            boolean c
                = i - 3 >= 0 && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1;
            f[i] = (a && f[i - 2]) || ((b || c) && f[i - 3]);
        }
        return f[n];
    }
}
```

### Solution 3: Dynamic Programming

> **Thinking**
>
> A partition is two equals, three equals, or three consecutive increases. $n \le 10^5$, so trying blocks overlaps, and the pair is always tried first.
>
> On an array of equal values that attempt is a chain of length $n/2$, which overflows the stack.
>
> Later indexes are known if we walk backward. Let $f[i]$ mean the suffix from $i$ has a valid partition, with $f[n]$ true, and fill $i$ from $n-1$ down to $0$. A legal block still jumps to $i+2$ or $i+3$.

Let $f[i]$ mean there is a valid partition of the suffix starting at index $i$. The answer is $f[0]$, and $f[n] = \textit{true}$.

Fill $i$ from $n - 1$ down to $0$. Two equal neighbors can continue from $f[i + 2]$. Three equal values, or three values that increase by $1$, can continue from $f[i + 3]$. Take the or of those cases; if none applies, $f[i]$ is false:

$$
f[i] = \textit{OR}
\begin{cases}
f[i+2],&i+1 < n\ \text{and}\ \textit{nums}[i] = \textit{nums}[i+1]\\
f[i+3],&i+2 < n\ \text{and}\ \textit{nums}[i] = \textit{nums}[i+1] = \textit{nums}[i+2]\\
f[i+3],&i+2 < n\ \text{and}\ \textit{nums}[i+1] - \textit{nums}[i] = 1\ \text{and}\ \textit{nums}[i+2] - \textit{nums}[i+1] = 1
\end{cases}
$$

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] f = new boolean[n + 1];
        f[n] = true;
        for (int i = n - 1; i >= 0; --i) {
            boolean a = i + 1 < n && nums[i] == nums[i + 1];
            boolean b = i + 2 < n && nums[i] == nums[i + 1] && nums[i + 1] == nums[i + 2];
            boolean c = i + 2 < n && nums[i + 1] - nums[i] == 1 && nums[i + 2] - nums[i + 1] == 1;
            f[i] = (a && f[i + 2]) || ((b || c) && f[i + 3]);
        }
        return f[0];
    }
}
```
