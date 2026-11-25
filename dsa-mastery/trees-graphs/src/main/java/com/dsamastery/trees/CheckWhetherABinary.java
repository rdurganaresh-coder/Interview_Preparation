package com.dsamastery.trees;

import java.util.*;

public class CheckWhetherABinary {

    // C program to check whether a given Binary Tree is full or not
    /* Tree node structure */
    static class Node
    {
    int key;
    static class Node *left, *right;
    };
    /* Helper function that allocates a new node with the
    given key and null left and right pointer. */
    static class Node *newNode(char k)
    {
    static class Node *node = (static class Node*)malloc(sizeof(static class Node));
    node.key = k;
    node.right = node.left = null;
    return node;
    }
    /* This function tests if a binary tree is a full binary tree. */
    boolean isFullTree (static class Node* root)
    {
    // If empty tree
    if (root == null)
    return true;
    // If leaf node
    if (root.left == null && root.right == null)
    return true;
    // If both left and right are not null, and left & right subtrees
    // are full
    if ((root.left) && (root.right))
    return (isFullTree(root.left) && isFullTree(root.right));
    // We reach here when none of the above if conditions work
    return false;
    }
    // Driver Program
    int main()
    {
    static class Node* root = null;
    root = newNode(10);
    root.left = newNode(20);
    root.right = newNode(30);
    root.left.right = newNode(40);
    root.left.left = newNode(50);
    root.right.left = newNode(60);
    root.right.right = newNode(70);
    root.left.left.left = newNode(80);
    root.left.left.right = newNode(90);
    root.left.right.left = newNode(80);
    root.left.right.right = newNode(90);
    root.right.left.left = newNode(80);
    root.right.left.right = newNode(90);
    root.right.right.left = newNode(80);
    root.right.right.right = newNode(90);
    if (isFullTree(root))
    System.out.printf("The Binary Tree is full\n");
    else
    System.out.printf("The Binary Tree is not full\n");
    return(0);
    }
}
