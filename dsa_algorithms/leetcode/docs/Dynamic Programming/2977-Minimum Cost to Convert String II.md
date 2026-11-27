# 2977. Minimum Cost to Convert String II

**Difficulty:** Hard  
**Category:** Dynamic Programming  
**LeetCode:** https://leetcode.com/problems/minimum-cost-to-convert-string-ii/

---

[中文文档](/solution/2900-2999/2977.Minimum%20Cost%20to%20Convert%20String%20II/README.md)

## Description

<p>You are given two <strong>0-indexed</strong> strings <code>source</code> and <code>target</code>, both of length <code>n</code> and consisting of <strong>lowercase</strong> English characters. You are also given two <strong>0-indexed</strong> string arrays <code>original</code> and <code>changed</code>, and an integer array <code>cost</code>, where <code>cost[i]</code> represents the cost of converting the string <code>original[i]</code> to the string <code>changed[i]</code>.</p>

<p>You start with the string <code>source</code>. In one operation, you can pick a <strong>substring</strong> <code>x</code> from the string, and change it to <code>y</code> at a cost of <code>z</code> <strong>if</strong> there exists <strong>any</strong> index <code>j</code> such that <code>cost[j] == z</code>, <code>original[j] == x</code>, and <code>changed[j] == y</code>. You are allowed to do <strong>any</strong> number of operations, but any pair of operations must satisfy <strong>either</strong> of these two conditions:</p>

<ul>
	<li>The substrings picked in the operations are <code>source[a..b]</code> and <code>source[c..d]</code> with either <code>b &lt; c</code> <strong>or</strong> <code>d &lt; a</code>. In other words, the indices picked in both operations are <strong>disjoint</strong>.</li>
	<li>The substrings picked in the operations are <code>source[a..b]</code> and <code>source[c..d]</code> with <code>a == c</code> <strong>and</strong> <code>b == d</code>. In other words, the indices picked in both operations are <strong>identical</strong>.</li>
</ul>

<p>Return <em>the <strong>minimum</strong> cost to convert the string </em><code>source</code><em> to the string </em><code>target</code><em> using <strong>any</strong> number of operations</em>. <em>If it is impossible to convert</em> <code>source</code> <em>to</em> <code>target</code>,<em> return</em> <code>-1</code>.</p>

<p><strong>Note</strong> that there may exist indices <code>i</code>, <code>j</code> such that <code>original[j] == original[i]</code> and <code>changed[j] == changed[i]</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> source = &quot;abcd&quot;, target = &quot;acbe&quot;, original = [&quot;a&quot;,&quot;b&quot;,&quot;c&quot;,&quot;c&quot;,&quot;e&quot;,&quot;d&quot;], changed = [&quot;b&quot;,&quot;c&quot;,&quot;b&quot;,&quot;e&quot;,&quot;b&quot;,&quot;e&quot;], cost = [2,5,5,1,2,20]
<strong>Output:</strong> 28
<strong>Explanation:</strong> To convert &quot;abcd&quot; to &quot;acbe&quot;, do the following operations:
- Change substring source[1..1] from &quot;b&quot; to &quot;c&quot; at a cost of 5.
- Change substring source[2..2] from &quot;c&quot; to &quot;e&quot; at a cost of 1.
- Change substring source[2..2] from &quot;e&quot; to &quot;b&quot; at a cost of 2.
- Change substring source[3..3] from &quot;d&quot; to &quot;e&quot; at a cost of 20.
The total cost incurred is 5 + 1 + 2 + 20 = 28. 
It can be shown that this is the minimum possible cost.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> source = &quot;abcdefgh&quot;, target = &quot;acdeeghh&quot;, original = [&quot;bcd&quot;,&quot;fgh&quot;,&quot;thh&quot;], changed = [&quot;cde&quot;,&quot;thh&quot;,&quot;ghh&quot;], cost = [1,3,5]
<strong>Output:</strong> 9
<strong>Explanation:</strong> To convert &quot;abcdefgh&quot; to &quot;acdeeghh&quot;, do the following operations:
- Change substring source[1..3] from &quot;bcd&quot; to &quot;cde&quot; at a cost of 1.
- Change substring source[5..7] from &quot;fgh&quot; to &quot;thh&quot; at a cost of 3. We can do this operation because indices [5,7] are disjoint with indices picked in the first operation.
- Change substring source[5..7] from &quot;thh&quot; to &quot;ghh&quot; at a cost of 5. We can do this operation because indices [5,7] are disjoint with indices picked in the first operation, and identical with indices picked in the second operation.
The total cost incurred is 1 + 3 + 5 = 9.
It can be shown that this is the minimum possible cost.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> source = &quot;abcdefgh&quot;, target = &quot;addddddd&quot;, original = [&quot;bcd&quot;,&quot;defgh&quot;], changed = [&quot;ddd&quot;,&quot;ddddd&quot;], cost = [100,1578]
<strong>Output:</strong> -1
<strong>Explanation:</strong> It is impossible to convert &quot;abcdefgh&quot; to &quot;addddddd&quot;.
If you select substring source[1..3] as the first operation to change &quot;abcdefgh&quot; to &quot;adddefgh&quot;, you cannot select substring source[3..7] as the second operation because it has a common index, 3, with the first operation.
If you select substring source[3..7] as the first operation to change &quot;abcdefgh&quot; to &quot;abcddddd&quot;, you cannot select substring source[1..3] as the second operation because it has a common index, 3, with the first operation.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= source.length == target.length &lt;= 1000</code></li>
	<li><code>source</code>, <code>target</code> consist only of lowercase English characters.</li>
	<li><code>1 &lt;= cost.length == original.length == changed.length &lt;= 100</code></li>
	<li><code>1 &lt;= original[i].length == changed[i].length &lt;= source.length</code></li>
	<li><code>original[i]</code>, <code>changed[i]</code> consist only of lowercase English characters.</li>
	<li><code>original[i] != changed[i]</code></li>
	<li><code>1 &lt;= cost[i] &lt;= 10<sup>6</sup></code></li>
