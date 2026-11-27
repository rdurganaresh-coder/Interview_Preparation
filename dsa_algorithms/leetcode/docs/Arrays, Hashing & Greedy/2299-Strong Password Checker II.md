# 2299. Strong Password Checker II

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/strong-password-checker-ii/

---

[中文文档](/solution/2200-2299/2299.Strong%20Password%20Checker%20II/README.md)

## Description

<p>A password is said to be <strong>strong</strong> if it satisfies all the following criteria:</p>

<ul>
	<li>It has at least <code>8</code> characters.</li>
	<li>It contains at least <strong>one lowercase</strong> letter.</li>
	<li>It contains at least <strong>one uppercase</strong> letter.</li>
	<li>It contains at least <strong>one digit</strong>.</li>
	<li>It contains at least <strong>one special character</strong>. The special characters are the characters in the following string: <code>&quot;!@#$%^&amp;*()-+&quot;</code>.</li>
	<li>It does <strong>not</strong> contain <code>2</code> of the same character in adjacent positions (i.e., <code>&quot;aab&quot;</code> violates this condition, but <code>&quot;aba&quot;</code> does not).</li>
</ul>

<p>Given a string <code>password</code>, return <code>true</code><em> if it is a <strong>strong</strong> password</em>. Otherwise, return <code>false</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> password = &quot;IloveLe3tcode!&quot;
<strong>Output:</strong> true
<strong>Explanation:</strong> The password meets all the requirements. Therefore, we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> password = &quot;Me+You--IsMyDream&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> The password does not contain a digit and also contains 2 of the same character in adjacent positions. Therefore, we return false.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> password = &quot;1aB!&quot;
<strong>Output:</strong> false
<strong>Explanation:</strong> The password does not meet the length requirement. Therefore, we return false.</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= password.length &lt;= 100</code></li>
	<li><code>password</code> consists of letters, digits, and special characters: <code>&quot;!@#$%^&amp;*()-+&quot;</code>.</li>
</ul>

## Solutions

### Solution 1: Simulation + Bit Manipulation

> **Thinking**
>
> A password needs length at least $8$, all four character classes, and no two equal neighbors. The length is at most $100$, so one scan can check everything. A four-bit mask records which classes appeared.
>
> Reject a short string or an equal adjacent pair; set the mask bit for the current class. A final mask of $15$ means all four classes are present.

According to the problem description, we can simulate the process of checking whether the password meets the requirements.

First, we check if the length of the password is less than $8$. If it is, we return $\textit{false}$.

Next, we use a mask $\textit{mask}$ to record whether the password contains lowercase letters, uppercase letters, digits, and special characters. We traverse the password, and for each character, we first check if it is the same as the previous character. If it is, we return $\textit{false}$. Then, we update the mask $\textit{mask}$ based on the character type. Finally, we check if the mask $\textit{mask}$ is $15$. If it is, we return $\textit{true}$; otherwise, we return $\textit{false}$.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the password.

#### Java

```java
class Solution {
    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        int mask = 0;
        for (int i = 0; i < password.length(); ++i) {
            char c = password.charAt(i);
            if (i > 0 && c == password.charAt(i - 1)) {
                return false;
            }
            if (Character.isLowerCase(c)) {
                mask |= 1;
            } else if (Character.isUpperCase(c)) {
                mask |= 2;
            } else if (Character.isDigit(c)) {
                mask |= 4;
            } else {
                mask |= 8;
            }
        }
        return mask == 15;
    }
}
```
