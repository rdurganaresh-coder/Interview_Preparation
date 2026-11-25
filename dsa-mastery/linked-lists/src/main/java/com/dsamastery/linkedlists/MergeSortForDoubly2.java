package com.dsamastery.linkedlists;

import java.util.*;

public class MergeSortForDoubly {

    // C program for merge sort on doubly linked list
    static class node
    {
    int data;
    static class node *next, *prev;
    };
    static class node *split(static class node *head);
    // Function to merge two linked lists
    static class node *merge(static class node *first, static class node *second)
    {
    // If first linked list is empty
    if (!first)
    return second;
    // If second linked list is empty
    if (!second)
    return first;
    // Pick the smaller value
    if (first.data < second.data)
    {
    first.next = merge(first.next,second);
    first.next.prev = first;
    first.prev = null;
    return first;
    }
    else
    {
    second.next = merge(first,second.next);
    second.next.prev = second;
    second.prev = null;
    return second;
    }
    }
    // Function to do merge sort
    static class node *mergeSort(static class node *head)
    {
    if (!head || !head.next)
    return head;
    static class node *second = split(head);
    // Recur for left and right halves
    head = mergeSort(head);
    second = mergeSort(second);
    // Merge the two sorted halves
    return merge(head,second);
    }
    // A utility function to insert a new node at the
    // beginning of doubly linked list
    void insert(static class node **head, int data)
    {
    static class node *temp =
    (static class node *)malloc(sizeof(static class node));
    temp.data = data;
    temp.next = temp.prev = null;
    if (!(*head))
    (*head) = temp;
    else
    {
    temp.next = *head;
    (*head)->prev = temp;
    (*head) = temp;
    }
    }
    // A utility function to print a doubly linked list in
    // both forward and backward directions
    void print(static class node *head)
    {
    static class node *temp = head;
    System.out.printf("Forward Traversal using next poitner\n");
    while (head)
    {
    System.out.printf("%d ",head.data);
    temp = head;
    head = head.next;
    }
    System.out.printf("\nBackword Traversal using prev pointer\n");
    while (temp)
    {
    System.out.printf("%d ", temp.data);
    temp = temp.prev;
    }
    }
    // Utility function to swap two integers
    void swap(int *A, int *B)
    {
    int temp = *A;
    *A = *B;
    *B = temp;
    }
    // Split a doubly linked list (DLL) into 2 DLLs of
    // half sizes
    static class node *split(static class node *head)
    {
    static class node *fast = head,*slow = head;
    while (fast.next && fast.next.next)
    {
    fast = fast.next.next;
    slow = slow.next;
    }
    static class node *temp = slow.next;
    slow.next = null;
    return temp;
    }
    // Driver program
    int main(void)
    {
    static class node *head = null;
    insert(&head,5);
    insert(&head,20);
    insert(&head,4);
    insert(&head,3);
    insert(&head,30);
    insert(&head,10);
    System.out.printf("Linked List before sorting\n");
    print(head);
    head = mergeSort(head);
    System.out.printf("\n\nLinked List after sorting\n");
    print(head);
    return 0;
    }
}
