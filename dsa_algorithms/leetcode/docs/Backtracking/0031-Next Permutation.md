# 31. Next Permutation

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/next-permutation/

---

[中文文档](/solution/0000-0099/0031.Next%20Permutation/README.md)

## Description

<p>A <strong>permutation</strong> of an array of integers is an arrangement of its members into a sequence or linear order.</p>

<ul>
	<li>For example, for <code>arr = [1, 2, 3]</code>, the following are all the permutations of <code>arr</code>: <code>[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]</code>.</li>
</ul>

<p>The <strong>next permutation</strong> of an array of integers is the next lexicographically greater permutation of its integer. More formally, if all the permutations of the array are sorted in one container according to their lexicographical order, then the <strong>next permutation</strong> of that array is the permutation that follows it in the sorted container. If such arrangement is not possible, the array must be rearranged as the lowest possible order (i.e., sorted in ascending order).</p>

<p>Examples:</p>

<ul>
	<li>The next permutation of <code>arr = [1, 2, 3]</code> is <code>[1, 3, 2]</code>.</li>
	<li>The next permutation of <code>arr = [2, 3, 1]</code> is <code>[3, 1, 2]</code>.</li>
	<li>The next permutation of <code>arr = [3, 2, 1]</code> is <code>[1, 2, 3]</code> because <code>[3, 2, 1]</code> does not have a lexicographical larger rearrangement.</li>
</ul>

<p>Given an array of integers <code>nums</code>, <em>find the next permutation of</em> <code>nums</code>.</p>

<p>The replacement must be <strong><a href="http://en.wikipedia.org/wiki/In-place_algorithm" target="_blank">in place</a></strong> and use only constant extra memory.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [1,3,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,2,1]
<strong>Output:</strong> [1,2,3]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,1,5]
<strong>Output:</strong> [1,5,1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 100</code></li>
	<li><code>0 &lt;= nums[i] &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1: Two traversals

> **Thinking**
>
> The first idea is to generate every permutation and take the one after the current sequence. Correct, but $n!$ is impossible at $n \le 100$, and the problem requires an in-place, constant-extra-space update.
>
> We do not need the full set, only the next sequence in lexicographic order: strictly larger, changing as far right as possible, and by the smallest amount.
>
> The longest non-increasing suffix is already the largest arrangement of that tail; the element just before it, $\textit{nums}[i]$, is the pivot we must raise. The smallest larger replacement sits at the right end of that suffix. After the swap, reverse the suffix so it becomes increasing. If the whole array is non-increasing, no larger permutation exists and we reverse everything.

We first traverse the array from back to front and find the first position $i$ where $\textit{nums}[i] \lt \textit{nums}[i + 1]$.

Then traverse the array from back to front again and find the first position $j$ where $\textit{nums}[j] \gt \textit{nums}[i]$. Swap $\textit{nums}[i]$ and $\textit{nums}[j]$, and then reverse the elements from $\textit{nums}[i + 1]$ to $\textit{nums}[n - 1]$, the next permutation can be obtained.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        for (; i >= 0; --i) {
            if (nums[i] < nums[i + 1]) {
                break;
            }
        }
        if (i >= 0) {
            for (int j = n - 1; j > i; --j) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }

        for (int j = i + 1, k = n - 1; j < k; ++j, --k) {
            swap(nums, j, k);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[j];
        nums[j] = nums[i];
        nums[i] = t;
    }
}
```
