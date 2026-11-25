package com.dsamastery.linkedlists;

import java.util.*;

public class IntersectionOfTwoSorted {

    Method 1 (Using Dummy Node)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    void push(static class node** head_ref, int new_data);
    /*This solution uses the temporary dummy to build up the result list */
    static class node* sortedIntersect(static class node* a, static class node* b)
    {
    static class node dummy;
    static class node* tail = &dummy;
    dummy.next = null;
    /* Once one or the other list runs out -- we're done */
    while (a != null && b != null)
    {
    if (a.data == b.data)
    {
    push((&tail.next), a.data);
    tail = tail.next;
    a = a.next;
    b = b.next;
    }
    else if (a.data < b.data) /* advance the smaller list */
    a = a.next;
    else
    b = b.next;
    }
    return(dummy.next);
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
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty lists */
    static class node* a = null;
    static class node* b = null;
    static class node *intersect = null;
    /* Let us create the first sorted linked list to test the functions
    Created linked list will be 1.2.3.4.5.6 */
    push(&a, 6);
    push(&a, 5);
    push(&a, 4);
    push(&a, 3);
    push(&a, 2);
    push(&a, 1);
    /* Let us create the second sorted linked list
    Created linked list will be 2.4.6.8 */
    push(&b, 8);
    push(&b, 6);
    push(&b, 4);
    push(&b, 2);
    /* Find the intersection two linked lists */
    intersect = sortedIntersect(a, b);
    System.out.printf("\n Linked list containing common items of a & b \n ");
    printList(intersect);
    getchar();
    }
    Method 2 (Using Local References)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    void push(static class node** head_ref, int new_data);
    /* This solution uses the local reference */
    static class node* sortedIntersect(static class node* a, static class node* b)
    {
    static class node* result = null;
    static class node** lastPtrRef = &result;
    /* Advance comparing the first nodes in both lists.
    When one or the other list runs out, we're done. */
    while (a!=null && b!=null)
    {
    if (a.data == b.data)
    {
    /* found a node for the intersection */
    push(lastPtrRef, a.data);
    lastPtrRef = &((*lastPtrRef)->next);
    a = a.next;
    b = b.next;
    }
    else if (a.data < b.data)
    a=a.next; /* advance the smaller list */
    else
    b=b.next;
    }
    return(result);
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
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty lists */
    static class node* a = null;
    static class node* b = null;
    static class node *intersect = null;
    /* Let us create the first sorted linked list to test the functions
    Created linked list will be 1.2.3.4.5.6 */
    push(&a, 6);
    push(&a, 5);
    push(&a, 4);
    push(&a, 3);
    push(&a, 2);
    push(&a, 1);
    /* Let us create the second sorted linked list
    Created linked list will be 2.4.6.8 */
    push(&b, 8);
    push(&b, 6);
    push(&b, 4);
    push(&b, 2);
    /* Find the intersection two linked lists */
    intersect = sortedIntersect(a, b);
    System.out.printf("\n Linked list containing common items of a & b \n ");
    printList(intersect);
    getchar();
    }
    Method 3 (Recursive)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    static class node *sortedIntersect(static class node *a, static class node *b)
    {
    /* base case */
    if (a == null || b == null)
    return null;
    /* If both lists are non-empty */
    /* advance the smaller list and call recursively */
    if (a.data < b.data)
    return sortedIntersect(a.next, b);
    if (a.data > b.data)
    return sortedIntersect(a, b.next);
    // Below lines are executed only when a.data == b.data
    static class node *temp = (static class node *)malloc(sizeof(static class node));
    temp.data = a.data;
    /* advance both lists and call recursively */
    temp.next = sortedIntersect(a.next, b.next);
    return temp;
    }
    /* UTILITY FUNCTIONS */
    /* Function to insert a node at the beginging of the linked list */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node = (static class node*) malloc(sizeof(static class node));
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
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty lists */
    static class node* a = null;
    static class node* b = null;
    static class node *intersect = null;
    /* Let us create the first sorted linked list to test the functions
    Created linked list will be 1.2.3.4.5.6 */
    push(&a, 6);
    push(&a, 5);
    push(&a, 4);
    push(&a, 3);
    push(&a, 2);
    push(&a, 1);
    /* Let us create the second sorted linked list
    Created linked list will be 2.4.6.8 */
    push(&b, 8);
    push(&b, 6);
    push(&b, 4);
    push(&b, 2);
    /* Find the intersection two linked lists */
    intersect = sortedIntersect(a, b);
    System.out.printf("\n Linked list containing common items of a & b \n ");
    printList(intersect);
    return 0;
    }
}
