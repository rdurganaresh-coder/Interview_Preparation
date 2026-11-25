package com.dsamastery.trees;

import java.util.*;

public class FindTheMaximumPath {

    The time complexity of above solution is O(n2)
    // C++ program to find maximum path sum between two leaves of
    // a binary tree
    // A binary tree node
    static class Node
    {
    int data;
    static class Node* left, *right;
    };
    // Utility function to allocate memory for a new node
    static class Node* newNode(int data)
    {
    static class Node* node = new(static class Node);
    node.data = data;
    node.left = node.right = null;
    return (node);
    }
    // Utility function to find maximum of two integers
    int max(int a, int b)
    { return (a >= b)? a: b; }
    // A utility function to find the maximum sum between any
    // two leaves.This function calculates two values:
    // 1) Maximum path sum between two leaves which is stored
    // in res.
    // 2) The maximum root to leaf path sum which is returned.
    // If one side of root is empty, then it returns INT_MIN
    int maxPathSumUtil(static class Node *root, int &res)
    {
    // Base cases
    if (root==null) return 0;
    if (!root.left && !root.right) return root.data;
    // Find maximum sum in left and right subtree. Also
    // find maximum root to leaf sums in left and right
    // subtrees and store them in ls and rs
    int ls = maxPathSumUtil(root.left, res);
    int rs = maxPathSumUtil(root.right, res);
    // If both left and right children exist
    if (root.left && root.right)
    {
    // Update result if needed
    res = max(res, ls + rs + root.data);
    // Return maxium possible value for root being
    // on one side
    return max(ls, rs) + root.data;
    }
    // If any of the two children is empty, return
    // root sum for root being on one side
    return (!root.left)? rs + root.data:
    ls + root.data;
    }
    // The main function which returns sum of the maximum
    // sum path between two leaves. This function mainly
    // uses maxPathSumUtil()
    int maxPathSum(static class Node *root)
    {
    int res = INT_MIN;
    maxPathSumUtil(root, res);
    return res;
    }
    // driver program to test above function
    int main()
    {
    static class Node *root = newNode(-15);
    root.left = newNode(5);
    root.right = newNode(6);
    root.left.left = newNode(-8);
    root.left.right = newNode(1);
    root.left.left.left = newNode(2);
    root.left.left.right = newNode(6);
    root.right.left = newNode(3);
    root.right.right = newNode(9);
    root.right.right.right= newNode(0);
    root.right.right.right.left= newNode(4);
    root.right.right.right.right= newNode(-1);
    root.right.right.right.right.left= newNode(10);
    cout << "Max pathSum of the given binary tree is "
    << maxPathSum(root);
    return 0;
    }
}
