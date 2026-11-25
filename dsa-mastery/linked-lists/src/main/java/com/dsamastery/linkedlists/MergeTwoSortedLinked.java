package com.dsamastery.linkedlists;

import java.util.*;

public class MergeTwoSortedLinked {

    new list should be made by splicing
    Method 1 (Using Dummy Nodes)
    /*Program to alternatively split a linked list into two halves */
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* pull off the front node of the source and put it in dest */
    void MoveNode(static class node** destRef, static class node** sourceRef);
    /* Takes two lists sorted in increasing order, and splices their nodes together to make one big sorted list which is returned. */
    static class node* SortedMerge(static class node* a, static class node* b)
    {
    /* a dummy first node to hang the result on */
    static class node dummy;
    /* tail points to the last result node */
    static class node* tail = &dummy;
    /* so tail.next is the place to add new nodes
    to the result. */
    dummy.next = null;
    while(1)
    {
    if(a == null)
    {
    /* if either list runs out, use the other list */
    tail.next = b;
    break;
    }
    else if (b == null)
    {
    tail.next = a;
    break;
    }
    if (a.data <= b.data)
    {
    MoveNode(&(tail.next), &a);
    }
    else
    {
    MoveNode(&(tail.next), &b);
    }
    tail = tail.next;
    }
    return(dummy.next);
    }
    /* UTILITY FUNCTIONS */
    /*MoveNode() function takes the node from the front of the source, and move it to the front of the dest.
    It is an error to call this with the source list empty.
    Before calling MoveNode():
    source == {1, 2, 3}
    dest == {1, 2, 3}
    Affter calling MoveNode():
    source == {2, 3}
    dest == {1, 1, 2, 3}
    */
    void MoveNode(static class node** destRef, static class node** sourceRef)
    {
    /* the front source node */
    static class node* newNode = *sourceRef;
    assert(newNode != null);
    /* Advance the source pointer */
    *sourceRef = newNode.next;
    /* Link the old dest off the new node */
    newNode.next = *destRef;
    /* Move dest to point to the new node */
    *destRef = newNode;
    }
    /* Function to insert a node at the beginging of the linked list */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Function to print nodes in a given linked list */
    void printList(static class node *node)
    {
    while(node!=null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class node* res = null;
    static class node* a = null;
    static class node* b = null;
    /* Let us create two sorted linked lists to test the functions
    Created lists shall be a: 5.10.15, b: 2.3.20 */
    push(&a, 15);
    push(&a, 10);
    push(&a, 5);
    push(&b, 20);
    push(&b, 3);
    push(&b, 2);
    /* Remove duplicates from linked list */
    res = SortedMerge(a, b);
    System.out.printf("\n Merged Linked List is: \n");
    printList(res);
    getchar();
    return 0;
    }
    Method 2 (Using Local References)
    static class node* SortedMerge(static class node* a, static class node* b)
    {
    static class node* result = null;
    /* point to the last result pointer */
    static class node** lastPtrRef = &result;
    while(1)
    {
    if (a == null)
    {
    *lastPtrRef = b;
    break;
    }
    else if (b==null)
    {
    *lastPtrRef = a;
    break;
    }
    if(a.data <= b.data)
    {
    MoveNode(lastPtrRef, &a);
    }
    else
    {
    MoveNode(lastPtrRef, &b);
    }
    /* tricky: advance to point to the next ".next" field */
    lastPtrRef = &((*lastPtrRef)->next);
    }
    return(result);
    }
    Method 3 (Using Recursion)
    static class node* SortedMerge(static class node* a, static class node* b)
    {
    static class node* result = null;
    /* Base cases */
    if (a == null)
    return(b);
    else if (b==null)
    return(a);
    /* Pick either a or b, and recur */
    if (a.data <= b.data)
    {
    result = a;
    result.next = SortedMerge(a.next, b);
    }
    else
    {
    result = b;
    result.next = SortedMerge(a, b.next);
    }
    return(result);
    }
}
