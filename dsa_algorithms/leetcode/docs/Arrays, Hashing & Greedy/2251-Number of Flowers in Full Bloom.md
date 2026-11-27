# 2251. Number of Flowers in Full Bloom

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-flowers-in-full-bloom/

---

[中文文档](/solution/2200-2299/2251.Number%20of%20Flowers%20in%20Full%20Bloom/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> 2D integer array <code>flowers</code>, where <code>flowers[i] = [start<sub>i</sub>, end<sub>i</sub>]</code> means the <code>i<sup>th</sup></code> flower will be in <strong>full bloom</strong> from <code>start<sub>i</sub></code> to <code>end<sub>i</sub></code> (<strong>inclusive</strong>). You are also given a <strong>0-indexed</strong> integer array <code>people</code> of size <code>n</code>, where <code>people[i]</code> is the time that the <code>i<sup>th</sup></code> person will arrive to see the flowers.</p>

<p>Return <em>an integer array </em><code>answer</code><em> of size </em><code>n</code><em>, where </em><code>answer[i]</code><em> is the <strong>number</strong> of flowers that are in full bloom when the </em><code>i<sup>th</sup></code><em> person arrives.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2251.Number%20of%20Flowers%20in%20Full%20Bloom/images/ex1new.jpg" style="width: 550px; height: 216px;" />
<pre>
<strong>Input:</strong> flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
<strong>Output:</strong> [1,2,2,2]
<strong>Explanation: </strong>The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2200-2299/2251.Number%20of%20Flowers%20in%20Full%20Bloom/images/ex2new.jpg" style="width: 450px; height: 195px;" />
<pre>
<strong>Input:</strong> flowers = [[1,10],[3,3]], people = [3,3,2]
<strong>Output:</strong> [2,2,1]
<strong>Explanation:</strong> The figure above shows the times when the flowers are in full bloom and when the people arrive.
For each person, we return the number of flowers in full bloom during their arrival.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= flowers.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>flowers[i].length == 2</code></li>
	<li><code>1 &lt;= start<sub>i</sub> &lt;= end<sub>i</sub> &lt;= 10<sup>9</sup></code></li>
	<li><code>1 &lt;= people.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= people[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Binary Search

> **Thinking**
>
> For each arrival time, count flowers still in bloom. Both arrays can have $5\times 10^4$ entries and times go to $10^9$. A flower is open at $t$ iff $\textit{start} \le t \le \textit{end}$, i.e. opened-so-far minus already-wilted.
>
> Sort all start times and all end times. For arrival $p$, $\textit{bisect\_right}$ on starts minus $\textit{bisect\_left}$ on ends is the count.

We sort the flowers by their start and end times. Then, for each person, we can use binary search to find the number of flowers in bloom when they arrive. This means finding the number of flowers that have started blooming by the time each person arrives, minus the number of flowers that have wilted by that time, to get the answer.

The time complexity is $O((m + n) \log n)$, and the space complexity is $O(n)$, where $n$ and $m$ are the lengths of the arrays $\textit{flowers}$ and $\textit{people}$, respectively.

#### Java

```java
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int n = flowers.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; ++i) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int m = people.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; ++i) {
            ans[i] = search(start, people[i] + 1) - search(end, people[i]);
        }
        return ans;
    }

    private int search(int[] nums, int x) {
        int l = 0, r = nums.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] >= x) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
```

### Solution 2: Difference Array + Sorting + Offline Query

> **Thinking**
>
> Solution 1 binary-searches each query separately. The same counts are a difference array: plus one at $\textit{start}$, minus one at $\textit{end}+1$. Sweep the sorted event times together with arrivals.
>
> A pointer accumulates every event at time $\le t$, which is the bloom count for that visitor. The asymptotics match, without two binary searches per query.

We can use a difference array to maintain the number of flowers at each time point. Next, we sort $\textit{people}$ by their arrival times in ascending order. When each person arrives, we perform a prefix sum operation on the difference array to get the answer.

The time complexity is $O(m \log m + n \log n)$, and the space complexity is $O(n + m)$, where $n$ and $m$ are the lengths of the arrays $\textit{flowers}$ and $\textit{people}$, respectively.

#### Java

```java
class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (int[] f : flowers) {
            d.merge(f[0], 1, Integer::sum);
            d.merge(f[1] + 1, -1, Integer::sum);
        }
        int s = 0;
        int m = people.length;
        Integer[] idx = new Integer[m];
        for (int i = 0; i < m; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, Comparator.comparingInt(i -> people[i]));
        int[] ans = new int[m];
        for (int i : idx) {
            int t = people[i];
            while (!d.isEmpty() && d.firstKey() <= t) {
                s += d.pollFirstEntry().getValue();
            }
            ans[i] = s;
        }
        return ans;
    }
}
```
