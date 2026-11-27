# 1452. People Whose List of Favorite Companies Is Not a Subset of Another List

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

---

[中文文档](/solution/1400-1499/1452.People%20Whose%20List%20of%20Favorite%20Companies%20Is%20Not%20a%20Subset%20of%20Another%20List/README.md)

## Description

<p>Given the array <code>favoriteCompanies</code> where <code>favoriteCompanies[i]</code> is the list of favorites companies for the <code>ith</code> person (<strong>indexed from 0</strong>).</p>

<p><em>Return the indices of people whose list of favorite companies is not a <strong>subset</strong> of any other list of favorites companies</em>. You must return the indices in increasing order.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> favoriteCompanies = [[&quot;leetcode&quot;,&quot;google&quot;,&quot;facebook&quot;],[&quot;google&quot;,&quot;microsoft&quot;],[&quot;google&quot;,&quot;facebook&quot;],[&quot;google&quot;],[&quot;amazon&quot;]]
<strong>Output:</strong> [0,1,4] 
<strong>Explanation:</strong> 
Person with index=2 has favoriteCompanies[2]=[&quot;google&quot;,&quot;facebook&quot;] which is a subset of favoriteCompanies[0]=[&quot;leetcode&quot;,&quot;google&quot;,&quot;facebook&quot;] corresponding to the person with index 0. 
Person with index=3 has favoriteCompanies[3]=[&quot;google&quot;] which is a subset of favoriteCompanies[0]=[&quot;leetcode&quot;,&quot;google&quot;,&quot;facebook&quot;] and favoriteCompanies[1]=[&quot;google&quot;,&quot;microsoft&quot;]. 
Other lists of favorite companies are not a subset of another list, therefore, the answer is [0,1,4].
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> favoriteCompanies = [[&quot;leetcode&quot;,&quot;google&quot;,&quot;facebook&quot;],[&quot;leetcode&quot;,&quot;amazon&quot;],[&quot;facebook&quot;,&quot;google&quot;]]
<strong>Output:</strong> [0,1] 
<strong>Explanation:</strong> In this case favoriteCompanies[2]=[&quot;facebook&quot;,&quot;google&quot;] is a subset of favoriteCompanies[0]=[&quot;leetcode&quot;,&quot;google&quot;,&quot;facebook&quot;], therefore, the answer is [0,1].
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> favoriteCompanies = [[&quot;leetcode&quot;],[&quot;google&quot;],[&quot;facebook&quot;],[&quot;amazon&quot;]]
<strong>Output:</strong> [0,1,2,3]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= favoriteCompanies.length &lt;= 100</code></li>
	<li><code>1 &lt;= favoriteCompanies[i].length &lt;= 500</code></li>
	<li><code>1 &lt;= favoriteCompanies[i][j].length &lt;= 20</code></li>
	<li>All strings in <code>favoriteCompanies[i]</code> are <strong>distinct</strong>.</li>
	<li>All lists of favorite companies are <strong>distinct</strong>, that is, If we sort alphabetically each list then <code>favoriteCompanies[i] != favoriteCompanies[j].</code></li>
	<li>All strings consist of lowercase English letters only.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> $n\le 100$ and each list has at most $500$ names. Map company names to integers, store each list as a set, and test subset relations in a double loop.
>
> Lists are unique, so person $i$ stays if no $j\neq i$ satisfies $\textit{nums}[i]\subseteq\textit{nums}[j]$.

We can map each company to a unique integer. Then, for each person, we convert their favorite companies into a set of integers. Finally, we check if the favorite companies of one person are a subset of another person's favorite companies.

The time complexity is $O(nmk + n^2m)$, and the space complexity is $O(nm)$, where $n$ and $m$ are the lengths of $\textit{favoriteCompanies}$ and the average length of each company's list, respectively, and $k$ is the average length of each company.

#### Java

```java
class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        int n = favoriteCompanies.size();
        Map<String, Integer> d = new HashMap<>();
        int idx = 0;
        Set<Integer>[] nums = new Set[n];
        Arrays.setAll(nums, i -> new HashSet<>());
        for (int i = 0; i < n; ++i) {
            var ss = favoriteCompanies.get(i);
            for (var s : ss) {
                if (!d.containsKey(s)) {
                    d.put(s, idx++);
                }
                nums[i].add(d.get(s));
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            boolean ok = true;
            for (int j = 0; j < n && ok; ++j) {
                if (i != j && nums[j].containsAll(nums[i])) {
                    ok = false;
                }
            }
            if (ok) {
                ans.add(i);
            }
        }
        return ans;
    }
}
```
