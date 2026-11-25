package com.dsamastery.trees;

import java.util.*;

public class GivenABinaryTree {

    /*1000 is some max limit for paths, it can change*/
    /*printPathsRecur traverses nodes of tree in preorder */
    printPathsRecur(tree, path[], pathlen)
    printPathsRecur(node.left, path, pathLen)
    printPathsRecur(node.right, path, pathLen)
    /*program to print all of its root-to-leaf paths for a tree*/
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    void printArray(int [], int);
    void printPathsRecur(static class node*, int [], int);
    static class node* newNode(int );
    void printPaths(static class node*);
    /* Given a binary tree, print out all of its root-to-leaf
    paths, one per line. Uses a recursive helper to do the work.*/
    void printPaths(static class node* node)
    {
    int path[1000];
    printPathsRecur(node, path, 0);
    }
    /* Recursive helper function -- given a node, and an array containing
    the path from the root node up to but not including this node,
    print out all the root-leaf paths. */
    void printPathsRecur(static class node* node, int path[], int pathLen)
    {
    if (node==null) return;
    /* append this node to the path array */
    path[pathLen] = node.data;
    pathLen++;
    /* it's a leaf, so print the path that led to here */
    if (node.left==null && node.right==null)
    {
    printArray(path, pathLen);
    }
    else
    {
    /* otherwise try both subtrees */
    printPathsRecur(node.left, path, pathLen);
    printPathsRecur(node.right, path, pathLen);
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
    /* Utility that prints out an array on a line */
    void printArray(int ints[], int len)
    {
    int i;
    for (i=0; i<len; i++) {
    System.out.printf("%d ", ints[i]);
    }
    System.out.printf("\n");
    }
    /* Driver program to test mirror() */
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    /* Print all root-to-leaf paths of the input tree */
    printPaths(root);
    getchar();
    return 0;
    }
}
