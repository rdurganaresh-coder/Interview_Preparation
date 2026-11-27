# 194. Transpose File

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/transpose-file/

---

[中文文档](/solution/0100-0199/0194.Transpose%20File/README.md)

## Description

<p>Given a text file <code>file.txt</code>, transpose its content.</p>

<p>You may assume that each row has the same number of columns, and each field is separated by the <code>&#39; &#39;</code> character.</p>

<p><strong class="example">Example:</strong></p>

<p>If <code>file.txt</code> has the following content:</p>

<pre>
name age
alice 21
ryan 30
</pre>

<p>Output the following:</p>

<pre>
name alice ryan
age 21 30
</pre>

## Solutions

### Solution 1: awk

> **Thinking**
>
> Transpose whitespace-separated text. While reading a row, append field $i$ to result string $i$; after the file, print those strings. $\textit{awk}$'s $\textit{NF}/\textit{NR}$ give the column index and whether this is the first row, so we know when to insert a space.
