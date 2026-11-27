# 1502. Can Make Arithmetic Progression From Sequence

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/

---

[中文文档](/solution/1500-1599/1502.Can%20Make%20Arithmetic%20Progression%20From%20Sequence/README.md)

## Description

<p>A sequence of numbers is called an <strong>arithmetic progression</strong> if the difference between any two consecutive elements is the same.</p>

<p>Given an array of numbers <code>arr</code>, return <code>true</code> <em>if the array can be rearranged to form an <strong>arithmetic progression</strong>. Otherwise, return</em> <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> arr = [3,5,1]
<strong>Output:</strong> true
<strong>Explanation: </strong>We can reorder the elements as [1,3,5] or [5,3,1] with differences 2 and -2 respectively, between each consecutive elements.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> arr = [1,2,4]
<strong>Output:</strong> false
<strong>Explanation: </strong>There is no way to reorder the elements to obtain an arithmetic progression.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= arr.length &lt;= 1000</code></li>
	<li><code>-10<sup>6</sup> &lt;= arr[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Traversal

> **Thinking**
>
> To decide whether the array can be rearranged into an arithmetic progression, trying every permutation is $n!$, which is impossible even for $n$ around a thousand. After a valid rearrangement every adjacent difference equals the same $d$, so one canonical order suffices.
>
> Sorting forces that order: the common difference must be the gap between consecutive sorted values. Checking that every adjacent pair matches the first gap is then a linear scan, and the sort is cheap enough for the given $n$.

We can first sort the array $\textit{arr}$, then traverse the array, and check whether the difference between adjacent items is equal.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }
}
```

### Solution 2: Hash Table + Mathematics

> **Thinking**
>
> Solution 1 spends $O(n \log n)$ on sorting. If an arithmetic progression exists, its difference is fixed by the minimum $a$ and maximum $b$ as $d=(b-a)/(n-1)$, which must be an integer. After placing the values in a hash set, it is enough to test that $a, a+d, \ldots, a+(n-1)d$ all appear, which is linear time.

We first find the minimum value $a$ and the maximum value $b$ in the array $\textit{arr}$. If the array $\textit{arr}$ can be rearranged into an arithmetic sequence, then the common difference $d = \frac{b - a}{n - 1}$ must be an integer.

We can use a hash table to record all elements in the array $\textit{arr}$, then traverse $i \in [0, n)$, and check whether $a + d \times i$ is in the hash table. If not, it means that the array $\textit{arr}$ cannot be rearranged into an arithmetic sequence, and we return `false`. Otherwise, after traversing the array, we return `true`.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{arr}$.

#### Java

```java
class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        int n = arr.length;
        int a = arr[0], b = arr[0];
        Set<Integer> s = new HashSet<>();
        for (int x : arr) {
            a = Math.min(a, x);
            b = Math.max(b, x);
            s.add(x);
        }
        if ((b - a) % (n - 1) != 0) {
            return false;
        }
        int d = (b - a) / (n - 1);
        for (int i = 0; i < n; ++i) {
            if (!s.contains(a + d * i)) {
                return false;
            }
        }
        return true;
    }
}
```
