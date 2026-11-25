package com.dsamastery.trees;

import java.util.*;

public class CheckIfAGiven {

    / \
    / \ \
    Method 1 ( Simple )
    /* A binary tree node has data, left child and right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* A utility function to get the sum of values in tree with root
    as root */
    int sum(static class node *root)
    {
    if(root == null)
    return 0;
    return sum(root.left) + root.data + sum(root.right);
    }
    /* returns 1 if sum property holds for the given
    node and both of its children */
    int isSumTree(static class node* node)
    {
    int ls, rs;
    /* If node is null or it's a leaf node then
    return true */
    if(node == null ||
    (node.left == null && node.right == null))
    return 1;
    /* Get sum of nodes in left and right subtrees */
    ls = sum(node.left);
    rs = sum(node.right);
    /* if the node and both of its children satisfy the
    property return 1 else 0*/
    if((node.data == ls + rs)&&
    isSumTree(node.left) &&
    isSumTree(node.right))
    return 1;
    return 0;
    }
    /*
    Helper function that allocates a new node
    with the given data and null left and right
    pointers.
    */
    static class node* newNode(int data)
    {
    static class node* node =
    (static class node*)malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Driver program to test above function */
    int main()
    {
    static class node *root = newNode(26);
    root.left = newNode(10);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(6);
    root.right.right = newNode(3);
    if(isSumTree(root))
    System.out.printf("The given tree is a SumTree ");
    else
    System.out.printf("The given tree is not a SumTree ");
    getchar();
    return 0;
    }
    Method 2 ( Tricky )
    /* A binary tree node has data, left child and right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Utillity function to check if the given node is leaf or not */
    int isLeaf(static class node *node)
    {
    if(node == null)
    return 0;
    if(node.left == null && node.right == null)
    return 1;
    return 0;
    }
    /* returns 1 if SumTree property holds for the given
    tree */
    int isSumTree(static class node* node)
    {
    int ls; // for sum of nodes in left subtree
    int rs; // for sum of nodes in right subtree
    /* If node is null or it's a leaf node then
    return true */
    if(node == null || isLeaf(node))
    return 1;
    if( isSumTree(node.left) && isSumTree(node.right))
    {
    // Get the sum of nodes in left subtree
    if(node.left == null)
    ls = 0;
    else if(isLeaf(node.left))
    ls = node.left.data;
    else
    ls = 2*(node.left.data);
    // Get the sum of nodes in right subtree
    if(node.right == null)
    rs = 0;
    else if(isLeaf(node.right))
    rs = node.right.data;
    else
    rs = 2*(node.right.data);
    /* If root's data is equal to sum of nodes in left
    and right subtrees then return 1 else return 0*/
    return(node.data == ls + rs);
    }
    return 0;
    }
    /* Helper function that allocates a new node
    with the given data and null left and right
    pointers.
    */
    static class node* newNode(int data)
    {
    static class node* node =
    (static class node*)malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    /* Driver program to test above function */
    int main()
    {
    static class node *root = newNode(26);
    root.left = newNode(10);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(6);
    root.right.right = newNode(3);
    if(isSumTree(root))
    System.out.printf("The given tree is a SumTree ");
    else
    System.out.printf("The given tree is not a SumTree ");
    getchar();
    return 0;
    }
}
