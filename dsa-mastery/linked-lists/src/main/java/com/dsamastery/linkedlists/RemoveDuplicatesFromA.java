package com.dsamastery.linkedlists;

import java.util.*;

public class RemoveDuplicatesFromA {

    /*Program to remove duplicates from a sorted linked list */
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* The function removes duplicates from a sorted list */
    void removeDuplicates(static class node* head)
    {
    /* Pointer to traverse the linked list */
    static class node* current = head;
    /* Pointer to store the next pointer of a node to be deleted*/
    static class node* next_next;
    /* do nothing if the list is empty */
    if(current == null)
    return;
    /* Traverse the list till last node */
    while(current.next != null)
    {
    /* Compare current node with next node */
    if(current.data == current.next.data)
    {
    /*The sequence of steps is important*/
    next_next = current.next.next;
    free(current.next);
    current.next = next_next;
    }
    else /* This is tricky: only advance if no deletion */
    {
    current = current.next;
    }
    }
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginging of the linked list */
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
    Created linked list will be 11.11.11.13.13.20 */
    push(&head, 20);
    push(&head, 13);
    push(&head, 13);
    push(&head, 11);
    push(&head, 11);
    push(&head, 11);
    System.out.printf("\n Linked list before duplicate removal ");
    printList(head);
    /* Remove duplicates from linked list */
    removeDuplicates(head);
    System.out.printf("\n Linked list after duplicate removal ");
    printList(head);
    getchar();
    }
}
