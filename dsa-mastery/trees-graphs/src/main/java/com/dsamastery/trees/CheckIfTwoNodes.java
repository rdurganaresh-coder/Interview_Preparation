package com.dsamastery.trees;

import java.util.*;

public class CheckIfTwoNodes {

    / \
    / \ / \
    // C program to check if two Nodes in a binary tree are cousins
    // A Binary Tree Node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to create a new Binary Tree Node
    static class Node *newNode(int item)
    {
    static class Node *temp = (static class Node *)malloc(sizeof(static class Node));
    temp.data = item;
    temp.left = temp.right = null;
    return temp;
    }
    // Recursive function to check if two Nodes are siblings
    int isSibling(static class Node *root, static class Node *a, static class Node *b)
    {
    // Base case
    if (root==null) return 0;
    return ((root.left==a && root.right==b)||
    (root.left==b && root.right==a)||
    isSibling(root.left, a, b)||
    isSibling(root.right, a, b));
    }
    // Recursive function to find level of Node 'ptr' in a binary tree
    int level(static class Node *root, static class Node *ptr, int lev)
    {
    // base cases
    if (root == null) return 0;
    if (root == ptr) return lev;
    // Return level if Node is present in left subtree
    int l = level(root.left, ptr, lev+1);
    if (l != 0) return l;
    // Else search in right subtree
    return level(root.right, ptr, lev+1);
    }
    // Returns 1 if a and b are cousins, otherwise 0
    int isCousin(static class Node *root, static class Node *a, static class Node *b)
    {
    //1. The two Nodes should be on the same level in the binary tree.
    //2. The two Nodes should not be siblings (means that they should
    // not have the same parent Node).
    if ((level(root,a,1) == level(root,b,1)) && !(isSibling(root,a,b)))
    return 1;
    else return 0;
    }
    // Driver Program to test above functions
    int main()
    {
    static class Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.left.right.right = newNode(15);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.right.left.right = newNode(8);
    static class Node *Node1,*Node2;
    Node1 = root.left.left;
    Node2 = root.right.right;
    isCousin(root,Node1,Node2)? puts("Yes"): puts("No");
    return 0;
    }
}
