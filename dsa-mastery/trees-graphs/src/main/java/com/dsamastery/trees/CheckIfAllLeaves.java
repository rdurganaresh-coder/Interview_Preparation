package com.dsamastery.trees;

import java.util.*;

public class CheckIfAllLeaves {

    / \
    / \
    / \
    / \
    // C program to check if all leaves are at same level
    // A binary tree node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to allocate a new tree node
    static class Node* newNode(int data)
    {
    static class Node* node = (static class Node*) malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    /* Recursive function which checks whether all leaves are at same level */
    boolean checkUtil(static class Node *root, int level, int *leafLevel)
    {
    // Base case
    if (root == null) return true;
    // If a leaf node is encountered
    if (root.left == null && root.right == null)
    {
    // When a leaf node is found first time
    if (*leafLevel == 0)
    {
    *leafLevel = level; // Set first found leaf's level
    return true;
    }
    // If this is not first leaf node, compare its level with
    // first leaf's level
    return (level == *leafLevel);
    }
    // If this node is not leaf, recursively check left and right subtrees
    return checkUtil(root.left, level+1, leafLevel) &&
    checkUtil(root.right, level+1, leafLevel);
    }
    /* The main function to check if all leafs are at same level.
    It mainly uses checkUtil() */
    boolean check(static class Node *root)
    {
    int level = 0, leafLevel = 0;
    return checkUtil(root, level, &leafLevel);
    }
    // Driver program to test above function
    int main()
    {
    // Let us create tree shown in thirdt example
    static class Node *root = newNode(12);
    root.left = newNode(5);
    root.left.left = newNode(3);
    root.left.right = newNode(9);
    root.left.left.left = newNode(1);
    root.left.right.left = newNode(1);
    if (check(root))
    System.out.printf("Leaves are at same level\n");
    else
    System.out.printf("Leaves are not at same level\n");
    getchar();
    return 0;
    }
}
