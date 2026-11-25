package com.dsamastery.linkedlists;

import java.util.*;

public class PracticeQuestionsForLinked {

    static class node
    {
    int data;
    static class node *next;
    };
    void fun1(static class node* head)
    {
    if(head == null)
    return;
    fun1(head.next);
    System.out.printf("%d ", head.data);
    }
    void fun2(static class node* head)
    {
    if(head== null)
    return;
    System.out.printf("%d ", head.data);
    if(head.next != null )
    fun2(head.next.next);
    System.out.printf("%d ", head.data);
    }
    /* A linked list node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* Prints a linked list in reverse manner */
    void fun1(static class node* head)
    {
    if(head == null)
    return;
    fun1(head.next);
    System.out.printf("%d ", head.data);
    }
    /* prints alternate nodes of a Linked List, first
    from head to end, and then from end to head. */
    void fun2(static class node* start)
    {
    if(start == null)
    return;
    System.out.printf("%d ", start.data);
    if(start.next != null )
    fun2(start.next.next);
    System.out.printf("%d ", start.data);
    }
    /* UTILITY FUNCTIONS TO TEST fun1() and fun2() */
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
    /* Drier program to test above functions */
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Using push() to construct below list
    1.2.3.4.5 */
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    System.out.printf("\n Output of fun1() for list 1.2.3.4.5 \n");
    fun1(head);
    System.out.printf("\n Output of fun2() for list 1.2.3.4.5 \n");
    fun2(head);
    getchar();
    return 0;
    }
}
