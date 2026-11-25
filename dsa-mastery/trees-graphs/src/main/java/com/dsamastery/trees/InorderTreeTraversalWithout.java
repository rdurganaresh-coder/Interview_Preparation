package com.dsamastery.trees;

import java.util.*;

public class InorderTreeTraversalWithout {

    / \
    / \
    c) current = null /*right of 4 */ and go to step 3
    c) current.5/*right of 2 */ and go to step 3
    c) current = null /*right of 5 */ and go to step 3
    c) current.3 /*right of 5 */
    c) current = null /*right of 3 */
    /* A binary tree tNode has data, pointer to left child
    and a pointer to right child */
    static class tNode
    {
    int data;
    static class tNode* left;
    static class tNode* right;
    };
    /* Structure of a stack node. Linked List implementation is used for
    stack. A stack node contains a pointer to tree node and a pointer to
    next stack node */
    static class sNode
    {
    static class tNode *t;
    static class sNode *next;
    };
    /* Stack related functions */
    void push(static class sNode** top_ref, static class tNode *t);
    static class tNode *pop(static class sNode** top_ref);
    boolean isEmpty(static class sNode *top);
    /* Iterative function for inorder tree traversal */
    void inOrder(static class tNode *root)
    {
    /* set current to root of binary tree */
    static class tNode *current = root;
    static class sNode *s = null; /* Initialize stack s */
    boolean done = 0;
    while (!done)
    {
    /* Reach the left most tNode of the current tNode */
    if(current != null)
    {
    /* place pointer to a tree node on the stack before traversing
    the node's left subtree */
    push(&s, current);
    current = current.left;
    }
    /* backtrack from the empty subtree and visit the tNode
    at the top of the stack; however, if the stack is empty,
    you are done */
    else
    {
    if (!isEmpty(s))
    {
    current = pop(&s);
    System.out.printf("%d ", current.data);
    /* we have visited the node and its left subtree.
    Now, it's right subtree's turn */
    current = current.right;
    }
    else
    done = 1;
    }
    } /* end of while */
    }
    /* UTILITY FUNCTIONS */
    /* Function to push an item to sNode*/
    void push(static class sNode** top_ref, static class tNode *t)
    {
    /* allocate tNode */
    static class sNode* new_tNode =
    (static class sNode*) malloc(sizeof(static class sNode));
    if(new_tNode == null)
    {
    System.out.printf("Stack Overflow \n");
    getchar();
    exit(0);
    }
    /* put in the data */
    new_tNode.t = t;
    /* link the old list off the new tNode */
    new_tNode.next = (*top_ref);
    /* move the head to point to the new tNode */
    (*top_ref) = new_tNode;
    }
    /* The function returns true if stack is empty, otherwise false */
    boolean isEmpty(static class sNode *top)
    {
    return (top == null)? 1 : 0;
    }
    /* Function to pop an item from stack*/
    static class tNode *pop(static class sNode** top_ref)
    {
    static class tNode *res;
    static class sNode *top;
    /*If sNode is empty then error */
    if(isEmpty(*top_ref))
    {
    System.out.printf("Stack Underflow \n");
    getchar();
    exit(0);
    }
    else
    {
    top = *top_ref;
    res = top.t;
    *top_ref = top.next;
    free(top);
    return res;
    }
    }
    /* Helper function that allocates a new tNode with the
    given data and null left and right pointers. */
    static class tNode* newtNode(int data)
    {
    static class tNode* tNode = (static class tNode*)
    malloc(sizeof(static class tNode));
    tNode.data = data;
    tNode.left = null;
    tNode.right = null;
    return(tNode);
    }
    /* Driver program to test above functions*/
    int main()
    {
    /* Constructed binary tree is
    / \
    2 3
    / \
    4 5
    */
    static class tNode *root = newtNode(1);
    root.left = newtNode(2);
    root.right = newtNode(3);
    root.left.left = newtNode(4);
    root.left.right = newtNode(5);
    inOrder(root);
    getchar();
    return 0;
    }
}
