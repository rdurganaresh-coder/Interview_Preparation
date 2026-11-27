# 1796. Second Largest Digit in a String

**Difficulty:** Easy  
**Category:** Bit Manipulation & Math  
**LeetCode:** https://leetcode.com/problems/second-largest-digit-in-a-string/

---

[中文文档](/solution/1700-1799/1796.Second%20Largest%20Digit%20in%20a%20String/README.md)

## Description

<p>Given an alphanumeric string <code>s</code>, return <em>the <strong>second largest</strong> numerical digit that appears in </em><code>s</code><em>, or </em><code>-1</code><em> if it does not exist</em>.</p>

<p>An <strong>alphanumeric</strong><strong> </strong>string is a string consisting of lowercase English letters and digits.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;dfa12321afd&quot;
<strong>Output:</strong> 2
<strong>Explanation:</strong> The digits that appear in s are [1, 2, 3]. The second largest digit is 2.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;abc1111&quot;
<strong>Output:</strong> -1
<strong>Explanation:</strong> The digits that appear in s are [1]. There is no second largest digit. 
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 500</code></li>
	<li><code>s</code> consists of only lowercase English letters and digits.</li>
</ul>

## Solutions

### Solution 1: One Pass

> **Thinking**
>
> We need the strict second-largest digit, or $-1$. One scan keeping the largest $a$ and second $b$ is enough.
>
> A new maximum shifts the old maximum into second place; a value strictly between them updates only the second.

We define $a$ and $b$ to represent the largest and second largest numbers in the string, initially $a = b = -1$.

We traverse the string $s$. If the current character is a digit, we convert it to a number $v$. If $v > a$, it means that $v$ is the largest number currently appearing, we update $b$ to $a$, and update $a$ to $v$; if $v < a$, it means that $v$ is the second largest number currently appearing, we update $b$ to $v$.

After the traversal, we return $b$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int secondHighest(String s) {
        int a = -1, b = -1;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int v = c - '0';
                if (v > a) {
                    b = a;
                    a = v;
                } else if (v > b && v < a) {
                    b = v;
                }
            }
        }
        return b;
    }
}
```

### Solution 2: Bit Manipulation

> **Thinking**
>
> A 10-bit mask of seen digits also works: walk bits from high to low and return the second set bit.

We can use an integer $\textit{mask}$ to mark the numbers that appear in the string, where the $i$-th bit of $\textit{mask}$ indicates whether the number $i$ has appeared.

We traverse the string $s$. If the current character is a digit, we convert it to a number $v$, and set the $v$-th bit of $\textit{mask}$ to $1$.

Finally, we traverse $\textit{mask}$ from high to low, find the second bit that is $1$, and the corresponding number is the second largest number. If there is no second largest number, return $-1$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int secondHighest(String s) {
        int mask = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                mask |= 1 << (c - '0');
            }
        }
        for (int i = 9, cnt = 0; i >= 0; --i) {
            if (((mask >> i) & 1) == 1 && ++cnt == 2) {
                return i;
            }
        }
        return -1;
    }
}
```
