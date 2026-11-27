# 434. Number of Segments in a String

**Difficulty:** Easy  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/number-of-segments-in-a-string/

---

[中文文档](/solution/0400-0499/0434.Number%20of%20Segments%20in%20a%20String/README.md)

## Description

<p>Given a string <code>s</code>, return <em>the number of segments in the string</em>.</p>

<p>A <strong>segment</strong> is defined to be a contiguous sequence of <strong>non-space characters</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;Hello, my name is John&quot;
<strong>Output:</strong> 5
<strong>Explanation:</strong> The five segments are [&quot;Hello,&quot;, &quot;my&quot;, &quot;name&quot;, &quot;is&quot;, &quot;John&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;Hello&quot;
<strong>Output:</strong> 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= s.length &lt;= 300</code></li>
	<li><code>s</code> consists of lowercase and uppercase English letters, digits, or one of the following characters <code>&quot;!@#$%^&amp;*()_+-=&#39;,.:&quot;</code>.</li>
	<li>The only space character in <code>s</code> is <code>&#39; &#39;</code>.</li>
</ul>

## Solutions

### Solution 1: String Splitting

> **Thinking**
>
> Segments are blank-separated. A hand-written scan must handle leading, trailing, and repeated spaces. $\texttt{split}$ already drops empty pieces, so its length is the answer.
>
> The library walk is a fine first solution.

We split the string $s$ by spaces and then count the number of non-empty words.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        for (String t : s.split(" ")) {
            if (!"".equals(t)) {
                ++ans;
            }
        }
        return ans;
    }
}
```

### Solution 2: Simulation

> **Thinking**
>
> Solution 1 allocates the list of words. Counting only, a new segment starts at a non-space whose previous character is a space (or the first index). Extra memory becomes $O(1)$.

We can also directly traverse each character $s[i]$ in the string. If $s[i]$ is not a space and $s[i-1]$ is a space or $i = 0$, then $s[i]$ marks the beginning of a new word, and we increment the answer by one.

After the traversal, we return the answer.

The time complexity is $O(n)$, and the space complexity is $O(1)$, where $n$ is the length of the string $s$.

#### Java

```java
class Solution {
    public int countSegments(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                ++ans;
            }
        }
        return ans;
    }
}
```
