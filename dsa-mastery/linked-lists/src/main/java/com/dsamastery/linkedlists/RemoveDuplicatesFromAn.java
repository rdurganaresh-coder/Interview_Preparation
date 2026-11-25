package com.dsamastery.linkedlists;

import java.util.*;

public class RemoveDuplicatesFromAn {

    METHOD 1 (Using two loops)
    /* Program to remove duplicates in an unsorted array */
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to remove duplicates from a unsorted linked list */
    void removeDuplicates(static class node *start)
    {
    static class node *ptr1, *ptr2, *dup;
    ptr1 = start;
    /* Pick elements one by one */
    while(ptr1 != null && ptr1.next != null)
    {
    ptr2 = ptr1;
    /* Compare the picked element with rest of the elements */
    while(ptr2.next != null)
    {
    /* If duplicate then delete it */
    if(ptr1.data == ptr2.next.data)
    {
    /* sequence of steps is important here */
    dup = ptr2.next;
    ptr2.next = ptr2.next.next;
    free(dup);
    }
    else /* This is tricky */
    {
    ptr2 = ptr2.next;
    }
    }
    ptr1 = ptr1.next;
    }
    }
    /* UTILITY FUNCTIONS */
    /* Function to push a node */
    void push(static class node** head_ref, int new_data);
    /* Function to print nodes in a given linked list */
    void printList(static class node *node);
    /* Druver program to test above function */
    int main()
    {
    static class node *start = null;
    /* The constructed linked list is:
    10.12.11.11.12.11.10*/
    push(&start, 10);
    push(&start, 11);
    push(&start, 12);
    push(&start, 11);
    push(&start, 11);
    push(&start, 12);
    push(&start, 10);
    System.out.printf("\n Linked list before removing duplicates ");
    printList(start);
    removeDuplicates(start);
    System.out.printf("\n Linked list after removing duplicates ");
    printList(start);
    getchar();
    }
    /* Function to push a node */
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
    METHOD 2 (Use Sorting)
    METHOD 3 (Use Hashing)
}
