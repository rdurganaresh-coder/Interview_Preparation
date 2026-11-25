package com.dsamastery.arrays;

import java.util.*;

public class UnionAndIntersectionOf {

    Method 1 (Simple)
    Intersection (list1, list2)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* A utility function to insert a node at the begining of a linked list*/
    void push (static class node** head_ref, int new_data);
    /* A utilty function to chec if given data is present in a list */
    boolean isPresent (static class node *head, int data);
    /* Function to get union of two linked lists head1 and head2 */
    static class node *getUnion (static class node *head1, static class node *head2)
    {
    static class node *result = null;
    static class node *t1 = head1, *t2 = head2;
    // Insert all elements of list1 to the result list
    while (t1 != null)
    {
    push(&result, t1.data);
    t1 = t1.next;
    }
    // Insert those elements of list2 which are not present in result list
    while (t2 != null)
    {
    if (!isPresent(result, t2.data))
    push(&result, t2.data);
    t2 = t2.next;
    }
    return result;
    }
    /* Function to get intersection of two linked lists head1 and head2 */
    static class node *getIntersection (static class node *head1, static class node *head2)
    {
    static class node *result = null;
    static class node *t1 = head1;
    // Traverse list1 and search each element of it in list2. If the element
    // is present in list 2, then insert the element to result
    while (t1 != null)
    {
    if (isPresent(head2, t1.data))
    push (&result, t1.data);
    t1 = t1.next;
    }
    return result;
    }
    /* A utility function to insert a node at the begining of a linked list*/
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
    /* A utility function to print a linked list*/
    void printList (static class node *node)
    {
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* A utilty function that returns true if data is present in linked list
    else return false */
    boolean isPresent (static class node *head, int data)
    {
    static class node *t = head;
    while (t != null)
    {
    if (t.data == data)
    return 1;
    t = t.next;
    }
    return 0;
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head1 = null;
    static class node* head2 = null;
    static class node* intersecn = null;
    static class node* unin = null;
    /*create a linked lits 10.15.5.20 */
    push (&head1, 20);
    push (&head1, 4);
    push (&head1, 15);
    push (&head1, 10);
    /*create a linked lits 8.4.2.10 */
    push (&head2, 10);
    push (&head2, 2);
    push (&head2, 4);
    push (&head2, 8);
    intersecn = getIntersection (head1, head2);
    unin = getUnion (head1, head2);
    System.out.printf("\n First list is \n");
    printList (head1);
    System.out.printf("\n Second list is \n");
    printList (head2);
    System.out.printf("\n Intersection list is \n");
    printList (intersecn);
    System.out.printf("\n Union list is \n");
    printList (unin);
    return 0;
    }
    Method 2 (Use Merge Sort)
    Method 3 (Use Hashing)
    Union (list1, list2)
    Intersection (list1, list2)
}
