package com.dsamastery.linkedlists;

import java.util.*;

public class DeleteNNodesAfter {

    delete next N nodes, continue the same till end of the linked list.
    // C program to delete N nodes after M nodes of a linked list
    // A linked list node
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to insert a node at the beginning */
    void push(static class node ** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node = (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Function to print linked list */
    void printList(static class node *head)
    {
    static class node *temp = head;
    while (temp != null)
    {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    }
    System.out.printf("\n");
    }
    // Function to skip M nodes and then delete N nodes of the linked list.
    void skipMdeleteN(static class node *head, int M, int N)
    {
    static class node *curr = head, *t;
    int count;
    // The main loop that traverses through the whole list
    while (curr)
    {
    // Skip M nodes
    for (count = 1; count<M && curr!= null; count++)
    curr = curr.next;
    // If we reached end of list, then return
    if (curr == null)
    return;
    // Start from next node and delete N nodes
    t = curr.next;
    for (count = 1; count<=N && t!= null; count++)
    {
    static class node *temp = t;
    t = t.next;
    free(temp);
    }
    curr.next = t; // Link the previous list with remaining nodes
    // Set current pointer for next iteration
    curr = t;
    }
    }
    // Driver program to test above functions
    int main()
    {
    /* Create following linked list
    1.2.3.4.5.6.7.8.9.10 */
    static class node* head = null;
    int M=2, N=3;
    push(&head, 10);
    push(&head, 9);
    push(&head, 8);
    push(&head, 7);
    push(&head, 6);
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    System.out.printf("M = %d, N = %d \nGiven Linked list is :\n", M, N);
    printList(head);
    skipMdeleteN(head, M, N);
    System.out.printf("\nLinked list after deletion is :\n");
    printList(head);
    return 0;
    }
}
