package com.dsamastery.trees;

import java.util.*;

public class ConvertABstTo {

    / \
    / \
    // Program to change a BST to Binary Tree such that key of a node becomes
    // original key plus sum of all greater keys in BST
    /* A BST node has key, left child and right child */
    static class node
    {
    int key;
    static class node* left;
    static class node* right;
    };
    /* Helper function that allocates a new node with the given key and
    null left and right pointers.*/
    static class node* newNode(int key)
    {
    static class node* node = (static class node*)malloc(sizeof(static class node));
    node.key = key;
    node.left = null;
    node.right = null;
    return (node);
    }
    // A recursive function that traverses the given BST in reverse inorder and
    // for every key, adds all greater keys to it
    void addGreaterUtil(static class node *root, int *sum_ptr)
    {
    // Base Case
    if (root == null)
    return;
    // Recur for right subtree first so that sum of all greater
    // nodes is stored at sum_ptr
    addGreaterUtil(root.right, sum_ptr);
    // Update the value at sum_ptr
    *sum_ptr = *sum_ptr + root.key;
    // Update key of this node
    root.key = *sum_ptr;
    // Recur for left subtree so that the updated sum is added
    // to smaller nodes
    addGreaterUtil(root.left, sum_ptr);
    }
    // A wrapper over addGreaterUtil(). It initializes sum and calls
    // addGreaterUtil() to recursivel upodate and use value of sum
    void addGreater(static class node *root)
    {
    int sum = 0;
    addGreaterUtil(root, &sum);
    }
    // A utility function to print inorder traversal of Binary Tree
    void printInorder(static class node* node)
    {
    if (node == null)
    return;
    printInorder(node.left);
    System.out.printf("%d ", node.key);
    printInorder(node.right);
    }
    // Driver program to test above function
    int main()
    {
    /* Create following BST
    / \
    2 13 */
    node *root = newNode(5);
    root.left = newNode(2);
    root.right = newNode(13);
    System.out.printf(" Inorder traversal of the given tree\n");
    printInorder(root);
    addGreater(root);
    System.out.printf("\n Inorder traversal of the modified tree\n");
    printInorder(root);
    return 0;
    }
}
