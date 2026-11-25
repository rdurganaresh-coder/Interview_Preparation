package com.dsamastery.trees;

import java.util.*;

public class RemoveNodesOnRoot {

    / \
    / \ \
    / \
    / \
    // C++ program to remove nodes on root to leaf paths of length < K
    static class Node
    {
    int data;
    Node *left, *right;
    };
    //New node of a tree
    Node *newNode(int data)
    {
    Node *node = new Node;
    node.data = data;
    node.left = node.right = null;
    return node;
    }
    // Utility method that actually removes the nodes which are not
    // on the pathLen >= k. This method can change the root as well.
    Node *removeShortPathNodesUtil(Node *root, int level, int k)
    {
    //Base condition
    if (root == null)
    return null;
    // Traverse the tree in postorder fashion so that if a leaf
    // node path length is shorter than k, then that node and
    // all of its descendants till the node which are not
    // on some other path are removed.
    root.left = removeShortPathNodesUtil(root.left, level + 1, k);
    root.right = removeShortPathNodesUtil(root.right, level + 1, k);
    // If root is a leaf node and it's level is less than k then
    // remove this node.
    // This goes up and check for the ancestor nodes also for the
    // same condition till it finds a node which is a part of other
    // path(s) too.
    if (root.left == null && root.right == null && level < k)
    {
    delete root;
    return null;
    }
    // Return root;
    return root;
    }
    // Method which calls the utitlity method to remove the short path
    // nodes.
    Node *removeShortPathNodes(Node *root, int k)
    {
    int pathLen = 0;
    return removeShortPathNodesUtil(root, 1, k);
    }
    //Method to print the tree in inorder fashion.
    void printInorder(Node *root)
    {
    if (root)
    {
    printInorder(root.left);
    System.out.print(root.data << " ");
    printInorder(root.right);
    }
    }
    // Driver method.
    int main()
    {
    int k = 4;
    Node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.left.left.left = newNode(7);
    root.right.right = newNode(6);
    root.right.right.left = newNode(8);
    System.out.println("Inorder Traversal of Original tree");
    printInorder(root);
    System.out.print(endl);
    System.out.println("Inorder Traversal of Modified tree");
    Node *res = removeShortPathNodes(root, k);
    printInorder(res);
    return 0;
    }
}
