# 2659. Make Array Empty

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/make-array-empty/

---

[中文文档](/solution/2600-2699/2659.Make%20Array%20Empty/README.md)

## Description

<p>You are given an integer array <code>nums</code> containing <strong>distinct</strong> numbers, and you can perform the following operations <strong>until the array is empty</strong>:</p>

<ul>
	<li>If the first element has the <strong>smallest</strong> value, remove it</li>
	<li>Otherwise, put the first element at the <strong>end</strong> of the array.</li>
</ul>

<p>Return <em>an integer denoting the number of operations it takes to make </em><code>nums</code><em> empty.</em></p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [3,4,-1]
<strong>Output:</strong> 5
</pre>

<table style="border: 2px solid black; border-collapse: collapse;">
	<thead>
		<tr>
			<th style="border: 2px solid black; padding: 5px;">Operation</th>
			<th style="border: 2px solid black; padding: 5px;">Array</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">1</td>
			<td style="border: 2px solid black; padding: 5px;">[4, -1, 3]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">2</td>
			<td style="border: 2px solid black; padding: 5px;">[-1, 3, 4]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">3</td>
			<td style="border: 2px solid black; padding: 5px;">[3, 4]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">4</td>
			<td style="border: 2px solid black; padding: 5px;">[4]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">5</td>
			<td style="border: 2px solid black; padding: 5px;">[]</td>
		</tr>
	</tbody>
</table>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,4,3]
<strong>Output:</strong> 5
</pre>

<table style="border: 2px solid black; border-collapse: collapse;">
	<thead>
		<tr>
			<th style="border: 2px solid black; padding: 5px;">Operation</th>
			<th style="border: 2px solid black; padding: 5px;">Array</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">1</td>
			<td style="border: 2px solid black; padding: 5px;">[2, 4, 3]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">2</td>
			<td style="border: 2px solid black; padding: 5px;">[4, 3]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">3</td>
			<td style="border: 2px solid black; padding: 5px;">[3, 4]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">4</td>
			<td style="border: 2px solid black; padding: 5px;">[4]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">5</td>
			<td style="border: 2px solid black; padding: 5px;">[]</td>
		</tr>
	</tbody>
</table>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 3
</pre>

<table style="border: 2px solid black; border-collapse: collapse;">
	<thead>
		<tr>
			<th style="border: 2px solid black; padding: 5px;">Operation</th>
			<th style="border: 2px solid black; padding: 5px;">Array</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">1</td>
			<td style="border: 2px solid black; padding: 5px;">[2, 3]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">2</td>
			<td style="border: 2px solid black; padding: 5px;">[3]</td>
		</tr>
		<tr>
			<td style="border: 2px solid black; padding: 5px;">3</td>
			<td style="border: 2px solid black; padding: 5px;">[]</td>
		</tr>
	</tbody>
</table>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9&nbsp;</sup>&lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>All values in <code>nums</code> are <strong>distinct</strong>.</li>
</ul>

## Solutions

### Solution 1: Hash Table + Sorting + Fenwick Tree

> **Thinking**
>
> Each step rotates left or deletes the current minimum. Simulating rotations fails for $n \le 10^5$. Deletions follow sorted order; the cost is the circular gap between consecutive minima minus already-deleted indices in between.
>
> Store original positions, sort the values, and keep deleted indices in an ordered list. The gap $j-i$ drops the deleted count between them; if $j$ wraps before $i$, add the remaining length of this round.

First, we use a hash table $\textit{pos}$ to record the position of each element in array $\textit{nums}$. Then, we sort array $\textit{nums}$. The initial answer is the position of the minimum element in array $\textit{nums}$ plus 1, which is $\textit{ans} = \textit{pos}[\textit{nums}[0]] + 1$.

Next, we traverse the sorted array $\textit{nums}$, the indexes of the two adjacent elements $a$ and $b$ are $i = \textit{pos}[a]$, $j = \textit{pos}[b]$. The number of operations needed to move the second element $b$ to the first position of the array and delete it is equal to the interval between the two indexes, minus the number of indexes deleted between the two indexes, and add the number of operations to the answer. We can use a Fenwick tree or an ordered list to maintain the deleted indexes between two indexes, so that we can find the number of deleted indexes between two indexes in $O(\log n)$ time. Note that if $i \gt j$, then we need to increase $n - k$ operations, where $k$ is the current position.

After the traversal is over, return the number of operations $\textit{ans}$.

The time complexity is $O(n \log n)$, and the space complexity is $O(n)$, where $n$ is the length of array $\textit{nums}$.

#### Java

```java
class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += x & -x;
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= x & -x;
        }
        return s;
    }
}

class Solution {
    public long countOperationsToEmptyArray(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            pos.put(nums[i], i);
        }
        Arrays.sort(nums);
        long ans = pos.get(nums[0]) + 1;
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int k = 0; k < n - 1; ++k) {
            int i = pos.get(nums[k]), j = pos.get(nums[k + 1]);
            long d = j - i - (tree.query(j + 1) - tree.query(i + 1));
            ans += d + (n - k) * (i > j ? 1 : 0);
            tree.update(i + 1, 1);
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 queries deleted counts in an ordered set. A Fenwick tree offers the same prefix counts: after shifting indices by one, `query(j+1)-query(i+1)` is the deleted amount, and an update is a point add. The wrap-around logic is unchanged.
