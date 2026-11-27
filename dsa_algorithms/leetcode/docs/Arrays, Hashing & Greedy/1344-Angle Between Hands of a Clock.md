# 1344. Angle Between Hands of a Clock

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/angle-between-hands-of-a-clock/

---

[中文文档](/solution/1300-1399/1344.Angle%20Between%20Hands%20of%20a%20Clock/README.md)

## Description

<p>Given two numbers, <code>hour</code> and <code>minutes</code>, return <em>the smaller angle (in degrees) formed between the </em><code>hour</code><em> and the </em><code>minute</code><em> hand</em>.</p>

<p>Answers within <code>10<sup>-5</sup></code> of the actual value will be accepted as correct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1344.Angle%20Between%20Hands%20of%20a%20Clock/images/sample_1_1673.png" style="width: 300px; height: 296px;" />
<pre>
<strong>Input:</strong> hour = 12, minutes = 30
<strong>Output:</strong> 165
</pre>

<p><strong class="example">Example 2:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1344.Angle%20Between%20Hands%20of%20a%20Clock/images/sample_2_1673.png" style="width: 300px; height: 301px;" />
<pre>
<strong>Input:</strong> hour = 3, minutes = 30
<strong>Output:</strong> 75
</pre>

<p><strong class="example">Example 3:</strong></p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/1300-1399/1344.Angle%20Between%20Hands%20of%20a%20Clock/images/sample_3_1673.png" style="width: 300px; height: 301px;" />
<pre>
<strong>Input:</strong> hour = 3, minutes = 15
<strong>Output:</strong> 7.5
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= hour &lt;= 12</code></li>
	<li><code>0 &lt;= minutes &lt;= 59</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The smaller angle between the hour and minute hands. The hour hand moves $30^\circ$ per hour and an extra $0.5^\circ$ per minute; the minute hand moves $6^\circ$ per minute. The answer is the minimum of the absolute difference and $360^\circ$ minus that difference.

#### Java

```java
class Solution {
    public double angleClock(int hour, int minutes) {
        double h = 30 * hour + 0.5 * minutes;
        double m = 6 * minutes;
        double diff = Math.abs(h - m);
        return Math.min(diff, 360 - diff);
    }
}
```
