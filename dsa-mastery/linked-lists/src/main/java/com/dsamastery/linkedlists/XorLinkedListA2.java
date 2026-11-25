package com.dsamastery.linkedlists;

import java.util.*;

public class XorLinkedListA {

    /* C/C++ Implementation of Memory efficient Doubly Linked List */
    // Node structure of a memory efficient doubly linked list
    static class node
    {
    int data;
    static class node* npx; /* XOR of next and previous node */
    };
    /* returns XORed value of the node addresses */
    static class node* XOR (static class node *a, static class node *b)
    {
    return (static class node*) ((unsigned int) (a) ^ (unsigned int) (b));
    }
    /* Insert a node at the begining of the XORed linked list and makes the
    newly inserted node as head */
    void insert(static class node **head_ref, int data)
    {
    // Allocate memory for new node
    static class node *new_node = (static class node *) malloc (sizeof (static class node) );
    new_node.data = data;
    /* Since new node is being inserted at the begining, npx of new node
    will always be XOR of current head and null */
    new_node.npx = XOR(*head_ref, null);
    /* If linked list is not empty, then npx of current head node will be XOR
    of new node and node next to current head */
    if (*head_ref != null)
    {
    // *(head_ref)->npx is XOR of null and next. So if we do XOR of
    // it with null, we get next
    static class node* next = XOR((*head_ref)->npx, null);
    (*head_ref)->npx = XOR(new_node, next);
    }
    // Change head
    *head_ref = new_node;
    }
    // prints contents of doubly linked list in forward direction
    void printList (static class node *head)
    {
    static class node *curr = head;
    static class node *prev = null;
    static class node *next;
    System.out.printf("Following are the nodes of Linked List: \n");
    while (curr != null)
    {
    // print current node
    System.out.printf("%d ", curr.data);
    // get address of next node: curr.npx is next^prev, so curr.npx^prev
    // will be next^prev^prev which is next
    next = XOR (prev, curr.npx);
    // update prev and curr for next iteration
    prev = curr;
    curr = next;
    }
    }
    // Driver program to test above functions
    int main ()
    {
    /* Create following Doubly Linked List
    head-->40<-->30<-->20<-->10 */
    static class node *head = null;
    insert(&head, 10);
    insert(&head, 20);
    insert(&head, 30);
    insert(&head, 40);
    // print the created list
    printList (head);
    return (0);
    }
}
