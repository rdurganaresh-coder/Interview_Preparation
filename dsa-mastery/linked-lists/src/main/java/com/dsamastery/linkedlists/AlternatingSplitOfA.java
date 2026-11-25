package com.dsamastery.linkedlists;

import java.util.*;

public class AlternatingSplitOfA {

    Method 1(Simple)
    /*Program to alternatively split a linked list into two halves */
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* pull off the front node of the source and put it in dest */
    void MoveNode(static class node** destRef, static class node** sourceRef) ;
    /* Given the source list, split its nodes into two shorter lists.
    If we number the elements 0, 1, 2, ... then all the even elements
    should go in the first list, and all the odd elements in the second.
    The elements in the new lists may be in any order. */
    void AlternatingSplit(static class node* source, static class node** aRef,
    static class node** bRef)
    {
    /* split the nodes of source to these 'a' and 'b' lists */
    static class node* a = null;
    static class node* b = null;
    static class node* current = source;
    while (current != null)
    {
    MoveNode(&a, &current); /* Move a node to list 'a' */
    if (current != null)
    {
    MoveNode(&b, &current); /* Move a node to list 'b' */
    }
    }
    *aRef = a;
    *bRef = b;
    }
    /* Take the node from the front of the source, and move it to the front of the dest.
    It is an error to call this with the source list empty.
    Before calling MoveNode():
    source == {1, 2, 3}
    dest == {1, 2, 3}
    Affter calling MoveNode():
    source == {2, 3}
    dest == {1, 1, 2, 3}
    */
    void MoveNode(static class node** destRef, static class node** sourceRef)
    {
    /* the front source node */
    static class node* newNode = *sourceRef;
    assert(newNode != null);
    /* Advance the source pointer */
    *sourceRef = newNode.next;
    /* Link the old dest off the new node */
    newNode.next = *destRef;
    /* Move dest to point to the new node */
    *destRef = newNode;
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginging of the linked list */
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
    while(node!=null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    static class node* a = null;
    static class node* b = null;
    /* Let us create a sorted linked list to test the functions
    Created linked list will be 0.1.2.3.4.5 */
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    push(&head, 0);
    System.out.printf("\n Original linked List: ");
    printList(head);
    /* Remove duplicates from linked list */
    AlternatingSplit(head, &a, &b);
    System.out.printf("\n Resultant Linked List 'a' ");
    printList(a);
    System.out.printf("\n Resultant Linked List 'b' ");
    printList(b);
    getchar();
    return 0;
    }
    Method 2(Using Dummy Nodes)
    void AlternatingSplit(static class node* source, static class node** aRef,
    static class node** bRef)
    {
    static class node aDummy;
    static class node* aTail = &aDummy; /* points to the last node in 'a' */
    static class node bDummy;
    static class node* bTail = &bDummy; /* points to the last node in 'b' */
    static class node* current = source;
    aDummy.next = null;
    bDummy.next = null;
    while (current != null)
    {
    MoveNode(&(aTail.next), &current); /* add at 'a' tail */
    aTail = aTail.next; /* advance the 'a' tail */
    if (current != null)
    {
    MoveNode(&(bTail.next), &current);
    bTail = bTail.next;
    }
    }
    *aRef = aDummy.next;
    *bRef = bDummy.next;
    }
}
