# 3501. Maximize Active Section with Trade II

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/maximize-active-section-with-trade-ii/

---

[中文文档](/solution/3500-3599/3501.Maximize%20Active%20Section%20with%20Trade%20II/README.md)

## Description

<p>You are given a binary string <code>s</code> of length <code>n</code>, where:</p>

<ul>
	<li><code>&#39;1&#39;</code> represents an <strong>active</strong> section.</li>
	<li><code>&#39;0&#39;</code> represents an <strong>inactive</strong> section.</li>
</ul>

<p>You can perform <strong>at most one trade</strong> to maximize the number of active sections in <code>s</code>. In a trade, you:</p>

<ul>
	<li>Convert a contiguous block of <code>&#39;1&#39;</code>s that is surrounded by <code>&#39;0&#39;</code>s to all <code>&#39;0&#39;</code>s.</li>
	<li>Afterward, convert a contiguous block of <code>&#39;0&#39;</code>s that is surrounded by <code>&#39;1&#39;</code>s to all <code>&#39;1&#39;</code>s.</li>
</ul>

<p>Additionally, you are given a <strong>2D array</strong> <code>queries</code>, where <code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code> represents a <span data-keyword="substring-nonempty">substring</span> <code>s[l<sub>i</sub>...r<sub>i</sub>]</code>.</p>

<p>For each query, determine the <strong>maximum</strong> possible number of active sections in <code>s</code> after making the optimal trade on the substring <code>s[l<sub>i</sub>...r<sub>i</sub>]</code>.</p>

<p>Return an array <code>answer</code>, where <code>answer[i]</code> is the result for <code>queries[i]</code>.</p>

<p><strong>Note</strong></p>

