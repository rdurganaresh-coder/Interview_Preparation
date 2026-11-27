# 128. Longest Consecutive Sequence

**Difficulty:** Medium  
**Category:** Sliding Window & Two Pointers  
**LeetCode:** https://leetcode.com/problems/longest-consecutive-sequence/

---

[中文文档](/solution/0100-0199/0128.Longest%20Consecutive%20Sequence/README.md)

## Description

<p>Given an unsorted array of integers <code>nums</code>, return <em>the length of the longest consecutive elements sequence.</em></p>

<p>You must write an algorithm that runs in&nbsp;<code>O(n)</code>&nbsp;time.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [100,4,200,1,3,2]
<strong>Output:</strong> 4
<strong>Explanation:</strong> The longest consecutive elements sequence is <code>[1, 2, 3, 4]</code>. Therefore its length is 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0,3,7,2,5,8,4,6,0,1]
<strong>Output:</strong> 9
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,0,1,2]
<strong>Output:</strong> 3
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> Sorting and scanning runs is $O(n \log n)$; the problem asks for $O(n)$. $n \le 10^5$. Put the values in a hash set. From each $x$ still in the set, walk right until the run breaks, store that length at the start, and let earlier starts concatenate. Each number enters and leaves the set once.

We can use a hash table $s$ to store all the elements in the array, a variable $\textit{ans}$ to record the length of the longest consecutive sequence, and a hash table $d$ to record the length of the consecutive sequence each element $x$ belongs to.

Next, we iterate through each element $x$ in the array, using a temporary variable $y$ to record the maximum value of the current consecutive sequence, initially $y = x$. Then, we continuously try to match $y+1, y+2, y+3, \dots$ until we can no longer match. During this process, we remove the matched elements from the hash table $s$. The length of the consecutive sequence that the current element $x$ belongs to is $d[x] = d[y] + y - x$, and then we update the answer $\textit{ans} = \max(\textit{ans}, d[x])$.

After the iteration, we return the answer $\textit{ans}$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        int ans = 0;
        Map<Integer, Integer> d = new HashMap<>();
        for (int x : nums) {
            int y = x;
            while (s.contains(y)) {
                s.remove(y++);
            }
            d.put(x, d.getOrDefault(y, 0) + y - x);
            ans = Math.max(ans, d.get(x));
        }
        return ans;
    }
}
```

### Solution 2: Hash Table (Optimization)

> **Thinking**
>
> Solution 1 stores each run's length so later starts can concatenate. If we only grow a run when $x-1$ is absent, $x$ is already a start, so the extra map $d$ is unnecessary. The code is shorter and still touches each number a constant number of times.

Similar to Solution 1, we use a hash table $s$ to store all the elements in the array and a variable $\textit{ans}$ to record the length of the longest consecutive sequence. However, we no longer use a hash table $d$ to record the length of the consecutive sequence each element $x$ belongs to. During the iteration, we skip elements where $x-1$ is also in the hash table $s$. If $x-1$ is in the hash table $s$, then $x$ is definitely not the start of a consecutive sequence, so we can directly skip $x$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        int ans = 0;
        for (int x : s) {
            if (!s.contains(x - 1)) {
                int y = x + 1;
                while (s.contains(y)) {
                    ++y;
                }
                ans = Math.max(ans, y - x);
            }
        }
        return ans;
    }
}
```
