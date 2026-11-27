# 888. Fair Candy Swap

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/fair-candy-swap/

---

[中文文档](/solution/0800-0899/0888.Fair%20Candy%20Swap/README.md)

## Description

<p>Alice and Bob have a different total number of candies. You are given two integer arrays <code>aliceSizes</code> and <code>bobSizes</code> where <code>aliceSizes[i]</code> is the number of candies of the <code>i<sup>th</sup></code> box of candy that Alice has and <code>bobSizes[j]</code> is the number of candies of the <code>j<sup>th</sup></code> box of candy that Bob has.</p>

<p>Since they are friends, they would like to exchange one candy box each so that after the exchange, they both have the same total amount of candy. The total amount of candy a person has is the sum of the number of candies in each box they have.</p>

<p>Return a<em>n integer array </em><code>answer</code><em> where </em><code>answer[0]</code><em> is the number of candies in the box that Alice must exchange, and </em><code>answer[1]</code><em> is the number of candies in the box that Bob must exchange</em>. If there are multiple answers, you may <strong>return any</strong> one of them. It is guaranteed that at least one answer exists.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> aliceSizes = [1,1], bobSizes = [2,2]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> aliceSizes = [1,2], bobSizes = [2,3]
<strong>Output:</strong> [1,2]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> aliceSizes = [2], bobSizes = [1,3]
<strong>Output:</strong> [2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= aliceSizes.length, bobSizes.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= aliceSizes[i], bobSizes[j] &lt;= 10<sup>5</sup></code></li>
	<li>Alice and Bob have a different total number of candies.</li>
	<li>There will be at least one valid answer for the given input.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> Each gives one box so totals become equal. If Alice gives $a$ and Bob $b$, then $a-b$ is half the total difference. $n\le 10^4$, so scanning Bob for every $a$ is quadratic.
>
> Put Bob’s sizes in a set and, for each $a$, test whether $a-\textit{diff}$ exists. A solution is guaranteed.

We can first calculate the difference in the total number of candies between Alice and Bob, divide it by two to get the difference in the number of candies to be exchanged $\textit{diff}$, and use a hash table $s$ to store the number of candies in Bob's candy boxes. Then, we traverse Alice's candy boxes, and for each candy count $a$, we check if $a - \textit{diff}$ is in the hash table $s$. If it exists, it means we have found a valid answer, and we return it.

The time complexity is $O(m + n)$, and the space complexity is $O(n)$, where $m$ and $n$ are the number of candy boxes Alice and Bob have, respectively.

#### Java

```java
class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int s1 = 0, s2 = 0;
        Set<Integer> s = new HashSet<>();
        for (int a : aliceSizes) {
            s1 += a;
        }
        for (int b : bobSizes) {
            s.add(b);
            s2 += b;
        }
        int diff = (s1 - s2) >> 1;
        for (int a : aliceSizes) {
            int b = a - diff;
            if (s.contains(b)) {
                return new int[] {a, b};
            }
        }
        return null;
    }
}
```
