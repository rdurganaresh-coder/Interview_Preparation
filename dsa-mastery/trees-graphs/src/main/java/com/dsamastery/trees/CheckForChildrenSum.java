package com.dsamastery.trees;

import java.util.*;

public class CheckForChildrenSum {

    /* Program to check children sum property */
    /* A binary tree node has data, left child and right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* returns 1 if children sum property holds for the given
    node and both of its children*/
    int isSumProperty(static class node* node)
    {
    /* left_data is left child data and right_data is for right child data*/
    int left_data = 0, right_data = 0;
    /* If node is null or it's a leaf node then
    return true */
    if(node == null ||
    (node.left == null && node.right == null))
    return 1;
    else
    {
    /* If left child is not present then 0 is used
    as data of left child */
    if(node.left != null)
    left_data = node.left.data;
    /* If right child is not present then 0 is used
    as data of right child */
    if(node.right != null)
    right_data = node.right.data;
    /* if the node and both of its children satisfy the
    property return 1 else 0*/
    if((node.data == left_data + right_data)&&
    isSumProperty(node.left) &&
    isSumProperty(node.right))
    return 1;
    else
    return 0;
    }
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
    static class node *root = newNode(10);
    root.left = newNode(8);
    root.right = newNode(2);
    root.left.left = newNode(3);
    root.left.right = newNode(5);
    root.right.right = newNode(2);
    if(isSumProperty(root))
    System.out.printf("The given tree satisfies the children sum property ");
    else
    System.out.printf("The given tree does not satisfy the children sum property ");
    getchar();
    return 0;
    }
}
