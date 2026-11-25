package com.dsamastery.trees;

import java.util.*;

public class AddAllGreaterValues {

    / \
    / \ / \
    / \
    / \ / \
    // C program to add all greater values in every node of BST
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // A utility function to create a new BST node
    static class node *newNode(int item)
    {
    static class node *temp = (static class node *)malloc(sizeof(static class node));
    temp.data = item;
    temp.left = temp.right = null;
    return temp;
    }
    // Recursive function to add all greater values in every node
    void modifyBSTUtil(static class node *root, int *sum)
    {
    // Base Case
    if (root == null) return;
    // Recur for right subtree
    modifyBSTUtil(root.right, sum);
    // Now *sum has sum of nodes in right subtree, add
    // root.data to sum and update root.data
    *sum = *sum + root.data;
    root.data = *sum;
    // Recur for left subtree
    modifyBSTUtil(root.left, sum);
    }
    // A wrapper over modifyBSTUtil()
    void modifyBST(static class node *root)
    {
    int sum = 0;
    modifyBSTUtil(root, &sum);
    }
    // A utility function to do inorder traversal of BST
    void inorder(static class node *root)
    {
    if (root != null)
    {
    inorder(root.left);
    System.out.printf("%d ", root.data);
    inorder(root.right);
    }
    }
    /* A utility function to insert a new node with given data in BST */
    static class node* insert(static class node* node, int data)
    {
    /* If the tree is empty, return a new node */
    if (node == null) return newNode(data);
    /* Otherwise, recur down the tree */
    if (data <= node.data)
    node.left = insert(node.left, data);
    else
    node.right = insert(node.right, data);
    /* return the (unchanged) node pointer */
    return node;
    }
    // Driver Program to test above functions
    int main()
    {
    /* Let us create following BST
    / \
    30 70
    / \ / \
    20 40 60 80 */
    static class node *root = null;
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);
    modifyBST(root);
    // print inoder tarversal of the modified BST
    inorder(root);
    return 0;
    }
}