</ul>

## Solutions

### Solution 1: Trie + Floyd Algorithm + Memoization Search

> **Thinking**
>
> Rewrites now replace whole substrings and must hit $\textit{source}$ and $\textit{target}$ together. At most $100$ candidates, so a trie assigns ids and Floyd on those ids gives every replacement cost. The rest is a partition: pay $g[p][q]$ when both tries accept a pair, or step one free character when they already match.
>
> $\textit{dfs}(i)$ memoizes the tail from $i$, walking both tries in lockstep. The string length is $1000$, so states are linear and a transition follows the match length.

According to the problem description, we can consider each string as a node, and the conversion cost between each pair of strings as a directed edge. We first initialize a $26 \times 26$ two-dimensional array $g$, where $g[i][j]$ represents the minimum cost of converting string $i$ to string $j$. Initially, $g[i][j] = \infty$, and if $i = j$, then $g[i][j] = 0$. Here, we can use a trie to store the strings in `original` and `changed` along with their corresponding integer identifiers.

Next, we use the Floyd algorithm to calculate the minimum cost between any two strings.

Then, we define a function $\textit{dfs}(i)$ to represent the minimum cost of converting the string $\textit{source}[i..]$ to the string $\textit{target}[i..]$. The answer is $\textit{dfs}(0)$.

The calculation process of the function $\textit{dfs}(i)$ is as follows:

- If $i \geq |\textit{source}|$, no conversion is needed, return $0$.
- Otherwise, if $\textit{source}[i] = \textit{target}[i]$, we can skip directly and recursively calculate $\textit{dfs}(i + 1)$. We can also enumerate the index $j$ in the range $[i, |\textit{source}|)$, if $\textit{source}[i..j]$ and $\textit{target}[i..j]$ are both in the trie, and their corresponding integer identifiers $x$ and $y$ are both greater than or equal to $0$, then we can add $\textit{dfs}(j + 1)$ and $g[x][y]$ to get the cost of one conversion scheme, and we take the minimum value among all schemes.

In summary, we can get:

$$
\textit{dfs}(i) = \begin{cases}
0, & i \geq |\textit{source}| \\
\textit{dfs}(i + 1), & \textit{source}[i] = \textit{target}[i] \\
\min_{i \leq j < |\textit{source}|} \{ \textit{dfs}(j + 1) + g[x][y] \}, & \text{otherwise}
\end{cases}
$$

Where $x$ and $y$ are the integer identifiers of $\textit{source}[i..j]$ and $\textit{target}[i..j]$ in the trie, respectively.

To avoid repeated calculations, we can use memoization search.

The time complexity is $O(m^3 + n^2 + mn)$, and the space complexity is $O(m^2 + mn + n)$, where $m$ and $n$ are the lengths of the arrays $\textit{original}$ and $\textit{source}$, respectively.

#### Java

