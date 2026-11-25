package com.dsamastery.linkedlists;

import java.util.*;

public class WriteAFunctionThat {

    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
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
    /* Counts the no. of occurences of a node
    (search_for) in a linked list (head)*/
    int count(static class node* head, int search_for)
    {
    static class node* current = head;
    int count = 0;
    while (current != null)
    {
    if (current.data == search_for)
    count++;
    current = current.next;
    }
    return count;
    }
    /* Drier program to test count function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Use push() to construct below list
    1.2.1.3.1 */
    push(&head, 1);
    push(&head, 3);
    push(&head, 1);
    push(&head, 2);
    push(&head, 1);
    /* Check the count function */
    System.out.printf("count of 1 is %d", count(head, 1));
    getchar();
    }
}
