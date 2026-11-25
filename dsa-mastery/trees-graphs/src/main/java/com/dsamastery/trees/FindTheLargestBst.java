package com.dsamastery.trees;

import java.util.*;

public class FindTheLargestBst {

    / \
    / \
    / \
    / \
    / \ / \
    / \
    / \
    / \
    Method 1 (Simple but ineﬃcient)
    /*
    See http://www.geeksforgeeks.org/archives/632 for implementation of size()
    See Method 3 of http://www.geeksforgeeks.org/archives/3042 for
    implementation of isBST()
    max() returns maximum of two integers
    */
    int largestBST(static class node *root)
    {
    if (isBST(root))
    return size(root);
    else
    return max(largestBST(root.left), largestBST(root.right));
    }
    Method 2 (Tricky and Eﬃcient)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
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
    int largestBSTUtil(static class node* node, int *min_ref, int *max_ref,
    int *max_size_ref, boolean *is_bst_ref);
    /* Returns size of the largest BST subtree in a Binary Tree
    (efficient version). */
    int largestBST(static class node* node)
    {
    // Set the initial values for calling largestBSTUtil()
    int min = INT_MAX; // For minimum value in right subtree
    int max = INT_MIN; // For maximum value in left subtree
    int max_size = 0; // For size of the largest BST
    boolean is_bst = 0;
    largestBSTUtil(node, &min, &max, &max_size, &is_bst);
    return max_size;
    }
    /* largestBSTUtil() updates *max_size_ref for the size of the largest BST
    subtree. Also, if the tree rooted with node is non-empty and a BST,
    then returns size of the tree. Otherwise returns 0.*/
    int largestBSTUtil(static class node* node, int *min_ref, int *max_ref,
    int *max_size_ref, boolean *is_bst_ref)
    {
    /* Base Case */
    if (node == null)
    {
    *is_bst_ref = 1; // An empty tree is BST
    return 0; // Size of the BST is 0
    }
    int min = INT_MAX;
    /* A flag variable for left subtree property
    i.e., max(root.left) < root.data */
    boolean left_flag = false;
    /* A flag variable for right subtree property
    i.e., min(root.right) > root.data */
    boolean right_flag = false;
    int ls, rs; // To store sizes of left and right subtrees
    /* Following tasks are done by recursive call for left subtree
    a) Get the maximum value in left subtree (Stored in *max_ref)
    b) Check whether Left Subtree is BST or not (Stored in *is_bst_ref)
    c) Get the size of maximum size BST in left subtree (updates *max_size) */
    *max_ref = INT_MIN;
    ls = largestBSTUtil(node.left, min_ref, max_ref, max_size_ref, is_bst_ref);
    if (*is_bst_ref == 1 && node.data > *max_ref)
    left_flag = true;
    /* Before updating *min_ref, store the min value in left subtree. So that we
    have the correct minimum value for this subtree */
    min = *min_ref;
    /* The following recursive call does similar (similar to left subtree)
    task for right subtree */
    *min_ref = INT_MAX;
    rs = largestBSTUtil(node.right, min_ref, max_ref, max_size_ref, is_bst_ref);
    if (*is_bst_ref == 1 && node.data < *min_ref)
    right_flag = true;
    // Update min and max values for the parent recursive calls
    if (min < *min_ref)
    *min_ref = min;
    if (node.data < *min_ref) // For leaf nodes
    *min_ref = node.data;
    if (node.data > *max_ref)
    *max_ref = node.data;
    /* If both left and right subtrees are BST. And left and right
    subtree properties hold for this node, then this tree is BST.
    So return the size of this tree */
    if(left_flag && right_flag)
    {
    if (ls + rs + 1 > *max_size_ref)
    *max_size_ref = ls + rs + 1;
    return ls + rs + 1;
    }
    else
    {
    //Since this subtree is not BST, set is_bst flag for parent calls
    *is_bst_ref = 0;
    return 0;
    }
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Let us construct the following Tree
    / \
    10 60
    / \ / \
    5 20 55 70
    / / \
    45 65 80
    */
    static class node *root = newNode(50);
    root.left = newNode(10);
    root.right = newNode(60);
    root.left.left = newNode(5);
    root.left.right = newNode(20);
    root.right.left = newNode(55);
    root.right.left.left = newNode(45);
    root.right.right = newNode(70);
    root.right.right.left = newNode(65);
    root.right.right.right = newNode(80);
    /* The complete tree is not BST as 45 is in right subtree of 50.
    The following subtree is the largest BST
    / \
    55 70
    / / \
    45 65 80
    */
    System.out.printf(" Size of the largest BST is %d", largestBST(root));
    getchar();
    return 0;
    }
}
