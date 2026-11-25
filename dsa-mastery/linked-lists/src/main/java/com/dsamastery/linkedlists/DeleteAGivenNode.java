package com.dsamastery.linkedlists;

import java.util.*;

public class DeleteAGivenNode {

    /* structure of a linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    void deleteNode(static class node *head, static class node *n)
    {
    // When node to be deleted is head node
    if(head == n)
    {
    if(head.next == null)
    {
    System.out.printf("There is only one node. The list can't be made empty ");
    return;
    }
    /* Copy the data of next node to head */
    head.data = head.next.data;
    // store address of next node
    n = head.next;
    // Remove the link of next node
    head.next = head.next.next;
    // free memory
    free(n);
    return;
    }
    // When not first node, follow the normal deletion process
    // find the previous node
    static class node *prev = head;
    while(prev.next != null && prev.next != n)
    prev = prev.next;
    // Check if node really exists in Linked List
    if(prev.next == null)
    {
    System.out.printf("\n Given node is not present in Linked List");
    return;
    }
    // Remove node from Linked List
    prev.next = prev.next.next;
    // Free memory
    free(n);
    return;
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
    /* Let us delete the node with value 10 */
    System.out.printf("\nDeleting node %d: ", head.next.next.data);
    deleteNode(head, head.next.next);
    System.out.printf("\nModified Linked List: ");
    printList(head);
    /* Let us delete the the first node */
    System.out.printf("\nDeleting first node ");
    deleteNode(head, head);
    System.out.printf("\nModified Linked List: ");
    printList(head);
    getchar();
    return 0;
    }
}
