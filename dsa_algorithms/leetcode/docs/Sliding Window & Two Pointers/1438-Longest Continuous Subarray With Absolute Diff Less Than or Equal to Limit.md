# 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/

---

[中文文档](/solution/1400-1499/1438.Longest%20Continuous%20Subarray%20With%20Absolute%20Diff%20Less%20Than%20or%20Equal%20to%20Limit/README.md)

## Description

<p>You are given an array of integers <code>nums</code> and an integer <code>limit</code>.</p>

<p>Return the size of the <strong>longest non-empty subarray</strong> such that the <strong>absolute</strong> difference between <strong>every pair of elements</strong> in this <strong>subarray</strong> is <strong>less than or equal</strong> to <code>limit</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [8,2,4,7], limit = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">2</span></p>

<p><strong>Explanation:</strong></p>

<p>Checking every subarray, where the absolute difference is taken over all pairs of its elements:<br />
<code>[8]</code> with maximum absolute diff <code>|8-8| = 0 &lt;= 4</code>.<br />
<code>[8,2]</code> with maximum absolute diff <code>|8-2| = 6 &gt; 4</code>.<br />
<code>[8,2,4]</code> with maximum absolute diff <code>|8-2| = 6 &gt; 4</code>.<br />
<code>[8,2,4,7]</code> with maximum absolute diff <code>|8-2| = 6 &gt; 4</code>.<br />
<code>[2]</code> with maximum absolute diff <code>|2-2| = 0 &lt;= 4</code>.<br />
<code>[2,4]</code> with maximum absolute diff <code>|4-2| = 2 &lt;= 4</code>.<br />
<code>[2,4,7]</code> with maximum absolute diff <code>|7-2| = 5 &gt; 4</code>. Note that the pair <code>(2, 7)</code> is not adjacent, but it is still compared.<br />
<code>[4]</code> with maximum absolute diff <code>|4-4| = 0 &lt;= 4</code>.<br />
<code>[4,7]</code> with maximum absolute diff <code>|7-4| = 3 &lt;= 4</code>.<br />
<code>[7]</code> with maximum absolute diff <code>|7-7| = 0 &lt;= 4</code>.<br />
Therefore, the size of the longest subarray is 2.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [10,1,2,4,7,2], limit = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The subarray <code>[2,4,7,2]</code> is valid because every pair of its elements differs by at most <code>5</code>, the largest being <code>|7-2| = 5</code>.</p>

<p>It cannot be extended to the left, since <code>[1,2,4,7,2]</code> contains the pair <code>(1, 7)</code> with <code>|7-1| = 6 &gt; 5</code>. Therefore, the size of the longest subarray is 4.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [4,2,2,2,4,4,2,2], limit = 0</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>Since <code>limit = 0</code>, every pair of elements in the subarray must be equal, so only runs of identical values qualify.</p>

<p>The longest such run is <code>[2,2,2]</code>, of size 3.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li><code>0 &lt;= limit &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Ordered Set + Sliding Window

> **Thinking**
>
> The max–min gap of a subarray does not decrease as the window grows. $n\le 10^5$ rules out all intervals. For each right end, move the left end until $\max-\min\le \textit{limit}$.
>
> An ordered multiset exposes the current extrema; remove the leftmost value when the window is illegal. The longest valid window is the answer.

