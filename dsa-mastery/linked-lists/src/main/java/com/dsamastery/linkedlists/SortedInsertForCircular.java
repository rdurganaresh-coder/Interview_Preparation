package com.dsamastery.linkedlists;

import java.util.*;

public class SortedInsertForCircular {

    new_node.next = new_node;
    *head_ref = new_node;
    while(current.next != *head_ref)
    current = current.next;
    current.next = new_node;
    new_node.next = *head_ref;
    *head_ref = new_node;
    while ( current.next!= *head_ref &&
    { current = current.next; }
    new_node.next = current.next;
    current.next = new_node;
    /* structure for a node */
    static class node
    {
    int data;
    static class node *next;
    };
    /* function to insert a new_node in a list in sorted way.
    Note that this function expects a pointer to head node
    as this can modify the head of the input linked list */
    void sortedInsert(static class node** head_ref, static class node* new_node)
    {
    static class node* current = *head_ref;
    // Case 1 of the above algo
    if (current == null)
    {
    new_node.next = new_node;
    *head_ref = new_node;
    }
    // Case 2 of the above algo
    else if (current.data >= new_node.data)
    {
    /* If value is smaller than head's value then
    we need to change next of last node */
    while(current.next != *head_ref)
    current = current.next;
    current.next = new_node;
    new_node.next = *head_ref;
    *head_ref = new_node;
    }
    // Case 3 of the above algo
    else
    {
    /* Locate the node before the point of insertion */
    while (current.next!= *head_ref && current.next.data < new_node.data)
    current = current.next;
    new_node.next = current.next;
    current.next = new_node;
    }
    }
    /* Function to print nodes in a given linked list */
    void printList(static class node *start)
    {
    static class node *temp;
    if(start != null)
    {
    temp = start;
    System.out.printf("\n");
    do {
    System.out.printf("%d ", temp.data);
    temp = temp.next;
    } while(temp != start);
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {12, 56, 2, 11, 1, 90};
    int list_size, i;
    /* start with empty linked list */
    static class node *start = null;
    static class node *temp;
    /* Create linked list from the array arr[].
    Created linked list will be 1.2.11.56.12 */
    for(i = 0; i< 6; i++)
    {
    temp = (static class node *)malloc(sizeof(static class node));
    temp.data = arr[i];
    sortedInsert(&start, temp);
    }
    printList(start);
    getchar();
    return 0;
    }
    // Case 2 of the above algo
    else if (current.data >= new_node.data)
    {
    // swap the data part of head node and new node
    swap(&(current.data), &(new_node.data)); // assuming that we have a function swap(int *, int *)
    new_node.next = (*head_ref)->next;
    (*head_ref)->next = new_node;
    }
}
