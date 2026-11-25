package com.dsamastery.trees;

import java.util.*;

public class WriteAnECient {

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
    /* Change a tree so that the roles of the left and
    right pointers are swapped at every node.
    So the tree...
    / \
    2 5
    / \
    1 3
    is changed to...
    / \
    5 2
    / \
    3 1
    */
    void mirror(static class node* node)
    {
    if (node==null)
    return;
    else
    {
    static class node* temp;
    /* do the subtrees */
    mirror(node.left);
    mirror(node.right);
    /* swap the pointers in this node */
    temp = node.left;
    node.left = node.right;
    node.right = temp;
    }
    }
    /* Helper function to test mirror(). Given a binary
    search tree, print out its data elements in
    increasing sorted order.*/
    void inOrder(static class node* node)
    {
    if (node == null)
    return;
    inOrder(node.left);
    System.out.printf("%d ", node.data);
    inOrder(node.right);
    }
    /* Driver program to test mirror() */
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    /* Print inorder traversal of the input tree */
    System.out.printf("\n Inorder traversal of the constructed tree is \n");
    inOrder(root);
    /* Convert tree to its mirror */
    mirror(root);
    /* Print inorder traversal of the mirror tree */
    System.out.printf("\n Inorder traversal of the mirror tree is \n");
    inOrder(root);
    getchar();
    return 0;
    }
    will be same as Tree traversal (Please see our Tree Traversal post for details)
}
