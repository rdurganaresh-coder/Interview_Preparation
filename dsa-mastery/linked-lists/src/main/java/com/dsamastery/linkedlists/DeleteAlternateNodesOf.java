package com.dsamastery.linkedlists;

import java.util.*;

public class DeleteAlternateNodesOf {

    Method 1 (Iterative)
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* deletes alternate nodes of a list starting with head */
    void deleteAlt(static class node *head)
    {
    if (head == null)
    return;
    /* Initialize prev and node to be deleted */
    static class node *prev = head;
    static class node *node = head.next;
    while (prev != null && node != null)
    {
    /* Change next link of previous node */
    prev.next = node.next;
    /* Free memory */
    free(node);
    /* Update prev and node */
    prev = prev.next;
    if(prev != null)
    node = prev.next;
    }
    }
    /* UTILITY FUNCTIONS TO TEST fun1() and fun2() */
    /* Given a reference (pointer to pointer) to the head
    of a list and an int, push a new node on the front
    of the list. */
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
    /* Drier program to test above functions */
    int main()
    {
    int arr[100];
    /* Start with the empty list */
    static class node* head = null;
    /* Using push() to construct below list
    1.2.3.4.5 */
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    System.out.printf("\n List before calling deleteAlt() ");
    printList(head);
    deleteAlt(head);
    System.out.printf("\n List after calling deleteAlt() ");
    printList(head);
    getchar();
    return 0;
    }
    Method 2 (Recursive)
    /* deletes alternate nodes of a list starting with head */
    void deleteAlt(static class node *head)
    {
    if (head == null)
    return;
    static class node *node = head.next;
    if (node == null)
    return;
    /* Change the next link of head */
    head.next = node.next;
    /* free memory allocated for node */
    free(node);
    /* Recursively call for the new next of head */
    deleteAlt(head.next);
    }
}
