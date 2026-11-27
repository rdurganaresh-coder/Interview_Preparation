# 645. Set Mismatch

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/set-mismatch/

---

[中文文档](/solution/0600-0699/0645.Set%20Mismatch/README.md)

## Description

<p>You have a set of integers <code>s</code>, which originally contains all the numbers from <code>1</code> to <code>n</code>. Unfortunately, due to some error, one of the numbers in <code>s</code> got duplicated to another number in the set, which results in <strong>repetition of one</strong> number and <strong>loss of another</strong> number.</p>

<p>You are given an integer array <code>nums</code> representing the data status of this set after the error.</p>

<p>Find the number that occurs twice and the number that is missing and return <em>them in the form of an array</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,2,4]
<strong>Output:</strong> [2,3]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,1]
<strong>Output:</strong> [1,2]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>1 &lt;= nums[i] &lt;= 10<sup>4</sup></code></li>
</ul>

## Solutions

### Solution 1: Mathematics

> **Thinking**
>
> One number in $[1,n]$ is duplicated and one is missing. Sums identify both at once.
>
> Let $s$ be the array sum, $s_2$ the unique-sum, $s_1$ the sum $1..n$. The duplicate is $s-s_2$ and the missing is $s_1-s_2$.

We denote $s_1$ as the sum of all numbers from $[1,..n]$, $s_2$ as the sum of the numbers in the array $\textit{nums}$ after removing duplicates, and $s$ as the sum of the numbers in the array $\textit{nums}$.

Then $s - s_2$ is the duplicate number, and $s_1 - s_2$ is the missing number.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$. Extra space is needed to store the array after de-duplication.

#### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int s1 = (1 + n) * n / 2;
        int s2 = 0;
        Set<Integer> set = new HashSet<>();
        int s = 0;
        for (int x : nums) {
            if (set.add(x)) {
                s2 += x;
            }
            s += x;
        }
        return new int[] {s - s2, s1 - s2};
    }
}
```

### Solution 2: Hash Table

> **Thinking**
>
> The sum method needs a set. A frequency map makes the duplicate ($2$) and the missing ($0$) explicit.

We can also use a more intuitive method, using a hash table $\textit{cnt}$ to count the occurrence of each number in the array $\textit{nums}$.

Next, iterate through $x \in [1, n]$, if $\textit{cnt}[x] = 2$, then $x$ is the duplicate number, if $\textit{cnt}[x] = 0$, then $x$ is the missing number.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> cnt = new HashMap<>(n);
        for (int x : nums) {
            cnt.merge(x, 1, Integer::sum);
        }
        int[] ans = new int[2];
        for (int x = 1; x <= n; ++x) {
            int t = cnt.getOrDefault(x, 0);
            if (t == 2) {
                ans[0] = x;
            } else if (t == 0) {
                ans[1] = x;
            }
        }
        return ans;
    }
}
```

### Solution 3: Bit Operation

> **Thinking**
>
> The first two methods use linear extra memory. XOR of $\textit{nums}$ and $1..n$ yields $a\oplus b$; split by the lowest set bit to recover $a$ and $b$, then see which one appears in the array.

According to the properties of the XOR operation, for integer $x$, we have $x \oplus x = 0$ and $x \oplus 0 = x$. Therefore, if we perform the XOR operation on all elements in the array $\textit{nums}$ and all numbers $i \in [1, n]$, we can eliminate the numbers that appear twice, leaving only the XOR result of the missing number and the duplicate number, i.e., $xs = a \oplus b$.

Since these two numbers are not equal, there must be at least one bit in the XOR result that is $1$. We find the lowest bit of $1$ in the XOR result through the $\textit{lowbit}$ operation, and then divide all numbers in the array $\textit{nums}$ and all numbers $i \in [1, n]$ into two groups according to whether this bit is $1$. In this way, the two numbers are divided into different groups. The XOR result of one group of numbers is $a$, and the XOR result of the other group is $b$. These two numbers are the answers we are looking for.

Next, we only need to determine which of $a$ and $b$ is the duplicate number and which is the missing number. Therefore, iterate through the array $\textit{nums}$, for the traversed number $x$, if $x=a$, then $a$ is the duplicate number, return $[a, b]$, otherwise, at the end of the iteration, return $[b, a]$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int xs = 0;
        for (int i = 1; i <= n; ++i) {
            xs ^= i ^ nums[i - 1];
        }
        int lb = xs & -xs;
        int a = 0;
        for (int i = 1; i <= n; ++i) {
            if ((i & lb) > 0) {
                a ^= i;
            }
            if ((nums[i - 1] & lb) > 0) {
                a ^= nums[i - 1];
            }
        }
        int b = xs ^ a;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == a) {
                return new int[] {a, b};
            }
        }
        return new int[] {b, a};
    }
}
```
