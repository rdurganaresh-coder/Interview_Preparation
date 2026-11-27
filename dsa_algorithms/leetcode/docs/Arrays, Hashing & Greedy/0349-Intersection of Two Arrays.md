# 349. Intersection of Two Arrays

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/intersection-of-two-arrays/

---

[中文文档](/solution/0300-0399/0349.Intersection%20of%20Two%20Arrays/README.md)

## Description

<p>Given two integer arrays <code>nums1</code> and <code>nums2</code>, return <em>an array of their <span data-keyword="array-intersection">intersection</span></em>. Each element in the result must be <strong>unique</strong> and you may return the result in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [1,2,2,1], nums2 = [2,2]
<strong>Output:</strong> [2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums1 = [4,9,5], nums2 = [9,4,9,8,4]
<strong>Output:</strong> [9,4]
<strong>Explanation:</strong> [4,9] is also accepted.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums1.length, nums2.length &lt;= 1000</code></li>
	<li><code>0 &lt;= nums1[i], nums2[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Hash Table or Array

> **Thinking**
>
> The distinct intersection of two arrays. Nested loops are $O(nm)$. A set (or a small table) answers membership in $O(1)$.
>
> Load one side into a set, scan the other, and remove on a hit to avoid duplicates. The code is simply the set intersection.

First, we use a hash table or an array $s$ of length $1001$ to record the elements that appear in the array $\textit{nums1}$. Then, we iterate through each element in the array $\textit{nums2}$. If an element $x$ is in $s$, we add $x$ to the answer and remove $x$ from $s$.

After the iteration is finished, we return the answer array.

The time complexity is $O(n+m)$, and the space complexity is $O(n)$, where $n$ and $m$ are the lengths of the arrays $\textit{nums1}$ and $\textit{nums2}$, respectively.

#### Java

```java
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] s = new boolean[1001];
        for (int x : nums1) {
            s[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : nums2) {
            if (s[x]) {
                ans.add(x);
                s[x] = false;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
```
