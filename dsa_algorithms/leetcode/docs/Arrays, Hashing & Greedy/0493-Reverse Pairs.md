# 493. Reverse Pairs

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/reverse-pairs/

---

[中文文档](/solution/0400-0499/0493.Reverse%20Pairs/README.md)

## Description

<p>Given an integer array <code>nums</code>, return <em>the number of <strong>reverse pairs</strong> in the array</em>.</p>

<p>A <strong>reverse pair</strong> is a pair <code>(i, j)</code> where:</p>

<ul>
	<li><code>0 &lt;= i &lt; j &lt; nums.length</code> and</li>
	<li><code>nums[i] &gt; 2 * nums[j]</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> nums = [1,3,2,3,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> The reverse pairs are:
(1, 4) --&gt; nums[1] = 3, nums[4] = 1, 3 &gt; 2 * 1
(3, 4) --&gt; nums[3] = 3, nums[4] = 1, 3 &gt; 2 * 1
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> nums = [2,4,3,5,1]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The reverse pairs are:
(1, 4) --&gt; nums[1] = 4, nums[4] = 1, 4 &gt; 2 * 1
(2, 4) --&gt; nums[2] = 3, nums[4] = 1, 3 &gt; 2 * 1
(3, 4) --&gt; nums[3] = 5, nums[4] = 1, 5 &gt; 2 * 1
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>

## Solutions

### Solution 1

> **Thinking**
>
> A reverse pair is $i<j$ and $\textit{nums}[i]>2\,\textit{nums}[j]$. A double loop is $O(n^2)$. During mergesort both halves are sorted, so cross pairs can be counted before merging.
>
> Recurse on both halves, then for each right value advance a left pointer until $\textit{nums}[i]>2\,\textit{nums}[j]$; the leftover left side all form pairs. Merge by raw value afterwards.
>
> Counting and merging stay separate: the count compares against $2\,\textit{nums}[j]$, the merge compares the original values.

#### Java

```java
class Solution {
    private int[] nums;
    private int[] t;

    public int reversePairs(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.t = new int[n];
        return mergeSort(0, n - 1);
    }

    private int mergeSort(int l, int r) {
        if (l >= r) {
            return 0;
        }
        int mid = (l + r) >> 1;
        int ans = mergeSort(l, mid) + mergeSort(mid + 1, r);
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j] * 2L) {
                ++i;
            } else {
                ans += mid - i + 1;
                ++j;
            }
        }
        i = l;
        j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) {
                t[k++] = nums[i++];
            } else {
                t[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            t[k++] = nums[i++];
        }
        while (j <= r) {
            t[k++] = nums[j++];
        }
        for (i = l; i <= r; ++i) {
            nums[i] = t[i - l];
        }
        return ans;
    }
}
```

### Solution 2

> **Thinking**
>
> Solution 1 rewrites the array. After discretizing $\textit{nums}$ and $2\,\textit{nums}$, walk right to left, insert $2\,\textit{nums}[j]$ into a Fenwick tree, and query how many inserted values are less than $\textit{nums}[i]$.
>
> The relative order of the original array is not needed beyond the right-to-left scan; the tree stores the $2\,\textit{nums}$ already seen.

#### Java

```java
class Solution {
    public int reversePairs(int[] nums) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add((long) num);
            ts.add((long) num * 2);
        }
        Map<Long, Integer> m = new HashMap<>();
        int idx = 0;
        for (long num : ts) {
            m.put(num, ++idx);
        }
        BinaryIndexedTree tree = new BinaryIndexedTree(m.size());
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int x = m.get((long) nums[i]);
            ans += tree.query(x - 1);
            tree.update(m.get((long) nums[i] * 2), 1);
        }
        return ans;
    }
}

class BinaryIndexedTree {
    private int n;
    private int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= lowbit(x);
        }
        return s;
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}
```

### Solution 3

> **Thinking**
>
> Replace the Fenwick tree with a segment tree: same discretization, insert $2\,\textit{nums}$ from the right, query the count below $\textit{nums}[i]$. Same algebra, with explicit interval nodes.

#### Java

```java
class Solution {
    public int reversePairs(int[] nums) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int num : nums) {
            ts.add((long) num);
            ts.add((long) num * 2);
        }
        Map<Long, Integer> m = new HashMap<>();
        int idx = 0;
        for (long num : ts) {
            m.put(num, ++idx);
        }
        SegmentTree tree = new SegmentTree(m.size());
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int x = m.get((long) nums[i]);
            ans += tree.query(1, 1, x - 1);
            tree.modify(1, m.get((long) nums[i] * 2), 1);
        }
        return ans;
    }
}

class Node {
    int l;
    int r;
    int v;
}

class SegmentTree {
    private Node[] tr;

    public SegmentTree(int n) {
        tr = new Node[4 * n];
        for (int i = 0; i < tr.length; ++i) {
            tr[i] = new Node();
        }
        build(1, 1, n);
    }

    public void build(int u, int l, int r) {
        tr[u].l = l;
        tr[u].r = r;
        if (l == r) {
            return;
        }
        int mid = (l + r) >> 1;
        build(u << 1, l, mid);
        build(u << 1 | 1, mid + 1, r);
    }

    public void modify(int u, int x, int v) {
        if (tr[u].l == x && tr[u].r == x) {
            tr[u].v += v;
            return;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        if (x <= mid) {
            modify(u << 1, x, v);
        } else {
            modify(u << 1 | 1, x, v);
        }
        pushup(u);
    }

    public void pushup(int u) {
        tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
    }

    public int query(int u, int l, int r) {
        if (tr[u].l >= l && tr[u].r <= r) {
            return tr[u].v;
        }
        int mid = (tr[u].l + tr[u].r) >> 1;
        int v = 0;
        if (l <= mid) {
            v += query(u << 1, l, r);
        }
        if (r > mid) {
            v += query(u << 1 | 1, l, r);
        }
        return v;
    }
}
```
