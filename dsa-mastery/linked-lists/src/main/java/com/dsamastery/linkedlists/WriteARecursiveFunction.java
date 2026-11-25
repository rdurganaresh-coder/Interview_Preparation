package com.dsamastery.linkedlists;

import java.util.*;

public class WriteARecursiveFunction {

    printReverse(head)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to reverse the linked list */
    void printReverse(static class node* head)
    {
    // Base case
    if(head == null)
    return;
    // print the list after head node
    printReverse(head.next);
    // After everything else is printed, print head
    System.out.printf("%d ", head.data);
    }
    /*UTILITY FUNCTIONS*/
    /* Push a node to linked list. Note that this function
    changes the head */
    void push(static class node** head_ref, char new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to pochar to the new node */
    (*head_ref) = new_node;
    }
    /* Drier program to test above function*/
    int main()
    {
    static class node* head = null;
    push(&head, 1);
    push(&head, 2);
    push(&head, 3);
    push(&head, 4);
    printReverse(head);
    getchar();
    }
}
