# 1622. Fancy Sequence

**Difficulty:** Hard  
**Category:** Arrays, Hashing & Greedy  
**LeetCode:** https://leetcode.com/problems/fancy-sequence/

---

[中文文档](/solution/1600-1699/1622.Fancy%20Sequence/README.md)

## Description

<p>Write an API that generates fancy sequences using the <code>append</code>, <code>addAll</code>, and <code>multAll</code> operations.</p>

<p>Implement the <code>Fancy</code> class:</p>

<ul>
	<li><code>Fancy()</code> Initializes the object with an empty sequence.</li>
	<li><code>void append(val)</code> Appends an integer <code>val</code> to the end of the sequence.</li>
	<li><code>void addAll(inc)</code> Increments all existing values in the sequence by an integer <code>inc</code>.</li>
	<li><code>void multAll(m)</code> Multiplies all existing values in the sequence by an integer <code>m</code>.</li>
	<li><code>int getIndex(idx)</code> Gets the current value at index <code>idx</code> (0-indexed) of the sequence <strong>modulo</strong> <code>10<sup>9</sup> + 7</code>. If the index is greater or equal than the length of the sequence, return <code>-1</code>.</li>
</ul>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input</strong>
[&quot;Fancy&quot;, &quot;append&quot;, &quot;addAll&quot;, &quot;append&quot;, &quot;multAll&quot;, &quot;getIndex&quot;, &quot;addAll&quot;, &quot;append&quot;, &quot;multAll&quot;, &quot;getIndex&quot;, &quot;getIndex&quot;, &quot;getIndex&quot;]
[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
<strong>Output</strong>
[null, null, null, null, null, 10, null, null, null, 26, 34, 20]

<strong>Explanation</strong>
Fancy fancy = new Fancy();
fancy.append(2);   // fancy sequence: [2]
fancy.addAll(3);   // fancy sequence: [2+3] -&gt; [5]
fancy.append(7);   // fancy sequence: [5, 7]
fancy.multAll(2);  // fancy sequence: [5*2, 7*2] -&gt; [10, 14]
fancy.getIndex(0); // return 10
fancy.addAll(3);   // fancy sequence: [10+3, 14+3] -&gt; [13, 17]
fancy.append(10);  // fancy sequence: [13, 17, 10]
fancy.multAll(2);  // fancy sequence: [13*2, 17*2, 10*2] -&gt; [26, 34, 20]
fancy.getIndex(0); // return 26
fancy.getIndex(1); // return 34
fancy.getIndex(2); // return 20
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= val, inc, m &lt;= 100</code></li>
	<li><code>0 &lt;= idx &lt;= 10<sup>5</sup></code></li>
	<li>At most <code>10<sup>5</sup></code> calls total will be made to <code>append</code>, <code>addAll</code>, <code>multAll</code>, and <code>getIndex</code>.</li>
</ul>

## Solutions

### Solution 1: Segment Tree

> **Thinking**
>
> We keep appending values, then add or multiply every value already in the sequence, and query one index. There are up to $10^5$ operations, so scanning the whole sequence each time is too slow.
>
> Both updates hit the prefix that is already present, and a query asks for a single position, so a segment tree fits. Each node stores the range sum and the pending multiply and add that have not been pushed to its children.
>
> The length is at most $10^5$, so we create nodes on demand over $[1,10^5]$. `append` updates one point, `addAll` and `multAll` update the current prefix, and `getIndex` reads one point, all modulo $10^9+7$.

By the problem statement, `append` inserts a number at the end, `addAll` adds the same value to every current number, `multAll` multiplies every current number by the same value, and `getIndex` reads one position. That is range add, range multiply, and a point query, which a segment tree can maintain.

Each node stores:

- `v`: the sum of the numbers in this range;
- `mul`: a pending multiply not yet pushed to the children, initially $1$;
- `add`: a pending add not yet pushed to the children, initially $0$.

The two tags mean: every number in the range should first be multiplied by `mul`, then increased by `add`. If two updates land on the same range, we merge the tags instead of walking to the leaves. After “multiply by $m_1$ then add $a_1$” and “multiply by $m_2$ then add $a_2$”:

$$
(x \cdot m_1 + a_1)\cdot m_2 + a_2 = x\cdot (m_1 m_2) + (a_1 m_2 + a_2)
$$

so the new multiply is $m_1 m_2$ and the new add is $a_1 m_2 + a_2$.

Hence, multiplying a range by $m$ multiplies the node’s `v`, `mul`, and `add` by $m$; adding $\textit{inc}$ increases `v` by $\textit{length} \times \textit{inc}$ and `add` by $\textit{inc}$. Pushing down applies the same “multiply then add” rule to both children. In the code, add and multiply are one operation: add-only is “multiply by $1$ then add $\textit{inc}$”, and multiply-only is “multiply by $m$ then add $0$”.

Indices are $1$-based and the length is at most $10^5$, so we create nodes over $[1,10^5]$ on demand. `append` increments $n$ and adds $\textit{val}$ at position $n$; `addAll` and `multAll` update $[1,n]$; `getIndex` queries position $\textit{idx}+1$. All arithmetic is modulo $10^9+7$.

The time complexity is $O(m \log n)$, and the space complexity is $O(m \log n)$, where $m$ is the number of operations and $n \le 10^5$ is the length bound.

#### Java

```java
class Node {
    Node left;
    Node right;
    int l, r, mid;
    long v, add, mul = 1;

    Node(int l, int r) {
        this.l = l;
        this.r = r;
        this.mid = (l + r) >> 1;
    }
}

class SegmentTree {
    private static final int MOD = (int) 1e9 + 7;
    private Node root = new Node(1, (int) 1e5 + 1);

    void modify(int l, int r, int mul, int add) {
        modify(l, r, mul, add, root);
    }

    void modify(int l, int r, int mul, int add, Node node) {
        if (l > r) {
            return;
        }
        if (node.l >= l && node.r <= r) {
            apply(node, mul, add);
            return;
        }
        pushdown(node);
        if (l <= node.mid) {
            modify(l, r, mul, add, node.left);
        }
        if (r > node.mid) {
            modify(l, r, mul, add, node.right);
        }
        pushup(node);
    }

    int query(int l, int r) {
        return query(l, r, root);
    }

    int query(int l, int r, Node node) {
        if (l > r) {
            return 0;
        }
        if (node.l >= l && node.r <= r) {
            return (int) node.v;
        }
        pushdown(node);
        int v = 0;
        if (l <= node.mid) {
            v = (v + query(l, r, node.left)) % MOD;
        }
        if (r > node.mid) {
            v = (v + query(l, r, node.right)) % MOD;
        }
        return v;
    }

    void apply(Node node, long mul, long add) {
        node.v = (node.v * mul + (node.r - node.l + 1) * add) % MOD;
        node.add = (node.add * mul + add) % MOD;
        node.mul = node.mul * mul % MOD;
    }

    void pushup(Node node) {
        node.v = (node.left.v + node.right.v) % MOD;
    }

    void pushdown(Node node) {
        if (node.left == null) {
            node.left = new Node(node.l, node.mid);
        }
        if (node.right == null) {
            node.right = new Node(node.mid + 1, node.r);
        }
        if (node.add != 0 || node.mul != 1) {
            apply(node.left, node.mul, node.add);
            apply(node.right, node.mul, node.add);
            node.add = 0;
            node.mul = 1;
        }
    }
}

class Fancy {
    private int n;
    private SegmentTree tree = new SegmentTree();

    public void append(int val) {
        ++n;
        tree.modify(n, n, 1, val);
    }

    public void addAll(int inc) {
        tree.modify(1, n, 1, inc);
    }

    public void multAll(int m) {
        tree.modify(1, n, m, 0);
    }

    public int getIndex(int idx) {
        return idx >= n ? -1 : tree.query(idx + 1, idx + 1);
    }
}
```

### Solution 2: Math + Modular Inverse

> **Thinking**
>
> The segment tree still walks $O(\log n)$ nodes on every update. `addAll` and `multAll` always hit every number already in the sequence, and a newly appended number is not changed by earlier adds or multiplies.
>
> So every number already present will go through the same later adds and multiplies. We only need two global variables: how much those numbers should still be multiplied by, and how much should then be added. The array stores the value before those operations; a query multiplies and adds to recover the true value. The modulus is prime, so division by $a$ becomes multiplication by the modular inverse (Fermat’s little theorem).

Every `addAll` and `multAll` applies to all numbers that exist at that moment, and a number appended later is not affected by earlier updates. Therefore the pending multiply and add for every current number can be described by two global variables: multiply by $a$, then add $b$. Initially $a=1$ and $b=0$.

The array $\textit{nums}$ does not store the current true values. It stores the values before multiplying by $a$ and adding $b$, so that at any time

$$
\text{true value} = (a \times \textit{nums}[i] + b) \bmod (10^9+7)
$$

The operations then become:

- `append(val)`: this new number has not gone through the current $a$ and $b$, so we store an $x$ with $a \times x + b = \textit{val}$, i.e. $x = (\textit{val} - b) \times a^{-1}$;
- `addAll(inc)`: every true value increases by $\textit{inc}$, so we add $\textit{inc}$ to $b$;
- `multAll(m)`: every true value is multiplied by $m$, so both $a$ and $b$ are multiplied by $m$;
- `getIndex(idx)`: return $-1$ if the index is out of range, otherwise $a \times \textit{nums}[\textit{idx}] + b$.

Here $a^{-1}$ is the modular inverse of $a$ modulo $10^9+7$. The modulus is prime, so Fermat’s little theorem gives $a^{-1} \equiv a^{\textit{MOD}-2} \pmod{\textit{MOD}}$.

All operations except the inverse in $\textit{append}$ run in $O(1)$ time; the inverse is $O(\log \textit{MOD})$. The space complexity is $O(n)$.

#### Java

```java
class Fancy {
    private static final int MOD = (int) 1e9 + 7;
    private List<Integer> nums = new ArrayList<>();
    private long a = 1, b;

    public void append(int val) {
        long x = (val - b + MOD) % MOD * qpow(a, MOD - 2) % MOD;
        nums.add((int) x);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = a * m % MOD;
        b = b * m % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) {
            return -1;
        }
        return (int) ((a * nums.get(idx) + b) % MOD);
    }

    private long qpow(long x, int n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }
}
```
