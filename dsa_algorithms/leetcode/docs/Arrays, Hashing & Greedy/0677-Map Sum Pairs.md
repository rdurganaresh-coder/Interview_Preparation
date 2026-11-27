# 677. Map Sum Pairs

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/map-sum-pairs/

---

[中文文档](/solution/0600-0699/0677.Map%20Sum%20Pairs/README.md)

## Description

<p>Design a map that allows you to do the following:</p>

<ul>
	<li>Maps a string key to a given value.</li>
	<li>Returns the sum of the values that have a key with a prefix equal to a given string.</li>
</ul>

<p>Implement the <code>MapSum</code> class:</p>

<ul>
	<li><code>MapSum()</code> Initializes the <code>MapSum</code> object.</li>
	<li><code>void insert(String key, int val)</code> Inserts the <code>key-val</code> pair into the map. If the <code>key</code> already existed, the original <code>key-value</code> pair will be overridden to the new one.</li>
	<li><code>int sum(string prefix)</code> Returns the sum of all the pairs&#39; value whose <code>key</code> starts with the <code>prefix</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MapSum&quot;, &quot;insert&quot;, &quot;sum&quot;, &quot;insert&quot;, &quot;sum&quot;]
[[], [&quot;apple&quot;, 3], [&quot;ap&quot;], [&quot;app&quot;, 2], [&quot;ap&quot;]]
<strong>Output</strong>
[null, null, 3, null, 5]

<strong>Explanation</strong>
MapSum mapSum = new MapSum();
mapSum.insert(&quot;apple&quot;, 3);  
mapSum.sum(&quot;ap&quot;);           // return 3 (<u>ap</u>ple = 3)
mapSum.insert(&quot;app&quot;, 2);    
mapSum.sum(&quot;ap&quot;);           // return 5 (<u>ap</u>ple + <u>ap</u>p = 3 + 2 = 5)
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= key.length, prefix.length &lt;= 50</code></li>
	<li><code>key</code> and <code>prefix</code> consist of only lowercase English letters.</li>
	<li><code>1 &lt;= val &lt;= 1000</code></li>
	<li>At most <code>50</code> calls will be made to <code>insert</code> and <code>sum</code>.</li>
</ul>

## Solutions

### Solution 1: Hash Table + Trie

> **Thinking**
>
> `sum(prefix)` needs the total of keys with that prefix, and `insert` overwrites. Scanning every key is linear in the map size.
>
> Trie nodes store subtree sums. Insert adds $\Delta=\textit{val}-\textit{old}$ along the path; `sum` returns the node at the prefix. A hash map keeps the previous value.

We use a hash table $d$ to store key-value pairs and a trie $t$ to store the prefix sums of the key-value pairs. Each node in the trie contains two pieces of information:

- $\textit{val}$: the total sum of the values of the key-value pairs with this node as the prefix
- `children`: an array of length $26$ that stores the child nodes of this node

When inserting a key-value pair $(\textit{key}, \textit{val})$, we first check if the key exists in the hash table. If it does, the $\textit{val}$ of each node in the trie needs to subtract the original value of the key and then add the new value. If it does not exist, the $\textit{val}$ of each node in the trie needs to add the new value.

When querying the prefix sum, we start from the root node of the trie and traverse the prefix string. If the current node's child nodes do not contain the character, it means the prefix does not exist in the trie, and we return $0$. Otherwise, we continue to traverse the next character until we finish traversing the prefix string and return the $\textit{val}$ of the current node.

In terms of time complexity, the time complexity of inserting a key-value pair is $O(n)$, where $n$ is the length of the key. The time complexity of querying the prefix sum is $O(m)$, where $m$ is the length of the prefix.

The space complexity is $O(nm \times C)$, where $n$ and $m$ are the number of keys and the maximum length of the keys, respectively; and $C$ is the size of the character set, which is $26$ in this problem.

#### Java

```java
class Trie {
    private Trie[] children = new Trie[26];
    private int val;

    public void insert(String w, int x) {
        Trie node = this;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new Trie();
            }
            node = node.children[idx];
            node.val += x;
        }
    }

    public int search(String w) {
        Trie node = this;
        for (int i = 0; i < w.length(); ++i) {
            int idx = w.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return 0;
            }
            node = node.children[idx];
        }
        return node.val;
    }
}

class MapSum {
    private Map<String, Integer> d = new HashMap<>();
    private Trie trie = new Trie();

    public MapSum() {
    }

    public void insert(String key, int val) {
        int x = val - d.getOrDefault(key, 0);
        d.put(key, val);
        trie.insert(key, x);
    }

    public int sum(String prefix) {
        return trie.search(prefix);
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
```
