# 705. Design HashSet

**Difficulty:** Easy  
**Category:** Design & Data Structures  
**LeetCode:** https://leetcode.com/problems/design-hashset/

---

[中文文档](/solution/0700-0799/0705.Design%20HashSet/README.md)

## Description

<p>Design a HashSet without using any built-in hash table libraries.</p>

<p>Implement <code>MyHashSet</code> class:</p>

<ul>
	<li><code>void add(key)</code> Inserts the value <code>key</code> into the HashSet.</li>
	<li><code>bool contains(key)</code> Returns whether the value <code>key</code> exists in the HashSet or not.</li>
	<li><code>void remove(key)</code> Removes the value <code>key</code> in the HashSet. If <code>key</code> does not exist in the HashSet, do nothing.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;MyHashSet&quot;, &quot;add&quot;, &quot;add&quot;, &quot;contains&quot;, &quot;contains&quot;, &quot;add&quot;, &quot;contains&quot;, &quot;remove&quot;, &quot;contains&quot;]
[[], [1], [2], [1], [3], [2], [2], [2], [2]]
<strong>Output</strong>
[null, null, null, true, false, null, true, null, false]

<strong>Explanation</strong>
MyHashSet myHashSet = new MyHashSet();
myHashSet.add(1);      // set = [1]
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(1); // return True
myHashSet.contains(3); // return False, (not found)
myHashSet.add(2);      // set = [1, 2]
myHashSet.contains(2); // return True
myHashSet.remove(2);   // set = [1]
myHashSet.contains(2); // return False, (already removed)</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>0 &lt;= key &lt;= 10<sup>6</sup></code></li>
	<li>At most <code>10<sup>4</sup></code> calls will be made to <code>add</code>, <code>remove</code>, and <code>contains</code>.</li>
</ul>

## Solutions

### Solution 1: Static Array Implementation

> **Thinking**
>
> Implement a set of keys in $[0, 10^6]$ with at most $10^4$ operations. A library map would work, but the point is to design the store.
>
> Keys are already non-negative integers with a fixed bound, so they can be indices. A boolean array of length $10^6+1$ turns add, remove, and contains into a single write or read.
>
> Space follows the value range rather than the number of keys; that is acceptable under these limits.

Directly create an array of size $1000001$, initially with each element set to `false`, indicating that the element does not exist in the hash set.

When adding an element to the hash set, set the corresponding position in the array to `true`; when deleting an element, set the corresponding position in the array to `false`; when checking if an element exists, directly return the value at the corresponding position in the array.

The time complexity of the above operations is $O(1)$.

#### Java

```java
class MyHashSet {
    private boolean[] data = new boolean[1000001];

    public MyHashSet() {
    }

    public void add(int key) {
        data[key] = true;
    }

    public void remove(int key) {
        data[key] = false;
    }

    public boolean contains(int key) {
        return data[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```

### Solution 2: Array of Linked Lists

> **Thinking**
>
> Solution 1 buys $O(1)$ with an array as large as the key universe; most of that space stays unused when few keys appear.
>
> Hash by a smaller modulus into a fixed number of buckets, and store collisions in a list. Each operation hashes, then scans one short bucket.
>
> With $\textit{SIZE}=1000$ the memory follows the bucket count, and the expected cost stays near constant.

We can also create an array of size $\textit{SIZE}=1000$, where each position in the array is a linked list.

#### Java

```java
class MyHashSet {
    private static final int SIZE = 1000;
    private LinkedList[] data;

    public MyHashSet() {
        data = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; ++i) {
            data[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        if (contains(key)) {
            return;
        }
        int idx = hash(key);
        data[idx].addFirst(key);
    }

    public void remove(int key) {
        if (!contains(key)) {
            return;
        }
        int idx = hash(key);
        data[idx].remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Iterator<Integer> it = data[idx].iterator();
        while (it.hasNext()) {
            Integer e = it.next();
            if (e == key) {
                return true;
            }
        }
        return false;
    }

    private int hash(int key) {
        return key % SIZE;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
```
