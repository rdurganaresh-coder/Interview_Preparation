package com.dsamastery.trees;

import java.util.*;

public class ConnectNodesAtSame {

    static class node {
    int data;
    static class node* left;
    static class node* right;
    static class node* nextRight;
    }
    / \
    / \ \
    / \
    / \ \
    / \
    / \ / \
    / \ / \
    void connectRecur(static class node* p);
    static class node *getNextRight(static class node *p);
    // Sets the nextRight of root and calls connectRecur() for other nodes
    void connect (static class node *p)
    {
    // Set the nextRight for root
    p.nextRight = null;
    // Set the next right for rest of the nodes (other than root)
    connectRecur(p);
    }
    /* Set next right of all descendents of p. This function makes sure that
    nextRight of nodes ar level i is set before level i+1 nodes. */
    void connectRecur(static class node* p)
    {
    // Base case
    if (!p)
    return;
    /* Before setting nextRight of left and right children, set nextRight
    of children of other nodes at same level (because we can access
    children of other nodes using p's nextRight only) */
    if (p.nextRight != null)
    connectRecur(p.nextRight);
    /* Set the nextRight pointer for p's left child */
    if (p.left)
    {
    if (p.right)
    {
    p.left.nextRight = p.right;
    p.right.nextRight = getNextRight(p);
    }
    else
    p.left.nextRight = getNextRight(p);
    /* Recursively call for next level nodes. Note that we call only
    for left child. The call for left child will call for right child */
    connectRecur(p.left);
    }
    /* If left child is null then first node of next level will either be
    p.right or getNextRight(p) */
    else if (p.right)
    {
    p.right.nextRight = getNextRight(p);
    connectRecur(p.right);
    }
    else
    connectRecur(getNextRight(p));
    }
    /* This function returns the leftmost child of nodes at the same level as p.
    This function is used to getNExt right of p's right child
    If right child of p is null then this can also be used for the left child */
    static class node *getNextRight(static class node *p)
    {
    static class node *temp = p.nextRight;
    /* Traverse nodes at p's level and find and return
    the first node's first child */
    while(temp != null)
    {
    if(temp.left != null)
    return temp.left;
    if(temp.right != null)
    return temp.right;
    temp = temp.nextRight;
    }
    // If all the nodes at p's level are leaf nodes then return null
    return null;
    }
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    static class node *nextRight;
    };
    /* This function returns the leftmost child of nodes at the same level as p.
    This function is used to getNExt right of p's right child
    If right child of is null then this can also be sued for the left child */
    static class node *getNextRight(static class node *p)
    {
    static class node *temp = p.nextRight;
    /* Traverse nodes at p's level and find and return
    the first node's first child */
    while (temp != null)
    {
    if (temp.left != null)
    return temp.left;
    if (temp.right != null)
    return temp.right;
    temp = temp.nextRight;
    }
    // If all the nodes at p's level are leaf nodes then return null
    return null;
    }
    /* Sets nextRight of all nodes of a tree with root as p */
    void connect(static class node* p)
    {
    static class node *temp;
    if (!p)
    return;
    // Set nextRight for root
    p.nextRight = null;
    // set nextRight of all levels one by one
    while (p != null)
    {
    static class node *q = p;
    /* Connect all childrem nodes of p and children nodes of all other nodes
    at same level as p */
    while (q != null)
    {
    // Set the nextRight pointer for p's left child
    if (q.left)
    {
    // If q has right child, then right child is nextRight of
    // p and we also need to set nextRight of right child
    if (q.right)
    q.left.nextRight = q.right;
    else
    q.left.nextRight = getNextRight(q);
    }
    if (q.right)
    q.right.nextRight = getNextRight(q);
    // Set nextRight for other nodes in pre order fashion
    q = q.nextRight;
    }
    // start from the first node of next level
    if (p.left)
    p = p.left;
    else if (p.right)
    p = p.right;
    else
    p = getNextRight(p);
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
    node.nextRight = null;
    return(node);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    8 2
    / \
    3 90
    */
    static class node *root = newnode(10);
    root.left = newnode(8);
    root.right = newnode(2);
    root.left.left = newnode(3);
    root.right.right = newnode(90);
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
    System.out.printf("nextRight of %d is %d \n", root.right.right.data,
    root.right.right.nextRight? root.right.right.nextRight.data: -1);
    getchar();
    return 0;
    }
}
