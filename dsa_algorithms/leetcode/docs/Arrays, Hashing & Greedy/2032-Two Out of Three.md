# 2032. Two Out of Three

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/two-out-of-three/

---

[中文文档](/solution/2000-2099/2032.Two%20Out%20of%20Three/README.md)

## Description

Given three integer arrays <code>nums1</code>, <code>nums2</code>, and <code>nums3</code>, return <em>a <strong>distinct</strong> array containing all the values that are present in <strong>at least two</strong> out of the three arrays. You may return the values in <strong>any</strong> order</em>.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]
<strong>Output:</strong> [3,2]
<strong>Explanation:</strong> The values that are present in at least two arrays are:
- 3, in all three arrays.
- 2, in nums1 and nums2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]
<strong>Output:</strong> [2,3,1]
<strong>Explanation:</strong> The values that are present in at least two arrays are:
- 2, in nums2 and nums3.
- 3, in nums1 and nums2.
- 1, in nums1 and nums3.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]
<strong>Output:</strong> []
<strong>Explanation:</strong> No value is present in at least two arrays.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length, nums3.length &lt;= 100</code></li>
	<li><code>1 &lt;= nums1[i], nums2[j], nums3[k] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Array + Enumeration

> **Thinking**
>
> Values lie in $[1,100]$ and each array has length $\le 100$. Deduplicate, then test how many of the three sets contain each $i \in [1,100]$. Keep those present at least twice.
>
> No bit tricks are required under these bounds.

We can first put each element of the arrays into an array, then enumerate each number $i$ from $1$ to $100$, and check whether $i$ appears in at least two arrays. If so, add $i$ to the answer array.

The time complexity is $O(n_1 + n_2 + n_3)$, and the space complexity is $O(n_1 + n_2 + n_3)$, where $n_1, n_2, n_3$ are the lengths of the arrays $\textit{nums1}$, $\textit{nums2}$, and $\textit{nums3}$, respectively.

#### Java

```java
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] s1 = get(nums1), s2 = get(nums2), s3 = get(nums3);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            if (s1[i] + s2[i] + s3[i] > 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int[] get(int[] nums) {
        int[] s = new int[101];
        for (int num : nums) {
            s[num] = 1;
        }
        return s;
    }
}
```

### Solution 2: Hash Table + Bit Manipulation

> **Thinking**
>
> Solution 1 hard-codes $1..100$. A bitmask instead records which arrays contain $x$ (bit $i$ for array $i$).
>
> $v\&(v-1)\ne 0$ iff at least two bits are set. One pass, independent of the value range.

We can use a hash table `mask` to record which arrays each number appears in. For each array, we add its elements to the hash table and set the corresponding bit to `1`. For example, if it is the first array, set the corresponding bit to `1`; if it is the second array, set it to `2`; if it is the third array, set it to `4`.

Finally, we iterate through each number in the hash table and check if its corresponding value has at least two bits set to `1` in binary. If so, add that number to the answer array.

The time complexity is $O(n_1 + n_2 + n_3)$, and the space complexity is $O(n_1 + n_2 + n_3)$, where $n_1, n_2, n_3$ are the lengths of the arrays $\textit{nums1}$, $\textit{nums2}$, and $\textit{nums3}$, respectively.

#### Java

```java
class Solution {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        Map<Integer, Integer> mask = new HashMap<>();
        int[][] nums = {nums1, nums2, nums3};
        for (int i = 0; i < 3; i++) {
            for (int x : nums[i]) {
                mask.merge(x, 1 << i, (oldVal, newVal) -> oldVal | newVal);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (var e : mask.entrySet()) {
            if ((e.getValue() & (e.getValue() - 1)) != 0) {
                ans.add(e.getKey());
            }
        }
        return ans;
    }
}
```
