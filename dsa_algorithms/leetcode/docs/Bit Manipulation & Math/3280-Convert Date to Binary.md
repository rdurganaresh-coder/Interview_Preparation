# 3280. Convert Date to Binary

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/convert-date-to-binary/

---

[中文文档](/solution/3200-3299/3280.Convert%20Date%20to%20Binary/README.md)

## Description

<p>You are given a string <code>date</code> representing a Gregorian calendar date in the <code>yyyy-mm-dd</code> format.</p>

<p><code>date</code> can be written in its binary representation obtained by converting year, month, and day to their binary representations without any leading zeroes and writing them down in <code>year-month-day</code> format.</p>

<p>Return the <strong>binary</strong> representation of <code>date</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">date = &quot;2080-02-29&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;100000100000-10-11101&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p><span class="example-io">100000100000, 10, and 11101 are the binary representations of 2080, 02, and 29 respectively.</span></p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">date = &quot;1900-01-01&quot;</span></p>

<p><strong>Output:</strong> <span class="example-io">&quot;11101101100-1-1&quot;</span></p>

<p><strong>Explanation:</strong></p>

<p><span class="example-io">11101101100, 1, and 1 are the binary representations of 1900, 1, and 1 respectively.</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>date.length == 10</code></li>
	<li><code>date[4] == date[7] == &#39;-&#39;</code>, and all other <code>date[i]</code>&#39;s are digits.</li>
	<li>The input is generated such that <code>date</code> represents a valid Gregorian calendar date between Jan 1<sup>st</sup>, 1900 and Dec 31<sup>st</sup>, 2100 (both inclusive).</li>
</ul>

## Solutions

### Solution 1: Simulation

> **Thinking**
>
> Replace each of `yyyy-mm-dd` by its binary representation. The date is valid and fixed-width, so split on `-` and format.
>
> Convert each part to `int`, emit binary, and join with `-`. No calendar arithmetic beyond that.

We first split the string $\textit{date}$ by `-`, then convert each part to its binary representation, and finally join these three parts with `-`.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $\textit{date}$.

#### Java

```java
class Solution {
    public String convertDateToBinary(String date) {
        List<String> ans = new ArrayList<>();
        for (var s : date.split("-")) {
            int x = Integer.parseInt(s);
            ans.add(Integer.toBinaryString(x));
        }
        return String.join("-", ans);
    }
}
```
