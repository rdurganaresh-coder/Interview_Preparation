package com.dsamastery.trees;

import java.util.*;

public class BinaryTreeToBinary {

    / \
    / \
    / \
    / \
    / \
    / \
    / \
    / \
    /* A program to convert Binary Tree to Binary Search Tree */
    /* A binary tree node structure */
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    };
    /* A helper function that stores inorder traversal of a tree rooted
    with node */
    void storeInorder (static class node* node, int inorder[], int *index_ptr)
    {
    // Base Case
    if (node == null)
    return;
    /* first store the left subtree */
    storeInorder (node.left, inorder, index_ptr);
    /* Copy the root's data */
    inorder[*index_ptr] = node.data;
    (*index_ptr)++; // increase index for next entry
    /* finally store the right subtree */
    storeInorder (node.right, inorder, index_ptr);
    }
    /* A helper function to count nodes in a Binary Tree */
    int countNodes (static class node* root)
    {
    if (root == null)
    return 0;
    return countNodes (root.left) +
    countNodes (root.right) + 1;
    }
    // Following function is needed for library function qsort()
    int compare (const void * a, const void * b)
    {
    return ( *(int*)a - *(int*)b );
    }
    /* A helper function that copies contents of arr[] to Binary Tree.
    This functon basically does Inorder traversal of Binary Tree and
    one by one copy arr[] elements to Binary Tree nodes */
    void arrayToBST (int *arr, static class node* root, int *index_ptr)
    {
    // Base Case
    if (root == null)
    return;
    /* first update the left subtree */
    arrayToBST (arr, root.left, index_ptr);
    /* Now update root's data and increment index */
    root.data = arr[*index_ptr];
    (*index_ptr)++;
    /* finally update the right subtree */
    arrayToBST (arr, root.right, index_ptr);
    }
    // This function converts a given Binary Tree to BST
    void binaryTreeToBST (static class node *root)
    {
    // base case: tree is empty
    if(root == null)
    return;
    /* Count the number of nodes in Binary Tree so that
    we know the size of temporary array to be created */
    int n = countNodes (root);
    // Create a temp array arr[] and store inorder traversal of tree in arr[]
    int *arr = new int[n];
    int i = 0;
    storeInorder (root, arr, &i);
    // Sort the array using library function for quick sort
    qsort (arr, n, sizeof(arr[0]), compare);
    // Copy array elements back to Binary Tree
    i = 0;
    arrayToBST (arr, root, &i);
    // delete dynamically allocated memory to avoid meory leak
    delete [] arr;
    }
    /* Utility function to create a new Binary Tree node */
    static class node* newNode (int data)
    {
    static class node *temp = new static class node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    /* Utility function to print inorder traversal of Binary Tree */
    void printInorder (static class node* node)
    {
    if (node == null)
    return;
    /* first recur on left child */
    printInorder (node.left);
    /* then print the data of node */
    System.out.printf("%d ", node.data);
    /* now recur on right child */
    printInorder (node.right);
    }
    /* Driver function to test above functions */
    int main()
    {
    static class node *root = null;
    /* Constructing tree given in the above figure
    / \
    30 15
    / \
    20 5 */
    root = newNode(10);
    root.left = newNode(30);
    root.right = newNode(15);
    root.left.left = newNode(20);
    root.right.right = newNode(5);
    // convert Binary Tree to BST
    binaryTreeToBST (root);
    System.out.printf("Following is Inorder Traversal of the converted BST: \n");
    printInorder (root);
    return 0;
    }
}
