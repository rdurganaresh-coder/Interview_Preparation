package com.dsamastery.trees;

import java.util.*;

public class ProgramToCountLeaf {

    getLeafCount(node)
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Function to get the count of leaf nodes in a binary tree*/
    unsigned int getLeafCount(static class node* node)
    {
    if(node == null)
    return 0;
    if(node.left == null && node.right==null)
    return 1;
    else
    return getLeafCount(node.left)+
    getLeafCount(node.right);
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
    /*Driver program to test above functions*/
    int main()
    {
    /*create a tree*/
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    /*get leaf count of the above created tree*/
    System.out.printf("Leaf count of the tree is %d", getLeafCount(root));
    getchar();
    return 0;
    }
    will be same as Tree traversal (Please see our Tree Traversal post for details)
}
