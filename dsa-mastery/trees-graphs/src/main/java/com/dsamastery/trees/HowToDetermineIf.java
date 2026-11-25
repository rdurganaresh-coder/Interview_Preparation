package com.dsamastery.trees;

import java.util.*;

public class HowToDetermineIf {

    /* program to check if a tree is height-balanced or not */
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Returns the height of a binary tree */
    int height(static class node* node);
    /* Returns true if binary tree with root as root is height-balanced */
    boolean isBalanced(static class node *root)
    {
    int lh; /* for height of left subtree */
    int rh; /* for height of right subtree */
    /* If tree is empty then return true */
    if(root == null)
    return 1;
    /* Get the height of left and right sub trees */
    lh = height(root.left);
    rh = height(root.right);
    if( abs(lh-rh) <= 1 &&
    isBalanced(root.left) &&
    isBalanced(root.right))
    return 1;
    /* If we reach here then tree is not height-balanced */
    return 0;
    }
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
    /* returns maximum of two integers */
    int max(int a, int b)
    {
    return (a >= b)? a: b;
    }
    /* The function Compute the "height" of a tree. Height is the
    number of nodes along the longest path from the root node
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
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.left.left.left = newNode(8);
    if(isBalanced(root))
    System.out.printf("Tree is balanced");
    else
    System.out.printf("Tree is not balanced");
    getchar();
    return 0;
    }
    /* program to check if a tree is height-balanced or not */
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* The function returns true if root is balanced else false
    The second parameter is to store the height of tree.
    Initially, we need to pass a pointer to a location with value
    as 0. We can also write a wrapper over this function */
    boolean isBalanced(static class node *root, int* height)
    {
    /* lh --> Height of left subtree
    rh --> Height of right subtree */
    int lh = 0, rh = 0;
    /* l will be true if left subtree is balanced
    and r will be true if right subtree is balanced */
    int l = 0, r = 0;
    if(root == null)
    {
    *height = 0;
    return 1;
    }
    /* Get the heights of left and right subtrees in lh and rh
    And store the returned values in l and r */
    l = isBalanced(root.left, &lh);
    r = isBalanced(root.right,&rh);
    /* Height of current node is max of heights of left and
    right subtrees plus 1*/
    *height = (lh > rh? lh: rh) + 1;
    /* If difference between heights of left and right
    subtrees is more than 2 then this node is not balanced
    so return 0 */
    if((lh - rh >= 2) || (rh - lh >= 2))
    return 0;
    /* If this node is balanced and left and right subtrees
    are balanced then return true */
    else return l&&r;
    }
    /* UTILITY FUNCTIONS TO TEST isBalanced() FUNCTION */
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
    int main()
    {
    int height = 0;
    /* Constructed binary tree is
    / \
    2 3
    / \ /
    4 5 6
    /
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.left.left.left = newNode(7);
    if(isBalanced(root, &height))
    System.out.printf("Tree is balanced");
    else
    System.out.printf("Tree is not balanced");
    getchar();
    return 0;
    }
}
