package com.dsamastery.trees;

import java.util.*;

public class ReverseLevelOrderTraversal {

    METHOD 1 (Recursive function to print a given level)
    // A recursive C program to print REVERSE level order traversal
    /* A binary tree node has data, pointer to left and right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /*Function protoypes*/
    void printGivenLevel(static class node* root, int level);
    int height(static class node* node);
    static class node* newNode(int data);
    /* Function to print REVERSE level order traversal a tree*/
    void reverseLevelOrder(static class node* root)
    {
    int h = height(root);
    int i;
    for (i=h; i>=1; i--) //THE ONLY LINE DIFFERENT FROM NORMAL LEVEL ORDER
    printGivenLevel(root, i);
    }
    /* Print nodes at a given level */
    void printGivenLevel(static class node* root, int level)
    {
    if (root == null)
    return;
    if (level == 1)
    System.out.printf("%d ", root.data);
    else if (level > 1)
    {
    printGivenLevel(root.left, level-1);
    printGivenLevel(root.right, level-1);
    }
    }
    /* Compute the "height" of a tree -- the number of
    nodes along the longest path from the root node
    down to the farthest leaf node.*/
    int height(static class node* node)
    {
    if (node==null)
    return 0;
    else
    {
    /* compute the height of each subtree */
    int lheight = height(node.left);
    int rheight = height(node.right);
    /* use the larger one */
    if (lheight > rheight)
    return(lheight+1);
    else return(rheight+1);
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
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    System.out.printf("Level Order traversal of binary tree is \n");
    reverseLevelOrder(root);
    return 0;
    }
    METHOD 2 (Using Queue and Stack)
    // A C++ program to print REVERSE level order traversal using stack and queue
    // This approach is adopted from following link
    // http://tech-queries.blogspot.in/2008/12/level-order-tree-traversal-in-reverse.html
    /* A binary tree node has data, pointer to left and right children */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    /* Given a binary tree, print its nodes in reverse level order */
    void reverseLevelOrder(node* root)
    {
    stack <node *> S;
    queue <node *> Q;
    Q.push(root);
    // Do something like normal level order traversal order. Following are the
    // differences with normal level order traversal
    // 1) Instead of printing a node, we push the node to stack
    // 2) Right subtree is visited before left subtree
    while (Q.empty() == false)
    {
    /* Dequeue node and make it root */
    root = Q.front();
    Q.pop();
    S.push(root);
    /* Enqueue right child */
    if (root.right)
    Q.push(root.right); // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
    /* Enqueue left child */
    if (root.left)
    Q.push(root.left);
    }
    // Now pop all items from stack one by one and print them
    while (S.empty() == false)
    {
    root = S.top();
    System.out.print(root.data << " ");
    S.pop();
    }
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    node* newNode(int data)
    {
    node* temp = new node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return (temp);
    }
    /* Driver program to test above functions*/
    int main()
    {
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(6);
    root.right.right = newNode(7);
    System.out.print("Level Order traversal of binary tree is \n");
    reverseLevelOrder(root);
    return 0;
    }
}
