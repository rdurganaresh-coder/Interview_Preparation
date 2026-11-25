package com.dsamastery.trees;

import java.util.*;

public class FindTheNodeWith {

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers. */
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Give a binary search tree and a number,
    inserts a new node with the given number in
    the correct place in the tree. Returns the new
    root pointer which the caller should then use
    (the standard trick to avoid using reference
    parameters). */
    static class node* insert(static class node* node, int data)
    {
    /* 1. If the tree is empty, return a new,
    single node */
    if (node == null)
    return(newNode(data));
    else
    {
    /* 2. Otherwise, recur down the tree */
    if (data <= node.data)
    node.left = insert(node.left, data);
    else
    node.right = insert(node.right, data);
    /* return the (unchanged) node pointer */
    return node;
    }
    }
    /* Given a non-empty binary search tree,
    return the minimum data value found in that
    tree. Note that the entire tree does not need
    to be searched. */
    int minValue(static class node* node) {
    static class node* current = node;
    /* loop down to find the leftmost leaf */
    while (current.left != null) {
    current = current.left;
    }
    return(current.data);
    }
    /* Driver program to test sameTree function*/
    int main()
    {
    static class node* root = null;
    root = insert(root, 4);
    insert(root, 2);
    insert(root, 1);
    insert(root, 3);
    insert(root, 6);
    insert(root, 5);
    System.out.printf("\n Minimum value in BST is %d", minValue(root));
    getchar();
    return 0;
    }
}