<ul>
	<li>For each query, treat <code>s[l<sub>i</sub>...r<sub>i</sub>]</code> as if it is <strong>augmented</strong> with a <code>&#39;1&#39;</code> at both ends, forming <code>t = &#39;1&#39; + s[l<sub>i</sub>...r<sub>i</sub>] + &#39;1&#39;</code>. The augmented <code>&#39;1&#39;</code>s <strong>do not</strong> contribute to the final count.</li>
	<li>The queries are independent of each other.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;01&quot;, queries = [[0,1]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[1]</span></p>

<p><strong>Explanation:</strong></p>

<p>Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;0100&quot;, queries = [[0,3],[0,2],[1,3],[2,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,3,1,1]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p>Query <code>[0, 3]</code> &rarr; Substring <code>&quot;0100&quot;</code> &rarr; Augmented to <code>&quot;101001&quot;</code><br />
	Choose <code>&quot;0100&quot;</code>, convert <code>&quot;0100&quot;</code> &rarr; <code>&quot;0000&quot;</code> &rarr; <code>&quot;1111&quot;</code>.<br />
	The final string without augmentation is <code>&quot;1111&quot;</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[0, 2]</code> &rarr; Substring <code>&quot;010&quot;</code> &rarr; Augmented to <code>&quot;10101&quot;</code><br />
	Choose <code>&quot;010&quot;</code>, convert <code>&quot;010&quot;</code> &rarr; <code>&quot;000&quot;</code> &rarr; <code>&quot;111&quot;</code>.<br />
	The final string without augmentation is <code>&quot;1110&quot;</code>. The maximum number of active sections is 3.</p>
	</li>
	<li>
	<p>Query <code>[1, 3]</code> &rarr; Substring <code>&quot;100&quot;</code> &rarr; Augmented to <code>&quot;11001&quot;</code><br />
	Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
	</li>
	<li>
	<p>Query <code>[2, 3]</code> &rarr; Substring <code>&quot;00&quot;</code> &rarr; Augmented to <code>&quot;1001&quot;</code><br />
	Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 1.</p>
	</li>
</ul>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;1000100&quot;, queries = [[1,5],[0,6],[0,4]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[6,7,2]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li data-end="383" data-start="217">
	<p data-end="383" data-start="219">Query <code>[1, 5]</code> &rarr; Substring <code data-end="255" data-start="246">&quot;00010&quot;</code> &rarr; Augmented to <code data-end="282" data-start="271">&quot;1000101&quot;</code><br data-end="285" data-start="282" />
	Choose <code data-end="303" data-start="294">&quot;00010&quot;</code>, convert <code data-end="322" data-start="313">&quot;00010&quot;</code> &rarr; <code data-end="322" data-start="313">&quot;00000&quot;</code> &rarr; <code data-end="334" data-start="325">&quot;11111&quot;</code>.<br />
	The final string without augmentation is <code data-end="404" data-start="396">&quot;1111110&quot;</code>. The maximum number of active sections is 6.</p>
	</li>
	<li data-end="561" data-start="385">
	<p data-end="561" data-start="387">Query <code>[0, 6]</code> &rarr; Substring <code data-end="425" data-start="414">&quot;1000100&quot;</code> &rarr; Augmented to <code data-end="454" data-start="441">&quot;110001001&quot;</code><br data-end="457" data-start="454" />
	Choose <code data-end="477" data-start="466">&quot;000100&quot;</code>, convert <code data-end="498" data-start="487">&quot;000100&quot;</code> &rarr; <code data-end="498" data-start="487">&quot;000000&quot;</code> &rarr; <code data-end="512" data-start="501">&quot;111111&quot;</code>.<br />
	The final string without augmentation is <code data-end="404" data-start="396">&quot;1111111&quot;</code>. The maximum number of active sections is 7.</p>
	</li>
	<li data-end="741" data-start="563">
	<p data-end="741" data-start="565">Query <code>[0, 4]</code> &rarr; Substring <code data-end="601" data-start="592">&quot;10001&quot;</code> &rarr; Augmented to <code data-end="627" data-start="617">&quot;1100011&quot;</code><br data-end="630" data-start="627" />
	Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 2.</p>
	</li>
</ul>
</div>

<p><strong class="example">Example 4:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">s = &quot;01010&quot;, queries = [[0,3],[1,4],[1,3]]</span></p>

<p><strong>Output:</strong> <span class="example-io">[4,4,2]</span></p>

<p><strong>Explanation:</strong></p>

<ul>
	<li>
	<p>Query <code>[0, 3]</code> &rarr; Substring <code>&quot;0101&quot;</code> &rarr; Augmented to <code>&quot;101011&quot;</code><br />
	Choose <code>&quot;010&quot;</code>, convert <code>&quot;010&quot;</code> &rarr; <code>&quot;000&quot;</code> &rarr; <code>&quot;111&quot;</code>.<br />
	The final string without augmentation is <code>&quot;11110&quot;</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[1, 4]</code> &rarr; Substring <code>&quot;1010&quot;</code> &rarr; Augmented to <code>&quot;110101&quot;</code><br />
	Choose <code>&quot;010&quot;</code>, convert <code>&quot;010&quot;</code> &rarr; <code>&quot;000&quot;</code> &rarr; <code>&quot;111&quot;</code>.<br />
	The final string without augmentation is <code>&quot;01111&quot;</code>. The maximum number of active sections is 4.</p>
	</li>
	<li>
	<p>Query <code>[1, 3]</code> &rarr; Substring <code>&quot;101&quot;</code> &rarr; Augmented to <code>&quot;11011&quot;</code><br />
	Because there is no block of <code>&#39;1&#39;</code>s surrounded by <code>&#39;0&#39;</code>s, no valid trade is possible. The maximum number of active sections is 2.</p>
	</li>
</ul>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= n == s.length &lt;= 10<sup>5</sup></code></li>
	<li><code>1 &lt;= queries.length &lt;= 10<sup>5</sup></code></li>
	<li><code>s[i]</code> is either <code>&#39;0&#39;</code> or <code>&#39;1&#39;</code>.</li>
	<li><code>queries[i] = [l<sub>i</sub>, r<sub>i</sub>]</code></li>
	<li><code>0 &lt;= l<sub>i</sub> &lt;= r<sub>i</sub> &lt; n</code></li>
</ul>

## Solutions

### Solution 1: Sparse Table

> **Thinking**
>
> Scanning every `'0'` run inside a query is $\Theta(q \cdot n)$ in the worst case, and both $n$ and $q$ can be $10^5$. A legal trade’s net gain is the sum of two `'0'` runs separated by `'1'`s, so the answer is the global number of `'1'`s plus the best gain inside the query.
>
> Adjacent pairs that lie wholly inside the interval can be queried in $O(1)$ with a sparse table on the sums of neighboring run lengths. Residual runs that straddle $l$ or $r$ pair with the next full run or with each other. After storing each run as $(\textit{start},\textit{len})$, each query needs only a constant number of comparisons.

A valid trade picks two consecutive `'0'` runs separated by `'1'`s, flips the `'1'`s to `'0'`s, then flips the merged `'0'` run back to `'1'`s. The net gain is the sum of the two `'0'` run lengths, and the original number of `'1'`s stays the same. Thus the answer for each query is the total number of `'1'`s in $s$, plus the maximum gain obtainable inside that query range.

Query $[l, r]$ may only operate on $s[l..r]$, treated as $t = \texttt{'1'} + s[l..r] + \texttt{'1'}$. Therefore:

- Any pair of adjacent `'0'` runs completely inside the range is a candidate, with gain equal to the sum of their lengths;
- If $s[l]$ or $s[r]$ lies in the middle of a `'0'` run, the suffix / prefix of that run inside the query range can also be paired.

We record every `'0'` run as $(\textit{start}, \textit{len})$ and build a sparse table on the sums of adjacent runs. For each query:

1. Query the sparse table for the maximum adjacent-run sum fully inside the range;
2. Also consider the leftover left run with the next run, the leftover right run with the previous run, and the special case where the two leftovers enclose a single `'1'` run.

Add the best gain to the global `'1'` count. If no trade is possible, the gain is $0$.

The time complexity is $O(n \log n + q)$, and the space complexity is $O(n \log n)$, where $n$ is the length of $s$ and $q$ is the number of queries.

#### Java

```java
class Solution {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int active = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++active;
            }
        }
        List<Integer> ans = new ArrayList<>();
        if (s.indexOf('0') < 0) {
            for (int i = 0; i < queries.length; ++i) {
                ans.add(active);
            }
            return ans;
        }

        int[][] zeros = new int[n][2];
        int z = 0;
        int[] idx = new int[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    ++zeros[z - 1][1];
                } else {
                    zeros[z][0] = i;
                    zeros[z++][1] = 1;
                }
            }
            idx[i] = z - 1;
        }

        int m = z - 1;
        int K = m > 0 ? 32 - Integer.numberOfLeadingZeros(m) : 0;
        int[][] st = new int[Math.max(K, 1)][Math.max(m, 0)];
        for (int i = 0; i < m; ++i) {
            st[0][i] = zeros[i][1] + zeros[i + 1][1];
        }
        for (int k = 1; k < K; ++k) {
            for (int i = 0; i + (1 << k) <= m; ++i) {
                st[k][i] = Math.max(st[k - 1][i], st[k - 1][i + (1 << (k - 1))]);
            }
        }

        for (int[] q : queries) {
            int L = q[0], R = q[1];
            int iL = idx[L], iR = idx[R];
            int cntL = iL < 0 ? -1 : zeros[iL][1] - (L - zeros[iL][0]);
            int cntR = iR < 0 ? -1 : R - zeros[iR][0] + 1;
            int start = iL + 1;
            int end = iR - (s.charAt(R) == '0' ? 1 : 0);
            int best = active;
            if (start < end) {
                best = Math.max(best, active + query(st, m, start, end - 1));
            }
            if (s.charAt(L) == '0' && s.charAt(R) == '0' && iL + 1 == iR) {
                best = Math.max(best, active + cntL + cntR);
            }
            if (s.charAt(L) == '0' && iL + 1 < iR + (s.charAt(R) == '1' ? 1 : 0)) {
                best = Math.max(best, active + cntL + zeros[iL + 1][1]);
            }
            if (s.charAt(R) == '0' && iL < iR - 1) {
                best = Math.max(best, active + cntR + zeros[iR - 1][1]);
            }
            ans.add(best);
        }
        return ans;
    }

    private int query(int[][] st, int m, int l, int r) {
        if (l > r || m <= 0) {
            return 0;
        }
        int k = 31 - Integer.numberOfLeadingZeros(r - l + 1);
        return Math.max(st[k][l], st[k][r - (1 << k) + 1]);
    }
}
```
