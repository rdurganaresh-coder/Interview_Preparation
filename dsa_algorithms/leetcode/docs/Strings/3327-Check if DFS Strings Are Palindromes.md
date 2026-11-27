# 3327. Check if DFS Strings Are Palindromes

**Difficulty:** Hard  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/check-if-dfs-strings-are-palindromes/

---

[中文文档](/solution/3300-3399/3327.Check%20if%20DFS%20Strings%20Are%20Palindromes/README.md)

## Description

<p>You are given a tree rooted at node 0, consisting of <code>n</code> nodes numbered from <code>0</code> to <code>n - 1</code>. The tree is represented by an array <code>parent</code> of size <code>n</code>, where <code>parent[i]</code> is the parent of node <code>i</code>. Since node 0 is the root, <code>parent[0] == -1</code>.</p>

<p>You are also given a string <code>s</code> of length <code>n</code>, where <code>s[i]</code> is the character assigned to node <code>i</code>.</p>

<p>Consider an empty string <code>dfsStr</code>, and define a recursive function <code>dfs(int x)</code> that takes a node <code>x</code> as a parameter and performs the following steps in order:</p>

<ul>
	<li>Iterate over each child <code>y</code> of <code>x</code> <strong>in increasing order of their numbers</strong>, and call <code>dfs(y)</code>.</li>
	<li>Add the character <code>s[x]</code> to the end of the string <code>dfsStr</code>.</li>
</ul>

<p><strong>Note</strong> that <code>dfsStr</code> is shared across all recursive calls of <code>dfs</code>.</p>

<p>You need to find a boolean array <code>answer</code> of size <code>n</code>, where for each index <code>i</code> from <code>0</code> to <code>n - 1</code>, you do the following:</p>

<ul>
	<li>Empty the string <code>dfsStr</code> and call <code>dfs(i)</code>.</li>
	<li>If the resulting string <code>dfsStr</code> is a <span data-keyword="palindrome-string">palindrome</span>, then set <code>answer[i]</code> to <code>true</code>. Otherwise, set <code>answer[i]</code> to <code>false</code>.</li>
</ul>

<p>Return the array <code>answer</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3300-3399/3327.Check%20if%20DFS%20Strings%20Are%20Palindromes/images/tree1drawio.png" style="width: 240px; height: 256px;" />
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">parent = [-1,0,0,1,1,2], s = &quot;aababa&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[true,true,false,true,true,true]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>Calling <code>dfs(0)</code> results in the string <code>dfsStr = &quot;abaaba&quot;</code>, which is a palindrome.</li>
	<li>Calling <code>dfs(1)</code> results in the string <code>dfsStr = &quot;aba&quot;</code>, which is a palindrome.</li>
	<li>Calling <code>dfs(2)</code> results in the string <code>dfsStr = &quot;ab&quot;</code>, which is <strong>not</strong> a palindrome.</li>
	<li>Calling <code>dfs(3)</code> results in the string <code>dfsStr = &quot;a&quot;</code>, which is a palindrome.</li>
	<li>Calling <code>dfs(4)</code> results in the string <code>dfsStr = &quot;b&quot;</code>, which is a palindrome.</li>
	<li>Calling <code>dfs(5)</code> results in the string <code>dfsStr = &quot;a&quot;</code>, which is a palindrome.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/3300-3399/3327.Check%20if%20DFS%20Strings%20Are%20Palindromes/images/tree2drawio-1.png" style="width: 260px; height: 167px;" />
<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">parent = [-1,0,0,0,0], s = &quot;aabcb&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">[true,true,true,true,true]</span></p>

<p><strong>Explanation:</strong></p>

<p>Every call on <code>dfs(x)</code> results in a palindrome string.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == parent.length == s.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= parent[i] &lt;= n - 1</code> for all <code>i &gt;= 1</code>.</li>
	<li><code>parent[0] == -1</code></li>
	<li><code>parent</code> represents a valid tree.</li>
	<li><code>s</code> consists only of lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: DFS + String Hashing

> **Thinking**
>
> The $\textit{dfsStr}$ of a subtree is a contiguous segment, and we must test whether it is a palindrome. With $n \le 10^5$ we cannot rescan the string at every node.
>
> One DFS writes the whole-tree $\textit{dfsStr}$ and records the interval $[l, r]$ of each node.
>
> Hashes of the string and of its reverse let us compare the first half of $[l, r]$ with the corresponding half of the reverse in $O(1)$, which decides palindromicity.

We can use Depth-First Search (DFS) to traverse the tree and compute the entire $\textit{dfsStr}$, while also determining the interval $[l, r]$ for each node.

