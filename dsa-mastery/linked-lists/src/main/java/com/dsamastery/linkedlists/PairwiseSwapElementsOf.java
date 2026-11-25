package com.dsamastery.linkedlists;

import java.util.*;

public class PairwiseSwapElementsOf {

    METHOD 1 (Iterative)
    /* Program to pairwise swap elements in a given linked list */
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /*Function to swap two integers at addresses a and b */
    void swap(int *a, int *b);
    /* Function to pairwise swap elements of a linked list */
    void pairWiseSwap(static class node *head)
    {
    static class node *temp = head;
    /* Traverse further only if there are at-least two nodes left */
    while (temp != null && temp.next != null)
    {
    /* Swap data of node with its next node's data */
    swap(&temp.data, &temp.next.data);
    /* Move temp by 2 for the next pair */
    temp = temp.next.next;
    }
    }
    /* UTILITY FUNCTIONS */
    /* Function to swap two integers */
    void swap(int *a, int *b)
    {
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
    }
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
    while (node != null)
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
    System.out.printf("\n Linked list before calling pairWiseSwap() ");
    printList(start);
    pairWiseSwap(start);
    System.out.printf("\n Linked list after calling pairWiseSwap() ");
    printList(start);
    getchar();
    return 0;
    }
    METHOD 2 (Recursive)
    /* Recursive function to pairwise swap elements of a linked list */
    void pairWiseSwap(static class node *head)
    {
    /* There must be at-least two nodes in the list */
    if(head != null && head.next != null)
    {
    /* Swap the node's data with data of next node */
    swap(&head.data, &head.next.data);
    /* Call pairWiseSwap() for rest of the list */
    pairWiseSwap(head.next.next);
    }
    }
}
