package com.dsamastery.trees;

import java.util.*;

public class SortedArrayToBalanced {

    Input: Array {1, 2, 3}
    / \
    Input: Array {1, 2, 3, 4}
    / \
    /* A Binary Tree node */
    static class TNode
    {
    int data;
    static class TNode* left;
    static class TNode* right;
    };
    static class TNode* newNode(int data);
    /* A function that constructs Balanced Binary Search Tree from a sorted array */
    static class TNode* sortedArrayToBST(int arr[], int start, int end)
    {
    /* Base Case */
    if (start > end)
    return null;
    /* Get the middle element and make it root */
    int mid = (start + end)/2;
    static class TNode *root = newNode(arr[mid]);
    /* Recursively construct the left subtree and make it
    left child of root */
    root.left = sortedArrayToBST(arr, start, mid-1);
    /* Recursively construct the right subtree and make it
    right child of root */
    root.right = sortedArrayToBST(arr, mid+1, end);
    return root;
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class TNode* newNode(int data)
    {
    static class TNode* node = (static class TNode*)
    malloc(sizeof(static class TNode));
    node.data = data;
    node.left = null;
    node.right = null;
    return node;
    }
    /* A utility function to print preorder traversal of BST */
    void preOrder(static class TNode* node)
    {
    if (node == null)
    return;
    System.out.printf("%d ", node.data);
    preOrder(node.left);
    preOrder(node.right);
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    int n = sizeof(arr)/sizeof(arr[0]);
    /* Convert List to BST */
    static class TNode *root = sortedArrayToBST(arr, 0, n-1);
    System.out.printf("\n PreOrder Traversal of constructed BST ");
    preOrder(root);
    return 0;
    }
}
