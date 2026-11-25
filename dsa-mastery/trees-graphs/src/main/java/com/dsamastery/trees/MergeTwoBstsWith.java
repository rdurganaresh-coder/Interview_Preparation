package com.dsamastery.trees;

import java.util.*;

public class MergeTwoBstsWith {

    / \
    / \
    / \
    // Structure of a BST Node
    static class node
    {
    int data;
    static class node *left;
    static class node *right;
    };
    //.................... START OF STACK RELATED STUFF....................
    // A stack node
    static class snode
    {
    static class node *t;
    static class snode *next;
    };
    // Function to add an elemt k to stack
    void push(static class snode **s, static class node *k)
    {
    static class snode *tmp = (static class snode *) malloc(sizeof(static class snode));
    //perform memory check here
    tmp.t = k;
    tmp.next = *s;
    (*s) = tmp;
    }
    // Function to pop an element t from stack
    static class node *pop(static class snode **s)
    {
    static class node *t;
    static class snode *st;
    st=*s;
    (*s) = (*s)->next;
    t = st.t;
    free(st);
    return t;
    }
    // Fucntion to check whether the stack is empty or not
    int isEmpty(static class snode *s)
    {
    if (s == null )
    return 1;
    return 0;
    }
    //.................... END OF STACK RELATED STUFF....................
    /* Utility function to create a new Binary Tree node */
    static class node* newNode (int data)
    {
    static class node *temp = new static class node;
    temp.data = data;
    temp.left = null;
    temp.right = null;
    return temp;
    }
    /* A utility function to print Inoder traversal of a Binary Tree */
    void inorder(static class node *root)
    {
    if (root != null)
    {
    inorder(root.left);
    System.out.printf("%d ", root.data);
    inorder(root.right);
    }
    }
    // The function to print data of two BSTs in sorted order
    void merge(static class node *root1, static class node *root2)
    {
    // s1 is stack to hold nodes of first BST
    static class snode *s1 = null;
    // Current node of first BST
    static class node *current1 = root1;
    // s2 is stack to hold nodes of second BST
    static class snode *s2 = null;
    // Current node of second BST
    static class node *current2 = root2;
    // If first BST is empty, then output is inorder
    // traversal of second BST
    if (root1 == null)
    {
    inorder(root2);
    return;
    }
    // If second BST is empty, then output is inorder
    // traversal of first BST
    if (root2 == null)
    {
    inorder(root1);
    return ;
    }
    // Run the loop while there are nodes not yet printed.
    // The nodes may be in stack(explored, but not printed)
    // or may be not yet explored
    while (current1 != null || !isEmpty(s1) ||
    current2 != null || !isEmpty(s2))
    {
    // Following steps follow iterative Inorder Traversal
    if (current1 != null || current2 != null )
    {
    // Reach the leftmost node of both BSTs and push ancestors of
    // leftmost nodes to stack s1 and s2 respectively
    if (current1 != null)
    {
    push(&s1, current1);
    current1 = current1.left;
    }
    if (current2 != null)
    {
    push(&s2, current2);
    current2 = current2.left;
    }
    }
    else
    {
    // If we reach a null node and either of the stacks is empty,
    // then one tree is exhausted, ptint the other tree
    if (isEmpty(s1))
    {
    while (!isEmpty(s2))
    {
    current2 = pop (&s2);
    current2.left = null;
    inorder(current2);
    }
    return ;
    }
    if (isEmpty(s2))
    {
    while (!isEmpty(s1))
    {
    current1 = pop (&s1);
    current1.left = null;
    inorder(current1);
    }
    return ;
    }
    // Pop an element from both stacks and compare the
    // popped elements
    current1 = pop(&s1);
    current2 = pop(&s2);
    // If element of first tree is smaller, then print it
    // and push the right subtree. If the element is larger,
    // then we push it back to the corresponding stack.
    if (current1.data < current2.data)
    {
    System.out.printf("%d ", current1.data);
    current1 = current1.right;
    push(&s2, current2);
    current2 = null;
    }
    else
    {
    System.out.printf("%d ", current2.data);
    current2 = current2.right;
    push(&s1, current1);
    current1 = null;
    }
    }
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    static class node *root1 = null, *root2 = null;
    /* Let us create the following tree as first tree
    / \
    1 5
    */
    root1 = newNode(3);
    root1.left = newNode(1);
    root1.right = newNode(5);
    /* Let us create the following tree as second tree
    / \
    2 6
    */
    root2 = newNode(4);
    root2.left = newNode(2);
    root2.right = newNode(6);
    // Print sorted nodes of both trees
    merge(root1, root2);
    return 0;
    }
}
