package com.dsamastery.trees;

import java.util.*;

public class MaximumWidthOfA {

    / \
    / \ \
    / \
    Method 1 (Using Level Order Traversal)
    /*Function to print level order traversal of tree*/
    getMaxWidth(tree)
    width = getWidth(tree, i);
    if(width > maxWdth)
    return width
    /*Function to get width of a given level */
    getWidth(tree, level)
    if tree is null then return 0;
    if level is 1, then return 1;
    else if level greater than 1, then
    return getWidth(tree.left, level-1) +
    getWidth(tree.right, level-1);
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /*Function protoypes*/
    int getWidth(static class node* root, int level);
    int height(static class node* node);
    static class node* newNode(int data);
    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(static class node* root)
    {
    int maxWidth = 0;
    int width;
    int h = height(root);
    int i;
    /* Get width of each level and compare
    the width with maximum width so far */
    for(i=1; i<=h; i++)
    {
    width = getWidth(root, i);
    if(width > maxWidth)
    maxWidth = width;
    }
    return maxWidth;
    }
    /* Get width of a given level */
    int getWidth(static class node* root, int level)
    {
    if(root == null)
    return 0;
    if(level == 1)
    return 1;
    else if (level > 1)
    return getWidth(root.left, level-1) +
    getWidth(root.right, level-1);
    }
    /* UTILITY FUNCTIONS */
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the height of each subtree */
    int lHeight = height(node.left);
    int rHeight = height(node.right);
    /* use the larger one */
    return (lHeight > rHeight)? (lHeight+1): (rHeight+1);
    }
    }
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
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.right = newNode(8);
    root.right.right.left = newNode(6);
    root.right.right.right = newNode(7);
    /*
    Constructed bunary tree is:
    / \
    2 3
    / \ \
    4 5 8
    / \
    6 7
    */
    System.out.printf("Maximum width is %d \n", getMaxWidth(root));
    getchar();
    return 0;
    }
    Method 2 (Using Preorder Traversal)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    // A utility function to get height of a binary tree
    int height(static class node* node);
    // A utility function to allocate a new node with given data
    static class node* newNode(int data);
    // A utility function that returns maximum value in arr[] of size n
    int getMax(int arr[], int n);
    // A function that fills count array with count of nodes at every
    // level of given binary tree
    void getMaxWidthRecur(static class node *root, int count[], int level);
    /* Function to get the maximum width of a binary tree*/
    int getMaxWidth(static class node* root)
    {
    int width;
    int h = height(root);
    // Create an array that will store count of nodes at each level
    int *count = (int *)calloc(sizeof(int), h);
    int level = 0;
    // Fill the count array using preorder traversal
    getMaxWidthRecur(root, count, level);
    // Return the maximum value from count array
    return getMax(count, h);
    }
    // A function that fills count array with count of nodes at every
    // level of given binary tree
    void getMaxWidthRecur(static class node *root, int count[], int level)
    {
    if(root)
    {
    count[level]++;
    getMaxWidthRecur(root.left, count, level+1);
    getMaxWidthRecur(root.right, count, level+1);
    }
    }
    /* UTILITY FUNCTIONS */
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the height of each subtree */
    int lHeight = height(node.left);
    int rHeight = height(node.right);
    /* use the larger one */
    return (lHeight > rHeight)? (lHeight+1): (rHeight+1);
    }
    }
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
    // Return the maximum value from count array
    int getMax(int arr[], int n)
    {
    int max = arr[0];
    int i;
    for (i = 0; i < n; i++)
    {
    if (arr[i] > max)
    max = arr[i];
    }
    return max;
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.right = newNode(8);
    root.right.right.left = newNode(6);
    root.right.right.right = newNode(7);
    /*
    Constructed bunary tree is:
    / \
    2 3
    / \ \
    4 5 8
    / \
    6 7
    */
    System.out.printf("Maximum width is %d \n", getMaxWidth(root));
    getchar();
    return 0;
    }
}
