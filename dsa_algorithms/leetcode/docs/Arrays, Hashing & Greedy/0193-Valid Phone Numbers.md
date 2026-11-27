# 193. Valid Phone Numbers

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/valid-phone-numbers/

---

[中文文档](/solution/0100-0199/0193.Valid%20Phone%20Numbers/README.md)

## Description

<p>Given a text file <code>file.txt</code> that contains a list of phone numbers (one per line), write a one-liner bash script to print all valid phone numbers.</p>

<p>You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or xxx-xxx-xxxx. (x means a digit)</p>

<p>You may also assume each line in the text file must not contain leading or trailing white spaces.</p>

<p><strong class="example">Example:</strong></p>

<p>Assume that <code>file.txt</code> has the following content:</p>

<pre>
987-123-4567
123 456 7890
(123) 456-7890
</pre>

<p>Your script should output the following valid phone numbers:</p>

<pre>
987-123-4567
(123) 456-7890
</pre>

## Solutions

### Solution 1: awk

> **Thinking**
>
> Valid numbers are only $\textit{xxx}-\textit{xxx}-\textit{xxxx}$ and $(\textit{xxx})\,\textit{xxx}-\textit{xxxx}$. Match the whole line. An $\textit{awk}$ regex anchored at both ends: three digits and a dash, or a parenthesized triple and a space, then three digits, a dash, and four digits.
