package com.dsamastery.linkedlists;

import java.util.*;

public class MoveLastElementTo {

    /* Program to move last element to front in a given linked list */
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* We are using a double pointer head_ref here because we change
    head of the linked list inside this function.*/
    void moveToFront(static class node **head_ref)
    {
    /* If linked list is empty, or it contains only one node,
    then nothing needs to be done, simply return */
    if(*head_ref == null || (*head_ref)->next == null)
    return;
    /* Initialize second last and last pointers */
    static class node *secLast = null;
    static class node *last = *head_ref;
    /*After this loop secLast contains address of second last
    node and last contains address of last node in Linked List */
    while(last.next != null)
    {
    secLast = last;
    last = last.next;
    }
    /* Set the next of second last as null */
    secLast.next = null;
    /* Set next of last as head node */
    last.next = *head_ref;
    /* Change the head pointer to point to last node now */
    *head_ref = last;
    }
    /* UTILITY FUNCTIONS */
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
    1.2.3.4.5 */
    push(&start, 5);
    push(&start, 4);
    push(&start, 3);
    push(&start, 2);
    push(&start, 1);
    System.out.printf("\n Linked list before moving last to front ");
    printList(start);
    moveToFront(&start);
    System.out.printf("\n Linked list after removing last to front ");
    printList(start);
    getchar();
    }
}
