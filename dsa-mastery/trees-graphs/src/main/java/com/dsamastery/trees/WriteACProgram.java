package com.dsamastery.trees;

import java.util.*;

public class WriteACProgram {

    size(tree)
    size( tree.left-subtree)
    size( tree.right-subtree)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
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
    /* Computes the number of nodes in a tree. */
    int size(static class node* node)
    {
    if (node==null)
    return 0;
    else
    return(size(node.left) + 1 + size(node.right));
    }
    /* Driver program to test size function*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Size of the tree is %d", size(root));
    getchar();
    return 0;
    }
    will be same as Tree traversal (Please see our Tree Traversal post for details)
}
