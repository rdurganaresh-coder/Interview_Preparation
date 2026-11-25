package com.dsamastery.linkedlists;

import java.util.*;

public class DeleteANodeIn {

    /* a node of the doubly linked list */
    static class node
    {
    int data;
    static class node *next;
    static class node *prev;
    };
    /* Function to delete a node in a Doubly Linked List.
    head_ref --> pointer to head node pointer.
    del --> pointer to node to be deleted. */
    void deleteNode(static class node **head_ref, static class node *del)
    {
    /* base case */
    if(*head_ref == null || del == null)
    return;
    /* If node to be deleted is head node */
    if(*head_ref == del)
    *head_ref = del.next;
    /* Change next only if node to be deleted is NOT the last node */
    if(del.next != null)
    del.next.prev = del.prev;
    /* Change prev only if node to be deleted is NOT the first node */
    if(del.prev != null)
    del.prev.next = del.next;
    /* Finally, free the memory occupied by del*/
    free(del);
    return;
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* since we are adding at the begining,
    prev is always null */
    new_node.prev = null;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* change prev of head node to new node */
    if((*head_ref) != null)
    (*head_ref)->prev = new_node ;
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Function to print nodes in a given doubly linked list
    This function is same as printList() of singly linked lsit */
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
    static class node* head = null;
    /* Let us create the doubly linked list 10<->8<->4<->2 */
    push(&head, 2);
    push(&head, 4);
    push(&head, 8);
    push(&head, 10);
    System.out.printf("\n Original Linked list ");
    printList(head);
    /* delete nodes from the doubly linked list */
    deleteNode(&head, head); /*delete first node*/
    deleteNode(&head, head.next); /*delete middle node*/
    deleteNode(&head, head.next); /*delete last node*/
    /* Modified linked list will be null<-8.null */
    System.out.printf("\n Modified Linked list ");
    printList(head);
    getchar();
    }
}
