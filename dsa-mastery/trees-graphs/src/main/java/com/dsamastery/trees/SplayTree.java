package com.dsamastery.trees;

import java.util.*;

public class SplayTree {

    / \ Zig (Right Rotation) / \
    / \
    / \ / \ / \
    / \ ============> / \ / \ ============> / \
    / \ / \
    / \ / \ / \
    / \ ============> / \ / \ ============> / \
    / \ / \
    / \ / \ / \
    / \ ============> / \ ============> / \ / \
    / \ / \
    / \ / \ / \
    / \ =============> / \ ============> / \ / \
    / \ / \
    / \ / \ \
    / search(20) / search(20) / \
    / 1. Zig-Zig \ 2. Zig-Zig \ \
    / \
    // The code is adopted from http://goo.gl/SDH9hH
    // An AVL tree node
    static class node
    {
    int key;
    static class node *left, *right;
    };
    /* Helper function that allocates a new node with the given key and
    null left and right pointers. */
    static class node* newNode(int key)
    {
    static class node* node = (static class node*)malloc(sizeof(static class node));
    node.key = key;
    node.left = node.right = null;
    return (node);
    }
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    static class node *rightRotate(static class node *x)
    {
    static class node *y = x.left;
    x.left = y.right;
    y.right = x;
    return y;
    }
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    static class node *leftRotate(static class node *x)
    {
    static class node *y = x.right;
    x.right = y.left;
    y.left = x;
    return y;
    }
    // This function brings the key at root if key is present in tree.
    // If key is not present, then it brings the last accessed item at
    // root. This function modifies the tree and returns the new root
    static class node *splay(static class node *root, int key)
    {
    // Base cases: root is null or key is present at root
    if (root == null || root.key == key)
    return root;
    // Key lies in left subtree
    if (root.key > key)
    {
    // Key is not in tree, we are done
    if (root.left == null) return root;
    // Zig-Zig (Left Left)
    if (root.left.key > key)
    {
    // First recursively bring the key as root of left-left
    root.left.left = splay(root.left.left, key);
    // Do first rotation for root, second rotation is done after else
    root = rightRotate(root);
    }
    else if (root.left.key < key) // Zig-Zag (Left Right)
    {
    // First recursively bring the key as root of left-right
    root.left.right = splay(root.left.right, key);
    // Do first rotation for root.left
    if (root.left.right != null)
    root.left = leftRotate(root.left);
    }
    // Do second rotation for root
    return (root.left == null)? root: rightRotate(root);
    }
    else // Key lies in right subtree
    {
    // Key is not in tree, we are done
    if (root.right == null) return root;
    // Zag-Zig (Right Left)
    if (root.right.key > key)
    {
    // Bring the key as root of right-left
    root.right.left = splay(root.right.left, key);
    // Do first rotation for root.right
    if (root.right.left != null)
    root.right = rightRotate(root.right);
    }
    else if (root.right.key < key)// Zag-Zag (Right Right)
    {
    // Bring the key as root of right-right and do first rotation
    root.right.right = splay(root.right.right, key);
    root = leftRotate(root);
    }
    // Do second rotation for root
    return (root.right == null)? root: leftRotate(root);
    }
    }
    // The search function for Splay tree. Note that this function
    // returns the new root of Splay Tree. If key is present in tree
    // then, it is moved to root.
    static class node *search(static class node *root, int key)
    {
    return splay(root, key);
    }
    // A utility function to print preorder traversal of the tree.
    // The function also prints height of every node
    void preOrder(static class node *root)
    {
    if (root != null)
    {
    System.out.printf("%d ", root.key);
    preOrder(root.left);
    preOrder(root.right);
    }
    }
    /* Drier program to test above function*/
    int main()
    {
    static class node *root = newNode(100);
    root.left = newNode(50);
    root.right = newNode(200);
    root.left.left = newNode(40);
    root.left.left.left = newNode(30);
    root.left.left.left.left = newNode(20);
    root = search(root, 20);
    System.out.printf("Preorder traversal of the modified Splay tree is \n");
    preOrder(root);
    return 0;
    }
    //www.cs.berkeley.edu/~jrs/61b/lec/36)
}
