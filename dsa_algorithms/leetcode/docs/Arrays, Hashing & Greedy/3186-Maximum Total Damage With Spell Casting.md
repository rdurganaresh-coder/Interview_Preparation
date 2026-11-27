# 3186. Maximum Total Damage With Spell Casting

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximum-total-damage-with-spell-casting/

---

[中文文档](/solution/3100-3199/3186.Maximum%20Total%20Damage%20With%20Spell%20Casting/README.md)

## Description

<p>A magician has various spells.</p>

<p>You are given an array <code>power</code>, where each element represents the damage of a spell. Multiple spells can have the same damage value.</p>

<p>It is a known fact that if a magician decides to cast a spell with a damage of <code>power[i]</code>, they <strong>cannot</strong> cast any spell with a damage of <code>power[i] - 2</code>, <code>power[i] - 1</code>, <code>power[i] + 1</code>, or <code>power[i] + 2</code>.</p>

<p>Each spell can be cast <strong>only once</strong>.</p>

<p>Return the <strong>maximum</strong> possible <em>total damage</em> that a magician can cast.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">power = [1,1,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>The maximum possible damage of 6 is produced by casting spells 0, 1, 3 with damage 1, 1, 4.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">power = [7,1,6,6]</span></p>

<p><strong>Output:</strong> <span class="example-io">13</span></p>

<p><strong>Explanation:</strong></p>

<p>The maximum possible damage of 13 is produced by casting spells 1, 2, 3 with damage 1, 6, 6.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= power.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= power[i] &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Binary Search + Memoization

> **Thinking**
>
> Taking damage $x$ forbids every other value in $[x-2,x+2]$, while equal $x$ may all be taken. Subsets of distinct damages are exponential.
>
> After sorting the choice is: skip every copy of the current value, or take them all and jump to the first value $>x+2$. That jump is a binary search.
>
> Memoize $\textit{dfs}(i)=\max(\textit{dfs}(i+\textit{cnt}[x]),\,x\cdot \textit{cnt}[x]+\textit{dfs}(\textit{nxt}[i]))$. Each distinct damage expands once.

We can first sort the array $\textit{power}$, use a hash table $\textit{cnt}$ to record the occurrence count of each damage value, and then iterate through the array $\textit{power}$. For each damage value $x$, we can determine the index of the next damage value that can be used when using a spell with damage value $x$, which is the index of the first damage value greater than $x + 2$. We can use binary search to find this index and record it in the array $\textit{nxt}$.

Next, we define a function $\textit{dfs}$ to calculate the maximum damage value that can be obtained starting from the $i$-th damage value.

In the $\textit{dfs}$ function, we can choose to skip the current damage value, so we can skip all the same damage values of the current one and directly jump to $i + \textit{cnt}[x]$, obtaining a damage value of $\textit{dfs}(i + \textit{cnt}[x])$; or we can choose to use the current damage value, so we can use all the same damage values of the current one and then jump to the index of the next damage value, obtaining a damage value of $x \times \textit{cnt}[x] + \textit{dfs}(\textit{nxt}[i])$, where $\textit{nxt}[i]$ represents the index of the first damage value greater than $x + 2$. We take the maximum of these two cases as the return value of the function.

To avoid repeated calculations, we can use memoization, storing the results that have already been calculated in an array $f$. Thus, when calculating $\textit{dfs}(i)$, if $f[i]$ is not $0$, we directly return $f[i]$.

The answer is $\textit{dfs}(0)$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{power}$.

#### Java

```java
class Solution {
    private Long[] f;
    private int[] power;
    private Map<Integer, Integer> cnt;
    private int[] nxt;
    private int n;

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        this.power = power;
        n = power.length;
        f = new Long[n];
        cnt = new HashMap<>(n);
        nxt = new int[n];
        for (int i = 0; i < n; ++i) {
            cnt.merge(power[i], 1, Integer::sum);
            int l = Arrays.binarySearch(power, power[i] + 3);
            l = l < 0 ? -l - 1 : l;
            nxt[i] = l;
        }
        return dfs(0);
    }

    private long dfs(int i) {
        if (i >= n) {
            return 0;
        }
        if (f[i] != null) {
            return f[i];
        }
        long a = dfs(i + cnt.get(power[i]));
        long b = 1L * power[i] * cnt.get(power[i]) + dfs(nxt[i]);
        return f[i] = Math.max(a, b);
    }
}
```

### Solution 2: Binary Search + Dynamic Programming

> **Thinking**
>
> Taking damage $x$ forbids every other value in $[x-2,x+2]$, while equal copies of $x$ may all be taken. $n$ can be $10^5$, so subsets of the distinct damages are exponential.
>
> After sorting, skipping the current value always calls a later index first. When the damages are distinct and adjacent, that call advances by $1$, so the chain has length $n$ and overflows the stack.
>
> Later indexes are known if we walk backward. Let $f[i]$ be the best damage from index $i$: skipping lands on $i+\textit{cnt}[x]$, and taking lands on the first value greater than $x+2$, which binary search stores ahead of time.

Sort $\textit{power}$ and record the count of each damage in a hash table $\textit{cnt}$. For every index $i$, binary search stores in $\textit{nxt}[i]$ the first position whose value is greater than $\textit{power}[i] + 2$.

Let $f[i]$ be the maximum damage obtainable from index $i$, with $f[n] = 0$. The answer is $f[0]$.

Fill $i$ from $n - 1$ down to $0$. Write $x = \textit{power}[i]$. Skipping every copy of $x$ yields $f[i + \textit{cnt}[x]]$. Taking those copies yields $x \times \textit{cnt}[x] + f[\textit{nxt}[i]]$. An index past $n$ contributes $0$. Take the larger value:

$$
f[i] = \max(f[i + \textit{cnt}[x]],\ x \times \textit{cnt}[x] + f[\textit{nxt}[i]])
$$

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{power}$.

#### Java

```java
class Solution {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        Map<Integer, Integer> cnt = new HashMap<>(n);
        int[] nxt = new int[n];
        for (int i = 0; i < n; ++i) {
            cnt.merge(power[i], 1, Integer::sum);
            int l = Arrays.binarySearch(power, power[i] + 3);
            l = l < 0 ? -l - 1 : l;
            nxt[i] = l;
        }
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int j = i + cnt.get(power[i]);
            long a = j <= n ? f[j] : 0;
            long b = 1L * power[i] * cnt.get(power[i]) + f[nxt[i]];
            f[i] = Math.max(a, b);
        }
        return f[0];
    }
}
```
