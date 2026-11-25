package com.dsamastery.trees;

import java.util.*;

public class PrintLeftViewOf {

    / \
    / \
    // C program to print left view of Binary Tree
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // A utility function to create a new Binary Tree node
    static class node *newNode(int item)
    {
    static class node *temp = (static class node *)malloc(sizeof(static class node));
    temp.data = item;
    temp.left = temp.right = null;
    return temp;
    }
    // Recursive function to print left view of a binary tree.
    void leftViewUtil(static class node *root, int level, int *max_level)
    {
    // Base Case
    if (root==null) return;
    // If this is the first node of its level
    if (*max_level < level)
    {
    System.out.printf("%d\t", root.data);
    *max_level = level;
    }
    // Recur for left and right subtrees
    leftViewUtil(root.left, level+1, max_level);
    leftViewUtil(root.right, level+1, max_level);
    }
    // A wrapper over leftViewUtil()
    void leftView(static class node *root)
    {
    int max_level = 0;
    leftViewUtil(root, 1, &max_level);
    }
    // Driver Program to test above functions
    int main()
    {
    static class node *root = newNode(12);
    root.left = newNode(10);
    root.right = newNode(30);
    root.right.left = newNode(25);
    root.right.right = newNode(40);
    leftView(root);
    return 0;
    }
}
