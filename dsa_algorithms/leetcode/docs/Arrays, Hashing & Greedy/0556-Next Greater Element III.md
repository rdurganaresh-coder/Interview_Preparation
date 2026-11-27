# 556. Next Greater Element III

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/next-greater-element-iii/

---

[中文文档](/solution/0500-0599/0556.Next%20Greater%20Element%20III/README.md)

## Description

<p>Given a positive integer <code>n</code>, find <em>the smallest integer which has exactly the same digits existing in the integer</em> <code>n</code> <em>and is greater in value than</em> <code>n</code>. If no such positive integer exists, return <code>-1</code>.</p>

<p><strong>Note</strong> that the returned integer should fit in <strong>32-bit integer</strong>, if there is a valid answer but it does not fit in <strong>32-bit integer</strong>, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 12
<strong>Output:</strong> 21
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 21
<strong>Output:</strong> -1
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> We need the next greater integer that is a permutation of $n$'s digits. That is exactly the next-permutation algorithm.
>
> Find the rightmost descent $i$, then the rightmost $j$ that is larger than $cs[i]$, swap, and reverse the suffix into increasing order. No descent means $n$ is already maximal. Overflow past $32$-bit also yields $-1$.

#### Java

```java
class Solution {
    public int nextGreaterElement(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        n = cs.length;
        int i = n - 2, j = n - 1;
        for (; i >= 0 && cs[i] >= cs[i + 1]; --i)
            ;
        if (i < 0) {
            return -1;
        }
        for (; cs[i] >= cs[j]; --j)
            ;
        swap(cs, i, j);
        reverse(cs, i + 1, n - 1);
        long ans = Long.parseLong(String.valueOf(cs));
        return ans > Integer.MAX_VALUE ? -1 : (int) ans;
    }

    private void swap(char[] cs, int i, int j) {
        char t = cs[i];
        cs[i] = cs[j];
        cs[j] = t;
    }

    private void reverse(char[] cs, int i, int j) {
        for (; i < j; ++i, --j) {
            swap(cs, i, j);
        }
    }
}
```
