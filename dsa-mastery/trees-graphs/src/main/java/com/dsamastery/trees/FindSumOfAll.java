package com.dsamastery.trees;

import java.util.*;

public class FindSumOfAll {

    // A C++ program to find sum of all left leaves
    /* A binary tree Node has key, pointer to left and right
    children */
    static class Node
    {
    int key;
    static class Node* left, *right;
    };
    /* Helper function that allocates a new node with the
    given data and null left and right pointer. */
    Node *newNode(char k)
    {
    Node *node = new Node;
    node.key = k;
    node.right = node.left = null;
    return node;
    }
    // A utility function to check if a given node is leaf or not
    boolean isLeaf(Node *node)
    {
    if (node == null)
    return false;
    if (node.left == null && node.right == null)
    return true;
    return false;
    }
    // This function returns sum of all left leaves in a given
    // binary tree
    int leftLeavesSum(Node *root)
    {
    // Initialize result
    int res = 0;
    // Update result if root is not null
    if (root != null)
    {
    // If left of root is null, then add key of
    // left child
    if (isLeaf(root.left))
    res += root.left.key;
    else // Else recur for left child of root
    res += leftLeavesSum(root.left);
    // Recur for right child of root and update res
    res += leftLeavesSum(root.right);
    }
    // return result
    return res;
    }
    /* Driver program to test above functions*/
    int main()
    {
    // Let us construct the Binary Tree shown in the
    // above figure
    static class Node *root = newNode(20);
    root.left = newNode(9);
    root.right = newNode(49);
    root.right.left = newNode(23);
    root.right.right = newNode(52);
    root.right.right.left = newNode(50);
    root.left.left = newNode(5);
    root.left.right = newNode(12);
    root.left.right.right = newNode(12);
    cout << "Sum of left leaves is "
    << leftLeavesSum(root);
    return 0;
    }
    // A C++ program to find sum of all left leaves
    /* A binary tree Node has key, pointer to left and right
    children */
    static class Node
    {
    int key;
    static class Node* left, *right;
    };
    /* Helper function that allocates a new node with the
    given data and null left and right pointer. */
    Node *newNode(char k)
    {
    Node *node = new Node;
    node.key = k;
    node.right = node.left = null;
    return node;
    }
    /* Pass in a sum variable as an accumulator */
    void leftLeavesSumRec(Node *root, boolean isleft, int *sum)
    {
    if (!root) return;
    // Check whether this node is a leaf node and is left.
    if (!root.left && !root.right && isleft)
    *sum += root.key;
    // Pass 1 for left and 0 for right
    leftLeavesSumRec(root.left, 1, sum);
    leftLeavesSumRec(root.right, 0, sum);
    }
    // A wrapper over above recursive function
    int leftLeavesSum(Node *root)
    {
    int sum = 0; //Initialize result
    // use the above recursive function to evaluate sum
    leftLeavesSumRec(root, 0, &sum);
    return sum;
    }
    /* Driver program to test above functions*/
    int main()
    {
    // Let us construct the Binary Tree shown in the
    // above figure
    int sum = 0;
    static class Node *root = newNode(20);
    root.left = newNode(9);
    root.right = newNode(49);
    root.right.left = newNode(23);
    root.right.right = newNode(52);
    root.right.right.left = newNode(50);
    root.left.left = newNode(5);
    root.left.right = newNode(12);
    root.left.right.right = newNode(12);
    System.out.println("Sum of left leaves is " << leftLeavesSum(root));
    return 0;
    }
}
