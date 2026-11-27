# 1231. Divide Chocolate

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/divide-chocolate/

---

[中文文档](/solution/1200-1299/1231.Divide%20Chocolate/README.md)

## Description

<p>You have one chocolate bar that consists of some chunks. Each chunk has its own sweetness given by the array&nbsp;<code>sweetness</code>.</p>

<p>You want to share the chocolate with your <code>k</code>&nbsp;friends so you start cutting the chocolate bar into <code>k + 1</code>&nbsp;pieces using&nbsp;<code>k</code>&nbsp;cuts, each piece consists of some <strong>consecutive</strong> chunks.</p>

<p>Being generous, you will eat the piece with the <strong>minimum total sweetness</strong> and give the other pieces to your friends.</p>

<p>Find the <strong>maximum total sweetness</strong> of the&nbsp;piece you can get by cutting the chocolate bar optimally.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> sweetness = [1,2,3,4,5,6,7,8,9], k = 5
<strong>Output:</strong> 6
<b>Explanation: </b>You can divide the chocolate to [1,2,3], [4,5], [6], [7], [8], [9]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> sweetness = [5,6,7,8,9,1,2,3,4], k = 8
<strong>Output:</strong> 1
<b>Explanation: </b>There is only one way to cut the bar into 9 pieces.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> sweetness = [1,2,2,1,2,2,1,2,2], k = 2
<strong>Output:</strong> 5
<b>Explanation: </b>You can divide the chocolate to [1,2,2], [1,2,2], [1,2,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= k &lt; sweetness.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= sweetness[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Search + Greedy

> **Thinking**
>
> We split the bar into $k+1$ pieces and maximize the minimum sweetness of our piece. $n \le 10^4$ forbids enumerating cuts. If a minimum $x$ is feasible, every smaller threshold is too, so the answer is monotone.
>
> The check accumulates from the left and cuts whenever the running sum reaches $x$; more than $k$ pieces (us plus $k$ friends) means $x$ works. We binary-search the largest feasible $x$ on $[0,\sum \textit{sweetness}]$. Cutting as soon as a piece fills can only leave more remainder for later pieces.

We notice that if we can eat a piece of chocolate with sweetness $x$, then we can also eat all chocolates with sweetness less than or equal to $x$. This shows monotonicity, therefore, we can use binary search to find the maximum $x$ that satisfies the condition.

We define the left boundary of the binary search as $l=0$, and the right boundary as $r=\sum_{i=0}^{n-1} \textit{sweetness}[i]$. Each time, we take the middle value $\textit{mid}$ of $l$ and $r$, and then determine whether we can eat a piece of chocolate with sweetness $\textit{mid}$. If we can, then we try to eat a piece of chocolate with greater sweetness, i.e., let $l=\textit{mid}$; otherwise, we try to eat a piece of chocolate with smaller sweetness, i.e., let $r=\textit{mid}-1$. After the binary search ends, we return $l$.

The key to the problem is how to determine whether we can eat a piece of chocolate with sweetness $x$. We can use a greedy approach, traverse the array from left to right, accumulate the current sweetness each time, when the accumulated sweetness is greater than or equal to $x$, the chocolate count $\textit{cnt}$ is increased by $1$, and the accumulated sweetness is reset to zero. Finally, check whether $\textit{cnt}$ is greater than $k$.

The time complexity is $O(n \log \sum_{i=0}^{n-1} \textit{sweetness}[i])$, and the space complexity is $O(1)$, where $n$ is the length of the array.

#### Java

```java
class Solution {
    public int maximizeSweetness(int[] sweetness, int k) {
        int l = 0, r = 0;
        for (int v : sweetness) {
            r += v;
        }
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            if (check(sweetness, mid, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] nums, int x, int k) {
        int s = 0, cnt = 0;
        for (int v : nums) {
            s += v;
            if (s >= x) {
                s = 0;
                ++cnt;
            }
        }
        return cnt > k;
    }
}
```
