# 841. Keys and Rooms

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/keys-and-rooms/

---

[中文文档](/solution/0800-0899/0841.Keys%20and%20Rooms/README.md)

## Description

<p>There are <code>n</code> rooms labeled from <code>0</code> to <code>n - 1</code>&nbsp;and all the rooms are locked except for room <code>0</code>. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.</p>

<p>When you visit a room, you may find a set of <strong>distinct keys</strong> in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.</p>

<p>Given an array <code>rooms</code> where <code>rooms[i]</code> is the set of keys that you can obtain if you visited room <code>i</code>, return <code>true</code> <em>if you can visit <strong>all</strong> the rooms, or</em> <code>false</code> <em>otherwise</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> rooms = [[1],[2],[3],[]]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> rooms = [[1,3],[3,0,1],[2],[0]]
<strong>Output:</strong> false
<strong>Explanation:</strong> We can not enter room number 2 since the only key that unlocks it is in that room.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == rooms.length</code></li>
	<li><code>2 &lt;= n &lt;= 1000</code></li>
	<li><code>0 &lt;= rooms[i].length &lt;= 1000</code></li>
	<li><code>1 &lt;= sum(rooms[i].length) &lt;= 3000</code></li>
	<li><code>0 &lt;= rooms[i][j] &lt; n</code></li>
	<li>All the values of <code>rooms[i]</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: Depth-First Search (DFS)

> **Thinking**
>
> Rooms form a directed graph whose edges are keys. We ask whether $0$ reaches every room. $n\le 1000$, so one traversal is enough.
>
> DFS from $0$ follows keys; success is $|\textit{vis}|=n$.

We can use the Depth-First Search (DFS) method to traverse the entire graph, count the number of reachable nodes, and use an array $\textit{vis}$ to mark whether the current node has been visited to prevent repeated visits.

Finally, we count the number of visited nodes. If it is the same as the total number of nodes, it means that all nodes can be visited; otherwise, there are nodes that cannot be reached.

The time complexity is $O(n + m)$, and the space complexity is $O(n)$, where $n$ is the number of nodes, and $m$ is the number of edges.

#### Java

```java
class Solution {
    private int cnt;
    private boolean[] vis;
    private List<List<Integer>> g;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        g = rooms;
        vis = new boolean[g.size()];
        dfs(0);
        return cnt == g.size();
    }

    private void dfs(int i) {
        if (vis[i]) {
            return;
        }
        vis[i] = true;
        ++cnt;
        for (int j : g.get(i)) {
            dfs(j);
        }
    }
}
```

### Solution 2: BFS

> **Thinking**
>
> Solution 1 follows keys by recursion. A chain of rooms uses a call depth equal to the room count. The same reachability is a queue: start at $0$ and enqueue a room when a key to it is found and that room is still unvisited. The visited marks still drop duplicate keys, and the answer still compares the visited count with $n$.

We can also use the Breadth-First Search (BFS) method to traverse the entire graph. We use a hash table or an array `vis` to mark whether the current node has been visited to prevent repeated visits.

Specifically, we define a queue $q$, initially put node $0$ into the queue, and then continuously traverse the queue. Each time we take out the front node $i$ of the queue, if $i$ has been visited, we skip it directly; otherwise, we mark it as visited, and then add the nodes that $i$ can reach to the queue.

Finally, we count the number of visited nodes. If it is the same as the total number of nodes, it means that all nodes can be visited; otherwise, it means that there are unreachable nodes.

The time complexity is $O(n + m)$, and the space complexity is $O(n)$, where $n$ is the number of nodes, and $m$ is the number of edges.

#### Java

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int i = q.poll();
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            ++cnt;
            for (int j : rooms.get(i)) {
                q.offer(j);
            }
        }
        return cnt == n;
    }
}
```

### Solution 3: Explicit Stack

> **Thinking**
>
> Rooms form a directed graph whose edges are keys. The question is whether room $0$ reaches every room. With $n \le 1000$, one traversal is enough. Following a chain of keys by recursion uses a call depth equal to the room count and overflows Python once the chain reaches length $1000$. A stack therefore holds the rooms still to open: a popped room is skipped when it was already visited, and otherwise it is marked and its keys are pushed. Duplicate keys may push the same room again, and the mark expands it only once. Every room is reachable when the visited count equals $n$.

Start at room $0$ and walk the reachable rooms with an explicit stack. The stack begins with $0$. When room $i$ is popped, skip it if it has already been visited; otherwise mark it and push the room behind each key found in $i$. A repeated key only pushes that room again, and the later pop is skipped.

Finally, check whether every room was visited. If so, return true; otherwise some room cannot be reached.

The time complexity is $O(n + m)$, and the space complexity is $O(n)$, where $n$ is the number of nodes, and $m$ is the number of edges.

#### Java

```java
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(0);
        while (!stk.isEmpty()) {
            int i = stk.pop();
            if (vis[i]) {
                continue;
            }
            vis[i] = true;
            for (int j : rooms.get(i)) {
                stk.push(j);
            }
        }
        for (boolean v : vis) {
            if (!v) {
                return false;
            }
        }
        return true;
    }
}
```
