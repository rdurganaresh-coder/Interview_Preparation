package com.dsamastery.trees;

import java.util.*;

public class ExtractLeavesOfA {

    / \
    / \ \
    / \ / \
    / \
    / \
    return values to update left or right pointers in parent nodes.
    // C program to extract leaves of a Binary Tree in a Doubly Linked List
    // Structure for tree and linked list
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // Main function which extracts all leaves from given Binary Tree.
    // The function returns new root of Binary Tree (Note that root may change
    // if Binary Tree has only one node). The function also sets *head_ref as
    // head of doubly linked list. left pointer of tree is used as prev in DLL
    // and right pointer is used as next
    static class Node* extractLeafList(static class Node *root, static class Node **head_ref)
    {
    // Base cases
    if (root == null) return null;
    if (root.left == null && root.right == null)
    {
    // This node is going to be added to doubly linked list
    // of leaves, set right pointer of this node as previous
    // head of DLL. We don't need to set left pointer as left
    // is already null
    root.right = *head_ref;
    // Change left pointer of previous head
    if (*head_ref != null) (*head_ref)->left = root;
    // Change head of linked list
    *head_ref = root;
    return null; // Return new root
    }
    // Recur for right and left subtrees
    root.right = extractLeafList(root.right, head_ref);
    root.left = extractLeafList(root.left, head_ref);
    return root;
    }
    // Utility function for allocating node for Binary Tree.
    static class Node* newNode(int data)
    {
    static class Node* node = (static class Node*)malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // Utility function for printing tree in In-Order.
    void print(static class Node *root)
    {
    if (root != null)
    {
    print(root.left);
    System.out.printf("%d ",root.data);
    print(root.right);
    }
    }
    // Utility function for printing double linked list.
    void printList(static class Node *head)
    {
    while (head)
    {
    System.out.printf("%d ", head.data);
    head = head.right;
    }
    }
    // Driver program to test above function
    int main()
    {
    static class Node *head = null;
    static class Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.right = newNode(6);
    root.left.left.left = newNode(7);
    root.left.left.right = newNode(8);
    root.right.right.left = newNode(9);
    root.right.right.right = newNode(10);
    System.out.printf("Inorder Trvaersal of given Tree is:\n");
    print(root);
    root = extractLeafList(root, &head);
    System.out.printf("\nExtracted Double Linked list is:\n");
    printList(head);
    System.out.printf("\nInorder traversal of modified tree is:\n");
    print(root);
    return 0;
    }
}
