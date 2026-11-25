package com.dsamastery.linkedlists;

import java.util.*;

public class GenericLinkedListIn {

    // C program for generic linked list
    /* A linked list node */
    static class node
    {
    // Any data type can be stored in this node
    void *data;
    static class node *next;
    };
    /* Function to add a node at the beginning of Linked List.
    This function expects a pointer to the data to be added
    and size of the data type */
    void push(static class node** head_ref, void *new_data, size_t data_size)
    {
    // Allocate memory for node
    static class node* new_node = (static class node*)malloc(sizeof(static class node));
    new_node.data = malloc(data_size);
    new_node.next = (*head_ref);
    // Copy contents of new_data to newly allocated memory.
    // Assumption: char takes 1 byte.
    int i;
    for (i=0; i<data_size; i++)
    *(char *)(new_node.data + i) = *(char *)(new_data + i);
    // Change head pointer as new node is added at the beginning
    (*head_ref) = new_node;
    }
    /* Function to print nodes in a given linked list. fpitr is used
    to access the function to be used for printing current node data.
    Note that different data types need different specifier in System.out.printf() */
    void printList(static class node *node, void (*fptr)(void *))
    {
    while (node != null)
    {
    (*fptr)(node.data);
    node = node.next;
    }
    }
    // Function to print an integer
    void printInt(void *n)
    {
    System.out.printf(" %d", *(int *)n);
    }
    // Function to print a float
    void printFloat(void *f)
    {
    System.out.printf(" %f", *(float *)f);
    }
    /* Driver program to test above function */
    int main()
    {
    static class node *start = null;
    // Create and print an int linked list
    unsigned int_size = sizeof(int);
    int arr[] = {10, 20, 30, 40, 50}, i;
    for (i=4; i>=0; i--)
    push(&start, &arr[i], int_size);
    System.out.printf("Created integer linked list is \n");
    printList(start, printInt);
    // Create and print a float linked list
    unsigned float_size = sizeof(float);
    start = null;
    float arr2[] = {10.1, 20.2, 30.3, 40.4, 50.5};
    for (i=4; i>=0; i--)
    push(&start, &arr2[i], float_size);
    System.out.printf("\n\nCreated float linked list is \n");
    printList(start, printFloat);
    return 0;
    }
}
