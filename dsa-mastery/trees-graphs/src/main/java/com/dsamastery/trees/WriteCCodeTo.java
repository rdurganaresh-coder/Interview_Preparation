package com.dsamastery.trees;

import java.util.*;

public class WriteCCodeTo {

    sameTree(tree1, tree2)
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
    /* Given two trees, return true if they are
    structurally identical */
    int identicalTrees(static class node* a, static class node* b)
    {
    /*1. both empty */
    if (a==null && b==null)
    return 1;
    /* 2. both non-empty.compare them */
    if (a!=null && b!=null)
    {
    return
    (
    a.data == b.data &&
    identicalTrees(a.left, b.left) &&
    identicalTrees(a.right, b.right)
    );
    }
    /* 3. one empty, one not.false */
    return 0;
    }
    /* Driver program to test identicalTrees function*/
    int main()
    {
    static class node *root1 = newNode(1);
    static class node *root2 = newNode(1);
    root1.left = newNode(2);
    root1.right = newNode(3);
    root1.left.left = newNode(4);
    root1.left.right = newNode(5);
    root2.left = newNode(2);
    root2.right = newNode(3);
    root2.left.left = newNode(4);
    root2.left.right = newNode(5);
    if(identicalTrees(root1, root2))
    System.out.printf("Both tree are identical.");
    else
    System.out.printf("Trees are not identical.");
    getchar();
    return 0;
    }
}
