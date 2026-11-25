package com.dsamastery.linkedlists;

import java.util.*;

public class WriteACFunction {

    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to get the middle of the linked list*/
    void printMiddle(static class node *head)
    {
    static class node *slow_ptr = head;
    static class node *fast_ptr = head;
    if (head!=null)
    {
    while (fast_ptr != null && fast_ptr.next != null)
    {
    fast_ptr = fast_ptr.next.next;
    slow_ptr = slow_ptr.next;
    }
    System.out.printf("The middle element is [%d]\n\n", slow_ptr.data);
    }
    }
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
    // A utility function to print a given linked list
    void printList(static class node *ptr)
    {
    while (ptr != null)
    {
    System.out.printf("%d.", ptr.data);
    ptr = ptr.next;
    }
    System.out.printf("null\n");
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    int i;
    for (i=5; i>0; i--)
    {
    push(&head, i);
    printList(head);
    printMiddle(head);
    }
    return 0;
    }
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to get the middle of the linked list*/
    void printMiddle(static class node *head)
    {
    int count = 0;
    static class node *mid = head;
    while (head != null)
    {
    /* update mid, when 'count' is odd number */
    if (count & 1)
    mid = mid.next;
    ++count;
    head = head.next;
    }
    /* if empty list is provided */
    if (mid != null)
    System.out.printf("The middle element is [%d]\n\n", mid.data);
    }
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
    // A utility function to print a given linked list
    void printList(static class node *ptr)
    {
    while (ptr != null)
    {
    System.out.printf("%d.", ptr.data);
    ptr = ptr.next;
    }
    System.out.printf("null\n");
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    int i;
    for (i=5; i>0; i--)
    {
    push(&head, i);
    printList(head);
    printMiddle(head);
    }
    return 0;
    }
}
