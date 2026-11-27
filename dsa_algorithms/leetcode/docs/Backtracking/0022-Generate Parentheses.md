# 22. Generate Parentheses

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/generate-parentheses/

---

[中文文档](/solution/0000-0099/0022.Generate%20Parentheses/README.md)

## Description

<p>Given <code>n</code> pairs of parentheses, write a function to <em>generate all combinations of well-formed parentheses</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> n = 3
<strong>Output:</strong> ["((()))","(()())","(())()","()(())","()()()"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> n = 1
<strong>Output:</strong> ["()"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 8</code></li>
</ul>

## Solutions

### Solution 1: DFS + Pruning

> **Thinking**
>
> The first idea is to enumerate every string of length $2n$ and keep the valid ones. $n \le 8$ gives $2^{16}$ candidates, so it would pass, but most prefixes are already illegal.
>
> The bottleneck is generate-then-check: once a prefix has more `)` than `(`, or either count exceeds $n$, no suffix can save it.
>
> A valid prefix only needs the two counts $l$ and $r$: keep $l \ge r$ and neither above $n$. When $l=r=n$, record the string.
>
> DFS therefore tries appending `(` or `)` and prunes on those three inequalities. The search tree is much smaller than full enumeration; extra space is just the current string, $O(n)$.

The range of $n$ in the problem is $[1, 8]$, so we can directly solve this problem through "brute force search + pruning".

We design a function $\textit{dfs}(l, r, t)$, where $l$ and $r$ represent the number of left and right brackets respectively, and $t$ represents the current bracket sequence. Then we can get the following recursive structure:

- If $l \gt n$ or $r \gt n$ or $l \lt r$, then the current bracket combination $t$ is invalid, return directly;
- If $l = n$ and $r = n$, then the current bracket combination $t$ is valid, add it to the answer array `ans`, and return directly;
- We can choose to add a left bracket, and recursively execute `dfs(l + 1, r, t + "(")`;
- We can also choose to add a right bracket, and recursively execute `dfs(l, r + 1, t + ")")`.

The time complexity is $O(n 2^{2n})$, and the space complexity is $O(n)$.

#### Java

```java
class Solution {
    private List<String> ans = new ArrayList<>();
    private int n;

    public List<String> generateParenthesis(int n) {
        this.n = n;
        dfs(0, 0, "");
        return ans;
    }

    private void dfs(int l, int r, String t) {
        if (l > n || r > n || l < r) {
            return;
        }
        if (l == n && r == n) {
            ans.add(t);
            return;
        }
        dfs(l + 1, r, t + "(");
        dfs(l, r + 1, t + ")");
    }
}
```
