package com.dsamastery.linkedlists;

import java.util.*;

public class ReverseAlternateKNodes {

    Method 1 (Process 2k nodes and recursively call for rest of the list)
    kAltReverse(static class node *head, int k)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Reverses alternate k nodes and
    returns the pointer to the new head node */
    static class node *kAltReverse(static class node *head, int k)
    {
    static class node* current = head;
    static class node* next;
    static class node* prev = null;
    int count = 0;
    /*1) reverse first k nodes of the linked list */
    while (current != null && count < k)
    {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
    count++;
    }
    /* 2) Now head points to the kth node. So change next
    of head to (k+1)th node*/
    if(head != null)
    head.next = current;
    /* 3) We do not want to reverse next k nodes. So move the current
    pointer to skip next k nodes */
    count = 0;
    while(count < k-1 && current != null )
    {
    current = current.next;
    count++;
    }
    /* 4) Recursively call for the list starting from current.next.
    And make rest of the list as next of first node */
    if(current != null)
    current.next = kAltReverse(current.next, k);
    /* 5) prev is new head of the input list */
    return prev;
    }
    /* UTILITY FUNCTIONS */
    /* Function to push a node */
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
    /* Function to print linked list */
    void printList(static class node *node)
    {
    int count = 0;
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    count++;
    }
    }
    /* Drier program to test above function*/
    int main(void)
    {
    /* Start with the empty list */
    static class node* head = null;
    // create a list 1.2.3.4.5...... ->20
    for(int i = 20; i > 0; i--)
    push(&head, i);
    System.out.printf("\n Given linked list \n");
    printList(head);
    head = kAltReverse(head, 3);
    System.out.printf("\n Modified Linked list \n");
    printList(head);
    getchar();
    return(0);
    }
    Method 2 (Process k nodes and recursively call for rest of the list)
    _kAltReverse(static class node *head, int k, boolean b)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Helper function for kAltReverse() */
    static class node * _kAltReverse(static class node *node, int k, boolean b);
    /* Alternatively reverses the given linked list in groups of
    given size k. */
    static class node *kAltReverse(static class node *head, int k)
    {
    return _kAltReverse(head, k, true);
    }
    /* Helper function for kAltReverse(). It reverses k nodes of the list only if
    the third parameter b is passed as true, otherwise moves the pointer k
    nodes ahead and recursively calls iteself */
    static class node * _kAltReverse(static class node *node, int k, boolean b)
    {
    if(node == null)
    return null;
    int count = 1;
    static class node *prev = null;
    static class node *current = node;
    static class node *next;
    /* The loop serves two purposes
    1) If b is true, then it reverses the k nodes
    2) If b is false, then it moves the current pointer */
    while(current != null && count <= k)
    {
    next = current.next;
    /* Reverse the nodes only if b is true*/
    if(b == true)
    current.next = prev;
    prev = current;
    current = next;
    count++;
    }
    /* 3) If b is true, then node is the kth node.
    So attach rest of the list after node.
    4) After attaching, return the new head */
    if(b == true)
    {
    node.next = _kAltReverse(current,k,!b);
    return prev;
    }
    /* If b is not true, then attach rest of the list after prev.
    So attach rest of the list after prev */
    else
    {
    prev.next = _kAltReverse(current, k, !b);
    return node;
    }
    }
    /* UTILITY FUNCTIONS */
    /* Function to push a node */
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
    /* Function to print linked list */
    void printList(static class node *node)
    {
    int count = 0;
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    count++;
    }
    }
    /* Drier program to test above function*/
    int main(void)
    {
    /* Start with the empty list */
    static class node* head = null;
    int i;
    // create a list 1.2.3.4.5...... ->20
    for(i = 20; i > 0; i--)
    push(&head, i);
    System.out.printf("\n Given linked list \n");
    printList(head);
    head = kAltReverse(head, 3);
    System.out.printf("\n Modified Linked list \n");
    printList(head);
    getchar();
    return(0);
    }
}
