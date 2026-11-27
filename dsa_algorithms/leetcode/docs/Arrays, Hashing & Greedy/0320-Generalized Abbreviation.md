# 320. Generalized Abbreviation

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/generalized-abbreviation/

---

[中文文档](/solution/0300-0399/0320.Generalized%20Abbreviation/README.md)

## Description

<p>A word&#39;s <strong>generalized abbreviation</strong> can be constructed by taking any number of <strong>non-overlapping</strong> and <strong>non-adjacent</strong> <span data-keyword="substring-nonempty">substrings</span> and replacing them with their respective lengths.</p>

<ul>
	<li>For example, <code>&quot;abcde&quot;</code> can be abbreviated into:
    <ul>
    	<li><code>&quot;a3e&quot;</code> (<code>&quot;bcd&quot;</code> turned into <code>&quot;3&quot;</code>)</li>
    	<li><code>&quot;1bcd1&quot;</code> (<code>&quot;a&quot;</code> and <code>&quot;e&quot;</code> both turned into <code>&quot;1&quot;</code>)</li>
    	<li><code>&quot;5&quot;</code> (<code>&quot;abcde&quot;</code> turned into <code>&quot;5&quot;</code>)</li>
    	<li><code>&quot;abcde&quot;</code> (no substrings replaced)</li>
    </ul>
    </li>
    <li>However, these abbreviations are <strong>invalid</strong>:
    <ul>
    	<li><code>&quot;23&quot;</code> (<code>&quot;ab&quot;</code> turned into <code>&quot;2&quot;</code> and <code>&quot;cde&quot;</code> turned into <code>&quot;3&quot;</code>) is invalid as the substrings chosen are adjacent.</li>
    	<li><code>&quot;22de&quot;</code> (<code>&quot;ab&quot;</code> turned into <code>&quot;2&quot;</code> and <code>&quot;bc&quot;</code> turned into <code>&quot;2&quot;</code>) is invalid as the substring chosen overlap.</li>
    </ul>
    </li>
</ul>

<p>Given a string <code>word</code>, return <em>a list of all the possible <strong>generalized abbreviations</strong> of</em> <code>word</code>. Return the answer in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> word = "word"
<strong>Output:</strong> ["4","3d","2r1","2rd","1o2","1o1d","1or1","1ord","w3","w2d","w1r1","w1rd","wo2","wo1d","wor1","word"]
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> word = "a"
<strong>Output:</strong> ["1","a"]
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= word.length &lt;= 15</code></li>
	<li><code>word</code> consists of only lowercase English letters.</li>
</ul>

## Solutions

### Solution 1: DFS

> **Thinking**
>
> Each letter is kept or folded into a run of omitted counts. $n\le 15$, so every scheme is enumerable.
>
> $\textit{dfs}(i)$ handles the suffix: keep $\textit{word}[i]$ and recurse, or collapse $[i,j)$ into a number and append $\textit{word}[j]$ (if any) plus the rest. The empty suffix returns $[""]$ as the join base.

We design a function $\textit{dfs}(i)$, which returns all possible abbreviations for the string $\textit{word}[i:]$.

The execution logic of the function $\textit{dfs}(i)$ is as follows:

If $i \geq n$, it means that the string $\textit{word}$ has been processed, and we directly return a list composed of an empty string.

Otherwise, we can choose to keep $\textit{word}[i]$, and then add $\textit{word}[i]$ to the front of each string in the list returned by $\textit{dfs}(i + 1)$, and add the obtained result to the answer.

We can also choose to delete $\textit{word}[i]$ and some characters after it. Suppose we delete $\textit{word}[i..j)$, then the $j$ th character is not deleted, and then add $j - i$ to the front of each string in the list returned by $\textit{dfs}(j + 1)$, and add the obtained result to the answer.

Finally, we call $\textit{dfs}(0)$ in the main function.

The time complexity is $O(n 2^n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $\textit{word}$.

#### Java

```java
class Solution {
    private String word;
    private int n;

    public List<String> generateAbbreviations(String word) {
        this.word = word;
        n = word.length();
        return dfs(0);
    }

    private List<String> dfs(int i) {
        if (i >= n) {
            return List.of("");
        }
        List<String> ans = new ArrayList<>();
        for (String s : dfs(i + 1)) {
            ans.add(String.valueOf(word.charAt(i)) + s);
        }
        for (int j = i + 1; j <= n; ++j) {
            for (String s : dfs(j + 1)) {
                ans.add((j - i) + "" + (j < n ? String.valueOf(word.charAt(j)) : "") + s);
            }
        }
        return ans;
    }
}
```

### Solution 2: Binary Enumeration

> **Thinking**
>
> The recursion matches the $2^n$ keep/omit choices. A bit mask marks omitted positions; runs of $1$s become a count, a $0$ emits the letter. The iterative form drops the call stack.

Since the length of the string $\textit{word}$ does not exceed $15$, we can use the method of binary enumeration to enumerate all abbreviations. We use a binary number $i$ of length $n$ to represent an abbreviation, where $0$ represents keeping the corresponding character, and $1$ represents deleting the corresponding character. We enumerate all $i$ in the range of $[0, 2^n)$, convert it into the corresponding abbreviation, and add it to the answer list.

The time complexity is $O(n 2^n)$, and the space complexity is $O(n)$, where $n$ is the length of the string $\textit{word}$.

#### Java

```java
class Solution {
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            StringBuilder s = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    ++cnt;
                } else {
                    if (cnt > 0) {
                        s.append(cnt);
                        cnt = 0;
                    }
                    s.append(word.charAt(j));
                }
            }
            if (cnt > 0) {
                s.append(cnt);
            }
            ans.add(s.toString());
        }
        return ans;
    }
}
```
