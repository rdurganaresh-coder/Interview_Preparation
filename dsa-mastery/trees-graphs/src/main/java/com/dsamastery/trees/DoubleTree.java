package com.dsamastery.trees;

import java.util.*;

public class DoubleTree {

    / \
    / \
    / \
    / \
    / \
    / \
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* function to create a new node of tree and returns pointer */
    static class node* newNode(int data);
    /* Function to convert a tree to double tree */
    void doubleTree(static class node* node)
    {
    static class node* oldLeft;
    if (node==null) return;
    /* do the subtrees */
    doubleTree(node.left);
    doubleTree(node.right);
    /* duplicate this node to its left */
    oldLeft = node.left;
    node.left = newNode(node.data);
    node.left.left = oldLeft;
    }
    /* UTILITY FUNCTIONS TO TEST doubleTree() FUNCTION */
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(static class node* node)
    {
    if (node == null)
    return;
    printInorder(node.left);
    System.out.printf("%d ", node.data);
    printInorder(node.right);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    2 3
    / \
    4 5
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Inorder traversal of the original tree is \n");
    printInorder(root);
    doubleTree(root);
    System.out.printf("\n Inorder traversal of the double tree is \n");
    printInorder(root);
    getchar();
    return 0;
    }
}
