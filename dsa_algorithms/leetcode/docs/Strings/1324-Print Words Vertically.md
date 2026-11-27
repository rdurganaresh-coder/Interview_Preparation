# 1324. Print Words Vertically

**Difficulty:** Medium  
**Category:** Strings  
**LeetCode:** https://leetcode.com/problems/print-words-vertically/

---

[中文文档](/solution/1300-1399/1324.Print%20Words%20Vertically/README.md)

## Description

<p>Given a string <code>s</code>.&nbsp;Return&nbsp;all the words vertically in the same order in which they appear in <code>s</code>.<br />
Words are returned as a list of strings, complete with&nbsp;spaces when is necessary. (Trailing spaces are not allowed).<br />
Each word would be put on only one column and that in one column there will be only one word.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;HOW ARE YOU&quot;
<strong>Output:</strong> [&quot;HAY&quot;,&quot;ORO&quot;,&quot;WEU&quot;]
<strong>Explanation: </strong>Each word is printed vertically. 
 &quot;HAY&quot;
&nbsp;&quot;ORO&quot;
&nbsp;&quot;WEU&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;TO BE OR NOT TO BE&quot;
<strong>Output:</strong> [&quot;TBONTB&quot;,&quot;OEROOE&quot;,&quot;   T&quot;]
<strong>Explanation: </strong>Trailing spaces is not allowed. 
&quot;TBONTB&quot;
&quot;OEROOE&quot;
&quot;   T&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> s = &quot;CONTEST IS COMING&quot;
<strong>Output:</strong> [&quot;CIC&quot;,&quot;OSO&quot;,&quot;N M&quot;,&quot;T I&quot;,&quot;E N&quot;,&quot;S G&quot;,&quot;T&quot;]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= s.length &lt;= 200</code></li>
	<li><code>s</code>&nbsp;contains only upper case English letters.</li>
	<li>It&#39;s guaranteed that there is only one&nbsp;space between 2 words.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> Words are read column-wise after a split; the height is the longest word, shorter words are padded, and trailing spaces on each column are removed. After computing that length $n$, column $j$ gathers the $j$-th character of every word (or a space), then pops trailing spaces before joining.

#### Java

```java
class Solution {
    public List<String> printVertically(String s) {
        String[] words = s.split(" ");
        int n = 0;
        for (var w : words) {
            n = Math.max(n, w.length());
        }
        List<String> ans = new ArrayList<>();
        for (int j = 0; j < n; ++j) {
            StringBuilder t = new StringBuilder();
            for (var w : words) {
                t.append(j < w.length() ? w.charAt(j) : ' ');
            }
            while (t.length() > 0 && t.charAt(t.length() - 1) == ' ') {
                t.deleteCharAt(t.length() - 1);
            }
            ans.add(t.toString());
        }
        return ans;
    }
}
```
