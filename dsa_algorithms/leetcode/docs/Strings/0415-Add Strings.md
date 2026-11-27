# 415. Add Strings

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/add-strings/

---

[中文文档](/solution/0400-0499/0415.Add%20Strings/README.md)

## Description

<p>Given two non-negative integers, <code>num1</code> and <code>num2</code> represented as string, return <em>the sum of</em> <code>num1</code> <em>and</em> <code>num2</code> <em>as a string</em>.</p>

<p>You must solve the problem without using any built-in library for handling large integers (such as <code>BigInteger</code>). You must also not convert the inputs to integers directly.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;11&quot;, num2 = &quot;123&quot;
<strong>Output:</strong> &quot;134&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;456&quot;, num2 = &quot;77&quot;
<strong>Output:</strong> &quot;533&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> num1 = &quot;0&quot;, num2 = &quot;0&quot;
<strong>Output:</strong> &quot;0&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= num1.length, num2.length &lt;= 10<sup>4</sup></code></li>
	<li><code>num1</code> and <code>num2</code> consist of only digits.</li>
	<li><code>num1</code> and <code>num2</code> don&#39;t have any leading zeros except for the zero itself.</li>
</ul>

## Solutions

### Solution 1: Two Pointers

> **Thinking**
>
> The addends are decimal strings and may not fit in a machine integer. Addition still starts at the least significant digit.
>
> Two pointers walk from the ends, add the digits plus carry, store the units digit, and keep the tens as the new carry. A missing digit is $0$. Reverse the buffer at the end.
>
> Low digits first propagate carry correctly; appending then reversing avoids inserts at the front.

We use two pointers $i$ and $j$ to point to the end of the two strings respectively, and start adding bit by bit from the end. Each time we take out the corresponding digits $a$ and $b$, calculate their sum $a + b + c$, where $c$ represents the carry from the last addition. Finally, we append the units digit of $a + b + c$ to the end of the answer string, and then take the tens digit of $a + b + c$ as the value of the carry $c$, and loop this process until the pointers of both strings have pointed to the beginning of the string and the value of the carry $c$ is $0$.

Finally, reverse the answer string and return it.

The time complexity is $O(\max(m, n))$, and the space complexity is $O(1)$, where $m$ and $n$ are the lengths of the two strings respectively.

The following code also implements string subtraction, refer to the `subStrings(num1, num2)` function.

#### Java

```java
class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0 || j >= 0 || c > 0; --i, --j) {
            int a = i < 0 ? 0 : num1.charAt(i) - '0';
            int b = j < 0 ? 0 : num2.charAt(j) - '0';
            c += a + b;
            ans.append(c % 10);
            c /= 10;
        }
        return ans.reverse().toString();
    }

    public String subStrings(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        boolean neg = m < n || (m == n && num1.compareTo(num2) < 0);
        if (neg) {
            String t = num1;
            num1 = num2;
            num2 = t;
        }
        int i = num1.length() - 1, j = num2.length() - 1;
        StringBuilder ans = new StringBuilder();
        for (int c = 0; i >= 0; --i, --j) {
            c = (num1.charAt(i) - '0') - c - (j < 0 ? 0 : num2.charAt(j) - '0');
            ans.append((c + 10) % 10);
            c = c < 0 ? 1 : 0;
        }
        while (ans.length() > 1 && ans.charAt(ans.length() - 1) == '0') {
            ans.deleteCharAt(ans.length() - 1);
        }
        if (neg) {
            ans.append('-');
        }
        return ans.reverse().toString();
    }
}
```
