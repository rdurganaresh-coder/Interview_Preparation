# 500. Keyboard Row

**Difficulty:** Easy  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/keyboard-row/

---

[中文文档](/solution/0500-0599/0500.Keyboard%20Row/README.md)

## Description

<p>Given an array of strings <code>words</code>, return <em>the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below</em>.</p>

<p><strong>Note</strong> that the strings are <strong>case-insensitive</strong>, both lowercased and uppercased of the same letter are treated as if they are at the same row.</p>

<p>In the <strong>American keyboard</strong>:</p>

<ul>
	<li>the first row consists of the characters <code>&quot;qwertyuiop&quot;</code>,</li>
	<li>the second row consists of the characters <code>&quot;asdfghjkl&quot;</code>, and</li>
	<li>the third row consists of the characters <code>&quot;zxcvbnm&quot;</code>.</li>
</ul>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0500-0599/0500.Keyboard%20Row/images/keyboard.png" style="width: 800px; max-width: 600px; height: 267px;" />
<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">words = [&quot;Hello&quot;,&quot;Alaska&quot;,&quot;Dad&quot;,&quot;Peace&quot;]</span></p>

<p><strong>Output:</strong> <span class="example-io">[&quot;Alaska&quot;,&quot;Dad&quot;]</span></p>

<p><strong>Explanation:</strong></p>

<p>Both <code>&quot;a&quot;</code> and <code>&quot;A&quot;</code> are in the 2nd row of the American keyboard due to case insensitivity.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">words = [&quot;omk&quot;]</span></p>

<p><strong>Output:</strong> <span class="example-io">[]</span></p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">words = [&quot;adsdf&quot;,&quot;sfd&quot;]</span></p>

<p><strong>Output:</strong> <span class="example-io">[&quot;adsdf&quot;,&quot;sfd&quot;]</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= words.length &lt;= 20</code></li>
	<li><code>1 &lt;= words[i].length &lt;= 100</code></li>
	<li><code>words[i]</code> consists of English letters (both lowercase and uppercase).&nbsp;</li>
</ul>

## Solutions

### Solution 1: Set Check

> **Thinking**
>
> Checking every letter of every word against the three keyboard rows costs linear time in the total number of letters, which the constraints allow. Rebuilding a row's character set on each query repeats the same work.
>
> The verdict depends only on whether a word's letters lie on a single row, not on their order. Store the three rows as sets, lowercase the word, and test subset. One pass collects every valid word.

Put the three keyboard rows into sets. For each word, if its letter set is a subset of one row, add it to the answer.

The time complexity is $O(L)$, and the space complexity is $O(C)$, where $L$ is the total length of all words and $C$ is the size of the alphabet ($C = 26$ here).

### Solution 2: Character Mapping

> **Thinking**
>
> The set test is already linear, but each word allocates a set and runs three subset checks.
>
> Map every letter to a row id first, then verify that all letters share the first letter's row. The table is constant size and the scan is still one pass, with a smaller constant.

Map each letter to its keyboard row, then check whether every letter of a word falls on the same row.

The time complexity is $O(L)$, and the space complexity is $O(C)$, where $L$ is the total length of all words and $C$ is the size of the alphabet ($C = 26$ here).

#### Java

```java
class Solution {
    public String[] findWords(String[] words) {
        String s = "12210111011122000010020202";
        List<String> ans = new ArrayList<>();
        for (var w : words) {
            String t = w.toLowerCase();
            char x = s.charAt(t.charAt(0) - 'a');
            boolean ok = true;
            for (char c : t.toCharArray()) {
                if (s.charAt(c - 'a') != x) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans.add(w);
            }
        }
        return ans.toArray(new String[0]);
    }
}
```
