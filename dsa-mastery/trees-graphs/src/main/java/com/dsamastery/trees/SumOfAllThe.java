package com.dsamastery.trees;

import java.util.*;

public class SumOfAllThe {

    / \
    / \ \
    / \
    // C program to find sum of all paths from root to leaves
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // function to allocate new node with given data
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)malloc(sizeof(static class node));
    node.data = data;
    node.left = node.right = null;
    return (node);
    }
    // Returns sum of all root to leaf paths. The first parameter is root
    // of current subtree, the second parameter is value of the number formed
    // by nodes from root to this node
    int treePathsSumUtil(static class node *root, int val)
    {
    // Base case
    if (root == null) return 0;
    // Update val
    val = (val*10 + root.data);
    // if current node is leaf, return the current value of val
    if (root.left==null && root.right==null)
    return val;
    // recur sum of values for left and right subtree
    return treePathsSumUtil(root.left, val) +
    treePathsSumUtil(root.right, val);
    }
    // A wrapper function over treePathsSumUtil()
    int treePathsSum(static class node *root)
    {
    // Pass the initial value as 0 as there is nothing above root
    return treePathsSumUtil(root, 0);
    }
    // Driver function to test the above functions
    int main()
    {
    static class node *root = newNode(6);
    root.left = newNode(3);
    root.right = newNode(5);
    root.right.right= newNode(7);
    root.left.left = newNode(2);
    root.left.right = newNode(5);
    root.right.right = newNode(4);
    root.left.right.left = newNode(7);
    root.left.right.right = newNode(4);
    System.out.printf("Sum of all paths is %d", treePathsSum(root));
    return 0;
    }
}
