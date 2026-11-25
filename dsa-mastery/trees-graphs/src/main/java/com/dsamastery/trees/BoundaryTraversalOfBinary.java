package com.dsamastery.trees;

import java.util.*;

public class BoundaryTraversalOfBinary {

    /* program for boundary traversal of a binary tree */
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // A simple function to print leaf nodes of a binary tree
    void printLeaves(static class node* root)
    {
    if ( root )
    {
    printLeaves(root.left);
    // Print it if it is a leaf node
    if ( !(root.left) && !(root.right) )
    System.out.printf("%d ", root.data);
    printLeaves(root.right);
    }
    }
    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    void printBoundaryLeft(static class node* root)
    {
    if (root)
    {
    if (root.left)
    {
    // to ensure top down order, print the node
    // before calling itself for left subtree
    System.out.printf("%d ", root.data);
    printBoundaryLeft(root.left);
    }
    else if( root.right )
    {
    System.out.printf("%d ", root.data);
    printBoundaryLeft(root.right);
    }
    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
    }
    }
    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    void printBoundaryRight(static class node* root)
    {
    if (root)
    {
    if ( root.right )
    {
    // to ensure bottom up order, first call for right
    // subtree, then print this node
    printBoundaryRight(root.right);
    System.out.printf("%d ", root.data);
    }
    else if ( root.left )
    {
    printBoundaryRight(root.left);
    System.out.printf("%d ", root.data);
    }
    // do nothing if it is a leaf node, this way we avoid
    // duplicates in output
    }
    }
    // A function to do boundary traversal of a given binary tree
    void printBoundary (static class node* root)
    {
    if (root)
    {
    System.out.printf("%d ",root.data);
    // Print the left boundary in top-down manner.
    printBoundaryLeft(root.left);
    // Print all leaf nodes
    printLeaves(root.left);
    printLeaves(root.right);
    // Print the right boundary in bottom-up manner
    printBoundaryRight(root.right);
    }
    }
    // A utility function to create a node
    static class node* newNode( int data )
    {
    static class node* temp = (static class node *) malloc( sizeof(static class node) );
    temp.data = data;
    temp.left = temp.right = null;
    return temp;
    }
    // Driver program to test above functions
    int main()
    {
    // Let us construct the tree given in the above diagram
    static class node *root = newNode(20);
    root.left = newNode(8);
    root.left.left = newNode(4);
    root.left.right = newNode(12);
    root.left.right.left = newNode(10);
    root.left.right.right = newNode(14);
    root.right = newNode(22);
    root.right.right = newNode(25);
    printBoundary( root );
    return 0;
    }
}
