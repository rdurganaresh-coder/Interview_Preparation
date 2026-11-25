package com.dsamastery.trees;

import java.util.*;

public class GivenABinaryTree {

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Prototypes for funtions needed in printPaths() */
    void printPathsRecur(static class node* node, int path[], int pathLen);
    void printArray(int ints[], int len);
    /*Given a binary tree, print out all of its root-to-leaf
    paths, one per line. Uses a recursive helper to do the work.*/
    void printPaths(static class node* node)
    {
    int path[1000];
    printPathsRecur(node, path, 0);
    }
    /* Recursive helper function -- given a node, and an array containing
    the path from the root node up to but not including this node,
    print out all the root-leaf paths.*/
    void printPathsRecur(static class node* node, int path[], int pathLen)
    {
    if (node==null)
    return;
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
    /* UTILITY FUNCTIONS */
    /* Utility that prints out an array on a line. */
    void printArray(int ints[], int len)
    {
    int i;
    for (i=0; i<len; i++)
    {
    System.out.printf("%d ", ints[i]);
    }
    System.out.printf("\n");
    }
    /* utility that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newnode(int data)
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
    /* Constructed binary tree is
    / \
    8 2
    / \ /
    3 5 2
    */
    static class node *root = newnode(10);
    root.left = newnode(8);
    root.right = newnode(2);
    root.left.left = newnode(3);
    root.left.right = newnode(5);
    root.right.left = newnode(2);
    printPaths(root);
    getchar();
    return 0;
    }
}
