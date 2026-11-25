package com.dsamastery.linkedlists;

import java.util.*;

public class MergeSortForLinked {

    MergeSort(headRef)
    FrontBackSplit(head, &a, &b); /* a and b are two halves */
    MergeSort(a);
    MergeSort(b);
    *headRef = SortedMerge(a, b);
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* function prototypes */
    static class node* SortedMerge(static class node* a, static class node* b);
    void FrontBackSplit(static class node* source,
    static class node** frontRef, static class node** backRef);
    /* sorts the linked list by changing next pointers (not data) */
    void MergeSort(static class node** headRef)
    {
    static class node* head = *headRef;
    static class node* a;
    static class node* b;
    /* Base case -- length 0 or 1 */
    if ((head == null) || (head.next == null))
    {
    return;
    }
    /* Split head into 'a' and 'b' sublists */
    FrontBackSplit(head, &a, &b);
    /* Recursively sort the sublists */
    MergeSort(&a);
    MergeSort(&b);
    /* answer = merge the two sorted lists together */
    *headRef = SortedMerge(a, b);
    }
    /* See http://geeksforgeeks.org/?p=3622 for details of this
    function */
    static class node* SortedMerge(static class node* a, static class node* b)
    {
    static class node* result = null;
    /* Base cases */
    if (a == null)
    return(b);
    else if (b==null)
    return(a);
    /* Pick either a or b, and recur */
    if (a.data <= b.data)
    {
    result = a;
    result.next = SortedMerge(a.next, b);
    }
    else
    {
    result = b;
    result.next = SortedMerge(a, b.next);
    }
    return(result);
    }
    /* UTILITY FUNCTIONS */
    /* Split the nodes of the given list into front and back halves,
    and return the two lists using the reference parameters.
    If the length is odd, the extra node should go in the front list.
    Uses the fast/slow pointer strategy. */
    void FrontBackSplit(static class node* source,
    static class node** frontRef, static class node** backRef)
    {
    static class node* fast;
    static class node* slow;
    if (source==null || source.next==null)
    {
    /* length < 2 cases */
    *frontRef = source;
    *backRef = null;
    }
    else
    {
    slow = source;
    fast = source.next;
    /* Advance 'fast' two nodes, and advance 'slow' one node */
    while (fast != null)
    {
    fast = fast.next;
    if (fast != null)
    {
    slow = slow.next;
    fast = fast.next;
    }
    }
    /* 'slow' is before the midpoint in the list, so split it in two
    at that point. */
    *frontRef = source;
    *backRef = slow.next;
    slow.next = null;
    }
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
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class node* res = null;
    static class node* a = null;
    /* Let us create a unsorted linked lists to test the functions
    Created lists shall be a: 2.3.20.5.10.15 */
    push(&a, 15);
    push(&a, 10);
    push(&a, 5);
    push(&a, 20);
    push(&a, 3);
    push(&a, 2);
    /* Sort the above created Linked List */
    MergeSort(&a);
    System.out.printf("\n Sorted Linked List is: \n");
    printList(a);
    getchar();
    return 0;
    }
}
