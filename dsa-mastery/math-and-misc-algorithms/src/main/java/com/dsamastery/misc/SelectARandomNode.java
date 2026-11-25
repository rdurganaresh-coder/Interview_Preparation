package com.dsamastery.misc;

import java.util.*;

public class SelectARandomNode {

    /* C program to randomly select a node from a singly
    linked list */
    /* Link list node */
    static class node
    {
    int key;
    static class node* next;
    };
    // A reservoir sampling based function to print a
    // random node from a linked list
    void printRandom(static class node *head)
    {
    // IF list is empty
    if (head == null)
    return;
    // Use a different seed value so that we don't get
    // same result each time we run this program
    srand(time(null));
    // Initialize result as first node
    int result = head.key;
    // Iterate from the (k+1)th element to nth element
    static class node *current = head;
    int n;
    for (n=2; current!=null; n++)
    {
    // change result with probability 1/n
    if (rand() % n == 0)
    result = current.key;
    // Move to next node
    current = current.next;
    }
    System.out.printf("Randomly selected key is %d\n", result);
    }
    /* BELOW FUNCTIONS ARE JUST UTILITY TO TEST */
    /* A utility function to create a new node */
    static class node *newNode(int new_key)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the key */
    new_node.key = new_key;
    new_node.next = null;
    return new_node;
    }
    /* A utility function to insert a node at the beginning
    of linked list */
    void push(static class node** head_ref, int new_key)
    {
    /* allocate node */
    static class node* new_node = new node;
    /* put in the key */
    new_node.key = new_key;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    // Driver program to test above functions
    int main()
    {
    static class node *head = null;
    push(&head, 5);
    push(&head, 20);
    push(&head, 4);
    push(&head, 3);
    push(&head, 30);
    printRandom(head);
    return 0;
    }
}
