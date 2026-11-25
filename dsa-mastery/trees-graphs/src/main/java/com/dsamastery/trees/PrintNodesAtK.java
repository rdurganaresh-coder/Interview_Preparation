package com.dsamastery.trees;

import java.util.*;

public class PrintNodesAtK {

    / \
    /* A binary tree node has data, pointer to left child
    and a pointer to right child */
    static class node
    {
    int data;
    static class node* left;
    static class node* right;
    };
    void printKDistant(node *root , int k)
    {
    if(root == null)
    return;
    if( k == 0 )
    {
    System.out.printf( "%d ", root.data );
    return ;
    }
    else
    {
    printKDistant( root.left, k-1 ) ;
    printKDistant( root.right, k-1 ) ;
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
    /* Constructed binary tree is
    / \
    2 3
    / \ /
    4 5 8
    */
    static class node *root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(8);
    printKDistant(root, 2);
    getchar();
    return 0;
    }
}
