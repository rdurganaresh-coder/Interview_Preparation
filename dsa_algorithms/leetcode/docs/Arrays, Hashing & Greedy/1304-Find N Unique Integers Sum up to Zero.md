# 1304. Find N Unique Integers Sum up to Zero

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/

---

[中文文档](/solution/1300-1399/1304.Find%20N%20Unique%20Integers%20Sum%20up%20to%20Zero/README.md)

## Description

<p>Given an integer <code>n</code>, return <strong>any</strong> array containing <code>n</code> <strong>unique</strong> integers such that they add up to <code>0</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 5
<strong>Output:</strong> [-7,-1,1,3,4]
<strong>Explanation:</strong> These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 3
<strong>Output:</strong> [-1,0,1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> n = 1
<strong>Output:</strong> [0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n &lt;= 1000</code></li>
</ul>

## Solutions

### Solution 1: Construction

> **Thinking**
>
> We need $n$ distinct integers that sum to $0$. Picking numbers at random and then adjusting them easily breaks uniqueness. A pair of opposite numbers already sums to $0$, so we emit $1,-1,\ldots,k,-k$. When $n$ is odd we append $0$, which preserves both the sum and distinctness.

We can start from $1$ and alternately add positive and negative numbers to the result array. We repeat this process $\frac{n}{2}$ times. If $n$ is odd, we add $0$ to the result array at the end.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the given integer.

#### Java

```java
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 1, j = 0; i <= n / 2; ++i) {
            ans[j++] = i;
            ans[j++] = -i;
        }
        return ans;
    }
}
```

### Solution 2: Construction + Mathematics

> **Thinking**
>
> Pairing must treat odd and even $n$ separately. Placing $1$ through $n-1$ and appending the negation of their sum forces the total to $0$, and that last value cannot equal any of those positive integers. The construction is shorter and still distinct.

We can also add all integers from $1$ to $n-1$ to the result array, and finally add the opposite of the sum of the first $n-1$ integers, which is $-\frac{n(n-1)}{2}$, to the result array.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the given integer.

#### Java

```java
class Solution {
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 1; i < n; ++i) {
            ans[i] = i;
        }
        ans[0] = -(n * (n - 1) / 2);
        return ans;
    }
}
```
