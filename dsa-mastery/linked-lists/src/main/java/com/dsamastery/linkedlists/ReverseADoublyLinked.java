package com.dsamastery.linkedlists;

import java.util.*;

public class ReverseADoublyLinked {

    /* Program to reverse a doubly linked list */
    /* a node of the doubly linked list */
    static class node
    {
    int data;
    static class node *next;
    static class node *prev;
    };
    /* Function to reverse a Doubly Linked List */
    void reverse(static class node **head_ref)
    {
    static class node *temp = null;
    static class node *current = *head_ref;
    /* swap next and prev for all nodes of
    doubly linked list */
    while (current != null)
    {
    temp = current.prev;
    current.prev = current.next;
    current.next = temp;
    current = current.prev;
    }
    /* Before changing head, check for the cases like empty
    list and list with only one node */
    if(temp != null )
    *head_ref = temp.prev;
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginging of the Doubly Linked List */
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
    /* Let us create a sorted linked list to test the functions
    Created linked list will be 10.8.4.2 */
    push(&head, 2);
    push(&head, 4);
    push(&head, 8);
    push(&head, 10);
    System.out.printf("\n Original Linked list ");
    printList(head);
    /* Reverse doubly linked list */
    reverse(&head);
    System.out.printf("\n Reversed Linked list ");
    printList(head);
    getchar();
    }
}
