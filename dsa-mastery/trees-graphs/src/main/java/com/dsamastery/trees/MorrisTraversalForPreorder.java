package com.dsamastery.trees;

import java.util.*;

public class MorrisTraversalForPreorder {

    // C program for Morris Preorder traversal
    static class node
    {
    int data;
    static class node *left, *right;
    };
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newNode(int data)
    {
    static class node* temp = (static class node*) malloc(sizeof(static class node));
    temp.data = data;
    temp.left = temp.right = null;
    return temp;
    }
    // Preorder traversal without recursion and without stack
    void morrisTraversalPreorder(static class node* root)
    {
    while (root)
    {
    // If left child is null, print the current node data. Move to
    // right child.
    if (root.left == null)
    {
    System.out.printf( "%d ", root.data );
    root = root.right;
    }
    else
    {
    // Find inorder predecessor
    static class node* current = root.left;
    while (current.right && current.right != root)
    current = current.right;
    // If the right child of inorder predecessor already points to
    // this node
    if (current.right == root)
    {
    current.right = null;
    root = root.right;
    }
    // If right child doesn't point to this node, then print this
    // node and make right child point to this node
    else
    {
    System.out.printf("%d ", root.data);
    current.right = root;
    root = root.left;
    }
    }
    }
    }
    // Function for sStandard preorder traversal
    void preorder(static class node* root)
    {
    if (root)
    {
    System.out.printf( "%d ", root.data);
    preorder(root.left);
    preorder(root.right);
    }
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node* root = null;
    root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.left.left.left = newNode(8);
    root.left.left.right = newNode(9);
    root.left.right.left = newNode(10);
    root.left.right.right = newNode(11);
    morrisTraversalPreorder(root);
    System.out.printf("\n");
    preorder(root);
    return 0;
    }
}
