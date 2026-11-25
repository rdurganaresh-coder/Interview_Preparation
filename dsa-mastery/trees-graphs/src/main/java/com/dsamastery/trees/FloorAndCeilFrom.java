package com.dsamastery.trees;

import java.util.*;

public class FloorAndCeilFrom {

    // Program to find ceil of a given value in BST
    /* A binary tree node has key, left child and right child */
    static class node
    {
    int key;
    static class node* left;
    static class node* right;
    };
    /* Helper function that allocates a new node with the given key and
    null left and right pointers.*/
    static class node* newNode(int key)
    {
    static class node* node = (static class node*)malloc(sizeof(static class node));
    node.key = key;
    node.left = null;
    node.right = null;
    return(node);
    }
    // Function to find ceil of a given input in BST. If input is more
    // than the max key in BST, return -1
    int Ceil(node *root, int input)
    {
    // Base case
    if( root == null )
    return -1;
    // We found equal key
    if( root.key == input )
    return root.key;
    // If root's key is smaller, ceil must be in right subtree
    if( root.key < input )
    return Ceil(root.right, input);
    // Else, either left subtree or root has the ceil value
    int ceil = Ceil(root.left, input);
    return (ceil >= input) ? ceil : root.key;
    }
    // Driver program to test above function
    int main()
    {
    node *root = newNode(8);
    root.left = newNode(4);
    root.right = newNode(12);
    root.left.left = newNode(2);
    root.left.right = newNode(6);
    root.right.left = newNode(10);
    root.right.right = newNode(14);
    for(int i = 0; i < 16; i++)
    System.out.printf("%d %d\n", i, Ceil(root, i));
    return 0;
    }
}