```java
class Node {
    Node[] children = new Node[26];
    int v = -1;
}

class Solution {
    private final long inf = 1L << 60;
    private Node root = new Node();
    private int idx;

    private long[][] g;
    private char[] s;
    private char[] t;
    private Long[] f;

    public long minimumCost(
        String source, String target, String[] original, String[] changed, int[] cost) {
        int m = cost.length;
        g = new long[m << 1][m << 1];
        s = source.toCharArray();
        t = target.toCharArray();
        for (int i = 0; i < g.length; ++i) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < m; ++i) {
            int x = insert(original[i]);
            int y = insert(changed[i]);
            g[x][y] = Math.min(g[x][y], cost[i]);
        }
        for (int k = 0; k < idx; ++k) {
            for (int i = 0; i < idx; ++i) {
                if (g[i][k] >= inf) {
                    continue;
                }
                for (int j = 0; j < idx; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        f = new Long[s.length];
        long ans = dfs(0);
        return ans >= inf ? -1 : ans;
    }

    private int insert(String w) {
        Node node = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Node();
            }
            node = node.children[i];
        }
        if (node.v < 0) {
            node.v = idx++;
        }
        return node.v;
    }

    private long dfs(int i) {
        if (i >= s.length) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        long res = s[i] == t[i] ? dfs(i + 1) : inf;
        Node p = root, q = root;
        for (int j = i; j < s.length; ++j) {
            p = p.children[s[j] - 'a'];
            q = q.children[t[j] - 'a'];
            if (p == null || q == null) {
                break;
            }
            if (p.v < 0 || q.v < 0) {
                continue;
            }
            long t = g[p.v][q.v];
            if (t < inf) {
                res = Math.min(res, t + dfs(j + 1));
            }
        }
        return f[i] = res;
    }
}
```

### Solution 2: Trie + Floyd Algorithm + Dynamic Programming

> **Thinking**
>
> Replacing $\textit{source}$ with $\textit{target}$ by every partition is exponential. The strings can have length $1000$, and when the current characters match the first call always lands on the next index, so the chain has depth $n$. The minimum cost from index $i$ depends only on later suffixes. At most $100$ candidates, so a trie assigns ids and Floyd on those ids gives every replacement cost. Set $f[n]=0$ and fill $i$ from $n-1$ down to $0$: equal characters may take $f[i+1]$ for free, and each numbered pair found by walking the tries together updates with $f[j+1]+g[x][y]$. If $f[0]$ is still at least the sentinel, return $-1$.

Treat each string in `original` and `changed` as a node and number them with a trie. $g[x][y]$ is the minimum cost of replacing the string numbered $x$ with the string numbered $y$, initially $\infty$, and $0$ on the diagonal. Floyd's algorithm then gives the minimum cost between any pair of ids.

Let $f[i]$ be the minimum cost of turning $\textit{source}[i..]$ into $\textit{target}[i..]$, with $f[n] = 0$. Scan $i$ from $n - 1$ down to $0$. If $\textit{source}[i] = \textit{target}[i]$, that character can stay for free, so start from $f[i + 1]$. Also walk the trie on $\textit{source}$ and $\textit{target}$ together from $i$. Whenever the prefixes $\textit{source}[i..j]$ and $\textit{target}[i..j]$ both have ids $x$ and $y$, update $f[i]$ with $f[j + 1] + g[x][y]$.

The answer is $f[0]$. If it is at least the preset upper bound, return $-1$.

The time complexity is $O(m^3 + n^2 + mn)$, and the space complexity is $O(m^2 + mn + n)$, where $m$ and $n$ are the lengths of $\textit{original}$ and $\textit{source}$, respectively.

#### Java

```java
class Node {
    Node[] children = new Node[26];
    int v = -1;
}

class Solution {
    private final long inf = 1L << 60;
    private Node root = new Node();
    private int idx;

    private long[][] g;

    public long minimumCost(
        String source, String target, String[] original, String[] changed, int[] cost) {
        int m = cost.length;
        g = new long[m << 1][m << 1];
        char[] s = source.toCharArray();
        char[] t = target.toCharArray();
        for (int i = 0; i < g.length; ++i) {
            Arrays.fill(g[i], inf);
            g[i][i] = 0;
        }
        for (int i = 0; i < m; ++i) {
            int x = insert(original[i]);
            int y = insert(changed[i]);
            g[x][y] = Math.min(g[x][y], cost[i]);
        }
        for (int k = 0; k < idx; ++k) {
            for (int i = 0; i < idx; ++i) {
                if (g[i][k] >= inf) {
                    continue;
                }
                for (int j = 0; j < idx; ++j) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int n = s.length;
        long[] f = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            f[i] = inf;
        }
        for (int i = n - 1; i >= 0; --i) {
            long res = s[i] == t[i] ? f[i + 1] : inf;
            Node p = root, q = root;
            for (int j = i; j < n; ++j) {
                int a = s[j] - 'a';
                int b = t[j] - 'a';
                if (p.children[a] == null || q.children[b] == null) {
                    break;
                }
                p = p.children[a];
                q = q.children[b];
                if (p.v < 0 || q.v < 0) {
                    continue;
                }
                long w = g[p.v][q.v];
                if (w < inf) {
                    res = Math.min(res, w + f[j + 1]);
                }
            }
            f[i] = res;
        }
        return f[0] >= inf ? -1 : f[0];
    }

    private int insert(String w) {
        Node node = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            if (node.children[i] == null) {
                node.children[i] = new Node();
            }
            node = node.children[i];
        }
        if (node.v < 0) {
            node.v = idx++;
        }
        return node.v;
    }
}
```