We can enumerate each position as the right endpoint of the subarray, and find the leftmost left endpoint corresponding to it, such that the difference between the maximum and minimum values in the interval does not exceed $\textit{limit}$. During the process, we use an ordered set to maintain the maximum and minimum values within the window.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int ans = 0;
        for (int i = 0, j = 0; i < nums.length; ++i) {
            tm.merge(nums[i], 1, Integer::sum);
            for (; tm.lastKey() - tm.firstKey() > limit; ++j) {
                if (tm.merge(nums[j], -1, Integer::sum) == 0) {
                    tm.remove(nums[j]);
                }
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
```

### Solution 2: Binary Search + Sliding Window

> **Thinking**
>
> Method 1 shrinks per right end. Length is monotone: if some window of length $\textit{mid}$ is valid, shorter ones exist. Binary-search the length and test a candidate with two monotonic queues.
>
> The time is still $O(n \log n)$; the longest-window search becomes a decision problem.

We notice that if a subarray of length $k$ satisfies the condition, then a subarray of length $k' < k$ also satisfies the condition. This shows a monotonicity, therefore, we can use binary search to find the longest subarray that satisfies the condition.

We define the left boundary of the binary search as $l = 0$, and the right boundary as $r = n$. For each $\textit{mid} = \frac{l + r + 1}{2}$, we check whether there exists a subarray of length $\textit{mid}$ that satisfies the condition. If it exists, we update $l = \textit{mid}$, otherwise we update $r = \textit{mid} - 1$. The problem is transformed into whether there exists a subarray of length $\textit{mid}$ in the array that satisfies the condition, which is actually to find the difference between the maximum and minimum values in the sliding window does not exceed $\textit{limit}$. We can use two monotonic queues to maintain the maximum and minimum values in the window respectively.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    private int[] nums;
    private int limit;

    public int longestSubarray(int[] nums, int limit) {
        this.nums = nums;
        this.limit = limit;
        int l = 1, r = nums.length;
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int k) {
        Deque<Integer> minQ = new ArrayDeque<>();
        Deque<Integer> maxQ = new ArrayDeque<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!minQ.isEmpty() && i - minQ.peekFirst() + 1 > k) {
                minQ.pollFirst();
            }
            if (!maxQ.isEmpty() && i - maxQ.peekFirst() + 1 > k) {
                maxQ.pollFirst();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] >= nums[i]) {
                minQ.pollLast();
            }
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            minQ.offer(i);
            maxQ.offer(i);
            if (i >= k - 1 && nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] <= limit) {
                return true;
            }
        }
        return false;
    }
}
```

### Solution 3: Sliding Window + Deque

> **Thinking**
>
> Methods 1 and 2 pay a logarithmic factor. Two monotonic deques maintain the window max and min in amortized $O(1)$, so expanding the right end and shrinking the left end is linear.

We can use a deque to maintain the maximum and minimum values within the window. We maintain two deques, one for storing the indices of the maximum values and the other for the minimum values within the window. Define two pointers $l$ and $r$ to point to the left and right boundaries of the window, respectively.

Each time we move the right boundary $r$ to the right, we check if the element corresponding to the tail index of the maximum value deque is less than the current element. If it is, we dequeue the tail element until the element corresponding to the tail of the maximum value deque is not less than the current element. Similarly, we check if the element corresponding to the tail index of the minimum value deque is greater than the current element. If it is, we dequeue the tail element until the element corresponding to the tail of the minimum value deque is not greater than the current element. Then, we enqueue the current element's index.

If the difference between the elements at the front of the maximum value deque and the minimum value deque is greater than $\textit{limit}$, then we move the left boundary $l$ to the right. If the element at the front of the maximum value deque is less than $l$, we dequeue the front element of the maximum value deque. Similarly, if the element at the front of the minimum value deque is less than $l$, we dequeue the front element of the minimum value deque.

The answer is $n - l$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new ArrayDeque<>();
        Deque<Integer> minQ = new ArrayDeque<>();
        int n = nums.length;
        int l = 0;
        for (int r = 0; r < n; ++r) {
            while (!maxQ.isEmpty() && nums[maxQ.peekLast()] < nums[r]) {
                maxQ.pollLast();
            }
            while (!minQ.isEmpty() && nums[minQ.peekLast()] > nums[r]) {
                minQ.pollLast();
            }
            maxQ.offerLast(r);
            minQ.offerLast(r);
            if (nums[maxQ.peekFirst()] - nums[minQ.peekFirst()] > limit) {
                ++l;
                if (maxQ.peekFirst() < l) {
                    maxQ.pollFirst();
                }
                if (minQ.peekFirst() < l) {
                    minQ.pollFirst();
                }
            }
        }
        return n - l;
    }
}
```
