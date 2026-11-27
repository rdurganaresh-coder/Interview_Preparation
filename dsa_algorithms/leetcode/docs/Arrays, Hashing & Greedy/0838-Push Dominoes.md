# 838. Push Dominoes

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/push-dominoes/

---

[中文文档](/solution/0800-0899/0838.Push%20Dominoes/README.md)

## Description

<p>There are <code>n</code> dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.</p>

<p>After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.</p>

<p>When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.</p>

<p>For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.</p>

<p>You are given a string <code>dominoes</code> representing the initial state where:</p>

<ul>
	<li><code>dominoes[i] = &#39;L&#39;</code>, if the <code>i<sup>th</sup></code> domino has been pushed to the left,</li>
	<li><code>dominoes[i] = &#39;R&#39;</code>, if the <code>i<sup>th</sup></code> domino has been pushed to the right, and</li>
	<li><code>dominoes[i] = &#39;.&#39;</code>, if the <code>i<sup>th</sup></code> domino has not been pushed.</li>
</ul>

<p>Return <em>a string representing the final state</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> dominoes = &quot;RR.L&quot;
<strong>Output:</strong> &quot;RR.L&quot;
<strong>Explanation:</strong> The first domino expends no additional force on the second domino.
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0800-0899/0838.Push%20Dominoes/images/domino.png" style="height: 196px; width: 512px;" />
<pre>
<strong>Input:</strong> dominoes = &quot;.L.R...LR..L..&quot;
<strong>Output:</strong> &quot;LL.RR.LLRRLL..&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == dominoes.length</code></li>
	<li><code>1 &lt;= n &lt;= 10<sup>5</sup></code></li>
	<li><code>dominoes[i]</code> is either <code>&#39;L&#39;</code>, <code>&#39;R&#39;</code>, or <code>&#39;.&#39;</code>.</li>
</ul>

## Solutions

### Solution 1: Multi-Source BFS

> **Thinking**
>
> Dominoes fall simultaneously; opposing forces cancel. $n\le 10^5$, so a full-board tick simulation is slow. Force spreads from already-fallen tiles, which is a multi-source BFS.
>
> Enqueue every initial $L$ and $R$. A cell falls only if it receives a single force at that time; both directions in the same second leave it upright. Layering by time yields the final string.

Treat all initially pushed dominoes (`L` or `R`) as **sources**, which simultaneously propagate their forces outward. Use a queue to perform BFS layer by layer (0, 1, 2, ...):

We define $\textit{time}[i]$ to record the first moment when the _i_-th domino is affected by a force, with `-1` indicating it has not been affected yet. We also define $\textit{force}[i]$ as a variable-length list that stores the directions (`'L'`, `'R'`) of forces acting on the domino at the same moment. Initially, push all indices of `L/R` dominoes into the queue and set their $\textit{time}$ to 0.

When dequeuing index _i_, if $\textit{force}[i]$ contains only one direction, the domino will fall in that direction $f$. Let the index of the next domino be:

$$
j =
\begin{cases}
i - 1, & f = L,\\
i + 1, & f = R.
\end{cases}
$$

If $0 \leq j < n$:

- If $\textit{time}[j] = -1$, it means _j_ has not been affected yet. Record $\textit{time}[j] = \textit{time}[i] + 1$, enqueue it, and append $f$ to $\textit{force}[j]$.
- If $\textit{time}[j] = \textit{time}[i] + 1$, it means _j_ has already been affected by another force at the same "next moment." In this case, append $f$ to $\textit{force}[j]$, causing a standoff. Subsequently, since $\textit{len}(\textit{force}[j]) = 2$, it will remain upright.

After the queue is emptied, all positions where $\textit{force}[i]$ has a length of 1 will fall in the corresponding direction, while positions with a length of 2 will remain as `.`. Finally, concatenate the character array to form the answer.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of dominoes.

#### Java

```java
class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        Deque<Integer> q = new ArrayDeque<>();
        int[] time = new int[n];
        Arrays.fill(time, -1);
        List<Character>[] force = new List[n];
        for (int i = 0; i < n; ++i) {
            force[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; ++i) {
            char f = dominoes.charAt(i);
            if (f != '.') {
                q.offer(i);
                time[i] = 0;
                force[i].add(f);
            }
        }
        char[] ans = new char[n];
        Arrays.fill(ans, '.');
        while (!q.isEmpty()) {
            int i = q.poll();
            if (force[i].size() == 1) {
                ans[i] = force[i].get(0);
                char f = ans[i];
                int j = f == 'L' ? i - 1 : i + 1;
                if (j >= 0 && j < n) {
                    int t = time[i];
                    if (time[j] == -1) {
                        q.offer(j);
                        time[j] = t + 1;
                        force[j].add(f);
                    } else if (time[j] == t + 1) {
                        force[j].add(f);
                    }
                }
            }
        }
        return new String(ans);
    }
}
```
