# 2248. Intersection of Multiple Arrays

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/intersection-of-multiple-arrays/

---

[中文文档](/solution/2200-2299/2248.Intersection%20of%20Multiple%20Arrays/README.md)

## Description

Given a 2D integer array <code>nums</code> where <code>nums[i]</code> is a non-empty array of <strong>distinct</strong> positive integers, return <em>the list of integers that are present in <strong>each array</strong> of</em> <code>nums</code><em> sorted in <strong>ascending order</strong></em>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [[<u><strong>3</strong></u>,1,2,<u><strong>4</strong></u>,5],[1,2,<u><strong>3</strong></u>,<u><strong>4</strong></u>],[<u><strong>3</strong></u>,<u><strong>4</strong></u>,5,6]]
<strong>Output:</strong> [3,4]
<strong>Explanation:</strong> 
The only integers present in each of nums[0] = [<u><strong>3</strong></u>,1,2,<u><strong>4</strong></u>,5], nums[1] = [1,2,<u><strong>3</strong></u>,<u><strong>4</strong></u>], and nums[2] = [<u><strong>3</strong></u>,<u><strong>4</strong></u>,5,6] are 3 and 4, so we return [3,4].</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [[1,2,3],[4,5,6]]
<strong>Output:</strong> []
<strong>Explanation:</strong> 
There does not exist any integer present both in nums[0] and nums[1], so we return an empty list [].
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 1000</code></li>
	<li><code>1 &lt;= sum(nums[i].length) &lt;= 1000</code></li>
	<li><code>1 &lt;= nums[i][j] &lt;= 1000</code></li>
	<li>All the values of <code>nums[i]</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> We need values that appear in every subarray, in increasing order. Values inside a subarray are unique and lie in $[1,1000]$. Repeated set intersections would work but allocate needlessly.
>
> A count array of length $1001$ increments $\textit{cnt}[x]$ once per subarray. Those $x$ whose count equals the number of subarrays form the intersection and are already ordered by index.

Traverse the array `nums`. For each sub-array `arr`, count the occurrence of each number in `arr`. Then traverse the count array, count the numbers that appear as many times as the length of the array `nums`, which are the answers.

The time complexity is $O(N)$, and the space complexity is $O(1000)$, where $N$ is the total number of numbers in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public List<Integer> intersection(int[][] nums) {
        int[] cnt = new int[1001];
        for (var arr : nums) {
            for (int x : arr) {
                ++cnt[x];
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int x = 0; x < 1001; ++x) {
            if (cnt[x] == nums.length) {
                ans.add(x);
            }
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 waits until the end to collect answers. We can append $x$ as soon as $\textit{cnt}[x]$ reaches the number of subarrays, then sort once. The domain is small, so both versions have the same order.

#### Java

```java
class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (var arr : nums) {
            for (int x : arr) {
                if (cnt.merge(x, 1, Integer::sum) == nums.length) {
                    ans.add(x);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}
```
