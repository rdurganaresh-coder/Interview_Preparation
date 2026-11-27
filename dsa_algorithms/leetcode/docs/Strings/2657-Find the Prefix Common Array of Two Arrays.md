# 2657. Find the Prefix Common Array of Two Arrays

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/

---

[中文文档](/solution/2600-2699/2657.Find%20the%20Prefix%20Common%20Array%20of%20Two%20Arrays/README.md)

## Description

<p>You are given two <strong>0-indexed </strong>integer<strong> </strong>permutations <code>A</code> and <code>B</code> of length <code>n</code>.</p>

<p>A <strong>prefix common array</strong> of <code>A</code> and <code>B</code> is an array <code>C</code> such that <code>C[i]</code> is equal to the count of numbers that are present at or before the index <code>i</code> in both <code>A</code> and <code>B</code>.</p>

<p>Return <em>the <strong>prefix common array</strong> of </em><code>A</code><em> and </em><code>B</code>.</p>

<p>A sequence of <code>n</code> integers is called a&nbsp;<strong>permutation</strong> if it contains all integers from <code>1</code> to <code>n</code> exactly once.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> A = [1,3,2,4], B = [3,1,2,4]
<strong>Output:</strong> [0,2,3,4]
<strong>Explanation:</strong> At i = 0: no number is common, so C[0] = 0.
At i = 1: 1 and 3 are common in A and B, so C[1] = 2.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
At i = 3: 1, 2, 3, and 4 are common in A and B, so C[3] = 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> A = [2,3,1], B = [3,1,2]
<strong>Output:</strong> [0,1,3]
<strong>Explanation:</strong> At i = 0: no number is common, so C[0] = 0.
At i = 1: only 3 is common in A and B, so C[1] = 1.
At i = 2: 1, 2, and 3 are common in A and B, so C[2] = 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= A.length == B.length == n &lt;= 50</code></li>
	<li><code>1 &lt;= A[i], B[i] &lt;= n</code></li>
	<li><code>It is guaranteed that A and B are both a permutation of n integers.</code></li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> We need the size of the intersection of two permutation prefixes. Rebuilding sets each time works for $n \le 50$, but a prefix grows by one element.
>
> Count occurrences in $A$ and $B$ and sum $\min$ over $[1,n]$ to obtain the current common count.

We can use two arrays $\textit{cnt1}$ and $\textit{cnt2}$ to record the occurrence times of each element in arrays $A$ and $B$ respectively, and use an array $\textit{ans}$ to record the answer.

Traverse arrays $A$ and $B$, increment the occurrence times of $A[i]$ in $\textit{cnt1}$, and increment the occurrence times of $B[i]$ in $\textit{cnt2}$. Then enumerate $j \in [1,n]$, calculate the minimum occurrence times of each element $j$ in $\textit{cnt1}$ and $\textit{cnt2}$, and accumulate them into $\textit{ans}[i]$.

After the traversal, return the answer array $\textit{ans}$.

The time complexity is $O(n^2)$, and the space complexity is $O(n)$, where $n$ is the length of arrays $A$ and $B$.

#### Java

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] cnt1 = new int[n + 1];
        int[] cnt2 = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            ++cnt1[A[i]];
            ++cnt2[B[i]];
            for (int j = 1; j <= n; ++j) {
                ans[i] += Math.min(cnt1[j], cnt2[j]);
            }
        }
        return ans;
    }
}
```

### Solution 2: Bit Operation (XOR Operation)

> **Thinking**
>
> Solution 1 scans the domain every step. Each value appears once per array, so XOR-flipping a $\textit{vis}$ flag increments the common count on the second sighting, an $O(1)$ update.

We can use an array $\textit{vis}$ of length $n+1$ to record the occurrence situation of each element in arrays $A$ and $B$, the initial value of array $\textit{vis}$ is $1$. In addition, we use a variable $s$ to record the current number of common elements.

Next, we traverse arrays $A$ and $B$, update $\textit{vis}[A[i]] = \textit{vis}[A[i]] \oplus 1$, and update $\textit{vis}[B[i]] = \textit{vis}[B[i]] \oplus 1$, where $\oplus$ represents XOR operation.

If at the current position, the element $A[i]$ has appeared twice (i.e., it has appeared in both arrays $A$ and $B$), then the value of $\textit{vis}[A[i]]$ will be $1$, and we increment $s$. Similarly, if the element $B[i]$ has appeared twice, then the value of $\textit{vis}[B[i]]$ will be $1$, and we increment $s$. Then add the value of $s$ to the answer array $\textit{ans}$.

After the traversal, return the answer array $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of arrays $A$ and $B$.

#### Java

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        int[] vis = new int[n + 1];
        Arrays.fill(vis, 1);
        int s = 0;
        for (int i = 0; i < n; ++i) {
            vis[A[i]] ^= 1;
            s += vis[A[i]];
            vis[B[i]] ^= 1;
            s += vis[B[i]];
            ans[i] = s;
        }
        return ans;
    }
}
```

### Solution 3: Bit Manipulation (Space Optimization)

> **Thinking**
>
> Solution 2 still uses a linear array. With $n \le 50$, two integer bitsets suffice: prefix OR plus `bit_count(x & y)` is the intersection size in constant extra space.

Since the elements of arrays $A$ and $B$ are in the range $[1, n]$ and do not exceed $50$, we can use an integer $x$ and an integer $y$ to represent the occurrence of each element in arrays $A$ and $B$, respectively. Specifically, we use the $i$-th bit of integer $x$ to indicate whether element $i$ has appeared in array $A$, and the $i$-th bit of integer $y$ to indicate whether element $i$ has appeared in array $B$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of arrays $A$ and $B$.

#### Java

```java
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];
        long x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            x |= 1L << A[i];
            y |= 1L << B[i];
            ans[i] = Long.bitCount(x & y);
        }
        return ans;
    }
}
```
