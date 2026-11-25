package com.dsamastery.trees;

import java.util.*;

public class AProgramToCheck {

    METHOD 1 (Simple but Wrong)
    int isBST(static class node* node)
    {
    if (node == null)
    return 1;
    /* false if left is > than node */
    if (node.left != null && node.left.data > node.data)
    return 0;
    /* false if right is < than node */
    if (node.right != null && node.right.data < node.data)
    return 0;
    /* false if, recursively, the left or right is not a BST */
    if (!isBST(node.left) || !isBST(node.right))
    return 0;
    /* passing all that, it's a BST */
    return 1;
    }
    METHOD 2 (Correct but not eﬃcient)
    /* Returns true if a binary tree is a binary search tree */
    int isBST(static class node* node)
    {
    if (node == null)
    return(true);
    /* false if the max of the left is > than us */
    if (node.left!=null && maxValue(node.left) > node.data)
    return(false);
    /* false if the min of the right is <= than us */
    if (node.right!=null && minValue(node.right) < node.data)
    return(false);
    /* false if, recursively, the left or right is not a BST */
    if (!isBST(node.left) || !isBST(node.right))
    return(false);
    /* passing all that, it's a BST */
    return(true);
    }
    METHOD 3 (Correct and Eﬃcient)
    int min, int max) that traverses down the tree keeping track of the narrowing min and max allowed values
    /* Returns true if the given tree is a binary search tree
    (efficient version). */
    int isBST(static class node* node)
    {
    return(isBSTUtil(node, INT_MIN, INT_MAX));
    }
    /* Returns true if the given tree is a BST and its
    values are >= min and
    Implementation:
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    int isBSTUtil(static class node* node, int min, int max);
    /* Returns true if the given tree is a binary search tree
    (efficient version). */
    int isBST(static class node* node)
    {
    return(isBSTUtil(node, INT_MIN, INT_MAX));
    }
    /* Returns true if the given tree is a BST and its
    values are >= min and <= max. */
    int isBSTUtil(static class node* node, int min, int max)
    {
    /* an empty tree is BST */
    if (node==null)
    return 1;
    /* false if this node violates the min/max constraint */
    if (node.data < min || node.data > max)
    return 0;
    /* otherwise check the subtrees recursively,
    tightening the min or max constraint */
    return
    isBSTUtil(node.left, min, node.data-1) && // Allow only distinct values
    isBSTUtil(node.right, node.data+1, max); // Allow only distinct values
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(4);
    root.left = newNode(2);
    root.right = newNode(5);
    root.left.left = newNode(1);
    root.left.right = newNode(3);
    if(isBST(root))
    System.out.printf("Is BST");
    else
    System.out.printf("Not a BST");
    getchar();
    return 0;
    }
    METHOD 4(Using In-Order Traversal)
    boolean isBST(static class node* root)
    {
    static static class node *prev = null;
    // traverse the tree in inorder fashion and keep track of prev node
    if (root)
    {
    if (!isBST(root.left))
    return false;
    // Allows only distinct valued nodes
    if (prev != null && root.data <= prev.data)
    return false;
    prev = root;
    return isBST(root.right);
    }
    return true;
    }
}