Then, we use string hashing to compute the hash values of both $\textit{dfsStr}$ and the reverse of $\textit{dfsStr}$ to check if it is a palindrome.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Hashing {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing(String word, long base, int mod) {
        int n = word.length();
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        this.mod = mod;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * base % mod;
            h[i] = (h[i - 1] * base + word.charAt(i - 1)) % mod;
        }
    }

    public long query(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod;
    }
}

class Solution {
    private char[] s;
    private int[][] pos;
    private List<Integer>[] g;
    private StringBuilder dfsStr = new StringBuilder();

    public boolean[] findAnswer(int[] parent, String s) {
        this.s = s.toCharArray();
        int n = s.length();
        g = new List[n];
        pos = new int[n][0];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        dfs(0);
        final int base = 13331;
        final int mod = 998244353;
        Hashing h1 = new Hashing(dfsStr.toString(), base, mod);
        Hashing h2 = new Hashing(new StringBuilder(dfsStr).reverse().toString(), base, mod);
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int l = pos[i][0], r = pos[i][1];
            int k = r - l + 1;
            long v1 = h1.query(l, l + k / 2 - 1);
            long v2 = h2.query(n + 1 - r, n + 1 - r + k / 2 - 1);
            ans[i] = v1 == v2;
        }
        return ans;
    }

    private void dfs(int i) {
        int l = dfsStr.length() + 1;
        for (int j : g[i]) {
            dfs(j);
        }
        dfsStr.append(s[i]);
        int r = dfsStr.length();
        pos[i] = new int[] {l, r};
    }
}
```

### Solution 2: Explicit Stack + String Hashing

> **Thinking**
>
> The $\textit{dfsStr}$ of a subtree is a contiguous segment, and we must test whether it is a palindrome. With $n \le 10^5$, rescanning the string at every node is $O(n^2)$, and writing the traversal by recursion from the root is too deep: a chain makes the call depth $n$.
>
> A node's character is appended only when the node is left, so its interval covers exactly the descendants written first. Children have to be processed in the adjacency-list order, or the endpoints will not match the recursive traversal.
>
> An explicit stack of $(\textit{node}, \textit{state})$ runs that postorder. On entry we push the exit marker and then the children in reverse, so they still pop from left to right, and on exit we record $[l, r]$. Hashes of the string and of its reverse compare the first half of $[l, r]$ with the matching half of the reverse in $O(1)$.

An explicit stack walks the tree in postorder. When a node is left, its character is appended to $\textit{dfsStr}$ and its interval $[l, r]$ is recorded. Children are processed from left to right in the adjacency list.

Then, we use string hashing to compute the hash values of both $\textit{dfsStr}$ and the reverse of $\textit{dfsStr}$ to check whether each interval is a palindrome.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Hashing {
    private final long[] p;
    private final long[] h;
    private final long mod;

    public Hashing(String word, long base, int mod) {
        int n = word.length();
        p = new long[n + 1];
        h = new long[n + 1];
        p[0] = 1;
        this.mod = mod;
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] * base % mod;
            h[i] = (h[i - 1] * base + word.charAt(i - 1)) % mod;
        }
    }

    public long query(int l, int r) {
        return (h[r] - h[l - 1] * p[r - l + 1] % mod + mod) % mod;
    }
}

class Solution {
    public boolean[] findAnswer(int[] parent, String s) {
        int n = s.length();
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, k -> new ArrayList<>());
        for (int i = 1; i < n; ++i) {
            g[parent[i]].add(i);
        }
        StringBuilder dfsStr = new StringBuilder();
        int[][] pos = new int[n][2];
        Deque<int[]> stk = new ArrayDeque<>();
        stk.push(new int[] {0, 0});
        while (!stk.isEmpty()) {
            int[] cur = stk.pop();
            int i = cur[0], state = cur[1];
            if (state == 0) {
                pos[i][0] = dfsStr.length() + 1;
                stk.push(new int[] {i, 1});
                for (int t = g[i].size() - 1; t >= 0; --t) {
                    stk.push(new int[] {g[i].get(t), 0});
                }
            } else {
                dfsStr.append(s.charAt(i));
                pos[i][1] = dfsStr.length();
            }
        }
        final int base = 13331;
        final int mod = 998244353;
        Hashing h1 = new Hashing(dfsStr.toString(), base, mod);
        Hashing h2 = new Hashing(new StringBuilder(dfsStr).reverse().toString(), base, mod);
        boolean[] ans = new boolean[n];
        for (int i = 0; i < n; ++i) {
            int l = pos[i][0], r = pos[i][1];
            int k = r - l + 1;
            long v1 = h1.query(l, l + k / 2 - 1);
            long v2 = h2.query(n + 1 - r, n + 1 - r + k / 2 - 1);
            ans[i] = v1 == v2;
        }
        return ans;
    }
}
```
