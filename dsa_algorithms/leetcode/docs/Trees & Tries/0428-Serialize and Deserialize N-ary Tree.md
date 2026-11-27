# 428. Serialize and Deserialize N-ary Tree

**Difficulty:** Hard  
**Category:** Trees & Tries  
**LeetCode:** https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/

---

[中文文档](/solution/0400-0499/0428.Serialize%20and%20Deserialize%20N-ary%20Tree/README.md)

## Description

<p>Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.</p>

<p>Design an algorithm to serialize and deserialize an N-ary tree. An N-ary tree is a rooted tree in which each node has no more than N children. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that an N-ary tree can be serialized to a string and this string can be deserialized to the original tree structure.</p>

<p>For example, you may serialize the following <code>3-ary</code> tree</p>
<img src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0428.Serialize%20and%20Deserialize%20N-ary%20Tree/images/narytreeexample.png" style="width: 500px; max-width: 300px; height: 321px;" />
<p>&nbsp;</p>

<p>as <code>[1 [3[5 6] 2 4]]</code>. Note that this is just an example, you do not necessarily need to follow this format.</p>

<p>Or you can follow LeetCode&#39;s level order traversal serialization format, where each group of children is separated by the null value.</p>
<img alt="" src="https://fastly.jsdelivr.net/gh/doocs/leetcode@main/solution/0400-0499/0428.Serialize%20and%20Deserialize%20N-ary%20Tree/images/sample_4_964.png" style="width: 500px; height: 454px;" />
<p>&nbsp;</p>

<p>For example, the above tree may be serialized as <code>[1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]</code>.</p>

<p>You do not necessarily need to follow the above-suggested formats, there are many more different formats that work so please be creative and come up with different approaches yourself.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
<strong>Output:</strong> [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre>
<strong>Input:</strong> root = [1,null,3,2,4,null,5,6]
<strong>Output:</strong> [1,null,3,2,4,null,5,6]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre>
<strong>Input:</strong> root = []
<strong>Output:</strong> []
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li>The number of nodes in the tree is in the range <code>[0, 10<sup>4</sup>]</code>.</li>
	<li><code>0 &lt;= Node.val &lt;= 10<sup>4</sup></code></li>
	<li>The height of the n-ary tree is less than or equal to <code>1000</code></li>
	<li>Do not use class member/global/static variables to store states. Your encode and decode algorithms should be stateless.</li>
</ul>

## Solutions

### Solution 1: Level Order Traversal

> **Thinking**
>
> An $N$-ary node has a variable number of children, so a value-only preorder cannot tell where a child list ends. A terminator after each list is required.
>
> Serialize in level order: write the root, then when a node is popped write its children and enqueue them, and finally write $\#$. Deserialize with the same queue: a node keeps taking the next tokens as children until $\#$.
>
> The sentinel lines up with the dequeue order, so every child list can be rebuilt; an empty tree is the empty string.

We can serialize an N-ary tree with level order traversal. Start from the root, append its value, and enqueue it. Each time we dequeue a node, we append the values of all its children and enqueue them, then append a special character `#` to mark the end of that node's children. Finally we join the values with commas.

During deserialization, we split the string by the delimiter. Create the root from the first value and enqueue it. For each dequeued node, keep reading the following values as its children until we meet `#`.

The time complexity is $O(n)$, and the space complexity is $O(n)$, where $n$ is the number of nodes in the N-ary tree.

#### Java

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Codec {
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }
        List<String> ans = new ArrayList<>();
        Deque<Node> q = new ArrayDeque<>();
        ans.add(String.valueOf(root.val));
        q.offer(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.children != null) {
                for (Node child : node.children) {
                    ans.add(String.valueOf(child.val));
                    q.offer(child);
                }
            }
            ans.add("#");
        }
        return String.join(",", ans);
    }

    public Node deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] vals = data.split(",");
        Node root = new Node(Integer.parseInt(vals[0]), new ArrayList<>());
        Deque<Node> q = new ArrayDeque<>();
        q.offer(root);
        int i = 1;
        while (!q.isEmpty()) {
            Node node = q.poll();
            while (!"#".equals(vals[i])) {
                Node child = new Node(Integer.parseInt(vals[i++]), new ArrayList<>());
                node.children.add(child);
                q.offer(child);
            }
            ++i;
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```
