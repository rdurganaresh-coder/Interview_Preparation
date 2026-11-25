package com.dsamastery.trees;

import java.util.*;

public class AvlTree {

    rooted with y (on left side) or x (on right side) y x / \ Right Rotation / \ x T3 – – – – – – – > T1 y / \
    / \ / \
    / \ - - - - - - - - -> / \ / \
    / \
    / \ / \ / \
    / \ - - - - - - - - -> / \ - - - - - - - -> / \ / \
    / \ / \
    / \ / \
    / \ - - - - - - - -> / \ / \
    / \
    / \ / \ / \
    / \ - - - - - - - - -> / \ - - - - - - - -> / \ / \
    / \ / \
    // An AVL tree node
    static class node
    {
    int key;
    static class node *left;
    static class node *right;
    int height;
    };
    // A utility function to get maximum of two integers
    int max(int a, int b);
    // A utility function to get height of the tree
    int height(static class node *N)
    {
    if (N == null)
    return 0;
    return N.height;
    }
    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
    return (a > b)? a : b;
    }
    /* Helper function that allocates a new node with the given key and
    null left and right pointers. */
    static class node* newNode(int key)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.key = key;
    node.left = null;
    node.right = null;
    node.height = 1; // new node is initially added at leaf
    return(node);
    }
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    static class node *rightRotate(static class node *y)
    {
    static class node *x = y.left;
    static class node *T2 = x.right;
    // Perform rotation
    x.right = y;
    y.left = T2;
    // Update heights
    y.height = max(height(y.left), height(y.right))+1;
    x.height = max(height(x.left), height(x.right))+1;
    // Return new root
    return x;
    }
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    static class node *leftRotate(static class node *x)
    {
    static class node *y = x.right;
    static class node *T2 = y.left;
    // Perform rotation
    y.left = x;
    x.right = T2;
    // Update heights
    x.height = max(height(x.left), height(x.right))+1;
    y.height = max(height(y.left), height(y.right))+1;
    // Return new root
    return y;
    }
    // Get Balance factor of node N
    int getBalance(static class node *N)
    {
    if (N == null)
    return 0;
    return height(N.left) - height(N.right);
    }
    static class node* insert(static class node* node, int key)
    {
    /* 1. Perform the normal BST rotation */
    if (node == null)
    return(newNode(key));
    if (key < node.key)
    node.left = insert(node.left, key);
    else
    node.right = insert(node.right, key);
    /* 2. Update height of this ancestor node */
    node.height = max(height(node.left), height(node.right)) + 1;
    /* 3. Get the balance factor of this ancestor node to check whether
    this node became unbalanced */
    int balance = getBalance(node);
    // If this node becomes unbalanced, then there are 4 cases
    // Left Left Case
    if (balance > 1 && key < node.left.key)
    return rightRotate(node);
    // Right Right Case
    if (balance < -1 && key > node.right.key)
    return leftRotate(node);
    // Left Right Case
    if (balance > 1 && key > node.left.key)
    {
    node.left = leftRotate(node.left);
    return rightRotate(node);
    }
    // Right Left Case
    if (balance < -1 && key < node.right.key)
    {
    node.right = rightRotate(node.right);
    return leftRotate(node);
    }
    /* return the (unchanged) node pointer */
    return node;
    }
    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    void preOrder(static class node *root)
    {
    if(root != null)
    {
    System.out.printf("%d ", root.key);
    preOrder(root.left);
    preOrder(root.right);
    }
    }
    /* Drier program to test above function*/
    int main()
    {
    static class node *root = null;
    /* Constructing tree given in the above figure */
    root = insert(root, 10);
    root = insert(root, 20);
    root = insert(root, 30);
    root = insert(root, 40);
    root = insert(root, 50);
    root = insert(root, 25);
    /* The constructed AVL Tree would be
    / \
    20 40
    / \ \
    10 25 50
    */
    System.out.printf("Pre order traversal of the constructed AVL tree is \n");
    preOrder(root);
    return 0;
    }
    Median in a stream of integers (running integers)
}
