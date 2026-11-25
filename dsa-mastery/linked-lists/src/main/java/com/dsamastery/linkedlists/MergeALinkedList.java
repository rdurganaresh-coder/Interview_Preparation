package com.dsamastery.linkedlists;

import java.util.*;

public class MergeALinkedList {

    // C implementation of above program.
    // A nexted list node
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to insert a node at the beginning */
    void push(static class node ** head_ref, int new_data)
    {
    static class node* new_node = (static class node*) malloc(sizeof(static class node));
    new_node.data = new_data;
    new_node.next = (*head_ref);
    (*head_ref) = new_node;
    }
    /* Utility function to print a singly linked list */
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
    // Main function that inserts nodes of linked list q into p at alternate
    // positions. Since head of first list never changes and head of second list
    // may change, we need single pointer for first list and double pointer for
    // second list.
    void merge(static class node *p, static class node **q)
    {
    static class node *p_curr = p, *q_curr = *q;
    static class node *p_next, *q_next;
    // While therre are avialable positions in p
    while (p_curr != null && q_curr != null)
    {
    // Save next pointers
    p_next = p_curr.next;
    q_next = q_curr.next;
    // Make q_curr as next of p_curr
    q_curr.next = p_next; // Change next pointer of q_curr
    p_curr.next = q_curr; // Change next pointer of p_curr
    // Update current pointers for next iteration
    p_curr = p_next;
    q_curr = q_next;
    }
    *q = q_curr; // Update head pointer of second list
    }
    // Driver program to test above functions
    int main()
    {
    static class node *p = null, *q = null;
    push(&p, 3);
    push(&p, 2);
    push(&p, 1);
    System.out.printf("First Linked List:\n");
    printList(p);
    push(&q, 8);
    push(&q, 7);
    push(&q, 6);
    push(&q, 5);
    push(&q, 4);
    System.out.printf("Second Linked List:\n");
    printList(q);
    merge(p, &q);
    System.out.printf("Modified First Linked List:\n");
    printList(p);
    System.out.printf("Modified Second Linked List:\n");
    printList(q);
    getchar();
    return 0;
    }
}
