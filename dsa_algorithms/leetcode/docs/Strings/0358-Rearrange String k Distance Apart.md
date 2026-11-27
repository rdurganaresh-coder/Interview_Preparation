# 358. Rearrange String k Distance Apart

**Difficulty:** Hard  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/rearrange-string-k-distance-apart/

---

[中文文档](/solution/0300-0399/0358.Rearrange%20String%20k%20Distance%20Apart/README.md)

## Description

<p>Given a string <code>s</code> and an integer <code>k</code>, rearrange <code>s</code> such that the same characters are <strong>at least</strong> distance <code>k</code> from each other. If it is not possible to rearrange the string, return an empty string <code>&quot;&quot;</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aabbcc&quot;, k = 3
<strong>Output:</strong> &quot;abcabc&quot;
<strong>Explanation:</strong> The same letters are at least a distance of 3 from each other.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaabc&quot;, k = 3
<strong>Output:</strong> &quot;&quot;
<strong>Explanation:</strong> It is not possible to rearrange the string.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;aaadbbcc&quot;, k = 2
<strong>Output:</strong> &quot;abacabcd&quot;
<strong>Explanation:</strong> The same letters are at least a distance of 2 from each other.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 3 * 10<sup>5</sup></code></li>
	<li><code>s</code> consists of only lowercase English letters.</li>
	<li><code>0 &lt;= k &lt;= s.length</code></li>
</ul>

## Solutions

### Solution 1: Greedy + Hash Table + Priority Queue (Max Heap)

> **Thinking**
>
> Rearrange so equal letters are at least $k$ apart; if impossible, return empty. Spend frequent letters first and cool them in a queue.
>
> A max-heap pops a letter, appends it, and enqueues it for $k$ steps; when the queue is full, leftover counts return to the heap. If the heap empties before the string is finished, no layout exists.

We use a hash table or array $\textit{cnt}$ to count the occurrences of each character in the string. Then, we use a max heap $pq$ to store each character and its count. Each element in the heap is a tuple $(v, c)$, where $v$ is the count and $c$ is the character.

When rearranging the string, we repeatedly pop the top element $(v, c)$ from the heap, add character $c$ to the result string, and push $(v-1, c)$ into a queue $q$. When the length of the queue $q$ reaches $k$ or more, we pop the front element; if its $v$ is greater than $0$, we push it back into the heap. Repeat this process until the heap is empty.

Finally, we check whether the length of the result string equals the original string. If so, we return the result string; otherwise, we return an empty string.

The time complexity is $O(n \log n)$, and the space complexity is $O(|\Sigma|)$, where $n$ is the length of the string, and $|\Sigma|$ is the size of the character set, which is $26$ in this problem.

Related problems:

- [767. Reorganize String](https://github.com/doocs/leetcode/blob/main/solution/0700-0799/0767.Reorganize%20String/README.md)

#### Java

```java
class Solution {
    public String rearrangeString(String s, int k) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            ++cnt[c - 'a'];
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                pq.offer(new int[] {cnt[i], i});
            }
        }
        Deque<int[]> q = new ArrayDeque<>();
        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            var p = pq.poll();
            p[0] -= 1;
            ans.append((char) ('a' + p[1]));
            q.offerLast(p);
            if (q.size() >= k) {
                p = q.pollFirst();
                if (p[0] > 0) {
                    pq.offer(p);
                }
            }
        }
        return ans.length() < s.length() ? "" : ans.toString();
    }
}
```
