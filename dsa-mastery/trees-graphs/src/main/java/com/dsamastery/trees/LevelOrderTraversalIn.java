package com.dsamastery.trees;

import java.util.*;

public class LevelOrderTraversalIn {

    Method 1 (Recursive)
    printSpiral(tree)
    boolean ltr = 0;
    printGivenLevel(tree, d, ltr);
    ltr ~= ltr /*flip ltr*/
    printGivenLevel(tree, level, ltr)
    if tree is null then return;
    print(tree.data);
    else if level greater than 1, then
    if(ltr)
    printGivenLevel(tree.left, level-1, ltr);
    printGivenLevel(tree.right, level-1, ltr);
    else
    printGivenLevel(tree.right, level-1, ltr);
    printGivenLevel(tree.left, level-1, ltr);
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Function protoypes */
    void printGivenLevel(static class node* root, int level, int ltr);
    int height(static class node* node);
    static class node* newNode(int data);
    /* Function to print spiral traversal of a tree*/
    void printSpiral(static class node* root)
    {
    int h = height(root);
    int i;
    /*ltr.Left to Right. If this variable is set,
    then the given level is traverseed from left to right. */
    boolean ltr = false;
    for(i=1; i<=h; i++)
    {
    printGivenLevel(root, i, ltr);
    /*Revert ltr to traverse next level in oppposite order*/
    ltr = !ltr;
    }
    }
    /* Print nodes at a given level */
    void printGivenLevel(static class node* root, int level, int ltr)
    {
    if(root == null)
    return;
    if(level == 1)
    System.out.printf("%d ", root.data);
    else if (level > 1)
    {
    if(ltr)
    {
    printGivenLevel(root.left, level-1, ltr);
    printGivenLevel(root.right, level-1, ltr);
    }
    else
    {
    printGivenLevel(root.right, level-1, ltr);
    printGivenLevel(root.left, level-1, ltr);
    }
    }
    }
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the height of each subtree */
    int lheight = height(node.left);
    int rheight = height(node.right);
    /* use the larger one */
    if (lheight > rheight)
    return(lheight+1);
    else return(rheight+1);
    }
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
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(7);
    root.left.right = newNode(6);
    root.right.left = newNode(5);
    root.right.right = newNode(4);
    System.out.printf("Spiral Order traversal of binary tree is \n");
    printSpiral(root);
    return 0;
    }
    Method 2 (Iterative)
    // C++ implementation of a O(n) time method for spiral order traversal
    // Binary Tree node
    static class node
    {
    int data;
    static class node *left, *right;
    };
    void printSpiral(static class node *root)
    {
    if (root == null) return; // null check
    // Create two stacks to store alternate levels
    stack<static class node*> s1; // For levels to be printed from right to left
    stack<static class node*> s2; // For levels to be printed from left to right
    // Push first level to first stack 's1'
    s1.push(root);
    // Keep ptinting while any of the stacks has some nodes
    while (!s1.empty() || !s2.empty())
    {
    // Print nodes of current level from s1 and push nodes of
    // next level to s2
    while (!s1.empty())
    {
    static class node *temp = s1.top();
    s1.pop();
    System.out.print(temp.data << " ");
    // Note that is right is pushed before left
    if (temp.right)
    s2.push(temp.right);
    if (temp.left)
    s2.push(temp.left);
    }
    // Print nodes of current level from s2 and push nodes of
    // next level to s1
    while (!s2.empty())
    {
    static class node *temp = s2.top();
    s2.pop();
    System.out.print(temp.data << " ");
    // Note that is left is pushed before right
    if (temp.left)
    s1.push(temp.left);
    if (temp.right)
    s1.push(temp.right);
    }
    }
    }
    // A utility functiont to create a new node
    static class node* newNode(int data)
    {
    static class node* node = new static class node;
    node.data = data;
    node.left = null;
    node.right = null;
    return(node);
    }
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(7);
    root.left.right = newNode(6);
    root.right.left = newNode(5);
    root.right.right = newNode(4);
    System.out.print("Spiral Order traversal of binary tree is \n");
    printSpiral(root);
    return 0;
    }
}
