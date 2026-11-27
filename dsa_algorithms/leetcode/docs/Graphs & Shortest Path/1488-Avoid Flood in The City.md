# 1488. Avoid Flood in The City

**Difficulty:** Medium  
**Category:** Graphs & Shortest Path  
**LeetCode:** https://leetcode.com/problems/avoid-flood-in-the-city/

---

[中文文档](/solution/1400-1499/1488.Avoid%20Flood%20in%20The%20City/README.md)

## Description

<p>Your country has 10<sup>9</sup> lakes. Initially, all the lakes are empty, but when it rains over the <code>n<sup>th</sup></code> lake, the <code>n<sup>th</sup></code> lake becomes full of water. If it rains over a lake that is <strong>full of water</strong>, there will be a <strong>flood</strong>. Your goal is to avoid floods in any lake.</p>

<p>Given an integer array <code>rains</code> where:</p>

<ul>
	<li><code>rains[i] &gt; 0</code> means there will be rains over the <code>rains[i]</code> lake.</li>
	<li><code>rains[i] == 0</code> means there are no rains this day and you&nbsp;<strong>must</strong> choose&nbsp;<strong>one lake</strong> this day and <strong>dry it</strong>.</li>
</ul>

<p>Return <em>an array <code>ans</code></em> where:</p>

<ul>
	<li><code>ans.length == rains.length</code></li>
	<li><code>ans[i] == -1</code> if <code>rains[i] &gt; 0</code>.</li>
	<li><code>ans[i]</code> is the lake you choose to dry in the <code>ith</code> day if <code>rains[i] == 0</code>.</li>
</ul>

<p>If there are multiple valid answers return <strong>any</strong> of them. If it is impossible to avoid flood return <strong>an empty array</strong>.</p>

<p>Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,3,4]
<strong>Output:</strong> [-1,-1,-1,-1]
<strong>Explanation:</strong> After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day full lakes are [1,2,3]
After the fourth day full lakes are [1,2,3,4]
There&#39;s no day to dry any lake and there is no flood in any lake.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,0,0,2,1]
<strong>Output:</strong> [-1,-1,2,1,-1,-1]
<strong>Explanation:</strong> After the first day full lakes are [1]
After the second day full lakes are [1,2]
After the third day, we dry lake 2. Full lakes are [1]
After the fourth day, we dry lake 1. There is no full lakes.
After the fifth day, full lakes are [2].
After the sixth day, full lakes are [1,2].
It is easy that this scenario is flood-free. [-1,-1,1,2,-1,-1] is another acceptable scenario.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> rains = [1,2,0,1,2]
<strong>Output:</strong> []
<strong>Explanation:</strong> After the second day, full lakes are  [1,2]. We have to dry one lake in the third day.
After that, it will rain over lakes [1,2]. It&#39;s easy to prove that no matter which lake you choose to dry in the 3rd day, the other one will flood.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= rains.length &lt;= 10<sup>5</sup></code></li>
	<li><code>0 &lt;= rains[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Greedy + Binary Search

> **Thinking**
>
> $n\le 10^5$. A lake that rains a second time must have been dried after the previous rain. A dry day should be spent on the lake that will rain again soonest among those still full.
>
> Store dry days in a sorted list and the last rain day of each lake in a map. On a repeat rain, binary-search the first dry day after that last rain; if none exists, fail. Unused dry days become $1$.

We store all sunny days in the $\textit{sunny}$ array or a sorted set, and use the hash table $\textit{rainy}$ to record the last rainy day for each lake. We initialize the answer array $\textit{ans}$ with each element set to $-1$.

Next, we traverse the $\textit{rains}$ array. For each rainy day $i$, if $\textit{rainy}[\textit{rains}[i]]$ exists, it means that the lake has rained before, so we need to find the first date in the $\textit{sunny}$ array that is greater than $\textit{rainy}[\textit{rains}[i]]$, and replace it with the rainy day. Otherwise, it means that the flood cannot be prevented, and we return an empty array. For each non-rainy day $i$, we store $i$ in the $\textit{sunny}$ array and set $\textit{ans}[i]$ to $1$.

After the traversal, we return the answer array.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the $\textit{rains}$ array.

#### Java

```java
class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        TreeSet<Integer> sunny = new TreeSet<>();
        Map<Integer, Integer> rainy = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            int v = rains[i];
            if (v > 0) {
                if (rainy.containsKey(v)) {
                    Integer t = sunny.higher(rainy.get(v));
                    if (t == null) {
                        return new int[0];
                    }
                    ans[t] = v;
                    sunny.remove(t);
                }
                rainy.put(v, i);
            } else {
                sunny.add(i);
                ans[i] = 1;
            }
        }
        return ans;
    }
}
```
