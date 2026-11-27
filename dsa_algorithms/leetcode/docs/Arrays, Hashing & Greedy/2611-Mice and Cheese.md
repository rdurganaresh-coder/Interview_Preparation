# 2611. Mice and Cheese

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/mice-and-cheese/

---

[中文文档](/solution/2600-2699/2611.Mice%20and%20Cheese/README.md)

## Description

<p>There are two mice and <code>n</code> different types of cheese, each type of cheese should be eaten by exactly one mouse.</p>

<p>A point of the cheese with index <code>i</code> (<strong>0-indexed</strong>) is:</p>

<ul>
	<li><code>reward1[i]</code> if the first mouse eats it.</li>
	<li><code>reward2[i]</code> if the second mouse eats it.</li>
</ul>

<p>You are given a positive integer array <code>reward1</code>, a positive integer array <code>reward2</code>, and a non-negative integer <code>k</code>.</p>

<p>Return <em><strong>the maximum</strong> points the mice can achieve if the first mouse eats exactly </em><code>k</code><em> types of cheese.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2
<strong>Output:</strong> 15
<strong>Explanation:</strong> In this example, the first mouse eats the 2<sup>nd</sup>&nbsp;(0-indexed) and the 3<sup>rd</sup>&nbsp;types of cheese, and the second mouse eats the 0<sup>th</sup>&nbsp;and the 1<sup>st</sup> types of cheese.
The total points are 4 + 4 + 3 + 4 = 15.
It can be proven that 15 is the maximum total points that the mice can achieve.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> reward1 = [1,1], reward2 = [1,1], k = 2
<strong>Output:</strong> 2
<strong>Explanation:</strong> In this example, the first mouse eats the 0<sup>th</sup>&nbsp;(0-indexed) and 1<sup>st</sup>&nbsp;types of cheese, and the second mouse does not eat any cheese.
The total points are 1 + 1 = 2.
It can be proven that 2 is the maximum total points that the mice can achieve.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == reward1.length == reward2.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= reward1[i],&nbsp;reward2[i] &lt;= 1000</code></li>
	<li><code>0 &lt;= k &lt;= n</code></li>
</ul>

## Solutions

### Solution 1: Greedy + Sort

> **Thinking**
>
> The first mouse eats exactly $k$ pieces. Choosing a $k$-subset is impossible for $n \le 10^5$.
>
> Give every piece to the second mouse first, then switch $k$ pieces to the first; the delta is $\textit{reward1}[i]-\textit{reward2}[i]$. Larger deltas should be switched.
>
> Sort indices by that difference descending; the first $k$ use $\textit{reward1}$, the rest $\textit{reward2}$.

We can first give all the cheese to the second mouse. Next, consider giving $k$ pieces of cheese to the first mouse. How should we choose these $k$ pieces of cheese? Obviously, if we give the $i$-th piece of cheese from the second mouse to the first mouse, the change in the score is $\textit{reward1}[i] - \textit{reward2}[i]$. We hope that this change is as large as possible, so that the total score is maximized.

Therefore, we sort the cheese in decreasing order of `reward1[i] - reward2[i]`. The first $k$ pieces of cheese are eaten by the first mouse, and the remaining cheese is eaten by the second mouse to obtain the maximum score.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the number of cheeses.

#### Java

```java
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> reward1[j] - reward2[j] - (reward1[i] - reward2[i]));
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += reward1[idx[i]];
        }
        for (int i = k; i < n; ++i) {
            ans += reward2[idx[i]];
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 sorts an index array. Writing the deltas into $\textit{reward1}$ and sorting it in place yields $\sum \textit{reward2}$ plus the $k$ largest deltas, without an index map.

#### Java

```java
class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        for (int i = 0; i < n; ++i) {
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = 0; i < k; ++i) {
            ans += reward1[n - i - 1];
        }
        return ans;
    }
}
```
