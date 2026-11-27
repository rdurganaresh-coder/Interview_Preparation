# 3267. Count Almost Equal Pairs II

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/count-almost-equal-pairs-ii/

---

[中文文档](/solution/3200-3299/3267.Count%20Almost%20Equal%20Pairs%20II/README.md)

## Description

<p><strong>Attention</strong>: In this version, the number of operations that can be performed, has been increased to <strong>twice</strong>.</p>

<p>You are given an array <code>nums</code> consisting of positive integers.</p>

<p>We call two integers <code>x</code> and <code>y</code> <strong>almost equal</strong> if both integers can become equal after performing the following operation <strong>at most <u>twice</u></strong>:</p>

<ul>
	<li>Choose <strong>either</strong> <code>x</code> or <code>y</code> and swap any two digits within the chosen number.</li>
</ul>

<p>Return the number of indices <code>i</code> and <code>j</code> in <code>nums</code> where <code>i &lt; j</code> such that <code>nums[i]</code> and <code>nums[j]</code> are <strong>almost equal</strong>.</p>

<p><strong>Note</strong> that it is allowed for an integer to have leading zeros after performing an operation.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1023,2310,2130,213]</span></p>

<p><strong>Output:</strong> <span class="example-io">4</span></p>

<p><strong>Explanation:</strong></p>

<p>The almost equal pairs of elements are:</p>

<ul>
	<li>1023 and 2310. By swapping the digits 1 and 2, and then the digits 0 and 3 in 1023, you get 2310.</li>
	<li>1023 and 213. By swapping the digits 1 and 0, and then the digits 1 and 2 in 1023, you get 0213, which is 213.</li>
	<li>2310 and 213. By swapping the digits 2 and 0, and then the digits 3 and 2 in 2310, you get 0213, which is 213.</li>
	<li>2310 and 2130. By swapping the digits 3 and 1 in 2310, you get 2130.</li>
</ul>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,10,100]</span></p>

<p><strong>Output:</strong> <span class="example-io">3</span></p>

<p><strong>Explanation:</strong></p>

<p>The almost equal pairs of elements are:</p>

<ul>
	<li>1 and 10. By swapping the digits 1 and 0 in 10, you get 01 which is 1.</li>
	<li>1 and 100. By swapping the second 0 with the digit 1 in 100, you get 001, which is 1.</li>
	<li>10 and 100. By swapping the first 0 with the digit 1 in 100, you get 010, which is 10.</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 5000</code></li>
	<li><code>1 &lt;= nums[i] &lt; 10<sup>7</sup></code></li>
</ul>

## Solutions

### Solution 1: Sorting + Enumeration

> **Thinking**
>
> Unlike I we may swap twice, and $n\le 5000$. We still sort so that swapping a larger number down is not missed. The two-swap closure is $O(\log^4 M)$ per value, which times $n$ fits.
>
> Swap once, then swap a second pair on the remaining digits, put every result in a set, and query earlier counts. The inner enumeration must not forget to restore.

We can enumerate each number, and for each number, we can enumerate each pair of different digits, then swap these two digits to get a new number. Record this new number in a hash table $\textit{vis}$, representing all possible numbers after at most one swap. Then continue to enumerate each pair of different digits, swap these two digits to get a new number, and record it in the hash table $\textit{vis}$, representing all possible numbers after at most two swaps.

This enumeration may miss some pairs of numbers, such as $[100, 1]$, because the number obtained after swapping $100$ is $1$, and the previously enumerated numbers do not include $1$, so some pairs of numbers will be missed. We only need to sort the array before enumeration to solve this problem.

The time complexity is $O(n(\log n + \log^5 M))$, and the space complexity is $O(n + \log^4 M)$, where $n$ is the length of the array $\textit{nums}$, and $M$ is the maximum value in the array $\textit{nums}$.

#### Java

```java
class Solution {
    public int countPairs(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : nums) {
            Set<Integer> vis = new HashSet<>();
            vis.add(x);
            char[] s = String.valueOf(x).toCharArray();
            for (int j = 0; j < s.length; ++j) {
                for (int i = 0; i < j; ++i) {
                    swap(s, i, j);
                    vis.add(Integer.parseInt(String.valueOf(s)));
                    for (int q = i; q < s.length; ++q) {
                        for (int p = i; p < q; ++p) {
                            swap(s, p, q);
                            vis.add(Integer.parseInt(String.valueOf(s)));
                            swap(s, p, q);
                        }
                    }
                    swap(s, i, j);
                }
            }
            for (int y : vis) {
                ans += cnt.getOrDefault(y, 0);
            }
            cnt.merge(x, 1, Integer::sum);
        }
        return ans;
    }

    private void swap(char[] s, int i, int j) {
        char t = s[i];
        s[i] = s[j];
        s[j] = t;
    }
}
```
