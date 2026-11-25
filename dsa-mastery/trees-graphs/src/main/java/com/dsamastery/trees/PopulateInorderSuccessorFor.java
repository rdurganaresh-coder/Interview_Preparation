package com.dsamastery.trees;

import java.util.*;

public class PopulateInorderSuccessorFor {

    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    static class node* next;
    }
    Solution (Use Reverse Inorder Traversal)
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    static class node *next;
    };
    /* Set next of p and all descendents of p by traversing them in reverse Inorder */
    void populateNext(static class node* p)
    {
    // The first visited node will be the rightmost node
    // next of the rightmost node will be null
    static static class node *next = null;
    if (p)
    {
    // First set the next pointer in right subtree
    populateNext(p.right);
    // Set the next as previously visited node in reverse Inorder
    p.next = next;
    // Change the prev for subsequent node
    next = p;
    // Finally, set the next pointer in left subtree
    populateNext(p.left);
    }
    }
    /* UTILITY FUNCTIONS */
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class node* newnode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = null;
    node.right = null;
    node.next = null;
    return(node);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    8 12
    /
    */
    static class node *root = newnode(10);
    root.left = newnode(8);
    root.right = newnode(12);
    root.left.left = newnode(3);
    // Populates nextRight pointer in all nodes
    populateNext(root);
    // Let us see the populated values
    static class node *ptr = root.left.left;
    while(ptr)
    {
    // -1 is printed if there is no successor
    System.out.printf("Next of %d is %d \n", ptr.data, ptr.next? ptr.next.data: -1);
    ptr = ptr.next;
    }
    return 0;
    }
    // An implementation that doesn't use static variable
    // A wrapper over populateNextRecur
    void populateNext(static class node *root)
    {
    // The first visited node will be the rightmost node
    // next of the rightmost node will be null
    static class node *next = null;
    populateNextRecur(root, &next);
    }
    /* Set next of all descendents of p by traversing them in reverse Inorder */
    void populateNextRecur(static class node* p, static class node **next_ref)
    {
    if (p)
    {
    // First set the next pointer in right subtree
    populateNextRecur(p.right, next_ref);
    // Set the next as previously visited node in reverse Inorder
    p.next = *next_ref;
    // Change the prev for subsequent node
    *next_ref = p;
    // Finally, set the next pointer in right subtree
    populateNextRecur(p.left, next_ref);
    }
    }
}
