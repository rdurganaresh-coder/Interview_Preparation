package com.dsamastery.trees;

import java.util.*;

public class ConstructAllPossibleBsts {

    \ / / / \ \
    / / \ \
    // A C++ prgroam to contrcut all unique BSTs for keys from 1 to n
    // node structure
    static class node
    {
    int key;
    static class node *left, *right;
    };
    // A utility function to create a new BST node
    static class node *newNode(int item)
    {
    static class node *temp = new node;
    temp.key = item;
    temp.left = temp.right = null;
    return temp;
    }
    // A utility function to do preorder traversal of BST
    void preorder(static class node *root)
    {
    if (root != null)
    {
    System.out.print(root.key << " ");
    preorder(root.left);
    preorder(root.right);
    }
    }
    // function for constructing trees
    vector<static class node *> constructTrees(int start, int end)
    {
    vector<static class node *> list;
    /* if start > end then subtree will be empty so returning null
    in the list */
    if (start > end)
    {
    list.push_back(null);
    return list;
    }
    /* iterating through all values from start to end for constructing\
    left and right subtree recursively */
    for (int i = start; i <= end; i++)
    {
    /* constructing left subtree */
    vector<static class node *> leftSubtree = constructTrees(start, i - 1);
    /* constructing right subtree */
    vector<static class node *> rightSubtree = constructTrees(i + 1, end);
    /* now looping through all left and right subtrees and connecting
    them to ith root below */
    for (int j = 0; j < leftSubtree.size(); j++)
    {
    static class node* left = leftSubtree[j];
    for (int k = 0; k < rightSubtree.size(); k++)
    {
    static class node * right = rightSubtree[k];
    static class node * node = newNode(i);// making value i as root
    node.left = left; // connect left subtree
    node.right = right; // connect right subtree
    list.push_back(node); // add this tree to list
    }
    }
    }
    return list;
    }
    // Driver Program to test above functions
    int main()
    {
    // Construct all possible BSTs
    vector<static class node *> totalTreesFrom1toN = constructTrees(1, 3);
    /* Printing preorder traversal of all constructed BSTs */
    System.out.print("Preorder traversal of all constructed BSTs is \n");
    for (int i = 0; i < totalTreesFrom1toN.size(); i++)
    {
    preorder(totalTreesFrom1toN[i]);
    System.out.print(endl);
    }
    return 0;
    }
}
