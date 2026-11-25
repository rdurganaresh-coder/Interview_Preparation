package com.dsamastery.trees;

import java.util.*;

public class GivenABinaryTree {

    return the root pointer of following new tree.
    // C program to remove all half nodes
    static class node
    {
    int data;
    static class node* left, *right;
    };
    static class node* newNode(int data)
    {
    static class node* node = (static class node*)
    malloc(sizeof(static class node));
    node.data = data;
    node.left = node.right = null;
    return(node);
    }
    void printInoder(static class node*root)
    {
    if (root != null)
    {
    printInoder(root.left);
    System.out.printf("%d ",root.data);
    printInoder(root.right);
    }
    }
    // Removes all nodes with only one child and returns
    // new root (note that root may change)
    static class node* RemoveHalfNodes(static class node* root)
    {
    if (root==null)
    return null;
    root.left = RemoveHalfNodes(root.left);
    root.right = RemoveHalfNodes(root.right);
    if (root.left==null && root.right==null)
    return root;
    /* if current nodes is a half node with left
    child null left, then it's right child is
    returned and replaces it in the given tree */
    if (root.left==null)
    {
    static class node *new_root = root.right;
    free(root); // To avoid memory leak
    return new_root;
    }
    /* if current nodes is a half node with right
    child null right, then it's right child is
    returned and replaces it in the given tree */
    if (root.right==null)
    {
    static class node *new_root = root.left;
    free(root); // To avoid memory leak
    return new_root;
    }
    return root;
    }
    // Driver program
    int main(void)
    {
    static class node*NewRoot=null;
    static class node *root = newNode(2);
    root.left = newNode(7);
    root.right = newNode(5);
    root.left.right = newNode(6);
    root.left.right.left=newNode(1);
    root.left.right.right=newNode(11);
    root.right.right=newNode(9);
    root.right.right.left=newNode(4);
    System.out.printf("Inorder traversal of given tree \n");
    printInoder(root);
    NewRoot = RemoveHalfNodes(root);
    System.out.printf("\nInorder traversal of the modified tree \n");
    printInoder(NewRoot);
    return 0;
    }
}
