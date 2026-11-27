# 2550. Count Collisions of Monkeys on a Polygon

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-collisions-of-monkeys-on-a-polygon/

---

[中文文档](/solution/2500-2599/2550.Count%20Collisions%20of%20Monkeys%20on%20a%20Polygon/README.md)

## Description

<p>There is a regular convex polygon with <code>n</code> vertices. The vertices are labeled from <code>0</code> to <code>n - 1</code> in a clockwise direction, and each vertex has <strong>exactly one monkey</strong>. The following figure shows a convex polygon of <code>6</code> vertices.</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/2500-2599/2550.Count%20Collisions%20of%20Monkeys%20on%20a%20Polygon/images/hexagon.jpg" style="width: 300px; height: 293px;" />
<p>Simultaneously, each monkey moves to a neighboring vertex. A <strong>collision</strong> happens if at least two monkeys reside on the same vertex after the movement or intersect on an edge.</p>

<p>Return the number of ways the monkeys can move so that at least <strong>one collision</strong> happens. Since the answer may be very large, return it modulo <code>10<sup>9 </sup>+ 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">6</span></p>

<p><strong>Explanation:</strong></p>

<p>There are 8 total possible movements.<br />
Two ways such that they collide at some point are:</p>

<ul>
	<li>Monkey 1 moves in a clockwise direction; monkey 2 moves in an anticlockwise direction; monkey 3 moves in a clockwise direction. Monkeys 1 and 2 collide.</li>
	<li>Monkey 1 moves in an anticlockwise direction; monkey 2 moves in an anticlockwise direction; monkey 3 moves in a clockwise direction. Monkeys 1 and 3 collide.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4</span></p>

<p><strong>Output:</strong> <span class="example-io">14</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= n &lt;= 10<sup>9</sup></code></li>
</ul>

## Solutions

### Solution 1: Mathematics (Fast Power)

> **Thinking**
>
> Monkeys on a regular $n$-gon each step clockwise or counterclockwise; we count walks that collide. There are $2^n$ assignments, and only the two unanimous directions are collision-free.
>
> $n$ reaches $10^9$, so enumerate nothing. Modular exponentiation gives $2^n$, then subtract $2$ with a borrow-safe modulo.

According to the problem description, each monkey has two ways of moving, either clockwise or counterclockwise. Therefore, there are a total of $2^n$ ways to move. The non-collision ways of moving are only two, that is, all monkeys move clockwise or all monkeys move counterclockwise. Therefore, the number of collision ways of moving is $2^n - 2$.

We can use fast power to calculate the value of $2^n$, then use $2^n - 2$ to calculate the number of collision ways of moving, and finally take the remainder of $10^9 + 7$.

The time complexity is $O(\log n)$, and the space complexity is $O(1)$, where $n$ is the number of monkeys.

#### Java

```java
class Solution {
    public int monkeyMove(int n) {
        final int mod = (int) 1e9 + 7;
        return (qpow(2, n, mod) - 2 + mod) % mod;
    }

    private int qpow(long a, int n, int mod) {
        long ans = 1;
        for (; n > 0; n >>= 1) {
            if ((n & 1) == 1) {
                ans = ans * a % mod;
            }
            a = a * a % mod;
        }
        return (int) ans;
    }
}
```
