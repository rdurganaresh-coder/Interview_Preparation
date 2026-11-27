# 1096. Brace Expansion II

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/brace-expansion-ii/

---

[中文文档](/solution/1000-1099/1096.Brace%20Expansion%20II/README.md)

## Description

<p>Under the grammar given below, strings can represent a set of lowercase words. Let&nbsp;<code>R(expr)</code>&nbsp;denote the set of words the expression represents.</p>

<p>The grammar can best be understood through simple examples:</p>

<ul>
	<li>Single letters represent a singleton set containing that word.
	<ul>
		<li><code>R(&quot;a&quot;) = {&quot;a&quot;}</code></li>
		<li><code>R(&quot;w&quot;) = {&quot;w&quot;}</code></li>
	</ul>
	</li>
	<li>When we take a comma-delimited list of two or more expressions, we take the union of possibilities.
	<ul>
		<li><code>R(&quot;{a,b,c}&quot;) = {&quot;a&quot;,&quot;b&quot;,&quot;c&quot;}</code></li>
		<li><code>R(&quot;{{a,b},{b,c}}&quot;) = {&quot;a&quot;,&quot;b&quot;,&quot;c&quot;}</code> (notice the final set only contains each word at most once)</li>
	</ul>
	</li>
	<li>When we concatenate two expressions, we take the set of possible concatenations between two words where the first word comes from the first expression and the second word comes from the second expression.
	<ul>
		<li><code>R(&quot;{a,b}{c,d}&quot;) = {&quot;ac&quot;,&quot;ad&quot;,&quot;bc&quot;,&quot;bd&quot;}</code></li>
		<li><code>R(&quot;a{b,c}{d,e}f{g,h}&quot;) = {&quot;abdfg&quot;, &quot;abdfh&quot;, &quot;abefg&quot;, &quot;abefh&quot;, &quot;acdfg&quot;, &quot;acdfh&quot;, &quot;acefg&quot;, &quot;acefh&quot;}</code></li>
	</ul>
	</li>
</ul>

<p>Formally, the three rules for our grammar:</p>

<ul>
	<li>For every lowercase letter <code>x</code>, we have <code>R(x) = {x}</code>.</li>
	<li>For expressions <code>e<sub>1</sub>, e<sub>2</sub>, ... , e<sub>k</sub></code> with <code>k &gt;= 2</code>, we have <code>R({e<sub>1</sub>, e<sub>2</sub>, ...}) = R(e<sub>1</sub>) &cup; R(e<sub>2</sub>) &cup; ...</code></li>
	<li>For expressions <code>e<sub>1</sub></code> and <code>e<sub>2</sub></code>, we have <code>R(e<sub>1</sub> + e<sub>2</sub>) = {a + b for (a, b) in R(e<sub>1</sub>) &times; R(e<sub>2</sub>)}</code>, where <code>+</code> denotes concatenation, and <code>&times;</code> denotes the cartesian product.</li>
</ul>

<p>Given an expression representing a set of words under the given grammar, return <em>the sorted list of words that the expression represents</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;{a,b}{c,{d,e}}&quot;
<strong>Output:</strong> [&quot;ac&quot;,&quot;ad&quot;,&quot;ae&quot;,&quot;bc&quot;,&quot;bd&quot;,&quot;be&quot;]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> expression = &quot;{{a,z},a{b,c},{ab,z}}&quot;
<strong>Output:</strong> [&quot;a&quot;,&quot;ab&quot;,&quot;ac&quot;,&quot;z&quot;]
<strong>Explanation:</strong> Each distinct word is written only once in the final answer.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= expression.length &lt;= 60</code></li>
	<li><code>expression[i]</code> consists of <code>&#39;{&#39;</code>, <code>&#39;}&#39;</code>, <code>&#39;,&#39;</code>or lowercase English letters.</li>
	<li>The given&nbsp;<code>expression</code>&nbsp;represents a set of words based on the grammar given in the description.</li>
</ul>

## Solutions

### Solution 1: Recursion

> **Thinking**
>
> The expression mixes union, concatenation, and nested braces. Length $\le 60$ lets us expand the innermost brace, splice, and recurse.
>
> Find the first `}` and its matching `{`. Prefix $a$, each alternative $b_i$, and suffix $c$ become $a+b_i+c$. A brace-free string is inserted into a set.
>
> The set is sorted for the answer.

Define a recursive function $\textit{dfs}(\textit{exp})$ that expands $\textit{exp}$ and stores every word in a set $s$.

Find the index $j$ of the first `}`. If there is none, $\textit{exp}$ is already a single word, so insert it into $s$.

