# 624. Maximum Distance in Arrays

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-distance-in-arrays/

---

[中文文档](/solution/0600-0699/0624.Maximum%20Distance%20in%20Arrays/README.md)

## Description

<p>You are given <code>m</code> <code>arrays</code>, where each array is sorted in <strong>ascending order</strong>.</p>

<p>You can pick up two integers from two different arrays (each array picks one) and calculate the distance. We define the distance between two integers <code>a</code> and <code>b</code> to be their absolute difference <code>|a - b|</code>.</p>

<p>Return <em>the maximum distance</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arrays = [[1,2,3],[4,5],[1,2,3]]
<strong>Output:</strong> 4
<strong>Explanation:</strong> One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arrays = [[1],[1]]
<strong>Output:</strong> 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>m == arrays.length</code></li>
	<li><code>2 &lt;= m &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= arrays[i].length &lt;= 500</code></li>
	<li><code>-10<sup>4</sup> &lt;= arrays[i][j] &lt;= 10<sup>4</sup></code></li>
	<li><code>arrays[i]</code> is sorted in <strong>ascending order</strong>.</li>
	<li>There will be at most <code>10<sup>5</sup></code> integers in all the arrays.</li>
</ul>

## Solutions

### Solution 1: Maintain Maximum and Minimum Values

> **Thinking**
>
> The distance uses endpoints from two different arrays. Pairing every two arrays is quadratic when there are $10^4$ arrays.
>
> The optimum is always a current endpoint versus a previous global min or max. Compare first, then merge the current array's ends into $mi$ and $mx$ so both ends never come from the same array.

We notice that the maximum distance must be the distance between the maximum value in one array and the minimum value in another array. Therefore, we can maintain two variables $mi$ and $mx$, representing the minimum and maximum values of the arrays we have traversed. Initially, $mi$ and $mx$ are the first and last elements of the first array, respectively.

Next, we traverse from the second array. For each array, we first calculate the distance between the first element of the current array and $mx$, and the distance between the last element of the current array and $mi$. Then, we update the maximum distance. At the same time, we update $mi = \min(mi, \textit{arr}[0])$ and $mx = \max(mx, \textit{arr}[\textit{size} - 1])$.

After traversing all arrays, we get the maximum distance.

The time complexity is $O(m)$, and the space complexity is $O(1)$, where $m$ is the number of arrays.

#### Java

```java
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int ans = 0;
        int mi = arrays.get(0).get(0);
        int mx = arrays.get(0).get(arrays.get(0).size() - 1);
        for (int i = 1; i < arrays.size(); ++i) {
            var arr = arrays.get(i);
            int a = Math.abs(arr.get(0) - mx);
            int b = Math.abs(arr.get(arr.size() - 1) - mi);
            ans = Math.max(ans, Math.max(a, b));
            mi = Math.min(mi, arr.get(0));
            mx = Math.max(mx, arr.get(arr.size() - 1));
        }
        return ans;
    }
}
```
