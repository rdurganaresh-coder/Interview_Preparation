package com.dsamastery.linkedlists;

import java.util.*;

public class SwapNodesInA {

    /* This program swaps the nodes of linked list rather
    than swapping the field from the nodes.*/
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Function to swap nodes x and y in linked list by
    changing links */
    void swapNodes(static class node **head_ref, int x, int y)
    {
    // Nothing to do if x and y are same
    if (x == y) return;
    // Search for x (keep track of prevX and CurrX
    static class node *prevX = null, *currX = *head_ref;
    while (currX && currX.data != x)
    {
    prevX = currX;
    currX = currX.next;
    }
    // Search for y (keep track of prevY and CurrY
    static class node *prevY = null, *currY = *head_ref;
    while (currY && currY.data != y)
    {
    prevY = currY;
    currY = currY.next;
    }
    // If either x or y is not present, nothing to do
    if (currX == null || currY == null)
    return;
    // If x is not head of linked list
    if (prevX != null)
    prevX.next = currY;
    else // Else make y as new head
    *head_ref = currY;
    // If y is not head of linked list
    if (prevY != null)
    prevY.next = currX;
    else // Else make x as new head
    *head_ref = currX;
    // Swap next pointers
    static class node *temp = currY.next;
    currY.next = currX.next;
    currX.next = temp;
    }
    /* Function to add a node at the begining of List */
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
    /* Druver program to test above function */
    int main()
    {
    static class node *start = null;
    /* The constructed linked list is:
    1.2.3.4.5.6.7 */
    push(&start, 7);
    push(&start, 6);
    push(&start, 5);
    push(&start, 4);
    push(&start, 3);
    push(&start, 2);
    push(&start, 1);
    System.out.printf("\n Linked list before calling swapNodes() ");
    printList(start);
    swapNodes(&start, 4, 3);
    System.out.printf("\n Linked list after calling swapNodes() ");
    printList(start);
    return 0;
    }
}
