# 3179. Find the N-th Value After K Seconds

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-the-n-th-value-after-k-seconds/

---

[中文文档](/solution/3100-3199/3179.Find%20the%20N-th%20Value%20After%20K%20Seconds/README.md)

## Description

<p>You are given two integers <code>n</code> and <code>k</code>.</p>

<p>Initially, you start with an array <code>a</code> of <code>n</code> integers where <code>a[i] = 1</code> for all <code>0 &lt;= i &lt;= n - 1</code>. After each second, you simultaneously update each element to be the sum of all its preceding elements plus the element itself. For example, after one second, <code>a[0]</code> remains the same, <code>a[1]</code> becomes <code>a[0] + a[1]</code>, <code>a[2]</code> becomes <code>a[0] + a[1] + a[2]</code>, and so on.</p>

<p>Return the <strong>value</strong> of <code>a[n - 1]</code> after <code>k</code> seconds.</p>

<p>Since the answer may be very large, return it <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 4, k = 5</span></p>

<p><strong>Output:</strong> <span class="example-io">56</span></p>

<p><strong>Explanation:</strong></p>

<table border="1">
	<tbody>
		<tr>
			<th>Second</th>
			<th>State After</th>
		</tr>
		<tr>
			<td>0</td>
			<td>[1,1,1,1]</td>
		</tr>
		<tr>
			<td>1</td>
			<td>[1,2,3,4]</td>
		</tr>
		<tr>
			<td>2</td>
			<td>[1,3,6,10]</td>
		</tr>
		<tr>
			<td>3</td>
			<td>[1,4,10,20]</td>
		</tr>
		<tr>
			<td>4</td>
			<td>[1,5,15,35]</td>
		</tr>
		<tr>
			<td>5</td>
			<td>[1,6,21,56]</td>
		</tr>
	</tbody>
</table>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">n = 5, k = 3</span></p>

<p><strong>Output:</strong> <span class="example-io">35</span></p>

<p><strong>Explanation:</strong></p>

<table border="1">
	<tbody>
		<tr>
			<th>Second</th>
			<th>State After</th>
		</tr>
		<tr>
			<td>0</td>
			<td>[1,1,1,1,1]</td>
		</tr>
		<tr>
			<td>1</td>
			<td>[1,2,3,4,5]</td>
		</tr>
		<tr>
			<td>2</td>
			<td>[1,3,6,10,15]</td>
		</tr>
		<tr>
			<td>3</td>
			<td>[1,4,10,20,35]</td>
		</tr>
	</tbody>
</table>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n, k &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Each second every entry becomes a prefix sum. The closed form is $\binom{n+k-1}{n-1}$, but $n,k\le 1000$ makes a direct simulation simpler under a modulus.
>
> The array length stays $n$, so prefix sums can be written in place from the left.
>
> Start from all ones, repeat $a[i]+=a[i-1]$ modulo $10^9+7$ for $k$ seconds, and return $a[n-1]$.

We notice that the range of the integer $n$ is $1 \leq n \leq 1000$, so we can directly simulate this process.

We define an array $a$ of length $n$ and initialize all elements to $1$. Then we simulate the process for $k$ seconds, updating the elements of array $a$ every second until $k$ seconds have passed.

Finally, we return $a[n - 1]$.

The time complexity is $O(nk)$, and the space complexity is $O(n)$, where $n$ is the length of the array $a$.

#### Java

```java
class Solution {
    public int valueAfterKSeconds(int n, int k) {
        final int mod = (int) 1e9 + 7;
        int[] a = new int[n];
        Arrays.fill(a, 1);
        while (k-- > 0) {
            for (int i = 1; i < n; ++i) {
                a[i] = (a[i] + a[i - 1]) % mod;
            }
        }
        return a[n - 1];
    }
}
```
