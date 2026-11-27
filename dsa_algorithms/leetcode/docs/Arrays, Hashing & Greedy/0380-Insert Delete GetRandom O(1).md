# 380. Insert Delete GetRandom O(1)

**Difficulty:** Medium  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/insert-delete-getrandom-o1/

---

[中文文档](/solution/0300-0399/0380.Insert%20Delete%20GetRandom%20O%281%29/README.md)

## Description

<p>Implement the <code>RandomizedSet</code> class:</p>

<ul>
	<li><code>RandomizedSet()</code> Initializes the <code>RandomizedSet</code> object.</li>
	<li><code>bool insert(int val)</code> Inserts an item <code>val</code> into the set if not present. Returns <code>true</code> if the item was not present, <code>false</code> otherwise.</li>
	<li><code>bool remove(int val)</code> Removes an item <code>val</code> from the set if present. Returns <code>true</code> if the item was present, <code>false</code> otherwise.</li>
	<li><code>int getRandom()</code> Returns a random element from the current set of elements (it&#39;s guaranteed that at least one element exists when this method is called). Each element must have the <b>same probability</b> of being returned.</li>
</ul>

<p>You must implement the functions of the class such that each function works in <strong>average</strong> <code>O(1)</code> time complexity.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;RandomizedSet&quot;, &quot;insert&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;, &quot;remove&quot;, &quot;insert&quot;, &quot;getRandom&quot;]
[[], [1], [2], [2], [], [1], [2], []]
<strong>Output</strong>
[null, true, false, true, 2, true, false, 2]

<strong>Explanation</strong>
RandomizedSet randomizedSet = new RandomizedSet();
randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
randomizedSet.insert(2); // 2 was already in the set, so return false.
randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>-2<sup>31</sup> &lt;= val &lt;= 2<sup>31</sup> - 1</code></li>
	<li>At most <code>2 *&nbsp;10<sup>5</sup></code> calls will be made to <code>insert</code>, <code>remove</code>, and <code>getRandom</code>.</li>
	<li>There will be <strong>at least one</strong> element in the data structure when <code>getRandom</code> is called.</li>
</ul>

## Solutions

### Solution 1: Hash Table + Dynamic List

> **Thinking**
>
> A set with insert, delete, and uniform random, all $O(1)$. A hash map alone has no index; an array alone deletes in $O(n)$.
>
> The array holds values, the map holds indices. Insert appends; delete swaps with the last element, pops, and repairs that index. Random is `choice` on the array.

We define a dynamic list $q$ to store the elements in the set, and a hash table $d$ to store the index of each element in $q$.

When inserting an element, if the element already exists in the hash table $d$, return `false` directly; otherwise, we insert the element into the end of the dynamic list $q$, and insert the element and its index in $q$ into the hash table $d$ at the same time, and finally return `true`.

When deleting an element, if the element does not exist in the hash table $d$, return `false` directly; otherwise, we obtain the index of the element in the list $q$ from the hash table, then swap the last element $q[-1]$ in the list $q$ with $q[i]$, and then update the index of $q[-1]$ in the hash table to $i$. Then delete the last element in $q$, and remove the element from the hash table at the same time, and finally return `true`.

When getting a random element, we can randomly select an element from the dynamic list $q$ and return it.

The time complexity is $O(1)$, and the space complexity is $O(n)$, where $n$ is the number of elements in the set.

#### Java

```java
class RandomizedSet {
    private Map<Integer, Integer> d = new HashMap<>();
    private List<Integer> q = new ArrayList<>();
    private Random rnd = new Random();

    public RandomizedSet() {
    }

    public boolean insert(int val) {
        if (d.containsKey(val)) {
            return false;
        }
        d.put(val, q.size());
        q.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!d.containsKey(val)) {
            return false;
        }
        int i = d.get(val);
        d.put(q.get(q.size() - 1), i);
        q.set(i, q.get(q.size() - 1));
        q.remove(q.size() - 1);
        d.remove(val);
        return true;
    }

    public int getRandom() {
        return q.get(rnd.nextInt(q.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
```
