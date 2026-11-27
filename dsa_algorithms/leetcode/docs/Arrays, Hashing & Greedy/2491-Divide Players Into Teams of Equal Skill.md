# 2491. Divide Players Into Teams of Equal Skill

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/

---

[中文文档](/solution/2400-2499/2491.Divide%20Players%20Into%20Teams%20of%20Equal%20Skill/README.md)

## Description

<p>You are given a positive integer array <code>skill</code> of <strong>even</strong> length <code>n</code> where <code>skill[i]</code> denotes the skill of the <code>i<sup>th</sup></code> player. Divide the players into <code>n / 2</code> teams of size <code>2</code> such that the total skill of each team is <strong>equal</strong>.</p>

<p>The <strong>chemistry</strong> of a team is equal to the <strong>product</strong> of the skills of the players on that team.</p>

<p>Return <em>the sum of the <strong>chemistry</strong> of all the teams, or return </em><code>-1</code><em> if there is no way to divide the players into teams such that the total skill of each team is equal.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> skill = [3,2,5,1,3,4]
<strong>Output:</strong> 22
<strong>Explanation:</strong> 
Divide the players into the following teams: (1, 5), (2, 4), (3, 3), where each team has a total skill of 6.
The sum of the chemistry of all the teams is: 1 * 5 + 2 * 4 + 3 * 3 = 5 + 8 + 9 = 22.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> skill = [3,4]
<strong>Output:</strong> 12
<strong>Explanation:</strong> 
The two players form a team with a total skill of 7.
The chemistry of the team is 3 * 4 = 12.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> skill = [1,1,2,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong> 
There is no way to divide the players into teams such that the total skill of each team is equal.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= skill.length &lt;= 10<sup>5</sup></code></li>
	<li><code>skill.length</code> is even.</li>
	<li><code>1 &lt;= skill[i] &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Sorting

> **Thinking**
>
> Every pair must share the same skill sum, which can only be global min plus max. At $n\le 10^5$, sort and pair ends; a mismatched sum fails, otherwise add products.

To make all 2-person teams have equal skill points, the minimum value must match the maximum value. Therefore, we sort the `skill` array, and then use two pointers $i$ and $j$ to point to the beginning and end of the array respectively, match them in pairs, and judge whether their sum is the same number.

If not, it means that the skill points cannot be equal, and we directly return $-1$. Otherwise, we add the chemical reaction to the answer.

At the end of the traversal, we return the answer.

The time complexity is $O(n \log n)$, and the space complexity is $O(\log n)$, where $n$ is the length of the $\textit{skill}$ array.

#### Java

```java
class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int t = skill[0] + skill[n - 1];
        long ans = 0;
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            if (skill[i] + skill[j] != t) {
                return -1;
            }
            ans += (long) skill[i] * skill[j];
        }
        return ans;
    }
}
```

### Solution 2: Counting

> **Thinking**
>
> Method 1 sorts. If the total skill is not divisible by the number of teams, it is impossible; the pair sum is $t=s/m$. Hash $v$ against $t-v$ in linear time.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the $\textit{skill}$ array.

#### Java

```java
class Solution {
    public long dividePlayers(int[] skill) {
        int s = Arrays.stream(skill).sum();
        int m = skill.length >> 1;
        if (s % m != 0) {
            return -1;
        }
        int t = s / m;
        int[] d = new int[1010];
        long ans = 0;
        for (int v : skill) {
            if (d[t - v] > 0) {
                ans += (long) v * (t - v);
                --d[t - v];
                --m;
            } else {
                ++d[v];
            }
        }
        return m == 0 ? ans : -1;
    }
}
```
