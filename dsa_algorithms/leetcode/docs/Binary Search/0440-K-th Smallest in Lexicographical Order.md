# 440. K-th Smallest in Lexicographical Order

**Difficulty:** Hard  
**Category:** Binary Search  
**LeetCode:** https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/

---

[中文文档](/solution/0400-0499/0440.K-th%20Smallest%20in%20Lexicographical%20Order/README.md)

## Description

<p>Given two integers <code>n</code> and <code>k</code>, return <em>the</em> <code>k<sup>th</sup></code> <em>lexicographically smallest integer in the range</em> <code>[1, n]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 13, k = 2
<strong>Output:</strong> 10
<strong>Explanation:</strong> The lexicographical order is [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9], so the second smallest number is 10.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1, k = 1
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= k &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Trie-Based Counting + Greedy Construction

> **Thinking**
>
> $n$ can be $10^9$, so we cannot list and sort. Lexicographic order is a $10$-ary trie: the children of $x$ are $10x,\ldots,10x+9$ that stay $\le n$.
>
> Count the subtree of a prefix $\textit{curr}$ by intersecting $[\textit{curr},\textit{curr}+1)$ with $[1,n]$ at each extra digit. If that count is $\le k$, skip the whole tree and increment $\textit{curr}$; otherwise step into $\textit{curr}\times 10$ and spend one for the prefix itself.
>
> Decrement $k$ once at the start because we already stand on $1$. Layered counting never enumerates every integer in the subtree.

The problem asks for the \$k\$-th smallest number in the range $[1, n]$ when all numbers are sorted in **lexicographical order**. Since $n$ can be as large as $10^9$, we cannot afford to generate and sort all the numbers explicitly. Instead, we adopt a strategy based on **greedy traversal over a conceptual Trie**.

We treat the range $[1, n]$ as a **10-ary prefix tree (Trie)**:

- Each node represents a numeric prefix, starting from an empty root;
- Each node has 10 children, corresponding to appending digits $0 \sim 9$;
- For example, prefix $1$ has children $10, 11, \ldots, 19$, and node $10$ has children $100, 101, \ldots, 109$;
- This tree naturally reflects lexicographical order traversal.

```
root
├── 1
│   ├── 10
│   ├── 11
│   ├── ...
├── 2
├── ...
```

We use a variable $\textit{curr}$ to denote the current prefix, initialized as $1$. At each step, we try to expand or skip prefixes until we find the \$k\$-th smallest number.

At each step, we calculate how many valid numbers (i.e., numbers $\le n$ with prefix $\textit{curr}$) exist under this prefix subtree. Let this count be $\textit{count}(\textit{curr})$:

- If $k \ge \textit{count}(\textit{curr})$: the target number is not in this subtree. We skip the entire subtree by moving to the next sibling:

    $$
    \textit{curr} \leftarrow \textit{curr} + 1,\quad k \leftarrow k - \textit{count}(\textit{curr})
    $$

- Otherwise: the target is within this subtree. We go one level deeper:

    $$
    \textit{curr} \leftarrow \textit{curr} \times 10,\quad k \leftarrow k - 1
    $$

At each level, we enlarge the current range by multiplying by 10 and continue descending until we exceed $n$.

The time complexity is $O(\log^2 n)$, as we perform logarithmic operations for counting and traversing the Trie structure. The space complexity is $O(1)$ since we only use a few variables to track the current prefix and count.

#### Java

```java
class Solution {
    private int n;

    public int findKthNumber(int n, int k) {
        this.n = n;
        long curr = 1;
        --k;
        while (k > 0) {
            int cnt = count(curr);
            if (k >= cnt) {
                k -= cnt;
                ++curr;
            } else {
                --k;
                curr *= 10;
            }
        }
        return (int) curr;
    }

    public int count(long curr) {
        long next = curr + 1;
        long cnt = 0;
        while (curr <= n) {
            cnt += Math.min(n - curr + 1, next - curr);
            next *= 10;
            curr *= 10;
        }
        return (int) cnt;
    }
}
```
