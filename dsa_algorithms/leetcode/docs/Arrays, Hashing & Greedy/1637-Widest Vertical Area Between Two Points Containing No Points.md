# 1637. Widest Vertical Area Between Two Points Containing No Points

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/widest-vertical-area-between-two-points-containing-no-points/

---

[中文文档](/solution/1600-1699/1637.Widest%20Vertical%20Area%20Between%20Two%20Points%20Containing%20No%20Points/README.md)

## Description

<p>Given <code>n</code> <code>points</code> on a 2D plane where <code>points[i] = [x<sub>i</sub>, y<sub>i</sub>]</code>, Return<em>&nbsp;the <strong>widest vertical area</strong> between two points such that no points are inside the area.</em></p>

<p>A <strong>vertical area</strong> is an area of fixed-width extending infinitely along the y-axis (i.e., infinite height). The <strong>widest vertical area</strong> is the one with the maximum width.</p>

<p>Note that points <strong>on the edge</strong> of a vertical area <strong>are not</strong> considered included in the area.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1600-1699/1637.Widest%20Vertical%20Area%20Between%20Two%20Points%20Containing%20No%20Points/images/points3.png" style="width: 276px; height: 371px;" />​
<pre>
<strong>Input:</strong> points = [[8,7],[9,9],[7,4],[9,7]]
<strong>Output:</strong> 1
<strong>Explanation:</strong> Both the red and the blue area are optimal.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == points.length</code></li>
	<li><code>2 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>points[i].length == 2</code></li>
	<li><code>0 &lt;= x<sub>i</sub>, y<sub>i</sub>&nbsp;&lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The width of a vertical gap depends only on consecutive $x$-coordinates. With $n$ up to $10^5$, sort by $x$ and scan adjacent differences.
>
> $y$ does not matter; the answer is $\max(x_{i+1}-x_i)$.

#### Java

```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);
        int ans = 0;
        for (int i = 0; i < points.length - 1; ++i) {
            ans = Math.max(ans, points[i + 1][0] - points[i][0]);
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 sorts in $O(n \log n)$. The max gap is at least $(\textit{max}-\textit{min})/(n-1)$; with that bucket width the answer can only lie between consecutive nonempty buckets.
>
> Each bucket stores its min and max $x$; a linear scan of buckets is expected $O(n)$.

#### Java

```java
class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int n = points.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = points[i][0];
        }
        final int inf = 1 << 30;
        int mi = inf, mx = -inf;
        for (int v : nums) {
            mi = Math.min(mi, v);
            mx = Math.max(mx, v);
        }
        int bucketSize = Math.max(1, (mx - mi) / (n - 1));
        int bucketCount = (mx - mi) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][2];
        for (var bucket : buckets) {
            bucket[0] = inf;
            bucket[1] = -inf;
        }
        for (int v : nums) {
            int i = (v - mi) / bucketSize;
            buckets[i][0] = Math.min(buckets[i][0], v);
            buckets[i][1] = Math.max(buckets[i][1], v);
        }
        int prev = inf;
        int ans = 0;
        for (var bucket : buckets) {
            if (bucket[0] > bucket[1]) {
                continue;
            }
            ans = Math.max(ans, bucket[0] - prev);
            prev = bucket[1];
        }
        return ans;
    }
}
```
