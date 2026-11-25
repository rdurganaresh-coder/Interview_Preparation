package com.dsamastery.trees;

import java.util.*;

public class WriteACProgram {

    maxDepth()
    call maxDepth( tree.left-subtree)
    call maxDepth( tree.right-subtree)
    See the below diagram for more clarity about execution of the recursive function maxDepth()
    / \
    / \
    / \
    / \
    / \
    / \
    / \
    / \
    / \
    / \
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Compute the "maxDepth" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int maxDepth(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the depth of each subtree */
    int lDepth = maxDepth(node.left);
    int rDepth = maxDepth(node.right);
    /* use the larger one */
    if (lDepth > rDepth)
    return(lDepth+1);
    else return(rDepth+1);
    }
    }
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
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Hight of tree is %d", maxDepth(root));
    getchar();
    return 0;
    }
}
