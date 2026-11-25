package com.dsamastery.trees;

import java.util.*;

public class FindTheClosestLeaf {

    / \
    / \
    / \
    // A C++ program to find the closesr leaf of a given key in Binary Tree
    /* A binary tree Node has key, pocharer to left and right children */
    static class Node
    {
    char key;
    static class Node* left, *right;
    };
    /* Helper function that allocates a new node with the
    given data and null left and right pocharers. */
    Node *newNode(char k)
    {
    Node *node = new Node;
    node.key = k;
    node.right = node.left = null;
    return node;
    }
    // A utility function to find minimum of x and y
    int getMin(int x, int y)
    {
    return (x < y)? x :y;
    }
    // A utility function to find distance of closest leaf of the tree
    // rooted under given root
    int closestDown(static class Node *root)
    {
    // Base cases
    if (root == null)
    return INT_MAX;
    if (root.left == null && root.right == null)
    return 0;
    // Return minimum of left and right, plus one
    return 1 + getMin(closestDown(root.left), closestDown(root.right));
    }
    // Returns distance of the cloest leaf to a given key 'k'. The array
    // ancestors is used to keep track of ancestors of current node and
    // 'index' is used to keep track of curremt index in 'ancestors[]'
    int findClosestUtil(static class Node *root, char k, static class Node *ancestors[],
    int index)
    {
    // Base case
    if (root == null)
    return INT_MAX;
    // If key found
    if (root.key == k)
    {
    // Find the cloest leaf under the subtree rooted with given key
    int res = closestDown(root);
    // Traverse all ancestors and update result if any parent node
    // gives smaller distance
    for (int i = index-1; i>=0; i--)
    res = getMin(res, index - i + closestDown(ancestors[i]));
    return res;
    }
    // If key node found, store current node and recur for left and
    // right childrens
    ancestors[index] = root;
    return getMin(findClosestUtil(root.left, k, ancestors, index+1),
    findClosestUtil(root.right, k, ancestors, index+1));
    }
    // The main function that returns distance of the closest key to 'k'. It
    // mainly uses recursive function findClosestUtil() to find the closes
    // distance.
    int findClosest(static class Node *root, char k)
    {
    // Create an array to store ancestors
    // Assumptiom: Maximum height of tree is 100
    static class Node *ancestors[100];
    return findClosestUtil(root, k, ancestors, 0);
    }
    /* Driver program to test above functions*/
    int main()
    {
    // Let us construct the BST shown in the above figure
    static class Node *root = newNode('A');
    root.left = newNode('B');
    root.right = newNode('C');
    root.right.left = newNode('E');
    root.right.right = newNode('F');
    root.right.left.left = newNode('G');
    root.right.left.left.left = newNode('I');
    root.right.left.left.right = newNode('J');
    root.right.right.right = newNode('H');
    root.right.right.right.left = newNode('K');
    char k = 'H';
    cout << "Distace of the closest key from " << k << " is "
    << findClosest(root, k) << endl;
    k = 'C';
    cout << "Distace of the closest key from " << k << " is "
    << findClosest(root, k) << endl;
    k = 'E';
    cout << "Distace of the closest key from " << k << " is "
    << findClosest(root, k) << endl;
    k = 'B';
    cout << "Distace of the closest key from " << k << " is "
    << findClosest(root, k) << endl;
    return 0;
    }
}