Otherwise search left from $j$ for the matching `{` at index $i$. The prefix $\textit{exp}[:i]$ and the suffix $\textit{exp}[j + 1:]$ are $a$ and $c$. Split the brace body $\textit{exp}[i + 1: j]$ on commas into $b_1, b_2, \cdots, b_k$, and recurse on $\textit{dfs}(a + b_i + c)$ for each $b_i$. The first `}` always closes a brace group with no nested braces, so splitting that body on commas is exact.

Sort $s$ in lexicographical order to obtain the answer.

The time complexity is $O(3^{n/6})$, and the space complexity is $O(n 3^{n/7})$, where $n$ is the length of $\textit{expression}$. The worst-case time comes from a nested three-way union such as $\{\ldots\{a,b,c\},a,b\}$: every extra $6$ characters multiplies the recursion tree by about $3$, and the total length of the strings processed is $\Theta(3^{n/6})$. Concatenating copies of $\{a,b,c\}$ produces $\Theta(3^{n/7})$ words of length $O(n)$. The deduplicated set occupies $O(n 3^{n/7})$ space, and sorting it costs $O(n^2 3^{n/7})$, which is within the time bound above. The recursion depth is $O(n)$, so the strings on the stack use $O(n^2)$ extra space.

#### Java

```java
class Solution {
    private TreeSet<String> s = new TreeSet<>();

    public List<String> braceExpansionII(String expression) {
        dfs(expression);
        return new ArrayList<>(s);
    }

    private void dfs(String exp) {
        int j = exp.indexOf('}');
        if (j == -1) {
            s.add(exp);
            return;
        }
        int i = exp.lastIndexOf('{', j);
        String a = exp.substring(0, i);
        String c = exp.substring(j + 1);
        for (String b : exp.substring(i + 1, j).split(",")) {
            dfs(a + b + c);
        }
    }
}
```

### Solution 2: Grammar Parsing

> **Thinking**
>
> Solution 1 copies the still-unexpanded suffix into every alternative. A nested three-way union such as $\{\ldots\{a,b,c\},a,b\}$ therefore repeats the same suffix and takes $O(3^{n/6})$ time, even when only a constant number of words are distinct.
>
> Commas occur only inside braces and mean union. Adjacent factors outside commas mean concatenation. A left-to-right parse evaluates each subexpression once.
>
> A factor is a run of lowercase letters or a brace expression. Concatenation is the Cartesian product of the current set with the factor, and commas take the union of those products. A hash set removes duplicates, and the final set is sorted.

Let $s$ be the expression. Starting at index $i$, define two functions.

$\textit{expr}(i)$ parses a union of terms. It parses one $\textit{term}$, and while the next character is a comma it skips the comma, parses another $\textit{term}$, and unions the sets together. It stops at `}` or the end of $s$.

$\textit{term}(i)$ parses a concatenation of factors, starting from $\{\varepsilon\}$. A `{` recursively parses the inner $\textit{expr}$ and then skips the matching `}`. Otherwise the factor is the following run of lowercase letters. The current set is replaced by its Cartesian product with that factor. The function returns at a comma, a `}`, or the end of $s$.

Sort the set returned by $\textit{expr}(0)$. Each subexpression is parsed once, so the suffix is no longer copied and rescanned on every branch.

The time complexity is $O(n^2 3^{n/7})$, and the space complexity is $O(n 3^{n/7})$, where $n$ is the length of the expression. The worst case is a concatenation of `{a,b,c}` groups, which produces $\Theta(3^{n/7})$ words of length $O(n)$. Building them costs $O(n 3^{n/7})$ and sorting them costs $O(n^2 3^{n/7})$. A nested three-way union keeps every intermediate set at size $O(1)$, so that input takes only $O(n)$ time.

#### Java

```java
class Solution {
    private String exp;
    private int i;

    public List<String> braceExpansionII(String expression) {
        exp = expression;
        i = 0;
        List<String> ans = new ArrayList<>(expr());
        Collections.sort(ans);
        return ans;
    }

    private Set<String> expr() {
        Set<String> res = term();
        while (i < exp.length() && exp.charAt(i) == ',') {
            ++i;
            res.addAll(term());
        }
        return res;
    }

    private Set<String> term() {
        Set<String> res = new HashSet<>();
        res.add("");
        while (i < exp.length() && exp.charAt(i) != ',' && exp.charAt(i) != '}') {
            Set<String> cur = new HashSet<>();
            if (exp.charAt(i) == '{') {
                ++i;
                cur = expr();
                ++i;
            } else {
                int j = i + 1;
                while (j < exp.length() && exp.charAt(j) >= 'a' && exp.charAt(j) <= 'z') {
                    ++j;
                }
                cur.add(exp.substring(i, j));
                i = j;
            }
            Set<String> nxt = new HashSet<>();
            for (String a : res) {
                for (String b : cur) {
                    nxt.add(a + b);
                }
            }
            res = nxt;
        }
        return res;
    }
}
```
