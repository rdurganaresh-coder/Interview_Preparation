package com.dsamastery.trees;

import java.util.*;

public class InorderPredecessorAndSuccessor {

    static class Node
    {
    int key;
    static class Node *left, *right ;
    };
    else
    // C++ program to find predecessor and successor in a BST
    // BST Node
    static class Node
    {
    int key;
    static class Node *left, *right;
    };
    // This function finds predecessor and successor of key in BST.
    // It sets pre and suc as predecessor and successor respectively
    void findPreSuc(Node* root, Node*& pre, Node*& suc, int key)
    {
    // Base case
    if (root == null) return ;
    // If key is present at root
    if (root.key == key)
    {
    // the maximum value in left subtree is predecessor
    if (root.left != null)
    {
    Node* tmp = root.left;
    while (tmp.right)
    tmp = tmp.right;
    pre = tmp ;
    }
    // the minimum value in right subtree is successor
    if (root.right != null)
    {
    Node* tmp = root.right ;
    while (tmp.left)
    tmp = tmp.left ;
    suc = tmp ;
    }
    return ;
    }
    // If key is smaller than root's key, go to left subtree
    if (root.key > key)
    {
    suc = root ;
    findPreSuc(root.left, pre, suc, key) ;
    }
    else // go to right subtree
    {
    pre = root ;
    findPreSuc(root.right, pre, suc, key) ;
    }
    }
    // A utility function to create a new BST node
    Node *newNode(int item)
    {
    Node *temp = new Node;
    temp.key = item;
    temp.left = temp.right = null;
    return temp;
    }
    /* A utility function to insert a new node with given key in BST */
    Node* insert(Node* node, int key)
    {
    if (node == null) return newNode(key);
    if (key < node.key)
    node.left = insert(node.left, key);
    else
    node.right = insert(node.right, key);
    return node;
    }
    // Driver program to test above function
    int main()
    {
    int key = 65; //Key to be searched in BST
    /* Let us create following BST
    / \
    30 70
    / \ / \
    20 40 60 80 */
    Node *root = null;
    root = insert(root, 50);
    insert(root, 30);
    insert(root, 20);
    insert(root, 40);
    insert(root, 70);
    insert(root, 60);
    insert(root, 80);
    Node* pre = null, *suc = null;
    findPreSuc(root, pre, suc, key);
    if (pre != null)
    System.out.println("Predecessor is " << pre.key);
    else
    System.out.print("No Predecessor");
    if (suc != null)
    System.out.print("Successor is " << suc.key);
    else
    System.out.print("No Successor");
    return 0;
    }
}
