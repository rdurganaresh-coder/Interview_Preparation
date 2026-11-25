package com.dsamastery.linkedlists;

import java.util.*;

public class DeleteNodesWhichHave {

    Method 1 (Simple)
    delete the picked node.
    Method 2 (Use Reverse)
    /* structure of a linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* prototype for utility functions */
    void reverseList(static class node **headref);
    void _delLesserNodes(static class node *head);
    /* Deletes nodes which have a node with greater value node
    on left side */
    void delLesserNodes(static class node **head_ref)
    {
    /* 1) Reverse the linked list */
    reverseList(head_ref);
    /* 2) In the reversed list, delete nodes which have a node
    with greater value node on left side. Note that head
    node is never deleted because it is the leftmost node.*/
    _delLesserNodes(*head_ref);
    /* 3) Reverse the linked list again to retain the
    original order */
    reverseList(head_ref);
    }
    /* Deletes nodes which have greater value node(s) on left side */
    void _delLesserNodes(static class node *head)
    {
    static class node *current = head;
    /* Initialize max */
    static class node *maxnode = head;
    static class node *temp;
    while (current != null && current.next != null)
    {
    /* If current is smaller than max, then delete current */
    if(current.next.data < maxnode.data)
    {
    temp = current.next;
    current.next = temp.next;
    free(temp);
    }
    /* If current is greater than max, then update max and
    move current */
    else
    {
    current = current.next;
    maxnode = current;
    }
    }
    }
    /* Utility function to insert a node at the begining */
    void push(static class node **head_ref, int new_data)
    {
    static class node *new_node =
    (static class node *)malloc(sizeof(static class node));
    new_node.data = new_data;
    new_node.next = *head_ref;
    *head_ref = new_node;
    }
    /* Utility function to reverse a linked list */
    void reverseList(static class node **headref)
    {
    static class node *current = *headref;
    static class node *prev = null;
    static class node *next;
    while(current != null)
    {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
    }
    *headref = prev;
    }
    /* Utility function to print a linked list */
    void printList(static class node *head)
    {
    while(head!=null)
    {
    System.out.printf("%d ",head.data);
    head=head.next;
    }
    System.out.printf("\n");
    }
    /* Driver program to test above functions */
    int main()
    {
    static class node *head = null;
    /* Create following linked list
    12.15.10.11.5.6.2.3 */
    push(&head,3);
    push(&head,2);
    push(&head,6);
    push(&head,5);
    push(&head,11);
    push(&head,10);
    push(&head,15);
    push(&head,12);
    System.out.printf("Given Linked List: ");
    printList(head);
    delLesserNodes(&head);
    System.out.printf("\nModified Linked List: ");
    printList(head);
    getchar();
    return 0;
    }
}
