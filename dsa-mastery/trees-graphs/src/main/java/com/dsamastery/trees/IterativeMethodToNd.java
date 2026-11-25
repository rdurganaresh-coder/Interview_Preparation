package com.dsamastery.trees;

import java.util.*;

public class IterativeMethodToNd {

    // If number of nodes at this level is 0, return height
    return Height;
    else
    // Remove nodes of this level and add nodes of
    // next level
    while (nodeCount > 0)
    // At this point, queue has nodes of next level
    /* Program to find height of the tree by Iterative Method */
    // A Binary Tree Node
    static class node
    {
    static class node *left;
    int data;
    static class node *right;
    };
    // Iterative method to find height of Bianry Tree
    int treeHeight(node *root)
    {
    // Base Case
    if (root == null)
    return 0;
    // Create an empty queue for level order tarversal
    queue<node *> q;
    // Enqueue Root and initialize height
    q.push(root);
    int height = 0;
    while (1)
    {
    // nodeCount (queue size) indicates number of nodes
    // at current lelvel.
    int nodeCount = q.size();
    if (nodeCount == 0)
    return height;
    height++;
    // Dequeue all nodes of current level and Enqueue all
    // nodes of next level
    while (nodeCount > 0)
    {
    node *node = q.front();
    q.pop();
    if (node.left != null)
    q.push(node.left);
    if (node.right != null)
    q.push(node.right);
    nodeCount--;
    }
    }
    }
    // Utility function to create a new tree node
    node* newNode(int data)
    {
    node *temp = new node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create binary tree shown in above diagram
    node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.print("Height of tree is " << treeHeight(root));
    return 0;
    }
}
