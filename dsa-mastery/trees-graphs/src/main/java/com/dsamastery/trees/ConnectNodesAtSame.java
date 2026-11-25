package com.dsamastery.trees;

import java.util.*;

public class ConnectNodesAtSame {

    static class node{
    int data;
    static class node* left;
    static class node* right;
    static class node* nextRight;
    }
    / \
    / \ \
    / \
    / \ \
    Method 1 (Extend Level Order Traversal or BFS)
    Method 2 (Extend Pre Order Traversal)
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    static class node *nextRight;
    };
    void connectRecur(static class node* p);
    // Sets the nextRight of root and calls connectRecur() for other nodes
    void connect (static class node *p)
    {
    // Set the nextRight for root
    p.nextRight = null;
    // Set the next right for rest of the nodes (other than root)
    connectRecur(p);
    }
    /* Set next right of all descendents of p.
    Assumption: p is a compete binary tree */
    void connectRecur(static class node* p)
    {
    // Base case
    if (!p)
    return;
    // Set the nextRight pointer for p's left child
    if (p.left)
    p.left.nextRight = p.right;
    // Set the nextRight pointer for p's right child
    // p.nextRight will be null if p is the right most child at its level
    if (p.right)
    p.right.nextRight = (p.nextRight)? p.nextRight.left: null;
    // Set nextRight for other nodes in pre order fashion
    connectRecur(p.left);
    connectRecur(p.right);
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
    node.nextRight = null;
    return(node);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    8 2
    /
    */
    static class node *root = newnode(10);
    root.left = newnode(8);
    root.right = newnode(2);
    root.left.left = newnode(3);
    // Populates nextRight pointer in all nodes
    connect(root);
    // Let us check the values of nextRight pointers
    System.out.printf("Following are populated nextRight pointers in the tree "
    "(-1 is printed if there is no nextRight) \n");
    System.out.printf("nextRight of %d is %d \n", root.data,
    root.nextRight? root.nextRight.data: -1);
    System.out.printf("nextRight of %d is %d \n", root.left.data,
    root.left.nextRight? root.left.nextRight.data: -1);
    System.out.printf("nextRight of %d is %d \n", root.right.data,
    root.right.nextRight? root.right.nextRight.data: -1);
    System.out.printf("nextRight of %d is %d \n", root.left.left.data,
    root.left.left.nextRight? root.left.left.nextRight.data: -1);
    getchar();
    return 0;
    }
    / \
    / \ / \
    / \ / \
}
