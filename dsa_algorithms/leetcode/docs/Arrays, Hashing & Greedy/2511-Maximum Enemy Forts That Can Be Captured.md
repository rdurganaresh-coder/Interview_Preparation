# 2511. Maximum Enemy Forts That Can Be Captured

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-enemy-forts-that-can-be-captured/

---

[中文文档](/solution/2500-2599/2511.Maximum%20Enemy%20Forts%20That%20Can%20Be%20Captured/README.md)

## Description

<p>You are given a <strong>0-indexed</strong> integer array <code>forts</code> of length <code>n</code> representing the positions of several forts. <code>forts[i]</code> can be <code>-1</code>, <code>0</code>, or <code>1</code> where:</p>

<ul>
	<li><code>-1</code> represents there is <strong>no fort</strong> at the <code>i<sup>th</sup></code> position.</li>
	<li><code>0</code> indicates there is an <strong>enemy</strong> fort at the <code>i<sup>th</sup></code> position.</li>
	<li><code>1</code> indicates the fort at the <code>i<sup>th</sup></code> the position is under your command.</li>
</ul>

<p>Now you have decided to move your army from one of your forts at position <code>i</code> to an empty position <code>j</code> such that:</p>

<ul>
	<li><code>0 &lt;= i, j &lt;= n - 1</code></li>
	<li>The army travels over enemy forts <strong>only</strong>. Formally, for all <code>k</code> where <code>min(i,j) &lt; k &lt; max(i,j)</code>, <code>forts[k] == 0.</code></li>
</ul>

<p>While moving the army, all the enemy forts that come in the way are <strong>captured</strong>.</p>

<p>Return<em> the <strong>maximum</strong> number of enemy forts that can be captured</em>. In case it is <strong>impossible</strong> to move your army, or you do not have any fort under your command, return <code>0</code><em>.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> forts = [1,0,0,-1,0,0,0,0,1]
<strong>Output:</strong> 4
<strong>Explanation:</strong>
- Moving the army from position 0 to position 3 captures 2 enemy forts, at 1 and 2.
- Moving the army from position 8 to position 3 captures 4 enemy forts.
Since 4 is the maximum number of enemy forts that can be captured, we return 4.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> forts = [0,0,1,-1]
<strong>Output:</strong> 0
<strong>Explanation:</strong> Since no enemy fort can be captured, 0 is returned.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= forts.length &lt;= 1000</code></li>
	<li><code>-1 &lt;= forts[i] &lt;= 1</code></li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> A move starts at a friendly fort, crosses a run of empty cells, and stops at an enemy fort; the captured count is the zeros in between. $n\le 1000$ allows enumerating endpoints, but each $i$ need not rescan to the right.
>
> Park $i$ on a nonzero cell and let $j$ skip the following zeros to the next nonzero. Opposite signs mean $j-i-1$ zeros can update the answer; then set $i$ to $j$ so the array is walked once.

We use a pointer $i$ to traverse the array $\textit{forts}$, and a pointer $j$ to start traversing from the next position of $i$ until it encounters the first non-zero position, i.e., $\textit{forts}[j] \neq 0$. If $\textit{forts}[i] + \textit{forts}[j] = 0$, then we can move the army between $i$ and $j$, destroying $j - i - 1$ enemy forts. We use the variable $\textit{ans}$ to record the maximum number of enemy forts that can be destroyed.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{forts}$.

#### Java

```java
class Solution {
    public int captureForts(int[] forts) {
        int n = forts.length;
        int ans = 0, i = 0;
        while (i < n) {
            int j = i + 1;
            if (forts[i] != 0) {
                while (j < n && forts[j] == 0) {
                    ++j;
                }
                if (j < n && forts[i] + forts[j] == 0) {
                    ans = Math.max(ans, j - i - 1);
                }
            }
            i = j;
        }
        return ans;
    }
}
```
