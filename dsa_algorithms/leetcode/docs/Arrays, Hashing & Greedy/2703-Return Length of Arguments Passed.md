# 2703. Return Length of Arguments Passed

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/return-length-of-arguments-passed/

---

[中文文档](/solution/2700-2799/2703.Return%20Length%20of%20Arguments%20Passed/README.md)

## Description

Write a function&nbsp;<code>argumentsLength</code> that returns the count of arguments passed to it.
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> args = [5]
<strong>Output:</strong> 1
<strong>Explanation:</strong>
argumentsLength(5); // 1

One value was passed to the function so it should return 1.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> args = [{}, null, &quot;3&quot;]
<strong>Output:</strong> 3
<strong>Explanation:</strong> 
argumentsLength({}, null, &quot;3&quot;); // 3

Three values were passed to the function so it should return 3.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>args</code>&nbsp;is a valid JSON array</li>
	<li><code>0 &lt;= args.length &lt;= 100</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> The task is only to report how many arguments were passed; their types and values do not matter. Copying them into a new array just to read the length adds an allocation.
>
> A rest parameter is already an array, so its $\textit{length}$ is the answer.
