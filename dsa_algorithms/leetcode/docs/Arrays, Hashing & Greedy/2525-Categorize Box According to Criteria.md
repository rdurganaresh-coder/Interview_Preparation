# 2525. Categorize Box According to Criteria

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/categorize-box-according-to-criteria/

---

[中文文档](/solution/2500-2599/2525.Categorize%20Box%20According%20to%20Criteria/README.md)

## Description

<p>Given four integers <code>length</code>, <code>width</code>, <code>height</code>, and <code>mass</code>, representing the dimensions and mass of a box, respectively, return <em>a string representing the <strong>category</strong> of the box</em>.</p>

<ul>
	<li>The box is <code>&quot;Bulky&quot;</code> if:
    <ul>
    	<li><strong>Any</strong> of the dimensions of the box is greater or equal to <code>10<sup>4</sup></code>.</li>
    	<li>Or, the <strong>volume</strong> of the box is greater or equal to <code>10<sup>9</sup></code>.</li>
    </ul>
    </li>
    <li>If the mass of the box is greater or equal to <code>100</code>, it is <code>&quot;Heavy&quot;.</code></li>
    <li>If the box is both <code>&quot;Bulky&quot;</code> and <code>&quot;Heavy&quot;</code>, then its category is <code>&quot;Both&quot;</code>.</li>
    <li>If the box is neither <code>&quot;Bulky&quot;</code> nor <code>&quot;Heavy&quot;</code>, then its category is <code>&quot;Neither&quot;</code>.</li>
    <li>If the box is <code>&quot;Bulky&quot;</code> but not <code>&quot;Heavy&quot;</code>, then its category is <code>&quot;Bulky&quot;</code>.</li>
    <li>If the box is <code>&quot;Heavy&quot;</code> but not <code>&quot;Bulky&quot;</code>, then its category is <code>&quot;Heavy&quot;</code>.</li>

</ul>

<p><strong>Note</strong> that the volume of the box is the product of its length, width and height.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> length = 1000, width = 35, height = 700, mass = 300
<strong>Output:</strong> &quot;Heavy&quot;
<strong>Explanation:</strong> 
None of the dimensions of the box is greater or equal to 10<sup>4</sup>. 
Its volume = 24500000 &lt;= 10<sup>9</sup>. So it cannot be categorized as &quot;Bulky&quot;.
However mass &gt;= 100, so the box is &quot;Heavy&quot;.
Since the box is not &quot;Bulky&quot; but &quot;Heavy&quot;, we return &quot;Heavy&quot;.</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> length = 200, width = 50, height = 800, mass = 50
<strong>Output:</strong> &quot;Neither&quot;
<strong>Explanation:</strong> 
None of the dimensions of the box is greater or equal to 10<sup>4</sup>.
Its volume = 8 * 10<sup>6</sup> &lt;= 10<sup>9</sup>. So it cannot be categorized as &quot;Bulky&quot;.
Its mass is also less than 100, so it cannot be categorized as &quot;Heavy&quot; either. 
Since its neither of the two above categories, we return &quot;Neither&quot;.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= length, width, height &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= mass &lt;= 10<sup>3</sup></code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> A box is classified by whether any dimension or the volume is bulky and whether the mass is heavy — four labels in all. Each test is a constant-time comparison.
>
> Store $\textit{bulky}$ and $\textit{heavy}$ as $0/1$ and index $[\textit{Neither},\textit{Bulky},\textit{Heavy},\textit{Both}]$ by $\textit{heavy}\ll 1\mid \textit{bulky}$, avoiding nested branches.

We can simulate according to the problem description.

The time complexity is $O(1)$, and the space complexity is $O(1)$.

#### Java

```java
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        int bulky = length >= 10000 || width >= 10000 || height >= 10000 || v >= 1000000000 ? 1 : 0;
        int heavy = mass >= 100 ? 1 : 0;
        String[] d = {"Neither", "Bulky", "Heavy", "Both"};
        int i = heavy << 1 | bulky;
        return d[i];
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 packs the two flags into an index. The same four cases can be written as sequential predicates — both, bulky only, heavy only, neither — with identical results.

#### Java

```java
class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        long v = (long) length * width * height;
        boolean bulky = length >= 1e4 || width >= 1e4 || height >= 1e4 || v >= 1e9;
        boolean heavy = mass >= 100;

        if (bulky && heavy) {
            return "Both";
        }
        if (bulky) {
            return "Bulky";
        }
        if (heavy) {
            return "Heavy";
        }

        return "Neither";
    }
}
```
