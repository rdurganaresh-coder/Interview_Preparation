package com.dsamastery.linkedlists;

import java.util.*;

public class NthNodeFromThe {

    Method 1 (Use length of linked list)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to get the nth node from the last of a linked list*/
    void printNthFromLast(static class node* head, int n)
    {
    int len = 0, i;
    static class node *temp = head;
    // 1) count the number of nodes in Linked List
    while (temp != null)
    {
    temp = temp.next;
    len++;
    }
    // check if value of n is not more than length of the linked list
    if (len < n)
    return;
    temp = head;
    // 2) get the (n-len+1)th node from the begining
    for (i = 1; i < len-n+1; i++)
    temp = temp.next;
    System.out.printf("%d", temp.data);
    return;
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
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    // create linked 35.15.4.20
    push(&head, 20);
    push(&head, 4);
    push(&head, 15);
    push(&head, 35);
    printNthFromLast(head, 5);
    getchar();
    return 0;
    }
    void printNthFromLast(static class node* head, int n)
    {
    static int i = 0;
    if(head == null)
    return;
    printNthFromLast(head.next, n);
    if(++i == n)
    System.out.printf("%d", head.data);
    }
    Method 2 (Use two pointers)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to get the nth node from the last of a linked list*/
    void printNthFromLast(static class node *head, int n)
    {
    static class node *main_ptr = head;
    static class node *ref_ptr = head;
    int count = 0;
    if(head != null)
    {
    while( count < n )
    {
    if(ref_ptr == null)
    {
    System.out.printf("%d is greater than the no. of "
    "nodes in list", n);
    return;
    }
    ref_ptr = ref_ptr.next;
    count++;
    } /* End of while*/
    while(ref_ptr != null)
    {
    main_ptr = main_ptr.next;
    ref_ptr = ref_ptr.next;
    }
    System.out.printf("Node no. %d from last is %d ",
    n, main_ptr.data);
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
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    push(&head, 20);
    push(&head, 4);
    push(&head, 15);
    printNthFromLast(head, 3);
    getchar();
    }
}
