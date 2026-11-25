package com.dsamastery.trees;

import java.util.*;

public class HowToHandleDuplicates {

    / \
    / \
    / \
    / \
    // C program to implement basic operations (search, insert and delete)
    // on a BST that handles duplicates by storing count with every node
    static class node
    {
    int key;
    int count;
    static class node *left, *right;
    };
    // A utility function to create a new BST node
    static class node *newNode(int item)
    {
    static class node *temp = (static class node *)malloc(sizeof(static class node));
    temp.key = item;
    temp.left = temp.right = null;
    temp.count = 1;
    return temp;
    }
    // A utility function to do inorder traversal of BST
    void inorder(static class node *root)
    {
    if (root != null)
    {
    inorder(root.left);
    System.out.printf("%d(%d) ", root.key, root.count);
    inorder(root.right);
    }
    }
    /* A utility function to insert a new node with given key in BST */
    static class node* insert(static class node* node, int key)
    {
    /* If the tree is empty, return a new node */
    if (node == null) return newNode(key);
    // If key already exists in BST, icnrement count and return
    if (key == node.key)
    {
    (node.count)++;
    return node;
    }
    /* Otherwise, recur down the tree */
    if (key < node.key)
    node.left = insert(node.left, key);
    else
    node.right = insert(node.right, key);
    /* return the (unchanged) node pointer */
    return node;
    }
    /* Given a non-empty binary search tree, return the node with
    minimum key value found in that tree. Note that the entire
    tree does not need to be searched. */
    static class node * minValueNode(static class node* node)
    {
    static class node* current = node;
    /* loop down to find the leftmost leaf */
    while (current.left != null)
    current = current.left;
    return current;
    }
    /* Given a binary search tree and a key, this function
    deletes a given key and returns root of modified tree */
    static class node* deleteNode(static class node* root, int key)
    {
    // base case
    if (root == null) return root;
    // If the key to be deleted is smaller than the
    // root's key, then it lies in left subtree
    if (key < root.key)
    root.left = deleteNode(root.left, key);
    // If the key to be deleted is greater than the root's key,
    // then it lies in right subtree
    else if (key > root.key)
    root.right = deleteNode(root.right, key);
    // if key is same as root's key
    else
    {
    // If key is present more than once, simply decrement
    // count and return
    if (root.count > 1)
    {
    (root.count)--;
    return root;
    }
    // ElSE, delete the node
    // node with only one child or no child
    if (root.left == null)
    {
    static class node *temp = root.right;
    free(root);
    return temp;
    }
    else if (root.right == null)
    {
    static class node *temp = root.left;
    free(root);
    return temp;
    }
    // node with two children: Get the inorder successor (smallest
    // in the right subtree)
    static class node* temp = minValueNode(root.right);
    // Copy the inorder successor's content to this node
    root.key = temp.key;
    // Delete the inorder successor
    root.right = deleteNode(root.right, temp.key);
    }
    return root;
    }
    // Driver Program to test above functions
    int main()
    {
    /* Let us create following BST
    12(3)
    / \
    10(2) 20(1)
    / \
    9(1) 11(1) */
    static class node *root = null;
    root = insert(root, 12);
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 9);
    root = insert(root, 11);
    root = insert(root, 10);
    root = insert(root, 12);
    root = insert(root, 12);
    System.out.printf("Inorder traversal of the given tree \n");
    inorder(root);
    System.out.printf("\nDelete 20\n");
    root = deleteNode(root, 20);
    System.out.printf("Inorder traversal of the modified tree \n");
    inorder(root);
    System.out.printf("\nDelete 12\n");
    root = deleteNode(root, 12);
    System.out.printf("Inorder traversal of the modified tree \n");
    inorder(root);
    System.out.printf("\nDelete 9\n");
    root = deleteNode(root, 9);
    System.out.printf("Inorder traversal of the modified tree \n");
    inorder(root);
    return 0;
    }
}
