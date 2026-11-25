package com.dsamastery.linkedlists;

import java.util.*;

public class GivenALinkedList {

    /* Program to insert in a sorted list */
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* function to insert a new_node in a list. Note that this
    function expects a pointer to head_ref as this can modify the
    head of the input linked list (similar to push())*/
    void sortedInsert(static class node** head_ref, static class node* new_node)
    {
    static class node* current;
    /* Special case for the head end */
    if (*head_ref == null || (*head_ref)->data >= new_node.data)
    {
    new_node.next = *head_ref;
    *head_ref = new_node;
    }
    else
    {
    /* Locate the node before the point of insertion */
    current = *head_ref;
    while (current.next!=null &&
    current.next.data < new_node.data)
    {
    current = current.next;
    }
    new_node.next = current.next;
    current.next = new_node;
    }
    }
    /* BELOW FUNCTIONS ARE JUST UTILITY TO TEST sortedInsert */
    /* A utility function to create a new node */
    static class node *newNode(int new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    new_node.next = null;
    return new_node;
    }
    /* Function to print linked list */
    void printList(static class node *head)
    {
    static class node *temp = head;
    while(temp != null)
    {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    }
    }
    /* Drier program to test count function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    static class node *new_node = newNode(5);
    sortedInsert(&head, new_node);
    new_node = newNode(10);
    sortedInsert(&head, new_node);
    new_node = newNode(7);
    sortedInsert(&head, new_node);
    new_node = newNode(3);
    sortedInsert(&head, new_node);
    new_node = newNode(1);
    sortedInsert(&head, new_node);
    new_node = newNode(9);
    sortedInsert(&head, new_node);
    System.out.printf("\n Created Linked List\n");
    printList(head);
    getchar();
    return 0;
    }
    current = &((*current)->next);
    new_node.next = *current; /* Copies the value-at-address current to new_node's next pointer*/
    *current = new_node; /* Fix next pointer of the node (using it's address) after which new_node is being inserted */
}
