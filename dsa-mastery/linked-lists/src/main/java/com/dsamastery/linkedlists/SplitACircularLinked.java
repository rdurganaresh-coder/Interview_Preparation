package com.dsamastery.linkedlists;

import java.util.*;

public class SplitACircularLinked {

    /* Program to split a circular linked list into two halves */
    /* structure for a node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to split a list (starting with head) into two lists.
    head1_ref and head2_ref are references to head nodes of
    the two resultant linked lists */
    void splitList(static class node *head, static class node **head1_ref,
    static class node **head2_ref)
    {
    static class node *slow_ptr = head;
    static class node *fast_ptr = head;
    if(head == null)
    return;
    /* If there are odd nodes in the circular list then
    fast_ptr.next becomes head and for even nodes
    fast_ptr.next.next becomes head */
    while(fast_ptr.next != head &&
    fast_ptr.next.next != head)
    {
    fast_ptr = fast_ptr.next.next;
    slow_ptr = slow_ptr.next;
    }
    /* If there are even elements in list then move fast_ptr */
    if(fast_ptr.next.next == head)
    fast_ptr = fast_ptr.next;
    /* Set the head pointer of first half */
    *head1_ref = head;
    /* Set the head pointer of second half */
    if(head.next != head)
    *head2_ref = slow_ptr.next;
    /* Make second half circular */
    fast_ptr.next = slow_ptr.next;
    /* Make first half circular */
    slow_ptr.next = head;
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the begining of a Circular
    linked lsit */
    void push(static class node **head_ref, int data)
    {
    static class node *ptr1 = (static class node *)malloc(sizeof(static class node));
    static class node *temp = *head_ref;
    ptr1.data = data;
    ptr1.next = *head_ref;
    /* If linked list is not null then set the next of
    last node */
    if(*head_ref != null)
    {
    while(temp.next != *head_ref)
    temp = temp.next;
    temp.next = ptr1;
    }
    else
    ptr1.next = ptr1; /*For the first node */
    *head_ref = ptr1;
    }
    /* Function to print nodes in a given Circular linked list */
    void printList(static class node *head)
    {
    static class node *temp = head;
    if(head != null)
    {
    System.out.printf("\n");
    do {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    } while(temp != head);
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    int list_size, i;
    /* Initialize lists as empty */
    static class node *head = null;
    static class node *head1 = null;
    static class node *head2 = null;
    /* Created linked list will be 12.56.2.11 */
    push(&head, 12);
    push(&head, 56);
    push(&head, 2);
    push(&head, 11);
    System.out.printf("Original Circular Linked List");
    printList(head);
    /* Split the list */
    splitList(head, &head1, &head2);
    System.out.printf("\nFirst Circular Linked List");
    printList(head1);
    System.out.printf("\nSecond Circular Linked List");
    printList(head2);
    getchar();
    return 0;
    }
}
