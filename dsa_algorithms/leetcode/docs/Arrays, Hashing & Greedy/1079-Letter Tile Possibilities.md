# 1079. Letter Tile Possibilities

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/letter-tile-possibilities/

---

[中文文档](/solution/1000-1099/1079.Letter%20Tile%20Possibilities/README.md)

## Description

<p>You have <code>n</code>&nbsp;&nbsp;<code>tiles</code>, where each tile has one letter <code>tiles[i]</code> printed on it.</p>

<p>Return <em>the number of possible non-empty sequences of letters</em> you can make using the letters printed on those <code>tiles</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> tiles = &quot;AAB&quot;
<strong>Output:</strong> 8
<strong>Explanation: </strong>The possible sequences are &quot;A&quot;, &quot;B&quot;, &quot;AA&quot;, &quot;AB&quot;, &quot;BA&quot;, &quot;AAB&quot;, &quot;ABA&quot;, &quot;BAA&quot;.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> tiles = &quot;AAABBC&quot;
<strong>Output:</strong> 188
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> tiles = &quot;V&quot;
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= tiles.length &lt;= 7</code></li>
	<li><code>tiles</code> consists of uppercase English letters.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Distinct sequences are permutations of a multiset. $n\le 7$ is searchable, but identical letters would be over-counted if we permuted positions. We should recurse on remaining counts.
>
> $\textit{dfs}(\textit{cnt})$ tries every letter still available, uses one copy, and counts that choice as a nonempty sequence before recursing.
>
> Counts are incremented back on return; the top call uses the bag’s frequencies.

#### Java

```java
class Solution {
    public int numTilePossibilities(String tiles) {
        int[] cnt = new int[26];
        for (char c : tiles.toCharArray()) {
            ++cnt[c - 'A'];
        }
        return dfs(cnt);
    }

    private int dfs(int[] cnt) {
        int res = 0;
        for (int i = 0; i < cnt.length; ++i) {
            if (cnt[i] > 0) {
                ++res;
                --cnt[i];
                res += dfs(cnt);
                ++cnt[i];
            }
        }
        return res;
    }
}
```
