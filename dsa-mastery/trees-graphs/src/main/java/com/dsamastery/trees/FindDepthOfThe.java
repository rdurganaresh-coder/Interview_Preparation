package com.dsamastery.trees;

import java.util.*;

public class FindDepthOfThe {

    / \
    / / \
    \ \
    / \
    // C program to find depth of the deepest odd level leaf node
    // A utility function to find maximum of two integers
    int max(int x, int y) { return (x > y)? x : y; }
    // A Binary Tree node
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to allocate a new tree node
    static class Node* newNode(int data)
    {
    static class Node* node = (static class Node*) malloc(sizeof(static class Node));
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // A recursive function to find depth of the deepest odd level leaf
    int depthOfOddLeafUtil(Node *root,int level)
    {
    // Base Case
    if (root == null)
    return 0;
    // If this node is a leaf and its level is odd, return its level
    if (root.left==null && root.right==null && level&1)
    return level;
    // If not leaf, return the maximum value from left and right subtrees
    return max(depthOfOddLeafUtil(root.left, level+1),
    depthOfOddLeafUtil(root.right, level+1));
    }
    /* Main function which calculates the depth of deepest odd level leaf.
    This function mainly uses depthOfOddLeafUtil() */
    int depthOfOddLeaf(static class Node *root)
    {
    int level = 1, depth = 0;
    return depthOfOddLeafUtil(root, level);
    }
    // Driver program to test above functions
    int main()
    {
    static class Node* root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.right.left = newNode(5);
    root.right.right = newNode(6);
    root.right.left.right = newNode(7);
    root.right.right.right = newNode(8);
    root.right.left.right.left = newNode(9);
    root.right.right.right.right = newNode(10);
    root.right.right.right.right.left = newNode(11);
    System.out.printf("%d is the required depth\n", depthOfOddLeaf(root));
    getchar();
    return 0;
    }
}
