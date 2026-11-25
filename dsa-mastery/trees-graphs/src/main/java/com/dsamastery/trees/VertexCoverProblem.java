package com.dsamastery.trees;

import java.util.*;

public class VertexCoverProblem {

    // A naive recursive C implementation for vertex cover problem for a tree
    // A utility function to find min of two integers
    int min(int x, int y) { return (x < y)? x: y; }
    /* A binary tree node has data, pointer to left child and a pointer to
    right child */
    static class node
    {
    int data;
    static class node *left, *right;
    };
    // The function returns size of the minimum vertex cover
    int vCover(static class node *root)
    {
    // The size of minimum vertex cover is zero if tree is empty or there
    // is only one node
    if (root == null)
    return 0;
    if (root.left == null && root.right == null)
    return 0;
    // Calculate size of vertex cover when root is part of it
    int size_incl = 1 + vCover(root.left) + vCover(root.right);
    // Calculate size of vertex cover when root is not part of it
    int size_excl = 0;
    if (root.left)
    size_excl += 1 + vCover(root.left.left) + vCover(root.left.right);
    if (root.right)
    size_excl += 1 + vCover(root.right.left) + vCover(root.right.right);
    // Return the minimum of two sizes
    return min(size_incl, size_excl);
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
    System.out.printf("Size of the smallest vertex cover is %d ", vCover(root));
    return 0;
    }
    /* Dynamic programming based program for Vertex Cover problem for
    a Binary Tree */
    // A utility function to find min of two integers
    int min(int x, int y) { return (x < y)? x: y; }
    /* A binary tree node has data, pointer to left child and a pointer to
    right child */
    static class node
    {
    int data;
    int vc;
    static class node *left, *right;
    };
    // A memoization based function that returns size of the minimum vertex cover.
    int vCover(static class node *root)
    {
    // The size of minimum vertex cover is zero if tree is empty or there
    // is only one node
    if (root == null)
    return 0;
    if (root.left == null && root.right == null)
    return 0;
    // If vertex cover for this node is already evaluated, then return it
    // to save recomputation of same subproblem again.
    if (root.vc != 0)
    return root.vc;
    // Calculate size of vertex cover when root is part of it
    int size_incl = 1 + vCover(root.left) + vCover(root.right);
    // Calculate size of vertex cover when root is not part of it
    int size_excl = 0;
    if (root.left)
    size_excl += 1 + vCover(root.left.left) + vCover(root.left.right);
    if (root.right)
    size_excl += 1 + vCover(root.right.left) + vCover(root.right.right);
    // Minimum of two values is vertex cover, store it before returning
    root.vc = min(size_incl, size_excl);
    return root.vc;
    }
    // A utility function to create a node
    static class node* newNode( int data )
    {
    static class node* temp = (static class node *) malloc( sizeof(static class node) );
    temp.data = data;
    temp.left = temp.right = null;
    temp.vc = 0; // Set the vertex cover as 0
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
    System.out.printf("Size of the smallest vertex cover is %d ", vCover(root));
    return 0;
    }
}
