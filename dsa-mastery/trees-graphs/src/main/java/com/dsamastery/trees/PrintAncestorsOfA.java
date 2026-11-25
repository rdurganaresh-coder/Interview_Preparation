package com.dsamastery.trees;

import java.util.*;

public class PrintAncestorsOfA {

    / \
    / \
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* If target is present in tree, then prints the ancestors
    and returns true, otherwise returns false. */
    boolean printAncestors(static class node *root, int target)
    {
    /* base cases */
    if (root == null)
    return false;
    if (root.data == target)
    return true;
    /* If target is present in either left or right subtree of this node,
    then print this node */
    if ( printAncestors(root.left, target) ||
    printAncestors(root.right, target) )
    {
    System.out.print(root.data << " ");
    return true;
    }
    /* Else return false */
    return false;
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newnode(int data)
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
    /* Construct the following binary tree
    / \
    2 3
    / \
    4 5
    /
    */
    static class node *root = newnode(1);
    root.left = newnode(2);
    root.right = newnode(3);
    root.left.left = newnode(4);
    root.left.right = newnode(5);
    root.left.left.left = newnode(7);
    printAncestors(root, 7);
    getchar();
    return 0;
    }
}
