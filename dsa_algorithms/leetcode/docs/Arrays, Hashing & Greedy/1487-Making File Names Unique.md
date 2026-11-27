# 1487. Making File Names Unique

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/making-file-names-unique/

---

[中文文档](/solution/1400-1499/1487.Making%20File%20Names%20Unique/README.md)

## Description

<p>Given an array of strings <code>names</code> of size <code>n</code>. You will create <code>n</code> folders in your file system <strong>such that</strong>, at the <code>i<sup>th</sup></code> minute, you will create a folder with the name <code>names[i]</code>.</p>

<p>Since two files <strong>cannot</strong> have the same name, if you enter a folder name that was previously used, the system will have a suffix addition to its name in the form of <code>(k)</code>, where, <code>k</code> is the <strong>smallest positive integer</strong> such that the obtained name remains unique.</p>

<p>Return <em>an array of strings of length </em><code>n</code> where <code>ans[i]</code> is the actual name the system will assign to the <code>i<sup>th</sup></code> folder when you create it.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> names = [&quot;pes&quot;,&quot;fifa&quot;,&quot;gta&quot;,&quot;pes(2019)&quot;]
<strong>Output:</strong> [&quot;pes&quot;,&quot;fifa&quot;,&quot;gta&quot;,&quot;pes(2019)&quot;]
<strong>Explanation:</strong> Let&#39;s see how the file system creates folder names:
&quot;pes&quot; --&gt; not assigned before, remains &quot;pes&quot;
&quot;fifa&quot; --&gt; not assigned before, remains &quot;fifa&quot;
&quot;gta&quot; --&gt; not assigned before, remains &quot;gta&quot;
&quot;pes(2019)&quot; --&gt; not assigned before, remains &quot;pes(2019)&quot;
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> names = [&quot;gta&quot;,&quot;gta(1)&quot;,&quot;gta&quot;,&quot;avalon&quot;]
<strong>Output:</strong> [&quot;gta&quot;,&quot;gta(1)&quot;,&quot;gta(2)&quot;,&quot;avalon&quot;]
<strong>Explanation:</strong> Let&#39;s see how the file system creates folder names:
&quot;gta&quot; --&gt; not assigned before, remains &quot;gta&quot;
&quot;gta(1)&quot; --&gt; not assigned before, remains &quot;gta(1)&quot;
&quot;gta&quot; --&gt; the name is reserved, system adds (k), since &quot;gta(1)&quot; is also reserved, systems put k = 2. it becomes &quot;gta(2)&quot;
&quot;avalon&quot; --&gt; not assigned before, remains &quot;avalon&quot;
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> names = [&quot;onepiece&quot;,&quot;onepiece(1)&quot;,&quot;onepiece(2)&quot;,&quot;onepiece(3)&quot;,&quot;onepiece&quot;]
<strong>Output:</strong> [&quot;onepiece&quot;,&quot;onepiece(1)&quot;,&quot;onepiece(2)&quot;,&quot;onepiece(3)&quot;,&quot;onepiece(4)&quot;]
<strong>Explanation:</strong> When the last folder is created, the smallest positive valid k is 4, and it becomes &quot;onepiece(4)&quot;.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= names.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>1 &lt;= names[i].length &lt;= 20</code></li>
	<li><code>names[i]</code> consists of lowercase English letters, digits, and/or round brackets.</li>
</ul>

## Solutions

### Solution 1: Hash Table

> **Thinking**
>
> $n\le 5\times 10^4$. Assign names in order without clashes. A map stores the next suffix $k$ to try; on a collision, probe $\textit{name}(k),\textit{name}(k+1),\ldots$ until free, then bump $k$.

We can use a hash table $d$ to record the minimum available index for each folder name, where $d[\textit{name}] = k$ means the minimum available index for the folder $\textit{name}$ is $k$. Initially, $d$ is empty since there are no folders.

Next, we iterate through the folder names array. For each file name $\textit{name}$:

- If $\textit{name}$ is already in $d$, it means the folder $\textit{name}$ already exists, and we need to find a new folder name. We can keep trying $\textit{name}(k)$, where $k$ starts from $d[\textit{name}]$, until we find a folder name $\textit{name}(k)$ that does not exist in $d$. We add $\textit{name}(k)$ to $d$, update $d[\textit{name}]$ to $k + 1$, and then update $\textit{name}$ to $\textit{name}(k)$.
- If $\textit{name}$ is not in $d$, we can directly add $\textit{name}$ to $d$ and set $d[\textit{name}]$ to $1$.
- Then, we add $\textit{name}$ to the answer array and continue to the next file name.

After traversing all file names, we obtain the answer array.

> In the code implementation below, we directly modify the $\textit{names}$ array without using an extra answer array.

The time complexity is $O(L)$, and the space complexity is $O(L)$, where $L$ is the sum of the lengths of all file names in the $\textit{names}$ array.

#### Java

```java
class Solution {
    public String[] getFolderNames(String[] names) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (d.containsKey(names[i])) {
                int k = d.get(names[i]);
                while (d.containsKey(names[i] + "(" + k + ")")) {
                    ++k;
                }
                d.put(names[i], k);
                names[i] += "(" + k + ")";
            }
            d.put(names[i], 1);
        }
        return names;
    }
}
```
