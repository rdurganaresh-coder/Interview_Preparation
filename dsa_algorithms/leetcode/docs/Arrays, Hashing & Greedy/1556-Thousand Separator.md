# 1556. Thousand Separator

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/thousand-separator/

---

[中文文档](/solution/1500-1599/1556.Thousand%20Separator/README.md)

## Description

<p>Given an integer <code>n</code>, add a dot (&quot;.&quot;) as the thousands separator and return it in string format.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> n = 987
<strong>Output:</strong> &quot;987&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> n = 1234
<strong>Output:</strong> &quot;1.234&quot;
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= n &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Insert a dot every three digits from the right. Converting to a string first requires extra care when the length is a multiple of three; peeling remainders from the low end is simpler.
>
> Repeatedly take $n\bmod 10$ and count digits; after every third digit, if a higher place remains, append a dot. Reverse the collected characters at the end. The loop runs once per digit, $O(\log n)$.

#### Java

```java
class Solution {
    public String thousandSeparator(int n) {
        int cnt = 0;
        StringBuilder ans = new StringBuilder();
        while (true) {
            int v = n % 10;
            n /= 10;
            ans.append(v);
            ++cnt;
            if (n == 0) {
                break;
            }
            if (cnt == 3) {
                ans.append('.');
                cnt = 0;
            }
        }
        return ans.reverse().toString();
    }
}
```
