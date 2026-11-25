package com.dsamastery.trees;

import java.util.*;

public class ConvertAGivenTree {

    / \
    / \ / \
    / \
    / \ / \
    /* A tree node structure */
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    };
    // Convert a given tree to a tree where every node contains sum of values of
    // nodes in left and right subtrees in the original tree
    int toSumTree(static class node *node)
    {
    // Base case
    if(node == null)
    return 0;
    // Store the old value
    int old_val = node.data;
    // Recursively call for left and right subtrees and store the sum as
    // new value of this node
    node.data = toSumTree(node.left) + toSumTree(node.right);
    // Return the sum of values of nodes in left and right subtrees and
    // old_value of this node
    return node.data + old_val;
    }
    // A utility function to print inorder traversal of a Binary Tree
    void printInorder(static class node* node)
    {
    if (node == null)
    return;
    printInorder(node.left);
    System.out.printf("%d ", node.data);
    printInorder(node.right);
    }
    /* Utility function to create a new Binary Tree node */
    static class node* newNode(int data)
    {
    static class node *temp = new static class node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    /* Driver function to test above functions */
    int main()
    {
    static class node *root = null;
    int x;
    /* Constructing tree given in the above figure */
    root = newNode(10);
    root.left = newNode(-2);
    root.right = newNode(6);
    root.left.left = newNode(8);
    root.left.right = newNode(-4);
    root.right.left = newNode(7);
    root.right.right = newNode(5);
    toSumTree(root);
    // Print inorder traversal of the converted tree to test result of toSumTree()
    System.out.printf("Inorder Traversal of the resultant tree is: \n");
    printInorder(root);
    getchar();
    return 0;
    }
}
