# 2974. Minimum Number Game

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/minimum-number-game/

---

[中文文档](/solution/2900-2999/2974.Minimum%20Number%20Game/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>nums</code> of <strong>even</strong> length and there is also an empty array <code>arr</code>. Alice and Bob decided to play a game where in every round Alice and Bob will do one move. The rules of the game are as follows:</p>

<ul>
	<li>Every round, first Alice will remove the <strong>minimum</strong> element from <code>nums</code>, and then Bob does the same.</li>
	<li>Now, first Bob will append the removed element in the array <code>arr</code>, and then Alice does the same.</li>
	<li>The game continues until <code>nums</code> becomes empty.</li>
</ul>

<p>Return <em>the resulting array </em><code>arr</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [5,4,2,3]
<strong>Output:</strong> [3,2,5,4]
<strong>Explanation:</strong> In round one, first Alice removes 2 and then Bob removes 3. Then in arr firstly Bob appends 3 and then Alice appends 2. So arr = [3,2].
At the begining of round two, nums = [5,4]. Now, first Alice removes 4 and then Bob removes 5. Then both append in arr which becomes [3,2,5,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,5]
<strong>Output:</strong> [5,2]
<strong>Explanation:</strong> In round one, first Alice removes 2 and then Bob removes 5. Then in arr firstly Bob appends and then Alice appends. So arr = [5,2].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>nums.length % 2 == 0</code></li>
</ul>

## Solutions

### Solution 1: Simulation + Priority Queue (Min Heap)

> **Thinking**
>
> Each round pops the two current minima but appends the larger first. That is two heap pops with the order swapped. $n \le 100$ is even, so the heap follows the statement.

We can put the elements of the array $\textit{nums}$ into a min heap one by one. Each time, we take out two elements $a$ and $b$ from the min heap, and then sequentially put $b$ and $a$ into the answer array until the min heap is empty.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] numberGame(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x : nums) {
            pq.offer(x);
        }
        int[] ans = new int[nums.length];
        int i = 0;
        while (!pq.isEmpty()) {
            int a = pq.poll();
            ans[i++] = pq.poll();
            ans[i++] = a;
        }
        return ans;
    }
}
```

### Solution 2: Sorting + Swapping

> **Thinking**
>
> Method 1 keeps a heap, yet the global minima are known after sorting: each adjacent pair $(a_{2i},a_{2i+1})$ is one round. Swap the two entries in place; no dynamic structure is required. Sorting still dominates.

We can sort the array $\textit{nums}$, and then iterate through the array, swapping adjacent elements each time until the iteration is complete, and return the swapped array.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 2) {
            int t = nums[i];
            nums[i] = nums[i + 1];
            nums[i + 1] = t;
        }
        return nums;
    }
}
```
