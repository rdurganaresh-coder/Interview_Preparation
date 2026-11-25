package com.dsamastery.trees;

import java.util.*;

public class TreeTraversals {

    Algorithm Inorder(tree)
    Algorithm Preorder(tree)
    Algorithm Postorder(tree)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
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
    /* Given a binary tree, print its nodes according to the
    "bottom-up" postorder traversal. */
    void printPostorder(static class node* node)
    {
    if (node == null)
    return;
    // first recur on left subtree
    printPostorder(node.left);
    // then recur on right subtree
    printPostorder(node.right);
    // now deal with the node
    System.out.printf("%d ", node.data);
    }
    /* Given a binary tree, print its nodes in inorder*/
    void printInorder(static class node* node)
    {
    if (node == null)
    return;
    /* first recur on left child */
    printInorder(node.left);
    /* then print the data of node */
    System.out.printf("%d ", node.data);
    /* now recur on right child */
    printInorder(node.right);
    }
    /* Given a binary tree, print its nodes in preorder*/
    void printPreorder(static class node* node)
    {
    if (node == null)
    return;
    /* first print data of node */
    System.out.printf("%d ", node.data);
    /* then recur on left sutree */
    printPreorder(node.left);
    /* now recur on right subtree */
    printPreorder(node.right);
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("\n Preorder traversal of binary tree is \n");
    printPreorder(root);
    System.out.printf("\n Inorder traversal of binary tree is \n");
    printInorder(root);
    System.out.printf("\n Postorder traversal of binary tree is \n");
    printPostorder(root);
    getchar();
    return 0;
    }
}
