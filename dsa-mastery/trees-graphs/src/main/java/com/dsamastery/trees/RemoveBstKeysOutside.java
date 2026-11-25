package com.dsamastery.trees;

import java.util.*;

public class RemoveBstKeysOutside {

    // A C++ program to remove BST keys outside the given range
    // A BST node has key, and left and right pointers
    static class node
    {
    int key;
    static class node *left;
    static class node *right;
    };
    // Resmoves all nodes having value outside the given range and returns the root
    // of modified tree
    node* removeOutsideRange(node *root, int min, int max)
    {
    // Base Case
    if (root == null)
    return null;
    // First fix the left and right subtrees of root
    root.left = removeOutsideRange(root.left, min, max);
    root.right = removeOutsideRange(root.right, min, max);
    // Now fix the root. There are 2 possible cases for toot
    // 1.a) Root's key is smaller than min value (root is not in range)
    if (root.key < min)
    {
    node *rChild = root.right;
    delete root;
    return rChild;
    }
    // 1.b) Root's key is greater than max value (root is not in range)
    if (root.key > max)
    {
    node *lChild = root.left;
    delete root;
    return lChild;
    }
    // 2. Root is in range
    return root;
    }
    // A utility function to create a new BST node with key as given num
    node* newNode(int num)
    {
    node* temp = new node;
    temp.key = num;
    temp.left = temp.right = null;
    return temp;
    }
    // A utility function to insert a given key to BST
    node* insert(node* root, int key)
    {
    if (root == null)
    return newNode(key);
    if (root.key > key)
    root.left = insert(root.left, key);
    else
    root.right = insert(root.right, key);
    return root;
    }
    // Utility function to traverse the binary tree after conversion
    void inorderTraversal(node* root)
    {
    if (root)
    {
    inorderTraversal( root.left );
    System.out.print(root.key << " ");
    inorderTraversal( root.right );
    }
    }
    // Driver program to test above functions
    int main()
    {
    node* root = null;
    root = insert(root, 6);
    root = insert(root, -13);
    root = insert(root, 14);
    root = insert(root, -8);
    root = insert(root, 15);
    root = insert(root, 13);
    root = insert(root, 7);
    System.out.print("Inorder traversal of the given tree is: ");
    inorderTraversal(root);
    root = removeOutsideRange(root, -10, 13);
    System.out.print("\nInorder traversal of the modified tree is: ");
    inorderTraversal(root);
    return 0;
    }
}
