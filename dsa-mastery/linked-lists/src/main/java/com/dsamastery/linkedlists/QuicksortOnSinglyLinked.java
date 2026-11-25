package com.dsamastery.linkedlists;

import java.util.*;

public class QuicksortOnSinglyLinked {

    // C++ program for Quick Sort on Singly Linled List
    /* a node of the singly linked list */
    static class node
    {
    int data;
    static class node *next;
    };
    /* A utility function to insert a node at the beginning of linked list */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node = new node;
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* A utility function to print linked list */
    void printList(static class node *node)
    {
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    System.out.printf("\n");
    }
    // Returns the last node of the list
    static class node *getTail(static class node *cur)
    {
    while (cur != null && cur.next != null)
    cur = cur.next;
    return cur;
    }
    // Partitions the list taking the last element as the pivot
    static class node *partition(static class node *head, static class node *end,
    static class node **newHead, static class node **newEnd)
    {
    static class node *pivot = end;
    static class node *prev = null, *cur = head, *tail = pivot;
    // During partition, both the head and end of the list might change
    // which is updated in the newHead and newEnd variables
    while (cur != pivot)
    {
    if (cur.data < pivot.data)
    {
    // First node that has a value less than the pivot - becomes
    // the new head
    if ((*newHead) == null)
    (*newHead) = cur;
    prev = cur;
    cur = cur.next;
    }
    else // If cur node is greater than pivot
    {
    // Move cur node to next of tail, and change tail
    if (prev)
    prev.next = cur.next;
    static class node *tmp = cur.next;
    cur.next = null;
    tail.next = cur;
    tail = cur;
    cur = tmp;
    }
    }
    // If the pivot data is the smallest element in the current list,
    // pivot becomes the head
    if ((*newHead) == null)
    (*newHead) = pivot;
    // Update newEnd to the current last node
    (*newEnd) = tail;
    // Return the pivot node
    return pivot;
    }
    //here the sorting happens exclusive of the end node
    static class node *quickSortRecur(static class node *head, static class node *end)
    {
    // base condition
    if (!head || head == end)
    return head;
    node *newHead = null, *newEnd = null;
    // Partition the list, newHead and newEnd will be updated
    // by the partition function
    static class node *pivot = partition(head, end, &newHead, &newEnd);
    // If pivot is the smallest element - no need to recur for
    // the left part.
    if (newHead != pivot)
    {
    // Set the node before the pivot node as null
    static class node *tmp = newHead;
    while (tmp.next != pivot)
    tmp = tmp.next;
    tmp.next = null;
    // Recur for the list before pivot
    newHead = quickSortRecur(newHead, tmp);
    // Change next of last node of the left half to pivot
    tmp = getTail(newHead);
    tmp.next = pivot;
    }
    // Recur for the list after the pivot element
    pivot.next = quickSortRecur(pivot.next, newEnd);
    return newHead;
    }
    // The main function for quick sort. This is a wrapper over recursive
    // function quickSortRecur()
    void quickSort(static class node **headRef)
    {
    (*headRef) = quickSortRecur(*headRef, getTail(*headRef));
    return;
    }
    // Driver program to test above functions
    int main()
    {
    static class node *a = null;
    push(&a, 5);
    push(&a, 20);
    push(&a, 4);
    push(&a, 3);
    push(&a, 30);
    System.out.print("Linked List before sorting \n");
    printList(a);
    quickSort(&a);
    System.out.print("Linked List after sorting \n");
    printList(a);
    return 0;
    }
}
