# 2006. Count Number of Pairs With Absolute Difference K

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-number-of-pairs-with-absolute-difference-k/

---

[中文文档](/solution/2000-2099/2006.Count%20Number%20of%20Pairs%20With%20Absolute%20Difference%20K/README.md)

## Description

<p>Given an integer array <code>nums</code> and an integer <code>k</code>, return <em>the number of pairs</em> <code>(i, j)</code> <em>where</em> <code>i &lt; j</code> <em>such that</em> <code>|nums[i] - nums[j]| == k</code>.</p>

<p>The value of <code>|x|</code> is defined as:</p>

<ul>
	<li><code>x</code> if <code>x &gt;= 0</code>.</li>
	<li><code>-x</code> if <code>x &lt; 0</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,2,1], k = 1
<strong>Output:</strong> 4
<strong>Explanation:</strong> The pairs with an absolute difference of 1 are:
- [<strong><u>1</u></strong>,<strong><u>2</u></strong>,2,1]
- [<strong><u>1</u></strong>,2,<strong><u>2</u></strong>,1]
- [1,<strong><u>2</u></strong>,2,<strong><u>1</u></strong>]
- [1,2,<strong><u>2</u></strong>,<strong><u>1</u></strong>]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3], k = 3
<strong>Output:</strong> 0
<strong>Explanation:</strong> There are no pairs with an absolute difference of 3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1,5,4], k = 2
<strong>Output:</strong> 3
<b>Explanation:</b> The pairs with an absolute difference of 2 are:
- [<strong><u>3</u></strong>,2,<strong><u>1</u></strong>,5,4]
- [<strong><u>3</u></strong>,2,1,<strong><u>5</u></strong>,4]
- [3,<strong><u>2</u></strong>,1,5,<strong><u>4</u></strong>]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 200</code></li>
	<li><code>1 &lt;= nums[i] &lt;= 100</code></li>
	<li><code>1 &lt;= k &lt;= 99</code></li>
</ul>

## Solutions

### Solution 1: Brute Force Enumeration

> **Thinking**
>
> With $n \le 200$, enumerating all $i<j$ and testing $|\textit{nums}[i]-\textit{nums}[j]|=k$ is about $2 \times 10^4$ pairs, which fits. Values and $k$ are small, so no extra structure is required.
>
> The double loop matches the definition directly.

We notice that the length of the array $\textit{nums}$ does not exceed $200$, so we can enumerate all pairs $(i, j)$, where $i < j$, and check if $|\textit{nums}[i] - \textit{nums}[j]|$ equals $k$. If it does, we increment the answer by one.

Finally, we return the answer.

The time complexity is $O(n^2)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        for (int i = 0, n = nums.length; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (Math.abs(nums[i] - nums[j]) == k) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```

### Solution 2: Hash Table or Array

> **Thinking**
>
> Solution 1 visits every pair. We only need the count of difference $k$: for current $x$, earlier $x-k$ and $x+k$ pair with it.
>
> A running counter adds those hits, then records $x$, giving a linear one-pass tally.

We can use a hash table or array to record the occurrence count of each number in the array $\textit{nums}$. Then, we enumerate each number $x$ in the array $\textit{nums}$, and check if $x + k$ and $x - k$ are in the array $\textit{nums}$. If they are, we increment the answer by the sum of the occurrence counts of $x + k$ and $x - k$.

Finally, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int countKDifference(int[] nums, int k) {
        int ans = 0;
        int[] cnt = new int[110];
        for (int num : nums) {
            if (num >= k) {
                ans += cnt[num - k];
            }
            if (num + k <= 100) {
                ans += cnt[num + k];
            }
            ++cnt[num];
        }
        return ans;
    }
}
```
