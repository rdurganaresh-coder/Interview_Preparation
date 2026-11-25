package com.dsamastery.stacksqueues;

import java.util.*;

public class DesignAStackWith {

    /* Program to implement a stack that supports findMiddle() and deleteMiddle
    in O(1) time */
    /* A Doubly Linked List Node */
    static class DLLNode
    {
    static class DLLNode *prev;
    int data;
    static class DLLNode *next;
    };
    /* Representation of the stack data structure that supports findMiddle()
    in O(1) time. The Stack is implemented using Doubly Linked List. It
    maintains pointer to head node, pointer to middle node and count of
    nodes */
    static class myStack
    {
    static class DLLNode *head;
    static class DLLNode *mid;
    int count;
    };
    /* Function to create the stack data structure */
    static class myStack *createMyStack()
    {
    static class myStack *ms =
    (static class myStack*) malloc(sizeof(static class myStack));
    ms.count = 0;
    return ms;
    };
    /* Function to push an element to the stack */
    void push(static class myStack *ms, int new_data)
    {
    /* allocate DLLNode and put in data */
    static class DLLNode* new_DLLNode =
    (static class DLLNode*) malloc(sizeof(static class DLLNode));
    new_DLLNode.data = new_data;
    /* Since we are adding at the begining,
    prev is always null */
    new_DLLNode.prev = null;
    /* link the old list off the new DLLNode */
    new_DLLNode.next = ms.head;
    /* Increment count of items in stack */
    ms.count += 1;
    /* Change mid pointer in two cases
    1) Linked List is empty
    2) Number of nodes in linked list is odd */
    if (ms.count == 1)
    {
    ms.mid = new_DLLNode;
    }
    else
    {
    ms.head.prev = new_DLLNode;
    if (ms.count & 1) // Update mid if ms.count is odd
    ms.mid = ms.mid.prev;
    }
    /* move head to point to the new DLLNode */
    ms.head = new_DLLNode;
    }
    /* Function to pop an element from stack */
    int pop(static class myStack *ms)
    {
    /* Stack underflow */
    if (ms.count == 0)
    {
    System.out.printf("Stack is empty\n");
    return -1;
    }
    static class DLLNode *head = ms.head;
    int item = head.data;
    ms.head = head.next;
    // If linked list doesn't become empty, update prev
    // of new head as null
    if (ms.head != null)
    ms.head.prev = null;
    ms.count -= 1;
    // update the mid pointer when we have even number of
    // elements in the stack, i,e move down the mid pointer.
    if (!((ms.count) & 1 ))
    ms.mid = ms.mid.next;
    free(head);
    return item;
    }
    // Function for finding middle of the stack
    int findMiddle(static class myStack *ms)
    {
    if (ms.count == 0)
    {
    System.out.printf("Stack is empty now\n");
    return -1;
    }
    return ms.mid.data;
    }
    // Driver program to test functions of myStack
    int main()
    {
    /* Let us create a stack using push() operation*/
    static class myStack *ms = createMyStack();
    push(ms, 11);
    push(ms, 22);
    push(ms, 33);
    push(ms, 44);
    push(ms, 55);
    push(ms, 66);
    push(ms, 77);
    System.out.printf("Item popped is %d\n", pop(ms));
    System.out.printf("Item popped is %d\n", pop(ms));
    System.out.printf("Middle Element is %d\n", findMiddle(ms));
    return 0;
    }
}
