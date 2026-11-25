package com.dsamastery.trees;

import java.util.*;

public class DiameterOfABinary {

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* function to create a new node of tree and returns pointer */
    static class node* newNode(int data);
    /* returns max of two integers */
    int max(int a, int b);
    /* function to Compute height of a tree. */
    int height(static class node* node);
    /* Function to get diameter of a binary tree */
    int diameter(static class node * tree)
    {
    /* base case where tree is empty */
    if (tree == 0)
    return 0;
    /* get the height of left and right sub-trees */
    int lheight = height(tree.left);
    int rheight = height(tree.right);
    /* get the diameter of left and right sub-trees */
    int ldiameter = diameter(tree.left);
    int rdiameter = diameter(tree.right);
    /* Return max of following three
    1) Diameter of left subtree
    2) Diameter of right subtree
    3) Height of left subtree + height of right subtree + 1 */
    return max(lheight + rheight + 1, max(ldiameter, rdiameter));
    }
    /* UTILITY FUNCTIONS TO TEST diameter() FUNCTION */
    /* The function Compute the "height" of a tree. Height is the
    number f nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    /* base case tree is empty */
    if(node == null)
    return 0;
    /* If tree is not empty then height = 1 + max of left
    height and right heights */
    return 1 + max(height(node.left), height(node.right));
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
    /* returns maximum of two integers */
    int max(int a, int b)
    {
    return (a >= b)? a: b;
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    2 3
    / \
    4 5
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Diameter of the given binary tree is %d\n", diameter(root));
    getchar();
    return 0;
    }
    /*The second parameter is to store the height of tree.
    Initially, we need to pass a pointer to a location with value
    as 0. So, function should be used as follows:
    int height = 0;
    static class node *root = SomeFunctionToMakeTree();
    int diameter = diameterOpt(root, &height); */
    int diameterOpt(static class node *root, int* height)
    {
    /* lh --> Height of left subtree
    rh --> Height of right subtree */
    int lh = 0, rh = 0;
    /* ldiameter --> diameter of left subtree
    rdiameter --> Diameter of right subtree */
    int ldiameter = 0, rdiameter = 0;
    if(root == null)
    {
    *height = 0;
    return 0; /* diameter is also 0 */
    }
    /* Get the heights of left and right subtrees in lh and rh
    And store the returned values in ldiameter and ldiameter */
    ldiameter = diameterOpt(root.left, &lh);
    rdiameter = diameterOpt(root.right, &rh);
    /* Height of current node is max of heights of left and
    right subtrees plus 1*/
    *height = max(lh, rh) + 1;
    return max(lh + rh + 1, max(ldiameter, rdiameter));
    }
}
