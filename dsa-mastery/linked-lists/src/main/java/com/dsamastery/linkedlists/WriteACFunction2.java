package com.dsamastery.linkedlists;

import java.util.*;

public class WriteACFunction {

    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
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
    int detectloop(static class node *list)
    {
    static class node *slow_p = list, *fast_p = list;
    while(slow_p && fast_p &&
    fast_p.next )
    {
    slow_p = slow_p.next;
    fast_p = fast_p.next.next;
    if (slow_p == fast_p)
    {
    System.out.printf("Found Loop");
    return 1;
    }
    }
    return 0;
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    push(&head, 20);
    push(&head, 4);
    push(&head, 15);
    push(&head, 10);
    /* Create a loop for testing */
    head.next.next.next.next = head;
    detectloop(head);
    getchar();
    }
}
