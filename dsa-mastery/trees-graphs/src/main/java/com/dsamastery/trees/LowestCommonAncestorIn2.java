package com.dsamastery.trees;

import java.util.*;

public class LowestCommonAncestorIn {

    // A O(n) solution to find LCA of two given values n1 and n2
    // A Bianry Tree node
    static class Node
    {
    int key;
    static class Node *left, *right;
    };
    // Utility function creates a new binary tree node with given key
    Node * newNode(int k)
    {
    Node *temp = new Node;
    temp.key = k;
    temp.left = temp.right = null;
    return temp;
    }
    // Finds the path from root node to given root of the tree, Stores the
    // path in a vector path[], returns true if path exists otherwise false
    boolean findPath(Node *root, vector<int> &path, int k)
    {
    // base case
    if (root == null) return false;
    // Store this node in path vector. The node will be removed if
    // not in path from root to k
    path.push_back(root.key);
    // See if the k is same as root's key
    if (root.key == k)
    return true;
    // Check if k is found in left or right sub-tree
    if ( (root.left && findPath(root.left, path, k)) ||
    (root.right && findPath(root.right, path, k)) )
    return true;
    // If not present in subtree rooted with root, remove root from
    // path[] and return false
    path.pop_back();
    return false;
    }
    // Returns LCA if node n1, n2 are present in the given binary tree,
    // otherwise return -1
    int findLCA(Node *root, int n1, int n2)
    {
    // to store paths to n1 and n2 from the root
    vector<int> path1, path2;
    // Find paths from root to n1 and root to n1. If either n1 or n2
    // is not present, return -1
    if ( !findPath(root, path1, n1) || !findPath(root, path2, n2))
    return -1;
    /* Compare the paths to get the first different value */
    int i;
    for (i = 0; i < path1.size() && i < path2.size() ; i++)
    if (path1[i] != path2[i])
    break;
    return path1[i-1];
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create the Binary Tree shown in above diagram.
    Node * root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    System.out.print("LCA(4, 5) = " << findLCA(root, 4, 5));
    System.out.print("\nLCA(4, 6) = " << findLCA(root, 4, 6));
    System.out.print("\nLCA(3, 4) = " << findLCA(root, 3, 4));
    System.out.print("\nLCA(2, 4) = " << findLCA(root, 2, 4));
    return 0;
    }
    Method 2 (Using Single Traversal)
    /* Program to find LCA of n1 and n2 using one traversal of Binary Tree */
    // A Binary Tree Node
    static class Node
    {
    static class Node *left, *right;
    int key;
    };
    // Utility function to create a new tree Node
    Node* newNode(int key)
    {
    Node *temp = new Node;
    temp.key = key;
    temp.left = temp.right = null;
    return temp;
    }
    // This function returns pointer to LCA of two given values n1 and n2.
    // This function assumes that n1 and n2 are present in Binary Tree
    static class Node *findLCA(static class Node* root, int n1, int n2)
    {
    // Base case
    if (root == null) return null;
    // If either n1 or n2 matches with root's key, report
    // the presence by returning root (Note that if a key is
    // ancestor of other, then the ancestor key becomes LCA
    if (root.key == n1 || root.key == n2)
    return root;
    // Look for keys in left and right subtrees
    Node *left_lca = findLCA(root.left, n1, n2);
    Node *right_lca = findLCA(root.right, n1, n2);
    // If both of the above calls return Non-null, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if (left_lca && right_lca) return root;
    // Otherwise check if left subtree or right subtree is LCA
    return (left_lca != null)? left_lca: right_lca;
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create binary tree given in the above example
    Node * root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    System.out.print("LCA(4, 5) = " << findLCA(root, 4, 5)->key);
    System.out.print("\nLCA(4, 6) = " << findLCA(root, 4, 6)->key);
    System.out.print("\nLCA(3, 4) = " << findLCA(root, 3, 4)->key);
    System.out.print("\nLCA(2, 4) = " << findLCA(root, 2, 4)->key);
    return 0;
    }
    /* Program to find LCA of n1 and n2 using one traversal of Binary Tree.
    It handles all cases even when n1 or n2 is not there in Binary Tree */
    // A Binary Tree Node
    static class Node
    {
    static class Node *left, *right;
    int key;
    };
    // Utility function to create a new tree Node
    Node* newNode(int key)
    {
    Node *temp = new Node;
    temp.key = key;
    temp.left = temp.right = null;
    return temp;
    }
    // This function returns pointer to LCA of two given values n1 and n2.
    // v1 is set as true by this function if n1 is found
    // v2 is set as true by this function if n2 is found
    static class Node *findLCAUtil(static class Node* root, int n1, int n2, boolean &v1, boolean &v2)
    {
    // Base case
    if (root == null) return null;
    // If either n1 or n2 matches with root's key, report the presence
    // by setting v1 or v2 as true and return root (Note that if a key
    // is ancestor of other, then the ancestor key becomes LCA)
    if (root.key == n1)
    {
    v1 = true;
    return root;
    }
    if (root.key == n2)
    {
    v2 = true;
    return root;
    }
    // Look for keys in left and right subtrees
    Node *left_lca = findLCAUtil(root.left, n1, n2, v1, v2);
    Node *right_lca = findLCAUtil(root.right, n1, n2, v1, v2);
    // If both of the above calls return Non-null, then one key
    // is present in once subtree and other is present in other,
    // So this node is the LCA
    if (left_lca && right_lca) return root;
    // Otherwise check if left subtree or right subtree is LCA
    return (left_lca != null)? left_lca: right_lca;
    }
    // Returns true if key k is present in tree rooted with root
    boolean find(Node *root, int k)
    {
    // Base Case
    if (root == null)
    return false;
    // If key is present at root, or in left subtree or right subtree,
    // return true;
    if (root.key == k || find(root.left, k) || find(root.right, k))
    return true;
    // Else return false
    return false;
    }
    // This function returns LCA of n1 and n2 only if both n1 and n2 are present
    // in tree, otherwise returns null;
    Node *findLCA(Node *root, int n1, int n2)
    {
    // Initialize n1 and n2 as not visited
    boolean v1 = false, v2 = false;
    // Find lca of n1 and n2 using the technique discussed above
    Node *lca = findLCAUtil(root, n1, n2, v1, v2);
    // Return LCA only if both n1 and n2 are present in tree
    if (v1 && v2 || v1 && find(lca, n2) || v2 && find(lca, n1))
    return lca;
    // Else return null
    return null;
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create binary tree given in the above example
    Node * root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    Node *lca = findLCA(root, 4, 5);
    if (lca != null)
    System.out.print("LCA(4, 5) = " << lca.key);
    else
    System.out.print("Keys are not present ");
    lca = findLCA(root, 4, 10);
    if (lca != null)
    System.out.print("\nLCA(4, 10) = " << lca.key);
    else
    System.out.print("\nKeys are not present ");
    return 0;
    }
}
