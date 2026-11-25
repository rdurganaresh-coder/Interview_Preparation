package com.dsamastery.linkedlists;

import java.util.*;

public class PairwiseSwapElementsOf {

    /* This program swaps the nodes of linked list rather than swapping the
    field from the nodes.
    Imagine a case where a node contains many fields, there will be plenty
    of unnecessary swap calls. */
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to pairwise swap elements of a linked list */
    void pairWiseSwap(static class node **head)
    {
    // If linked list is empty or there is only one node in list
    if (*head == null || (*head)->next == null)
    return;
    // Initialize previous and current pointers
    static class node *prev = *head;
    static class node *curr = (*head)->next;
    *head = curr; // Change head before proceeeding
    // Traverse the list
    while (true)
    {
    static class node *next = curr.next;
    curr.next = prev; // Change next of current as previous node
    // If next null or next is the last node
    if (next == null || next.next == null)
    {
    prev.next = next;
    break;
    }
    // Change next of previous to next next
    prev.next = next.next;
    // Update previous and curr
    prev = next;
    curr = prev.next;
    }
    }
    /* Function to add a node at the begining of Linked List */
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
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Druver program to test above function */
    int main()
    {
    static class node *start = null;
    /* The constructed linked list is:
    1.2.3.4.5.6.7 */
    push(&start, 7);
    push(&start, 6);
    push(&start, 5);
    push(&start, 4);
    push(&start, 3);
    push(&start, 2);
    push(&start, 1);
    System.out.printf("\n Linked list before calling pairWiseSwap() ");
    printList(start);
    pairWiseSwap(&start);
    System.out.printf("\n Linked list after calling pairWiseSwap() ");
    printList(start);
    getchar();
    return 0;
    }
    /* This program swaps the nodes of linked list rather than swapping the
    field from the nodes.
    Imagine a case where a node contains many fields, there will be plenty
    of unnecessary swap calls. */
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to pairwise swap elements of a linked list.
    It returns head of the modified list, so return value
    of this node must be assigned */
    static class node *pairWiseSwap(static class node* head)
    {
    // Base Case: The list is empty or has only one node
    if (head == null || head.next == null)
    return head;
    // Store head of list after two nodes
    static class node* remaing = head.next.next;
    // Change head
    static class node* newhead = head.next;
    // Change next of second node
    head.next.next = head;
    // Recur for remaining list and change next of head
    head.next = pairWiseSwap(remaing);
    // Return new head of modified list
    return newhead;
    }
    /* Function to add a node at the begining of Linked List */
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
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Druver program to test above function */
    int main()
    {
    static class node *start = null;
    /* The constructed linked list is:
    1.2.3.4.5.6.7 */
    push(&start, 7);
    push(&start, 6);
    push(&start, 5);
    push(&start, 4);
    push(&start, 3);
    push(&start, 2);
    push(&start, 1);
    System.out.printf("\n Linked list before calling pairWiseSwap() ");
    printList(start);
    start = pairWiseSwap(start); // NOTE THIS CHANGE
    System.out.printf("\n Linked list after calling pairWiseSwap() ");
    printList(start);
    return 0;
    }
}
