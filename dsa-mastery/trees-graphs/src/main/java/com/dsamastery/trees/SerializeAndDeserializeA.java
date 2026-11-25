package com.dsamastery.trees;

import java.util.*;

public class SerializeAndDeserializeA {

    / \
    / \
    / \
    \
    \
    \
    // A C++ program to demonstrate serialization and deserialiation of
    // Binary Tree
    /* A binary tree Node has key, pointer to left and right children */
    static class Node
    {
    int key;
    static class Node* left, *right;
    };
    /* Helper function that allocates a new Node with the
    given key and null left and right pointers. */
    Node* newNode(int key)
    {
    Node* temp = new Node;
    temp.key = key;
    temp.left = temp.right = null;
    return (temp);
    }
    // This function stores a tree in a file pointed by fp
    void serialize(Node *root, FILE *fp)
    {
    // If current node is null, store marker
    if (root == null)
    {
    fprintf(fp, "%d ", MARKER);
    return;
    }
    // Else, store current node and recur for its children
    fprintf(fp, "%d ", root.key);
    serialize(root.left, fp);
    serialize(root.right, fp);
    }
    // This function constructs a tree from a file pointed by 'fp'
    void deSerialize(Node *&root, FILE *fp)
    {
    // Read next item from file. If theere are no more items or next
    // item is marker, then return
    int val;
    if ( !fscanf(fp, "%d ", &val) || val == MARKER)
    return;
    // Else create node with this item and recur for children
    root = newNode(val);
    deSerialize(root.left, fp);
    deSerialize(root.right, fp);
    }
    // A simple inorder traversal used for testing the constructed tree
    void inorder(Node *root)
    {
    if (root)
    {
    inorder(root.left);
    System.out.printf("%d ", root.key);
    inorder(root.right);
    }
    }
    /* Driver program to test above functions*/
    int main()
    {
    // Let us construct a tree shown in the above figure
    static class Node *root = newNode(20);
    root.left = newNode(8);
    root.right = newNode(22);
    root.left.left = newNode(4);
    root.left.right = newNode(12);
    root.left.right.left = newNode(10);
    root.left.right.right = newNode(14);
    // Let us open a file and serialize the tree into the file
    FILE *fp = fopen("tree.txt", "w");
    if (fp == null)
    {
    puts("Could not open file");
    return 0;
    }
    serialize(root, fp);
    fclose(fp);
    // Let us deserialize the storeed tree into root1
    Node *root1 = null;
    fp = fopen("tree.txt", "r");
    deSerialize(root1, fp);
    System.out.printf("Inorder Traversal of the tree constructed from file:\n");
    inorder(root1);
    return 0;
    }
}
