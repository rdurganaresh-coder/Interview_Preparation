# 2355. Maximum Number of Books You Can Take

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-number-of-books-you-can-take/

---

[中文文档](/solution/2300-2399/2355.Maximum%20Number%20of%20Books%20You%20Can%20Take/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>books</code> of length <code>n</code> where <code>books[i]</code> denotes the number of books on the <code>i<sup>th</sup></code> shelf of a bookshelf.</p>

<p>You are going to take books from a <strong>contiguous</strong> section of the bookshelf spanning from <code>l</code> to <code>r</code> where <code>0 &lt;= l &lt;= r &lt; n</code>. For each index <code>i</code> in the range <code>l &lt;= i &lt; r</code>, you must take <strong>strictly fewer</strong> books from shelf <code>i</code> than shelf <code>i + 1</code>.</p>

<p>Return <em>the <strong>maximum</strong> number of books you can take from the bookshelf.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> books = [8,5,2,7,9]
<strong>Output:</strong> 19
<strong>Explanation:</strong>
- Take 1 book from shelf 1.
- Take 2 books from shelf 2.
- Take 7 books from shelf 3.
- Take 9 books from shelf 4.
You have taken 19 books, so return 19.
It can be proven that 19 is the maximum number of books you can take.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> books = [7,0,3,4,5]
<strong>Output:</strong> 12
<strong>Explanation:</strong>
- Take 3 books from shelf 2.
- Take 4 books from shelf 3.
- Take 5 books from shelf 4.
You have taken 12 books so return 12.
It can be proven that 12 is the maximum number of books you can take.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> books = [8,2,3,7,3,4,0,1,4,3]
<strong>Output:</strong> 13
<strong>Explanation:</strong>
- Take 1 book from shelf 0.
- Take 2 books from shelf 1.
- Take 3 books from shelf 2.
- Take 7 books from shelf 3.
You have taken 13 books so return 13.
It can be proven that 13 is the maximum number of books you can take.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= books.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= books[i] &lt;= 10<sup>5</sup></code></li>
</ul>

## Solutions

### Solution 1: Monotonic Stack + Dynamic Programming

> **Thinking**
>
> Books come from a contiguous range of shelves, decreasing by at least one toward the left. Finding the break by brute force for every right end is too slow.
>
> Let $\textit{nums}[i]=\textit{books}[i]-i$. The break is the nearest smaller $\textit{nums}[j]$ on the left. A monotonic stack fills $\textit{left}[i]$; $dp[i]$ is the best take ending at $i$: an arithmetic segment in the middle plus $dp[j]$ on the left.

Let $dp[i]$ be the maximum number of books taken from a contiguous segment that ends at shelf $i$. Set $\textit{nums}[i] = \textit{books}[i] - i$. If the strictly decreasing pattern breaks at some $j$ with $0 \le j < i$, then $\textit{books}[j] < \textit{books}[i] - (i - j)$, that is $\textit{nums}[j] < \textit{nums}[i]$. A monotonic stack finds, for each index, the nearest strictly smaller $\textit{nums}$ on the left and stores it as $j$. When no such index exists, $j = -1$.

The books taken from shelf $j + 1$ through $i$ form an arithmetic sequence with difference $1$. Its length is $\textit{cnt} = \min(\textit{books}[i], i - j)$, it ends at $\textit{books}[i]$, and it starts at $u = \textit{books}[i] - \textit{cnt} + 1$. The sum of that sequence is $s = (u + \textit{books}[i]) \times \textit{cnt} / 2$. Then $dp[i] = s$, plus $dp[j]$ when $j \ne -1$.

The answer is $\max\limits_{i} dp[i]$.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of $\textit{books}$.

#### Java

```java
class Solution {
    public long maximumBooks(int[] books) {
        int n = books.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = books[i] - i;
        }
        int[] left = new int[n];
        Arrays.fill(left, -1);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            while (!stk.isEmpty() && nums[stk.peek()] >= nums[i]) {
                stk.pop();
            }
            if (!stk.isEmpty()) {
                left[i] = stk.peek();
            }
            stk.push(i);
        }
        long ans = 0;
        long[] dp = new long[n];
        dp[0] = books[0];
        for (int i = 0; i < n; ++i) {
            int j = left[i];
            int v = books[i];
            int cnt = Math.min(v, i - j);
            int u = v - cnt + 1;
            long s = (long) (u + v) * cnt / 2;
            dp[i] = s + (j == -1 ? 0 : dp[j]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
```
