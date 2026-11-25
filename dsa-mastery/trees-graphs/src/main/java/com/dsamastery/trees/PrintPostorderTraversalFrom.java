package com.dsamastery.trees;

import java.util.*;

public class PrintPostorderTraversalFrom {

    Inorder traversal in[] = {4, 2, 5, 1, 3, 6}
    Preorder traversal pre[] = {1, 2, 4, 5, 3, 6}
    Postorder traversal is {4, 5, 2, 6, 3, 1}
    / \
    / \ \
    // C++ program to print postorder traversal from preorder and inorder traversals
    // A utility function to search x in arr[] of size n
    int search(int arr[], int x, int n)
    {
    for (int i = 0; i < n; i++)
    if (arr[i] == x)
    return i;
    return -1;
    }
    // Prints postorder traversal from given inorder and preorder traversals
    void printPostOrder(int in[], int pre[], int n)
    {
    // The first element in pre[] is always root, search it
    // in in[] to find left and right subtrees
    int root = search(in, pre[0], n);
    // If left subtree is not empty, print left subtree
    if (root != 0)
    printPostOrder(in, pre+1, root);
    // If right subtree is not empty, print right subtree
    if (root != n-1)
    printPostOrder(in+root+1, pre+root+1, n-root-1);
    // Print root
    System.out.print(pre[0] << " ");
    }
    // Driver program to test above functions
    int main()
    {
    int in[] = {4, 2, 5, 1, 3, 6};
    int pre[] = {1, 2, 4, 5, 3, 6};
    int n = sizeof(in)/sizeof(in[0]);
    System.out.println("Postorder traversal ");
    printPostOrder(in, pre, n);
    return 0;
    }
}
