package com.dsamastery.trees;

import java.util.*;

public class PrintABinaryTree {

    / \
    / \ / \
    \ \
    // min --> Minimum horizontal distance from root
    // max --> Maximum horizontal distance from root
    // hd --> Horizontal distance of current node from root
    findMinMax(tree, min, max, hd)
    if tree is null then return;
    min = hd;
    else if hd is greater than max then
    *max = hd;
    findMinMax(tree.left, min, max, hd-1);
    findMinMax(tree.right, min, max, hd+1);
    printVerticalLine(tree, line_no, hd)
    if tree is null then return;
    print(tree.data);
    printVerticalLine(tree.left, line_no, hd-1);
    printVerticalLine(tree.right, line_no, hd+1);
    // A node of binary tree
    static class Node
    {
    int data;
    static class Node *left, *right;
    };
    // A utility function to create a new Binary Tree node
    Node* newNode(int data)
    {
    Node *temp = new Node;
    temp.data = data;
    temp.left = temp.right = null;
    return temp;
    }
    // A utility function to find min and max distances with respect
    // to root.
    void findMinMax(Node *node, int *min, int *max, int hd)
    {
    // Base case
    if (node == null) return;
    // Update min and max
    if (hd < *min) *min = hd;
    else if (hd > *max) *max = hd;
    // Recur for left and right subtrees
    findMinMax(node.left, min, max, hd-1);
    findMinMax(node.right, min, max, hd+1);
    }
    // A utility function to print all nodes on a given line_no.
    // hd is horizontal distance of current node with respect to root.
    void printVerticalLine(Node *node, int line_no, int hd)
    {
    // Base case
    if (node == null) return;
    // If this node is on the given line number
    if (hd == line_no)
    System.out.print(node.data << " ");
    // Recur for left and right subtrees
    printVerticalLine(node.left, line_no, hd-1);
    printVerticalLine(node.right, line_no, hd+1);
    }
    // The main function that prints a given binary tree in
    // vertical order
    void verticalOrder(Node *root)
    {
    // Find min and max distances with resepect to root
    int min = 0, max = 0;
    findMinMax(root, &min, &max, 0);
    // Iterate through all possible vertical lines starting
    // from the leftmost line and print nodes line by line
    for (int line_no = min; line_no <= max; line_no++)
    {
    printVerticalLine(root, line_no, 0);
    System.out.print(endl);
    }
    }
    // Driver program to test above functions
    int main()
    {
    // Create binary tree shown in above figure
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
    verticalOrder(root);
    return 0;
    }
}
