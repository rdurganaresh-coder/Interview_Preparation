package com.dsamastery.linkedlists;

import java.util.*;

public class WriteAFunctionTo {

    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to reverse the linked list */
    static void reverse(static class node** head_ref)
    {
    static class node* prev = null;
    static class node* current = *head_ref;
    static class node* next;
    while (current != null)
    {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
    }
    *head_ref = prev;
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
    /* Function to print linked list */
    void printList(static class node *head)
    {
    static class node *temp = head;
    while(temp != null)
    {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    }
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    push(&head, 20);
    push(&head, 4);
    push(&head, 15);
    push(&head, 85);
    printList(head);
    reverse(&head);
    System.out.printf("\n Reversed Linked list \n");
    printList(head);
    getchar();
    }
    void recursiveReverse(static class node** head_ref)
    {
    static class node* first;
    static class node* rest;
    /* empty list */
    if (*head_ref == null)
    return;
    /* suppose first = {1, 2, 3}, rest = {2, 3} */
    first = *head_ref;
    rest = first.next;
    /* List has only one node */
    if (rest == null)
    return;
    /* reverse the rest list and put the first element at the end */
    recursiveReverse(&rest);
    first.next.next = first;
    /* tricky step -- see the diagram */
    first.next = null;
    /* fix the head pointer */
    *head_ref = rest;
    }
    // A simple and tail recursive C++ program to reverse
    // a linked list
    static class node
    {
    int data;
    static class node *next;
    };
    void reverseUtil(node *curr, node *prev, node **head);
    // This function mainly calls reverseUtil()
    // with prev as null
    void reverse(node **head)
    {
    if (!head)
    return;
    reverseUtil(*head, null, head);
    }
    // A simple and tail recursive function to reverse
    // a linked list. prev is passed as null initially.
    void reverseUtil(node *curr, node *prev, node **head)
    {
    /* If last node mark it head*/
    if (!curr.next)
    {
    *head = curr;
    /* Update next to prev node */
    curr.next = prev;
    return;
    }
    /* Save curr.next node for recursive call */
    node *next = curr.next;
    /* and update next ..*/
    curr.next = prev;
    reverseUtil(next, curr, head);
    }
    // A utility function to create a new node
    node *newNode(int key)
    {
    node *temp = new node;
    temp.data = key;
    temp.next = null;
    return temp;
    }
    // A utility function to print a linked list
    void printlist(node *head)
    {
    while(head != null)
    {
    System.out.print(head.data << " ");
    head = head.next;
    }
    System.out.print(endl);
    }
    // Driver program to test above functions
    int main()
    {
    node *head1 = newNode(1);
    head1.next = newNode(2);
    head1.next.next = newNode(2);
    head1.next.next.next = newNode(4);
    head1.next.next.next.next = newNode(5);
    head1.next.next.next.next.next = newNode(6);
    head1.next.next.next.next.next.next = newNode(7);
    head1.next.next.next.next.next.next.next = newNode(8);
    System.out.print("Given linked list\n");
    printlist(head1);
    reverse(&head1);
    System.out.print("\nReversed linked list\n");
    printlist(head1);
    return 0;
    }
}
