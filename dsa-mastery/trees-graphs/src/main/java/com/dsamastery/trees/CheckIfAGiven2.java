package com.dsamastery.trees;

import java.util.*;

public class CheckIfAGiven {

    \ / \
    \ / \
    / \
    / \
    /* Program to check if a given Binary Tree is balanced like a Red-Black Tree */
    static class Node
    {
    int key;
    Node *left, *right;
    };
    /* utility that allocates a new Node with the given key */
    Node* newNode(int key)
    {
    Node* node = new Node;
    node.key = key;
    node.left = node.right = null;
    return (node);
    }
    // Returns returns tree if the Binary tree is balanced like a Red-Black
    // tree. This function also sets value in maxh and minh (passed by
    // reference). maxh and minh are set as maximum and minimum heights of root.
    boolean isBalancedUtil(Node *root, int &maxh, int &minh)
    {
    // Base case
    if (root == null)
    {
    maxh = minh = 0;
    return true;
    }
    int lmxh, lmnh; // To store max and min heights of left subtree
    int rmxh, rmnh; // To store max and min heights of right subtree
    // Check if left subtree is balanced, also set lmxh and lmnh
    if (isBalancedUtil(root.left, lmxh, lmnh) == false)
    return false;
    // Check if right subtree is balanced, also set rmxh and rmnh
    if (isBalancedUtil(root.right, rmxh, rmnh) == false)
    return false;
    // Set the max and min heights of this node for the parent call
    maxh = max(lmxh, rmxh) + 1;
    minh = min(lmnh, rmnh) + 1;
    // See if this node is balanced
    if (maxh <= 2*minh)
    return true;
    return false;
    }
    // A wrapper over isBalancedUtil()
    boolean isBalanced(Node *root)
    {
    int maxh, minh;
    return isBalancedUtil(root, maxh, minh);
    }
    /* Driver program to test above functions*/
    int main()
    {
    Node * root = newNode(10);
    root.left = newNode(5);
    root.right = newNode(100);
    root.right.left = newNode(50);
    root.right.right = newNode(150);
    root.right.left.left = newNode(40);
    isBalanced(root)? System.out.print("Balanced" : cout << "Not Balanced");
    return 0;
    }
}
