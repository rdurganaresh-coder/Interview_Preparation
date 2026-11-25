package com.dsamastery.trees;

import java.util.*;

public class IterativePreorderTraversal {

    /* A binary tree node has data, left child and right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Helper function that allocates a new node with the given data and
    null left and right pointers.*/
    static class node* newNode(int data)
    {
    static class node* node = new static class node;
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    // An iterative process to print preorder traversal of Binary tree
    void iterativePreorder(node *root)
    {
    // Base Case
    if (root == null)
    return;
    // Create an empty stack and push root to it
    stack<node *> nodeStack;
    nodeStack.push(root);
    /* Pop all items one by one. Do following for every popped item
    a) print it
    b) push its right child
    c) push its left child
    Note that right child is pushed first so that left is processed first */
    while (nodeStack.empty() == false)
    {
    // Pop the top item from stack and print it
    static class node *node = nodeStack.top();
    System.out.printf("%d ", node.data);
    nodeStack.pop();
    // Push right and left children of the popped node to stack
    if (node.right)
    nodeStack.push(node.right);
    if (node.left)
    nodeStack.push(node.left);
    }
    }
    // Driver program to test above functions
    int main()
    {
    /* Constructed binary tree is
    / \
    8 2
    / \ /
    3 5 2
    */
    static class node *root = newNode(10);
    root.left = newNode(8);
    root.right = newNode(2);
    root.left.left = newNode(3);
    root.left.right = newNode(5);
    root.right.left = newNode(2);
    iterativePreorder(root);
    return 0;
    }
}
