package com.dsamastery.trees;

import java.util.*;

public class ConvertAGivenBinary {

    // A simple inorder traversal based program to convert a Binary Tree to DLL
    // A tree node
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // A utility function to create a new tree node
    static class node *newNode(int data)
    {
    static class node *node = (static class node *)malloc(sizeof(static class node));
    node.data = data;
    node.left = node.right = null;
    return(node);
    }
    // Standard Inorder traversal of tree
    void inorder(static class node *root)
    {
    if (root != null)
    {
    inorder(root.left);
    System.out.printf("\t%d",root.data);
    inorder(root.right);
    }
    }
    // Changes left pointers to work as previous pointers in converted DLL
    // The function simply does inorder traversal of Binary Tree and updates
    // left pointer using previously visited node
    void fixPrevPtr(static class node *root)
    {
    static static class node *pre = null;
    if (root != null)
    {
    fixPrevPtr(root.left);
    root.left = pre;
    pre = root;
    fixPrevPtr(root.right);
    }
    }
    // Changes right pointers to work as next pointers in converted DLL
    static class node *fixNextPtr(static class node *root)
    {
    static class node *prev = null;
    // Find the right most node in BT or last node in DLL
    while (root && root.right != null)
    root = root.right;
    // Start from the rightmost node, traverse back using left pointers.
    // While traversing, change right pointer of nodes.
    while (root && root.left != null)
    {
    prev = root;
    root = root.left;
    root.right = prev;
    }
    // The leftmost node is head of linked list, return it
    return (root);
    }
    // The main function that converts BST to DLL and returns head of DLL
    static class node *BTToDLL(static class node *root)
    {
    // Set the previous pointer
    fixPrevPtr(root);
    // Set the next pointer and return head of DLL
    return fixNextPtr(root);
    }
    // Traverses the DLL from left tor right
    void printList(static class node *root)
    {
    while (root != null)
    {
    System.out.printf("\t%d", root.data);
    root = root.right;
    }
    }
    // Driver program to test above functions
    int main(void)
    {
    // Let us create the tree shown in above diagram
    static class node *root = newNode(10);
    root.left = newNode(12);
    root.right = newNode(15);
    root.left.left = newNode(25);
    root.left.right = newNode(30);
    root.right.left = newNode(36);
    System.out.printf("\n\t\tInorder Tree Traversal\n\n");
    inorder(root);
    static class node *head = BTToDLL(root);
    System.out.printf("\n\n\t\tDLL Traversal\n\n");
    printList(head);
    return 0;
    }
}
