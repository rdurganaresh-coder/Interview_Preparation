# 3289. The Two Sneaky Numbers of Digitville

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/

---

[中文文档](/solution/3200-3299/3289.The%20Two%20Sneaky%20Numbers%20of%20Digitville/README.md)

## Description

<p>In the town of Digitville, there was a list of numbers called <code>nums</code> containing integers from <code>0</code> to <code>n - 1</code>. Each number was supposed to appear <strong>exactly once</strong> in the list, however, <strong>two</strong> mischievous numbers sneaked in an <em>additional time</em>, making the list longer than usual.</p>

<p>As the town detective, your task is to find these two sneaky numbers. Return an array of size <strong>two</strong> containing the two numbers (in <em>any order</em>), so peace can return to Digitville.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [0,1,1,0]</span></p>

<p><strong>Output:</strong> <span class="example-io">[0,1]</span></p>

<p><strong>Explanation:</strong></p>

<p>The numbers 0 and 1 each appear twice in the array.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [0,3,2,1,3,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">[2,3]</span></p>

<p><strong>Explanation: </strong></p>

<p>The numbers 2 and 3 each appear twice in the array.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [7,1,5,4,3,4,6,0,9,5,8,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,5]</span></p>

<p><strong>Explanation: </strong></p>

<p>The numbers 4 and 5 each appear twice in the array.</p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li data-stringify-border="0" data-stringify-indent="1"><code>2 &lt;= n &lt;= 100</code></li>
	<li data-stringify-border="0" data-stringify-indent="1"><code>nums.length == n + 2</code></li>
	<li data-stringify-border="0" data-stringify-indent="1"><code data-stringify-type="code">0 &lt;= nums[i] &lt; n</code></li>
	<li data-stringify-border="0" data-stringify-indent="1">The input is generated such that <code>nums</code> contains <strong>exactly</strong> two repeated elements.</li>
</ul>

## Solutions

### Solution 1: Counting

> **Thinking**
>
> The array holds $0\ldots n-1$ once each, plus two extra repeats. $n\le 100$, so a count of frequencies equal to $2$ is enough.
>
> A map or a length-$n$ array records occurrences; the two values with count $2$ are the answer.

We can use an array $\textit{cnt}$ to record the number of occurrences of each number.

Traverse the array $\textit{nums}$, and when a number appears for the second time, add it to the answer array.

After the traversal, return the answer array.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int[] ans = new int[2];
        int[] cnt = new int[100];
        int k = 0;
        for (int x : nums) {
            if (++cnt[x] == 2) {
                ans[k++] = x;
            }
        }
        return ans;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> Solution 1 uses linear extra space. The XOR of the two repeats is the XOR of the array with $0\ldots n-1$. The highest bit where they differ splits every number into two groups; XOR inside each group isolates one answer in $O(1)$ extra space.

Let the length of array $\textit{nums}$ be $n + 2$, which contains integers from $0$ to $n - 1$, with two numbers appearing twice.

We can find these two numbers using XOR operations. First, we perform XOR operations on all numbers in array $\textit{nums}$ and the integers from $0$ to $n - 1$. The result is the XOR value of the two duplicate numbers, denoted as $xx$.

Next, we can find certain characteristics of these two numbers through $xx$ and separate them. The specific steps are as follows:

1. Find the position of the lowest bit or highest bit with value $1$ in the binary representation of $xx$, denoted as $k$. This position indicates that the two numbers differ at this bit.
2. Based on the value of the $k$-th bit, divide the numbers in array $\textit{nums}$ and the integers from $0$ to $n - 1$ into two groups: one group with $0$ at the $k$-th bit, and another group with $1$ at the $k$-th bit. Then perform XOR operations on these two groups separately, and the results are the two duplicate numbers.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n = nums.length - 2;
        int xx = nums[n] ^ nums[n + 1];
        for (int i = 0; i < n; ++i) {
            xx ^= i ^ nums[i];
        }
        int k = Integer.numberOfTrailingZeros(xx);
        int[] ans = new int[2];
        for (int x : nums) {
            ans[x >> k & 1] ^= x;
        }
        for (int i = 0; i < n; ++i) {
            ans[i >> k & 1] ^= i;
        }
        return ans;
    }
}
```
