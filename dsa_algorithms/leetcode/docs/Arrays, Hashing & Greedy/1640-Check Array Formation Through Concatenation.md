# 1640. Check Array Formation Through Concatenation

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/check-array-formation-through-concatenation/

---

[中文文档](/solution/1600-1699/1640.Check%20Array%20Formation%20Through%20Concatenation/README.md)

## Description

<p>You are given an array of <strong>distinct</strong> integers <code>arr</code> and an array of integer arrays <code>pieces</code>, where the integers in <code>pieces</code> are <strong>distinct</strong>. Your goal is to form <code>arr</code> by concatenating the arrays in <code>pieces</code> <strong>in any order</strong>. However, you are <strong>not</strong> allowed to reorder the integers in each array <code>pieces[i]</code>.</p>

<p>Return <code>true</code> <em>if it is possible </em><em>to form the array </em><code>arr</code><em> from </em><code>pieces</code>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [15,88], pieces = [[88],[15]]
<strong>Output:</strong> true
<strong>Explanation:</strong> Concatenate [15] then [88]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [49,18,16], pieces = [[16,18,49]]
<strong>Output:</strong> false
<strong>Explanation:</strong> Even though the numbers match, we cannot reorder pieces[0].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> arr = [91,4,64,78], pieces = [[78],[4,64],[91]]
<strong>Output:</strong> true
<strong>Explanation:</strong> Concatenate [91] then [4,64] then [78]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= pieces.length &lt;= arr.length &lt;= 100</code></li>
	<li><code>sum(pieces[i].length) == arr.length</code></li>
	<li><code>1 &lt;= pieces[i].length &lt;= arr.length</code></li>
	<li><code>1 &lt;= arr[i], pieces[i][j] &lt;= 100</code></li>
	<li>The integers in <code>arr</code> are <strong>distinct</strong>.</li>
	<li>The integers in <code>pieces</code> are <strong>distinct</strong> (i.e., If we flatten pieces in a 1D array, all the integers in this array are distinct).</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Each piece is ordered and values are unique, so we walk $\textit{arr}$ and match the piece that starts with the current value. $n \le 100$ allows a linear search for that piece.
>
> Pointer $i$ scans $\textit{arr}$ and looks up the piece whose first element is $\textit{arr}[i]$; a failed match means we cannot form the array.

#### Java

```java
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        for (int i = 0; i < arr.length;) {
            int k = 0;
            while (k < pieces.length && pieces[k][0] != arr[i]) {
                ++k;
            }
            if (k == pieces.length) {
                return false;
            }
            int j = 0;
            while (j < pieces[k].length && arr[i] == pieces[k][j]) {
                ++i;
                ++j;
            }
        }
        return true;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 scans every piece at each step. Values are unique, so a map from the first element to the piece makes lookup $O(1)$.
>
> Store $d[p[0]]=p$ and compare $\textit{arr}[i:i+|p|]$ with $p$.

#### Java

```java
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer, int[]> d = new HashMap<>();
        for (var p : pieces) {
            d.put(p[0], p);
        }
        for (int i = 0; i < arr.length;) {
            if (!d.containsKey(arr[i])) {
                return false;
            }
            for (int v : d.get(arr[i])) {
                if (arr[i++] != v) {
                    return false;
                }
            }
        }
        return true;
    }
}
```
