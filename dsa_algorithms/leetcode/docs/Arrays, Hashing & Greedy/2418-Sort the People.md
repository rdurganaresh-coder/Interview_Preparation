# 2418. Sort the People

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/sort-the-people/

---

[中文文档](/solution/2400-2499/2418.Sort%20the%20People/README.md)

## Description

<p>You are given an array of strings <code>names</code>, and an array <code>heights</code> that consists of <strong>distinct</strong> positive integers. Both arrays are of length <code>n</code>.</p>

<p>For each index <code>i</code>, <code>names[i]</code> and <code>heights[i]</code> denote the name and height of the <code>i<sup>th</sup></code> person.</p>

<p>Return <code>names</code><em> sorted in <strong>descending</strong> order by the people&#39;s heights</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> names = [&quot;Mary&quot;,&quot;John&quot;,&quot;Emma&quot;], heights = [180,165,170]
<strong>Output:</strong> [&quot;Mary&quot;,&quot;Emma&quot;,&quot;John&quot;]
<strong>Explanation:</strong> Mary is the tallest, followed by Emma and John.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> names = [&quot;Alice&quot;,&quot;Bob&quot;,&quot;Bob&quot;], heights = [155,185,150]
<strong>Output:</strong> [&quot;Bob&quot;,&quot;Alice&quot;,&quot;Bob&quot;]
<strong>Explanation:</strong> The first Bob is the tallest, followed by Alice and the second Bob.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == names.length == heights.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>3</sup></code></li>
	<li><code>1 &lt;= names[i].length &lt;= 20</code></li>
	<li><code>1 &lt;= heights[i] &lt;= 10<sup>5</sup></code></li>
	<li><code>names[i]</code> consists of lower and upper case English letters.</li>
	<li>All the values of <code>heights</code> are distinct.</li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> With $n\le 10^3$, sort names by descending height. Heights are unique, so the key is total. Sort indices by $\textit{heights}$ descending, then emit $\textit{names}[i]$.

According to the problem description, we can create an index array $\textit{idx}$ of length $n$, where $\textit{idx}[i]=i$. Then we sort each index in $\textit{idx}$ in descending order according to the corresponding height in $\textit{heights}$. Finally, we traverse each index $i$ in the sorted $\textit{idx}$ and add $\textit{names}[i]$ to the answer array.

We can also create an array $\textit{arr}$ of length $n$, where each element is a tuple $(\textit{heights}[i], i)$. Then we sort $\textit{arr}$ in descending order by height. Finally, we traverse each element $(\textit{heights}[i], i)$ in the sorted $\textit{arr}$ and add $\textit{names}[i]$ to the answer array.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the arrays $\textit{names}$ and $\textit{heights}$.

#### Java

```java
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> heights[j] - heights[i]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[idx[i]];
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Method 1 already sorts via an index array. Zipping height with name and sorting that pair descending removes the extra index array; the order is the same.

#### Java

```java
class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {heights[i], i};
        }
        Arrays.sort(arr, (a, b) -> b[0] - a[0]);
        String[] ans = new String[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = names[arr[i][1]];
        }
        return ans;
    }
}
```
