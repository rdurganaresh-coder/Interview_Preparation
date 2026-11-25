package com.dsamastery.trees;

import java.util.*;

public class PrintABinaryTree {

    / \
    / \ / \
    \ \
    // C++ program for printing vertical order of a given binary tree
    // Structure for a binary tree node
    static class Node
    {
    int key;
    Node *left, *right;
    };
    // A utility function to create a new node
    static class Node* newNode(int key)
    {
    static class Node* node = new Node;
    node.key = key;
    node.left = node.right = null;
    return node;
    }
    // Utility function to store vertical order in map 'm'
    // 'hd' is horigontal distance of current node from root.
    // 'hd' is initally passed as 0
    void getVerticalOrder(Node* root, int hd, map<int, vector<int>> &m)
    {
    // Base case
    if (root == null)
    return;
    // Store current node in map 'm'
    m[hd].push_back(root.key);
    // Store nodes in left subtree
    getVerticalOrder(root.left, hd-1, m);
    // Store nodes in right subtree
    getVerticalOrder(root.right, hd+1, m);
    }
    // The main function to print vertical oder of a binary tree
    // with given root
    void printVerticalOrder(Node* root)
    {
    // Create a map and store vertical oder in map using
    // function getVerticalOrder()
    map < int,vector<int> > m;
    int hd = 0;
    getVerticalOrder(root, hd,m);
    // Traverse the map and print nodes at every horigontal
    // distance (hd)
    map< int,vector<int> > :: iterator it;
    for (it=m.begin(); it!=m.end(); it++)
    {
    for (int i=0; i<it.second.size(); ++i)
    System.out.print(it.second[i] << " ");
    System.out.print(endl);
    }
    }
    // Driver program to test above functions
    int main()
    {
    Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    root.right.left.right = newNode(8);
    root.right.right.right = newNode(9);
    System.out.print("Vertical order traversal is \n");
    printVerticalOrder(root);
    return 0;
    }
}
