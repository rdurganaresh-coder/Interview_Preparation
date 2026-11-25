package com.dsamastery.linkedlists;

import java.util.*;

public class ReverseALinkedList {

    2) head.next = reverse(next, k) /* Recursively call for rest of the list and link the two sub-lists */
    3) return prev /* prev becomes the new head of the list (see the diagrams of iterative method of this post)
    */
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Reverses the linked list in groups of size k and returns the
    pointer to the new head node. */
    static class node *reverse (static class node *head, int k)
    {
    static class node* current = head;
    static class node* next = null;
    static class node* prev = null;
    int count = 0;
    /*reverse first k nodes of the linked list */
    while (current != null && count < k)
    {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
    count++;
    }
    /* next is now a pointer to (k+1)th node
    Recursively call for the list starting from current.
    And make rest of the list as next of first node */
    if(next != null)
    { head.next = reverse(next, k); }
    /* prev is new head of the input list */
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
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above function*/
    int main(void)
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Created Linked list is 1.2.3.4.5.6.7.8 */
    push(&head, 8);
    push(&head, 7);
    push(&head, 6);
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    System.out.printf("\n Given linked list \n");
    printList(head);
    head = reverse(head, 3);
    System.out.printf("\n Reversed Linked list \n");
    printList(head);
    getchar();
    return(0);
    }
}
