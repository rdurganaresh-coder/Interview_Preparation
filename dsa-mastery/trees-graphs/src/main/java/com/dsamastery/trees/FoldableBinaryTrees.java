package com.dsamastery.trees;

import java.util.*;

public class FoldableBinaryTrees {

    / \
    / \
    / \
    / \
    / \
    Method 1 (Change Left subtree to its Mirror and compare it with Right subtree)
    mirror(root.left); /* See this post */
    res = isStructSame(root.left, root.right); /*isStructSame()
    recursively compares structures of two subtrees and returns
    true if structures are same */
    mirror(root.left);
    /* You would want to remove below 3 lines if your compiler
    supports boolean, true and false */
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* converts a tree to its mrror image */
    void mirror(static class node* node);
    /* returns true if structure of two trees a and b is same
    Only structure is considered for comparison, not data! */
    boolean isStructSame(static class node *a, static class node *b);
    /* Returns true if the given tree is foldable */
    boolean isFoldable(static class node *root)
    {
    boolean res;
    /* base case */
    if(root == null)
    return true;
    /* convert left subtree to its mirror */
    mirror(root.left);
    /* Compare the structures of the right subtree and mirrored
    left subtree */
    res = isStructSame(root.left, root.right);
    /* Get the originial tree back */
    mirror(root.left);
    return res;
    }
    boolean isStructSame(static class node *a, static class node *b)
    {
    if (a == null && b == null)
    { return true; }
    if ( a != null && b != null &&
    isStructSame(a.left, b.left) &&
    isStructSame(a.right, b.right)
    )
    { return true; }
    return false;
    }
    /* UTILITY FUNCTIONS */
    /* Change a tree so that the roles of the left and
    right pointers are swapped at every node.
    See http://geeksforgeeks.org/?p=662 for details */
    void mirror(static class node* node)
    {
    if (node==null)
    return;
    else
    {
    static class node* temp;
    /* do the subtrees */
    mirror(node.left);
    mirror(node.right);
    /* swap the pointers in this node */
    temp = node.left;
    node.left = node.right;
    node.right = temp;
    }
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
    /* Driver program to test mirror() */
    int main(void)
    {
    /* The constructed binary tree is
    / \
    2 3
    \ /
    4 5
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.right.left = newNode(4);
    root.left.right = newNode(5);
    if(isFoldable(root) == 1)
    { System.out.printf("\n tree is foldable"); }
    else
    { System.out.printf("\n tree is not foldable"); }
    getchar();
    return 0;
    }
    Method 2 (Check if Left and Right subtrees are Mirror)
    // Checks if tree can be folded or not
    IsFoldable(root)
    // Checks if n1 and n2 are mirror of each other.
    IsFoldableUtil(n1, n2)
    /* You would want to remove below 3 lines if your compiler
    supports boolean, true and false */
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* A utility function that checks if trees with roots as n1 and n2
    are mirror of each other */
    boolean IsFoldableUtil(static class node *n1, static class node *n2);
    /* Returns true if the given tree can be folded */
    boolean IsFoldable(static class node *root)
    {
    if (root == null)
    { return true; }
    return IsFoldableUtil(root.left, root.right);
    }
    /* A utility function that checks if trees with roots as n1 and n2
    are mirror of each other */
    boolean IsFoldableUtil(static class node *n1, static class node *n2)
    {
    /* If both left and right subtrees are null,
    then return true */
    if (n1 == null && n2 == null)
    { return true; }
    /* If one of the trees is null and other is not,
    then return false */
    if (n1 == null || n2 == null)
    { return false; }
    /* Otherwise check if left and right subtrees are mirrors of
    their counterparts */
    return IsFoldableUtil(n1.left, n2.right) &&
    IsFoldableUtil(n1.right, n2.left);
    }
    /*UTILITY FUNCTIONS */
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
    /* Driver program to test mirror() */
    int main(void)
    {
    /* The constructed binary tree is
    / \
    2 3
    \ /
    4 5
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.right = newNode(4);
    root.right.left = newNode(5);
    if(IsFoldable(root) == true)
    { System.out.printf("\n tree is foldable"); }
    else
    { System.out.printf("\n tree is not foldable"); }
    getchar();
    return 0;
    }
}
