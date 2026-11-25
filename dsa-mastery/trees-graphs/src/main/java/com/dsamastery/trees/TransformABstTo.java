package com.dsamastery.trees;

import java.util.*;

public class TransformABstTo {

    Method 2 (Using only one traversal)
    // C++ program to transform a BST to sum tree
    // A BST node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to create a new Binary Tree Node
    static class Node *newNode(int item)
    {
    static class Node *temp = new Node;
    temp.data = item;
    temp.left = temp.right = null;
    return temp;
    }
    // Recursive function to transform a BST to sum tree.
    // This function traverses the tree in reverse inorder so
    // that we have visited all greater key nodes of the currently
    // visited node
    void transformTreeUtil(static class Node *root, int *sum)
    {
    // Base case
    if (root == null) return;
    // Recur for right subtree
    transformTreeUtil(root.right, sum);
    // Update sum
    *sum = *sum + root.data;
    // Store old sum in current node
    root.data = *sum - root.data;
    // Recur for left subtree
    transformTreeUtil(root.left, sum);
    }
    // A wrapper over transformTreeUtil()
    void transformTree(static class Node *root)
    {
    int sum = 0; // Initialize sum
    transformTreeUtil(root, &sum);
    }
    // A utility function to print indorder traversal of a
    // binary tree
    void printInorder(static class Node *root)
    {
    if (root == null) return;
    printInorder(root.left);
    System.out.print(root.data << " ");
    printInorder(root.right);
    }
    // Driver Program to test above functions
    int main()
    {
    static class Node *root = newNode(11);
    root.left = newNode(2);
    root.right = newNode(29);
    root.left.left = newNode(1);
    root.left.right = newNode(7);
    root.right.left = newNode(15);
    root.right.right = newNode(40);
    root.right.right.left = newNode(35);
    System.out.print("Inorder Traversal of given tree\n");
    printInorder(root);
    transformTree(root);
    System.out.print("\n\nInorder Traversal of transformed tree\n");
    printInorder(root);
    return 0;
    }
}
