package com.dsamastery.trees;

import java.util.*;

public class InorderSuccessorInBinary {

    Method 1 (Uses Parent Pointer)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    static class node* parent;
    };
    static class node * minValue(static class node* node);
    static class node * inOrderSuccessor(static class node *root, static class node *n)
    {
    // step 1 of the above algorithm
    if( n.right != null )
    return minValue(n.right);
    // step 2 of the above algorithm
    static class node *p = n.parent;
    while(p != null && n == p.right)
    {
    n = p;
    p = p.parent;
    }
    return p;
    }
    /* Given a non-empty binary search tree, return the minimum data
    value found in that tree. Note that the entire tree does not need
    to be searched. */
    static class node * minValue(static class node* node) {
    static class node* current = node;
    /* loop down to find the leftmost leaf */
    while (current.left != null) {
    current = current.left;
    }
    return current;
    }
    /* Helper function that allocates a new node with the given data and
    null left and right pointers. */
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    node.parent = null;
    return(node);
    }
    /* Give a binary search tree and a number, inserts a new node with
    the given number in the correct place in the tree. Returns the new
    root pointer which the caller should then use (the standard trick to
    avoid using reference parameters). */
    static class node* insert(static class node* node, int data)
    {
    /* 1. If the tree is empty, return a new,
    single node */
    if (node == null)
    return(newNode(data));
    else
    {
    static class node *temp;
    /* 2. Otherwise, recur down the tree */
    if (data <= node.data)
    {
    temp = insert(node.left, data);
    node.left = temp;
    temp.parent= node;
    }
    else
    {
    temp = insert(node.right, data);
    node.right = temp;
    temp.parent = node;
    }
    /* return the (unchanged) node pointer */
    return node;
    }
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node* root = null, *temp, *succ, *min;
    //creating the tree given in the above diagram
    root = insert(root, 20);
    root = insert(root, 8);
    root = insert(root, 22);
    root = insert(root, 4);
    root = insert(root, 12);
    root = insert(root, 10);
    root = insert(root, 14);
    temp = root.left.right.right;
    succ = inOrderSuccessor(root, temp);
    if(succ != null)
    System.out.printf("\n Inorder Successor of %d is %d ", temp.data, succ.data);
    else
    System.out.printf("\n Inorder Successor doesn't exit");
    getchar();
    return 0;
    }
    Method 2 (Search from root)
    static class node * inOrderSuccessor(static class node *root, static class node *n)
    {
    // step 1 of the above algorithm
    if( n.right != null )
    return minValue(n.right);
    static class node *succ = null;
    // Start from root and search for successor down the tree
    while (root != null)
    {
    if (n.data < root.data)
    {
    succ = root;
    root = root.left;
    }
    else if (n.data > root.data)
    root = root.right;
    else
    break;
    }
    return succ;
    }
}
