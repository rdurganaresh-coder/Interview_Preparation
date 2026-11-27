# 78. Subsets

**Difficulty:** Medium  
**Category:** Backtracking  
**LeetCode:** https://leetcode.com/problems/subsets/

---

[中文文档](/solution/0000-0099/0078.Subsets/README.md)

## Description

<p>Given an integer array <code>nums</code> of <strong>unique</strong> elements, return <em>all possible</em> <span data-keyword="subset"><em>subsets</em></span> <em>(the power set)</em>.</p>

<p>The solution set <strong>must not</strong> contain duplicate subsets. Return the solution in <strong>any order</strong>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [0]
<strong>Output:</strong> [[],[0]]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10</code></li>
	<li><code>-10 &lt;= nums[i] &lt;= 10</code></li>
	<li>All the numbers of&nbsp;<code>nums</code> are <strong>unique</strong>.</li>
</ul>

## Solutions

### Solution 1: DFS (Backtracking)

> **Thinking**
>
> A subset is a choose/skip for each element, $2^n$ of them. $n \le 10$, so listing all is fine. We could rebuild from each mask, or recurse.
>
> Recursion is the direct picture: from index $i$, skip $\textit{nums}[i]$ then take it and pop. At $i=n$ copy the path into the answer. Distinct elements mean no duplicate subsets.

We design a function $\textit{dfs}(i)$, which represents starting the search from the $i$th element of the array for all subsets. The execution logic of the function $\textit{dfs}(i)$ is as follows:

- If $i = n$, it means the current search has ended. Add the current subset $t$ to the answer array $\textit{ans}$, and then return.
- Otherwise, we can choose not to select the current element and directly execute $\textit{dfs}(i + 1)$; or we can choose the current element, i.e., add the current element $\textit{nums}[i]$ to the subset $t$, and then execute $\textit{dfs}(i + 1)$. Note that we need to remove $\textit{nums}[i]$ from the subset $t$ after executing $\textit{dfs}(i + 1)$ (backtracking).

In the main function, we call $\textit{dfs}(0)$, i.e., start searching all subsets from the first element of the array. Finally, return the answer array $\textit{ans}$.

The time complexity is $O(n 2^n)$, and the space complexity is $O(n)$, where $n$ is the length of the array. There are a total of $2^n$ subsets, and each subset takes $O(n)$ time to construct.

#### Java

```java
class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private List<Integer> t = new ArrayList<>();
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        dfs(0);
        return ans;
    }

    private void dfs(int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(t));
            return;
        }
        dfs(i + 1);
        t.add(nums[i]);
        dfs(i + 1);
        t.remove(t.size() - 1);
    }
}
```

### Solution 2: Binary Enumeration

> **Thinking**
>
> Method 1 expands choose/skip on the call stack. $n$ is tiny, so each subset can be a mask in $[0,2^n)$: bit $i$ includes $\textit{nums}[i]$. No recursion; the same $O(n 2^n)$ work.

We can also use the method of binary enumeration to get all subsets.

We can use $2^n$ binary numbers to represent all subsets of $n$ elements. For the current binary number $\textit{mask}$, if the $i$th bit is $1$, it means that the $i$th element is selected, otherwise it means that the $i$th element is not selected.

The time complexity is $O(n 2^n)$, and the space complexity is $O(n)$, where $n$ is the length of the array. There are a total of $2^n$ subsets, and each subset takes $O(n)$ time to construct.

#### Java

```java
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int mask = 0; mask < 1 << n; ++mask) {
            List<Integer> t = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                if (((mask >> i) & 1) == 1) {
                    t.add(nums[i]);
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
```
