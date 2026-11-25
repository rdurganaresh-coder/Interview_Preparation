package com.dsamastery.linkedlists;

import java.util.*;

public class QuicksortOnDoublyLinked {

    /* A typical recursive implementation of Quicksort for array*/
    /* This function takes last element as pivot, places the pivot element at its
    correct position in sorted array, and places all smaller (smaller than
    pivot) to left of pivot and all greater elements to right of pivot */
    int partition (int arr[], int l, int h)
    {
    int x = arr[h];
    int i = (l - 1);
    for (int j = l; j <= h- 1; j++)
    {
    if (arr[j] <= x)
    {
    i++;
    swap (&arr[i], &arr[j]);
    }
    }
    swap (&arr[i + 1], &arr[h]);
    return (i + 1);
    }
    /* A[] --> Array to be sorted, l --> Starting index, h --> Ending index */
    void quickSort(int A[], int l, int h)
    {
    if (l < h)
    {
    int p = partition(A, l, h); /* Partitioning index */
    quickSort(A, l, p - 1);
    quickSort(A, p + 1, h);
    }
    }
    // A C++ program to sort a linked list using Quicksort
    /* a node of the doubly linked list */
    static class node
    {
    int data;
    static class node *next;
    static class node *prev;
    };
    /* A utility function to swap two elements */
    void swap ( int* a, int* b )
    { int t = *a; *a = *b; *b = t; }
    // A utility function to find last node of linked list
    static class node *lastNode(node *root)
    {
    while (root && root.next)
    root = root.next;
    return root;
    }
    /* Considers last element as pivot, places the pivot element at its
    correct position in sorted array, and places all smaller (smaller than
    pivot) to left of pivot and all greater elements to right of pivot */
    node* partition(node *l, node *h)
    {
    // set pivot as h element
    int x = h.data;
    // similar to i = l-1 for array implementation
    node *i = l.prev;
    // Similar to "for (int j = l; j <= h- 1; j++)"
    for (node *j = l; j != h; j = j.next)
    {
    if (j.data <= x)
    {
    // Similar to i++ for array
    i = (i == null)? l : i.next;
    swap(&(i.data), &(j.data));
    }
    }
    i = (i == null)? l : i.next; // Similar to i++
    swap(&(i.data), &(h.data));
    return i;
    }
    /* A recursive implementation of quicksort for linked list */
    void _quickSort(static class node* l, static class node *h)
    {
    if (h != null && l != h && l != h.next)
    {
    static class node *p = partition(l, h);
    _quickSort(l, p.prev);
    _quickSort(p.next, h);
    }
    }
    // The main function to sort a linked list. It mainly calls _quickSort()
    void quickSort(static class node *head)
    {
    // Find last node
    static class node *h = lastNode(head);
    // Call the recursive QuickSort
    _quickSort(head, h);
    }
    // A utility function to print contents of arr
    void printList(static class node *head)
    {
    while (head)
    {
    System.out.print(head.data << " ");
    head = head.next;
    }
    System.out.print(endl);
    }
    /* Function to insert a node at the beginging of the Doubly Linked List */
    void push(static class node** head_ref, int new_data)
    {
    static class node* new_node = new node; /* allocate node */
    new_node.data = new_data;
    /* since we are adding at the begining, prev is always null */
    new_node.prev = null;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* change prev of head node to new node */
    if ((*head_ref) != null) (*head_ref)->prev = new_node ;
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Driver program to test above function */
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
    quickSort(a);
    System.out.print("Linked List after sorting \n");
    printList(a);
    return 0;
    }
}
