# 2530. Maximal Score After Applying K Operations

**Difficulty:** Medium  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/maximal-score-after-applying-k-operations/

---

[中文文档](/solution/2500-2599/2530.Maximal%20Score%20After%20Applying%20K%20Operations/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> and an integer <code>k</code>. You have a <strong>starting score</strong> of <code>0</code>.</p>

<p>In one <strong>operation</strong>:</p>

<ol>
	<li>choose an index <code>i</code> such that <code>0 &lt;= i &lt; nums.length</code>,</li>
	<li>increase your <strong>score</strong> by <code>nums[i]</code>, and</li>
	<li>replace <code>nums[i]</code> with <code>ceil(nums[i] / 3)</code>.</li>
</ol>

<p>Return <em>the maximum possible <strong>score</strong> you can attain after applying <strong>exactly</strong></em> <code>k</code> <em>operations</em>.</p>

<p>The ceiling function <code>ceil(val)</code> is the least integer greater than or equal to <code>val</code>.</p>

<p>&nbsp;</p>
<p><strong>Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [10,10,10,10,10], k = 5
<strong>Output:</strong> 50
<strong>Explanation:</strong> Apply the operation to each array element exactly once. The final score is 10 + 10 + 10 + 10 + 10 = 50.
</pre>

<p><strong>Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,10,3,3,3], k = 3
<strong>Output:</strong> 17
<strong>Explanation: </strong>You can do the following operations:
Operation 1: Select i = 1, so nums becomes [1,<strong><u>4</u></strong>,3,3,3]. Your score increases by 10.
Operation 2: Select i = 1, so nums becomes [1,<strong><u>2</u></strong>,3,3,3]. Your score increases by 4.
Operation 3: Select i = 2, so nums becomes [1,2,<u><strong>1</strong></u>,3,3]. Your score increases by 3.
The final score is 10 + 4 + 3 = 17.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length, k &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Priority Queue (Max Heap)

> **Thinking**
>
> Each step adds the current maximum $v$ to the score and replaces it with $\lceil v/3\rceil$, for $k$ steps. Scanning for the max each time is quadratic when $k$ and $n$ reach $10^5$.
>
> A max-heap always yields the current largest: pop $v$, add it, and push $\lceil v/3\rceil$. Python stores negations. The loop is $k$ logarithmic operations.

To maximize the sum of scores, we need to select the element with the maximum value at each step. Therefore, we can use a priority queue (max heap) to maintain the element with the maximum value.

At each step, we take out the element with the maximum value $v$ from the priority queue, add $v$ to the answer, and replace $v$ with $\lceil \frac{v}{3} \rceil$, and then add it to the priority queue. After repeating this process $k$ times, we return the answer.

The time complexity is $O(n + k \log n)$, and the space complexity is $O(n)$ or $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int v : nums) {
            pq.offer(v);
        }
        long ans = 0;
        while (k-- > 0) {
            int v = pq.poll();
            ans += v;
            pq.offer((v + 2) / 3);
        }
        return ans;
    }
}
```
