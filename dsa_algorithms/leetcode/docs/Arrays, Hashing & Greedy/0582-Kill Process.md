# 582. Kill Process

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/kill-process/

---

[中文文档](/solution/0500-0599/0582.Kill%20Process/README.md)

## Description

<p>You have <code>n</code> processes forming a rooted tree structure. You are given two integer arrays <code>pid</code> and <code>ppid</code>, where <code>pid[i]</code> is the ID of the <code>i<sup>th</sup></code> process and <code>ppid[i]</code> is the ID of the <code>i<sup>th</sup></code> process&#39;s parent process.</p>

<p>Each process has only <strong>one parent process</strong> but may have multiple children processes. Only one process has <code>ppid[i] = 0</code>, which means this process has <strong>no parent process</strong> (the root of the tree).</p>

<p>When a process is <strong>killed</strong>, all of its children processes will also be killed.</p>

<p>Given an integer <code>kill</code> representing the ID of a process you want to kill, return <em>a list of the IDs of the processes that will be killed. You may return the answer in <strong>any order</strong>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0582.Kill%20Process/images/ptree.jpg" style="width: 207px; height: 302px;" />
<pre>
<strong>Input:</strong> pid = [1,3,10,5], ppid = [3,0,5,3], kill = 5
<strong>Output:</strong> [5,10]
<strong>Explanation:</strong>&nbsp;The processes colored in red are the processes that should be killed.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> pid = [1], ppid = [0], kill = 1
<strong>Output:</strong> [1]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == pid.length</code></li>
	<li><code>n == ppid.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= pid[i] &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>0 &lt;= ppid[i] &lt;= 5 * 10<sup>4</sup></code></li>
	<li>Only one process has no parent.</li>
	<li>All the values of <code>pid</code> are <strong>unique</strong>.</li>
	<li><code>kill</code> is <strong>guaranteed</strong> to be in <code>pid</code>.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Killing a process kills its whole descendant tree. The parent arrays should become an adjacency list first.
>
> $g[p]$ stores children of $p$. DFS or BFS from $\textit{kill}$ gathers every reachable id. Each process is entered once.

We first construct a graph $g$ based on $\textit{pid}$ and $\textit{ppid}$, where $g[i]$ represents all child processes of process $i$. Then, starting from the process $\textit{kill}$, we perform depth-first search to obtain all killed processes.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of processes.

#### Java

```java
class Solution {
    private Map<Integer, List<Integer>> g = new HashMap<>();
    private List<Integer> ans = new ArrayList<>();

    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        int n = pid.size();
        for (int i = 0; i < n; ++i) {
            g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }
        dfs(kill);
        return ans;
    }

    private void dfs(int i) {
        ans.add(i);
        for (int j : g.getOrDefault(i, Collections.emptyList())) {
            dfs(j);
        }
    }
}
```

### Solution 2: Explicit Stack

> **Thinking**
>
> Killing a process also kills every descendant. The parent links arrive as two parallel arrays, and $n$ can be $5 \times 10^4$, so each process should first store its children. Collecting descendants by recursion along a parent chain uses a call depth equal to the process count and overflows Python once the chain reaches length $1000$. A stack therefore holds the processes still to visit: a popped process is recorded, and its children are pushed in reverse so the collection order matches a preorder walk of the child lists. The process tree has no cycle, so each process is pushed once.

Build a graph $g$ from $\textit{pid}$ and $\textit{ppid}$, where $g[i]$ is the list of child processes of process $i$. Start at process $\textit{kill}$ and walk with an explicit stack. When process $i$ is popped, append it to the answer and push its children in reverse order, so the earlier child is popped next. Every descendant is collected once. The problem accepts the ids in any order.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of processes.

#### Java

```java
class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        int n = pid.size();
        for (int i = 0; i < n; ++i) {
            g.computeIfAbsent(ppid.get(i), k -> new ArrayList<>()).add(pid.get(i));
        }
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(kill);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            ans.add(i);
            List<Integer> children = g.getOrDefault(i, List.of());
            for (int k = children.size() - 1; k >= 0; --k) {
                stk.push(children.get(k));
            }
        }
        return ans;
    }
}
```
