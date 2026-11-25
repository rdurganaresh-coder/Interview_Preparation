package com.dsamastery.trees;

import java.util.*;

public class RemoveAllNodesWhich {

    / \
    / \ / \
    / \ \
    / \
    / \ \
    / \ \
    \
    \
    return the sum back to the previous node. Since the path is from root to leaf and nodes are deleted in
    // A utility function to get maximum of two integers
    int max(int l, int r) { return (l > r ? l : r); }
    // A Binary Tree Node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to create a new Binary Tree node with given data
    static class Node* newNode(int data)
    {
    static class Node* node = (static class Node*) malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // print the tree in LVR (Inorder traversal) way.
    void print(static class Node *root)
    {
    if (root != null)
    {
    print(root.left);
    System.out.printf("%d ",root.data);
    print(root.right);
    }
    }
    /* Main function which truncates the binary tree. */
    static class Node *pruneUtil(static class Node *root, int k, int *sum)
    {
    // Base Case
    if (root == null) return null;
    // Initialize left and right sums as sum from root to
    // this node (including this node)
    int lsum = *sum + (root.data);
    int rsum = lsum;
    // Recursively prune left and right subtrees
    root.left = pruneUtil(root.left, k, &lsum);
    root.right = pruneUtil(root.right, k, &rsum);
    // Get the maximum of left and right sums
    *sum = max(lsum, rsum);
    // If maximum is smaller than k, then this node
    // must be deleted
    if (*sum < k)
    {
    free(root);
    root = null;
    }
    return root;
    }
    // A wrapper over pruneUtil()
    static class Node *prune(static class Node *root, int k)
    {
    int sum = 0;
    return pruneUtil(root, k, &sum);
    }
    // Driver program to test above function
    int main()
    {
    int k = 45;
    static class Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.left.left.left = newNode(8);
    root.left.left.right = newNode(9);
    root.left.right.left = newNode(12);
    root.right.right.left = newNode(10);
    root.right.right.left.right = newNode(11);
    root.left.left.right.left = newNode(13);
    root.left.left.right.right = newNode(14);
    root.left.left.right.right.left = newNode(15);
    System.out.printf("Tree before truncation\n");
    print(root);
    root = prune(root, k); // k is 45
    System.out.printf("\n\nTree after truncation\n");
    print(root);
    return 0;
    }
    // A Binary Tree Node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to create a new Binary
    // Tree node with given data
    static class Node* newNode(int data)
    {
    static class Node* node =
    (static class Node*) malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // print the tree in LVR (Inorder traversal) way.
    void print(static class Node *root)
    {
    if (root != null)
    {
    print(root.left);
    System.out.printf("%d ",root.data);
    print(root.right);
    }
    }
    /* Main function which truncates the binary tree. */
    static class Node *prune(static class Node *root, int sum)
    {
    // Base Case
    if (root == null) return null;
    // Recur for left and right subtrees
    root.left = prune(root.left, sum - root.data);
    root.right = prune(root.right, sum - root.data);
    // If we reach leaf whose data is smaller than sum,
    // we delete the leaf. An important thing to note
    // is a non-leaf node can become leaf when its
    // chilren are deleted.
    if (root.left==null && root.right==null)
    {
    if (root.data < sum)
    {
    free(root);
    return null;
    }
    }
    return root;
    }
    // Driver program to test above function
    int main()
    {
    int k = 45;
    static class Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.left.left.left = newNode(8);
    root.left.left.right = newNode(9);
    root.left.right.left = newNode(12);
    root.right.right.left = newNode(10);
    root.right.right.left.right = newNode(11);
    root.left.left.right.left = newNode(13);
    root.left.left.right.right = newNode(14);
    root.left.left.right.right.left = newNode(15);
    System.out.printf("Tree before truncation\n");
    print(root);
    root = prune(root, k); // k is 45
    System.out.printf("\n\nTree after truncation\n");
    print(root);
    return 0;
    }
}
