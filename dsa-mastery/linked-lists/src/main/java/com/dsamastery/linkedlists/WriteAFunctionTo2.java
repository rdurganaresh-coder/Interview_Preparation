package com.dsamastery.linkedlists;

import java.util.*;

public class WriteAFunctionTo {

    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to delete the entire linked list */
    void deleteList(static class node** head_ref)
    {
    /* deref head_ref to get the real head */
    static class node* current = *head_ref;
    static class node* next;
    while (current != null)
    {
    next = current.next;
    free(current);
    current = next;
    }
    /* deref head_ref to affect the real head back
    in the caller. */
    *head_ref = null;
    }
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
    /* Drier program to test count function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Use push() to construct below list
    1.12.1.4.1 */
    push(&head, 1);
    push(&head, 4);
    push(&head, 1);
    push(&head, 12);
    push(&head, 1);
    System.out.printf("\n Deleting linked list");
    deleteList(&head);
    System.out.printf("\n Linked list deleted");
    getchar();
    }
}
