# 2023. Number of Pairs of Strings With Concatenation Equal to Target

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

---

[中文文档](/solution/2000-2099/2023.Number%20of%20Pairs%20of%20Strings%20With%20Concatenation%20Equal%20to%20Target/README.md)

## Description

<p>Given an array of <strong>digit</strong> strings <code>nums</code> and a <strong>digit</strong> string <code>target</code>, return <em>the number of pairs of indices </em><code>(i, j)</code><em> (where </em><code>i != j</code><em>) such that the <strong>concatenation</strong> of </em><code>nums[i] + nums[j]</code><em> equals </em><code>target</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [&quot;777&quot;,&quot;7&quot;,&quot;77&quot;,&quot;77&quot;], target = &quot;7777&quot;
<strong>Output:</strong> 4
<strong>Explanation:</strong> Valid pairs are:
- (0, 1): &quot;777&quot; + &quot;7&quot;
- (1, 0): &quot;7&quot; + &quot;777&quot;
- (2, 3): &quot;77&quot; + &quot;77&quot;
- (3, 2): &quot;77&quot; + &quot;77&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [&quot;123&quot;,&quot;4&quot;,&quot;12&quot;,&quot;34&quot;], target = &quot;1234&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> Valid pairs are:
- (0, 1): &quot;123&quot; + &quot;4&quot;
- (2, 3): &quot;12&quot; + &quot;34&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [&quot;1&quot;,&quot;1&quot;,&quot;1&quot;], target = &quot;11&quot;
<strong>Output:</strong> 6
<strong>Explanation:</strong> Valid pairs are:
- (0, 1): &quot;1&quot; + &quot;1&quot;
- (1, 0): &quot;1&quot; + &quot;1&quot;
- (0, 2): &quot;1&quot; + &quot;1&quot;
- (2, 0): &quot;1&quot; + &quot;1&quot;
- (1, 2): &quot;1&quot; + &quot;1&quot;
- (2, 1): &quot;1&quot; + &quot;1&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums[i].length &lt;= 100</code></li>
	<li><code>2 &lt;= target.length &lt;= 100</code></li>
	<li><code>nums[i]</code> and <code>target</code> consist of digits.</li>
	<li><code>nums[i]</code> and <code>target</code> do not have leading zeros.</li>
</ul>

## Solutions

### Solution 1: Enumeration

> **Thinking**
>
> With $n \le 100$ and short strings, enumerate ordered pairs $(i,j)$ and concatenate. $i \neq j$ means a value can be reused only if it appears twice.
>
> The double loop matches the statement; no preprocess is needed.

Traverse the array $\textit{nums}$, for each $i$, enumerate all $j$, if $i \neq j$ and $\textit{nums}[i] + \textit{nums}[j] = \textit{target}$, then increment the answer by one.

The time complexity is $O(n^2m)$, and the space complexity is $O(1)$, where $n$ and $m$ are the lengths of the array $\textit{nums}$ and the string $\textit{target}$, respectively.

#### Java

```java
class Solution {
    public int numOfPairs(String[] nums, String target) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i != j && target.equals(nums[i] + nums[j])) {
                    ++ans;
                }
            }
        }
        return ans;
    }
}
```

### Solution 2: Hash Table

> **Thinking**
>
> Solution 1 concatenates in $O(m)$ per pair. Every valid pair is some prefix of $\textit{target}$ plus the matching suffix.
>
> Count string frequencies, then split $\textit{target}$. When prefix equals suffix use $c(c-1)$ so one index is not paired with itself.

We can use a hash table to count the occurrence of each string in the array `nums`, then traverse all prefixes and suffixes of the string $\textit{target}$. If both the prefix and suffix are in the hash table, then increment the answer by the product of their occurrences.

The time complexity is $O(n + m^2)$, and the space complexity is $O(n)$, where $n$ and $m$ are the lengths of the array $\textit{nums}$ and the string $\textit{target}$, respectively.

#### Java

```java
class Solution {
    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> cnt = new HashMap<>();
        for (String x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int ans = 0;
        for (int i = 1; i < target.length(); ++i) {
            String a = target.substring(0, i);
            String b = target.substring(i);
            int x = cnt.getOrDefault(a, 0);
            int y = cnt.getOrDefault(b, 0);
            if (!a.equals(b)) {
                ans += x * y;
            } else {
                ans += x * (y - 1);
            }
        }
        return ans;
    }
}
```
