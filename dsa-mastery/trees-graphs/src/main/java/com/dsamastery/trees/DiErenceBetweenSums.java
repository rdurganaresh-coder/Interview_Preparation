package com.dsamastery.trees;

import java.util.*;

public class DiErenceBetweenSums {

    / \
    / \ \
    / / \
    // A recursive program to find difference between sum of nodes at
    // odd level and sum at even level
    // Binary Tree node
    static class node
    {
    int data;
    static class node* left, *right;
    };
    // A utility function to allocate a new tree node with given data
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)malloc(sizeof(static class node));
    node.data = data;
    node.left = node.right = null;
    return (node);
    }
    // The main function that return difference between odd and even level
    // nodes
    int getLevelDiff(static class node *root)
    {
    // Base case
    if (root == null)
    return 0;
    // Difference for root is root's data - difference for left subtree
    // - difference for right subtree
    return root.data - getLevelDiff(root.left) - getLevelDiff(root.right);
    }
    // Driver program to test above functions
    int main()
    {
    static class node *root = newNode(5);
    root.left = newNode(2);
    root.right = newNode(6);
    root.left.left = newNode(1);
    root.left.right = newNode(4);
    root.left.right.left = newNode(3);
    root.right.right = newNode(8);
    root.right.right.right = newNode(9);
    root.right.right.left = newNode(7);
    System.out.printf("%d is the required difference\n", getLevelDiff(root));
    getchar();
    return 0;
    }
}
