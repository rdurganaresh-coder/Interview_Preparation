package com.dsamastery.trees;

import java.util.*;

public class WriteACProgram {

    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
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
    /* This function traverses tree in post order to
    to delete each and every node of the tree */
    void deleteTree(static class node* node)
    {
    if (node == null) return;
    /* first delete both subtrees */
    deleteTree(node.left);
    deleteTree(node.right);
    /* then delete the node */
    System.out.printf("\n Deleting node: %d", node.data);
    free(node);
    }
    /* Driver program to test deleteTree function*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    deleteTree(root);
    root = null;
    System.out.printf("\n Tree deleted ");
    getchar();
    return 0;
    }
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
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
    /* This function is same as deleteTree() in the previous program */
    void _deleteTree(static class node* node)
    {
    if (node == null) return;
    /* first delete both subtrees */
    _deleteTree(node.left);
    _deleteTree(node.right);
    /* then delete the node */
    System.out.printf("\n Deleting node: %d", node.data);
    free(node);
    }
    /* Deletes a tree and sets the root as null */
    void deleteTree(static class node** node_ref)
    {
    _deleteTree(*node_ref);
    *node_ref = null;
    }
    /* Driver program to test deleteTree function*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    // Note that we pass the address of root here
    deleteTree(&root);
    System.out.printf("\n Tree deleted ");
    getchar();
    return 0;
    }
}
