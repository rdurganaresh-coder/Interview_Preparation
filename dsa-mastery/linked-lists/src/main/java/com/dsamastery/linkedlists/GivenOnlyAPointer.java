package com.dsamastery.linkedlists;

import java.util.*;

public class GivenOnlyAPointer {

    static class node *temp = node_ptr.next;
    node_ptr.data = temp.data;
    node_ptr.next = temp.next;
    free(temp);
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Given a reference (pointer to pointer) to the head
    of a list and an int, push a new node on the front
    of the list. */
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
    void printList(static class node *head)
    {
    static class node *temp = head;
    while(temp != null)
    {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    }
    }
    void deleteNode(static class node *node_ptr)
    {
    static class node *temp = node_ptr.next;
    node_ptr.data = temp.data;
    node_ptr.next = temp.next;
    free(temp);
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Use push() to construct below list
    1.12.1.4.1 */
    push(&head, 1);
    push(&head, 4);
    push(&head, 1);
    push(&head, 12);
    push(&head, 1);
    System.out.printf("\n Before deleting \n");
    printList(head);
    /* I m deleting the head itself.
    You can check for more cases */
    deleteNode(head);
    System.out.printf("\n After deleting \n");
    printList(head);
    getchar();
    return 0;
    }
}
