package com.dsamastery.trees;

import java.util.*;

public class MergeTwoBalancedBinary {

    Method 1 (Insert elements of ﬁrst tree to second)
    Method 2 (Merge Inorder Traversals)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    // A utility unction to merge two sorted arrays into one
    int *merge(int arr1[], int arr2[], int m, int n);
    // A helper function that stores inorder traversal of a tree in inorder array
    void storeInorder(static class node* node, int inorder[], int *index_ptr);
    /* A function that constructs Balanced Binary Search Tree from a sorted array
    See http://www.geeksforgeeks.org/archives/17138 */
    static class node* sortedArrayToBST(int arr[], int start, int end);
    /* This function merges two balanced BSTs with roots as root1 and root2.
    m and n are the sizes of the trees respectively */
    static class node* mergeTrees(static class node *root1, static class node *root2, int m, int n)
    {
    // Store inorder traversal of first tree in an array arr1[]
    int *arr1 = new int[m];
    int i = 0;
    storeInorder(root1, arr1, &i);
    // Store inorder traversal of second tree in another array arr2[]
    int *arr2 = new int[n];
    int j = 0;
    storeInorder(root2, arr2, &j);
    // Merge the two sorted array into one
    int *mergedArr = merge(arr1, arr2, m, n);
    // Construct a tree from the merged array and return root of the tree
    return sortedArrayToBST (mergedArr, 0, m+n-1);
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
    // A utility function to print inorder traversal of a given binary tree
    void printInorder(static class node* node)
    {
    if (node == null)
    return;
    /* first recur on left child */
    printInorder(node.left);
    System.out.printf("%d ", node.data);
    /* now recur on right child */
    printInorder(node.right);
    }
    // A utility unction to merge two sorted arrays into one
    int *merge(int arr1[], int arr2[], int m, int n)
    {
    // mergedArr[] is going to contain result
    int *mergedArr = new int[m + n];
    int i = 0, j = 0, k = 0;
    // Traverse through both arrays
    while (i < m && j < n)
    {
    // Pick the smaler element and put it in mergedArr
    if (arr1[i] < arr2[j])
    {
    mergedArr[k] = arr1[i];
    i++;
    }
    else
    {
    mergedArr[k] = arr2[j];
    j++;
    }
    k++;
    }
    // If there are more elements in first array
    while (i < m)
    {
    mergedArr[k] = arr1[i];
    i++; k++;
    }
    // If there are more elements in second array
    while (j < n)
    {
    mergedArr[k] = arr2[j];
    j++; k++;
    }
    return mergedArr;
    }
    // A helper function that stores inorder traversal of a tree rooted with node
    void storeInorder(static class node* node, int inorder[], int *index_ptr)
    {
    if (node == null)
    return;
    /* first recur on left child */
    storeInorder(node.left, inorder, index_ptr);
    inorder[*index_ptr] = node.data;
    (*index_ptr)++; // increase index for next entry
    /* now recur on right child */
    storeInorder(node.right, inorder, index_ptr);
    }
    /* A function that constructs Balanced Binary Search Tree from a sorted array
    See http://www.geeksforgeeks.org/archives/17138 */
    static class node* sortedArrayToBST(int arr[], int start, int end)
    {
    /* Base Case */
    if (start > end)
    return null;
    /* Get the middle element and make it root */
    int mid = (start + end)/2;
    static class node *root = newNode(arr[mid]);
    /* Recursively construct the left subtree and make it
    left child of root */
    root.left = sortedArrayToBST(arr, start, mid-1);
    /* Recursively construct the right subtree and make it
    right child of root */
    root.right = sortedArrayToBST(arr, mid+1, end);
    return root;
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Create following tree as first balanced BST
    / \
    50 300
    / \
    20 70
    */
    static class node *root1 = newNode(100);
    root1.left = newNode(50);
    root1.right = newNode(300);
    root1.left.left = newNode(20);
    root1.left.right = newNode(70);
    /* Create following tree as second balanced BST
    / \
    40 120
    */
    static class node *root2 = newNode(80);
    root2.left = newNode(40);
    root2.right = newNode(120);
    static class node *mergedTree = mergeTrees(root1, root2, 5, 3);
    System.out.printf("Following is Inorder traversal of the merged tree \n");
    printInorder(mergedTree);
    getchar();
    return 0;
    }
    Method 3 (In-Place Merge using DLL)
}
