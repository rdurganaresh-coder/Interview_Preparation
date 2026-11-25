package com.dsamastery.linkedlists;

import java.util.*;

public class IdenticalLinkedLists {

    Method 1 (Iterative)
    /* Structure for a linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* returns 1 if linked lists a and b are identical, otherwise 0 */
    boolean areIdentical(static class node *a, static class node *b)
    {
    while(1)
    {
    /* base case */
    if(a == null && b == null)
    { return 1; }
    if(a == null && b != null)
    { return 0; }
    if(a != null && b == null)
    { return 0; }
    if(a.data != b.data)
    { return 0; }
    /* If we reach here, then a and b are not null and their
    data is same, so move to next nodes in both lists */
    a = a.next;
    b = b.next;
    }
    }
    /* UTILITY FUNCTIONS TO TEST fun1() and fun2() */
    /* Given a reference (pointer to pointer) to the head
    of a list and an int, push a new node on the front
    of the list. */
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
    /* Druver program to test above function */
    int main()
    {
    static class node *a = null;
    static class node *b = null;
    /* The constructed linked lists are :
    a: 3.2.1
    b: 3.2.1 */
    push(&a, 1);
    push(&a, 2);
    push(&a, 3);
    push(&b, 1);
    push(&b, 2);
    push(&b, 3);
    if(areIdentical(a, b) == 1)
    System.out.printf(" Linked Lists are identical ");
    else
    System.out.printf(" Linked Lists are not identical ");
    getchar();
    return 0;
    }
    Method 2 (Recursive)
    boolean areIdentical(static class node *a, static class node *b)
    {
    if (a == null && b == null)
    { return 1; }
    if (a == null && b != null)
    { return 0; }
    if (a != null && b == null)
    { return 0; }
    if (a.data != b.data)
    { return 0; }
    /* If we reach here, then a and b are not null and their
    data is same, so move to next nodes in both lists */
    return areIdentical(a.next, b.next);
    }
}
