# 726. Number of Atoms

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/number-of-atoms/

---

[中文文档](/solution/0700-0799/0726.Number%20of%20Atoms/README.md)

## Description

<p>Given a string <code>formula</code> representing a chemical formula, return <em>the count of each atom</em>.</p>

<p>The atomic element always starts with an uppercase character, then zero or more lowercase letters, representing the name.</p>

<p>One or more digits representing that element&#39;s count may follow if the count is greater than <code>1</code>. If the count is <code>1</code>, no digits will follow.</p>

<ul>
	<li>For example, <code>&quot;H2O&quot;</code> and <code>&quot;H2O2&quot;</code> are possible, but <code>&quot;H1O2&quot;</code> is impossible.</li>
</ul>

<p>Two formulas are concatenated together to produce another formula.</p>

<ul>
	<li>For example, <code>&quot;H2O2He3Mg4&quot;</code> is also a formula.</li>
</ul>

<p>A formula placed in parentheses, and a count (optionally added) is also a formula.</p>

<ul>
	<li>For example, <code>&quot;(H2O2)&quot;</code> and <code>&quot;(H2O2)3&quot;</code> are formulas.</li>
</ul>

<p>Return the count of all elements as a string in the following form: the first name (in sorted order), followed by its count (if that count is more than <code>1</code>), followed by the second name (in sorted order), followed by its count (if that count is more than <code>1</code>), and so on.</p>

<p>The test cases are generated so that all the values in the output fit in a <strong>32-bit</strong> integer.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> formula = &quot;H2O&quot;
<strong>Output:</strong> &quot;H2O&quot;
<strong>Explanation:</strong> The count of elements are {&#39;H&#39;: 2, &#39;O&#39;: 1}.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> formula = &quot;Mg(OH)2&quot;
<strong>Output:</strong> &quot;H2MgO2&quot;
<strong>Explanation:</strong> The count of elements are {&#39;H&#39;: 2, &#39;Mg&#39;: 1, &#39;O&#39;: 2}.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> formula = &quot;K4(ON(SO3)2)2&quot;
<strong>Output:</strong> &quot;K4N2O14S4&quot;
<strong>Explanation:</strong> The count of elements are {&#39;K&#39;: 4, &#39;N&#39;: 2, &#39;O&#39;: 14, &#39;S&#39;: 4}.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= formula.length &lt;= 1000</code></li>
	<li><code>formula</code> consists of English letters, digits, <code>&#39;(&#39;</code>, and <code>&#39;)&#39;</code>.</li>
	<li><code>formula</code> is always valid.</li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A chemical formula with parentheses and counts must be tallied and printed with atoms in sorted order. Length $\le 1000$, so a stack or a recursive descent both work.
>
> A multiplier applies to a whole parenthesized group. Scanning right to left, a count is seen before the group: on `)` push the current multiplier and multiply by the count; on `(` restore it.
>
> Accumulate this way: digits form $\textit{freq}$, and each element name (plus trailing lowercase letters) adds $\textit{freq}\times\textit{multiplier}$. Sort the keys and omit a count of $1$.

#### Java

```java
class Solution {
    public String countOfAtoms(String formula) {
        Map<String, Integer> map = new HashMap<>();
        int[] stack = new int[1000];
        int top = 0, multiplier = 1, freq = 0;
        char[] c = formula.toCharArray();
        for (int i = c.length - 1; i >= 0; i--) {
            if (c[i] >= 'a' && c[i] <= 'z') {
                int end = i--;
                while (i >= 0 && c[i] >= 'a' && c[i] <= 'z') i--;
                String key = new String(c, i, end - i + 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= 'A' && c[i] <= 'Z') {
                String key = new String(c, i, 1);
                map.put(key, map.getOrDefault(key, 0) + Math.max(freq, 1) * multiplier);
                freq = 0;
            } else if (c[i] >= '0' && c[i] <= '9') {
                freq = c[i] - '0';
                int p = 10;
                while (i - 1 >= 0 && c[i - 1] >= '0' && c[i - 1] <= '9') {
                    freq += p * (c[--i] - '0');
                    p *= 10;
                }
            } else if (c[i] == ')') {
                stack[top++] = multiplier;
                multiplier *= Math.max(freq, 1);
                freq = 0;
            } else {
                multiplier = stack[--top];
            }
        }
        List<String> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key);
            int f = map.get(key);
            if (f > 1) sb.append(f);
        }
        return sb.toString();
    }
}
```
