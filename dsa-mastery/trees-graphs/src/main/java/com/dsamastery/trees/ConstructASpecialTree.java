package com.dsamastery.trees;

import java.util.*;

public class ConstructASpecialTree {

    Input: pre[] = {10, 30, 20, 5, 15}, preLN[] = {'N', 'N', 'L', 'L', 'L'}
    / \
    / \
    return it. If left and right subtrees are not empty, then recursively call for left and right subtrees and link
    /* A program to construct Binary Tree from preorder traversal */
    /* A binary tree node structure */
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    };
    /* Utility function to create a new Binary Tree node */
    static class node* newNode (int data)
    {
    static class node *temp = new static class node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    /* A recursive function to create a Binary Tree from given pre[]
    preLN[] arrays. The function returns root of tree. index_ptr is used
    to update index values in recursive calls. index must be initially
    passed as 0 */
    static class node *constructTreeUtil(int pre[], char preLN[], int *index_ptr, int n)
    {
    int index = *index_ptr; // store the current value of index in pre[]
    // Base Case: All nodes are constructed
    if (index == n)
    return null;
    // Allocate memory for this node and increment index for
    // subsequent recursive calls
    static class node *temp = newNode ( pre[index] );
    (*index_ptr)++;
    // If this is an internal node, construct left and right subtrees and link the subtrees
    if (preLN[index] == 'N')
    {
    temp.left = constructTreeUtil(pre, preLN, index_ptr, n);
    temp.right = constructTreeUtil(pre, preLN, index_ptr, n);
    }
    return temp;
    }
    // A wrapper over constructTreeUtil()
    static class node *constructTree(int pre[], char preLN[], int n)
    {
    // Initialize index as 0. Value of index is used in recursion to maintain
    // the current index in pre[] and preLN[] arrays.
    int index = 0;
    return constructTreeUtil (pre, preLN, &index, n);
    }
    /* This function is used only for testing */
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
    int pre[] = {10, 30, 20, 5, 15};
    char preLN[] = {'N', 'N', 'L', 'L', 'L'};
    int n = sizeof(pre)/sizeof(pre[0]);
    // construct the above tree
    root = constructTree (pre, preLN, n);
    // Test the constructed tree
    System.out.printf("Following is Inorder Traversal of the Constructed Binary Tree: \n");
    printInorder (root);
    return 0;
    }
}
