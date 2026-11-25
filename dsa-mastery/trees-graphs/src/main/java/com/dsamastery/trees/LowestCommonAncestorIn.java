package com.dsamastery.trees;

import java.util.*;

public class LowestCommonAncestorIn {

    static class node *lca(node* root, int n1, int n2)
    <stdio.h> #include <stdlib.h> static class node { int data; static class node* left, *right; }; /* Function to ﬁnd LCA
    of n1 and n2. The function assumes that both n1 and n2 are present in BST */ static class node *lca(struct
    return lca(root.right, n1, n2); return root; } /* Helper function that allocates a new node with the given
    data.*/ static class node* newNode(int data) { static class node* node = (static class node*)malloc(sizeof(static class node));
    node.data = data; node.left = node.right = null; return(node); } /* Driver program to test mirror()
    */ int main() { // Let us construct the BST shown in the above ﬁgure static class node *root = newNode(20);
    root.left = newNode(8); root.right = newNode(22); root.left.left = newNode(4); root.left.right =
    newNode(12); root.left.right.left = newNode(10); root.left.right.right = newNode(14); int n1 =
    10, n2 = 14; static class node *t = lca(root, n1, n2); System.out.printf(“LCA of %d and %d is %d \n”, n1, n2, t.data); n1
    = 14, n2 = 8; t = lca(root, n1, n2); System.out.printf(“LCA of %d and %d is %d \n”, n1, n2, t.data); n1 = 10, n2 =
    22; t = lca(root, n1, n2); System.out.printf(“LCA of %d and %d is %d \n”, n1, n2, t.data); getchar(); return 0; }
    /* Function to find LCA of n1 and n2. The function assumes that both
    n1 and n2 are present in BST */
    static class node *lca(static class node* root, int n1, int n2)
    {
    while (root != null)
    {
    // If both n1 and n2 are smaller than root, then LCA lies in left
    if (root.data > n1 && root.data > n2)
    root = root.left;
    // If both n1 and n2 are greater than root, then LCA lies in right
    else if (root.data < n1 && root.data < n2)
    root = root.right;
    else break;
    }
    return root;
    }
    return incorrect result. Extend the above solutions to return null if n1 or n2 or both not present in BST.
}
