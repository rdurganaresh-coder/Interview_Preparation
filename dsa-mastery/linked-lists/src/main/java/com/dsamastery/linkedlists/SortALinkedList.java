package com.dsamastery.linkedlists;

import java.util.*;

public class SortALinkedList {

    // Program to sort a linked list 0s, 1s or 2s
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    // Function to sort a linked list of 0s, 1s and 2s
    void sortList(static class node *head)
    {
    int count[3] = {0, 0, 0}; // Initialize count of '0', '1' and '2' as 0
    static class node *ptr = head;
    /* count total number of '0', '1' and '2'
    * count[0] will store total number of '0's
    * count[1] will store total number of '1's
    * count[2] will store total number of '2's */
    while (ptr != null)
    {
    count[ptr.data] += 1;
    ptr = ptr.next;
    }
    int i = 0;
    ptr = head;
    /* Let say count[0] = n1, count[1] = n2 and count[2] = n3
    * now start traversing list from head node,
    * 1) fill the list with 0, till n1 > 0
    * 2) fill the list with 1, till n2 > 0
    * 3) fill the list with 2, till n3 > 0 */
    while (ptr != null)
    {
    if (count[i] == 0)
    ++i;
    else
    {
    ptr.data = i;
    --count[i];
    ptr = ptr.next;
    }
    }
    }
    /* Function to push a node */
    void push (static class node** head_ref, int new_data)
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
    /* Function to print linked list */
    void printList(static class node *node)
    {
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    System.out.printf("\n");
    }
    /* Drier program to test above function*/
    int main(void)
    {
    static class node *head = null;
    push(&head, 0);
    push(&head, 1);
    push(&head, 0);
    push(&head, 2);
    push(&head, 1);
    push(&head, 1);
    push(&head, 2);
    push(&head, 1);
    push(&head, 2);
    System.out.printf("Linked List Before Sorting\n");
    printList(head);
    sortList(head);
    System.out.printf("Linked List After Sorting\n");
    printList(head);
    return 0;
    }
}
