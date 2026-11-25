package com.dsamastery.linkedlists;

import java.util.*;

public class AddTwoNumbersRepresented {

    /* Linked list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to create a new node with given data */
    static class node *newNode(int data)
    {
    static class node *new_node = (static class node *) malloc(sizeof(static class node));
    new_node.data = data;
    new_node.next = null;
    return new_node;
    }
    /* Function to insert a node at the beginning of the Doubly Linked List */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node = newNode(new_data);
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Adds contents of two linked lists and return the head node of resultant list */
    static class node* addTwoLists (static class node* first, static class node* second)
    {
    static class node* res = null; // res is head node of the resultant list
    static class node *temp, *prev = null;
    int carry = 0, sum;
    while (first != null || second != null) //while both lists exist
    {
    // Calculate value of next digit in resultant list.
    // The next digit is sum of following things
    // (i) Carry
    // (ii) Next digit of first list (if there is a next digit)
    // (ii) Next digit of second list (if there is a next digit)
    sum = carry + (first? first.data: 0) + (second? second.data: 0);
    // update carry for next calulation
    carry = (sum >= 10)? 1 : 0;
    // update sum if it is greater than 10
    sum = sum % 10;
    // Create a new node with sum as data
    temp = newNode(sum);
    // if this is the first node then set it as head of the resultant list
    if(res == null)
    res = temp;
    else // If this is not the first node then connect it to the rest.
    prev.next = temp;
    // Set prev for next insertion
    prev = temp;
    // Move first and second pointers to next nodes
    if (first) first = first.next;
    if (second) second = second.next;
    }
    if (carry > 0)
    temp.next = newNode(carry);
    // return head of the resultant list
    return res;
    }
    // A utility function to print a linked list
    void printList(static class node *node)
    {
    while(node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    System.out.printf("\n");
    }
    /* Drier program to test above function */
    int main(void)
    {
    static class node* res = null;
    static class node* first = null;
    static class node* second = null;
    // create first list 7.5.9.4.6
    push(&first, 6);
    push(&first, 4);
    push(&first, 9);
    push(&first, 5);
    push(&first, 7);
    System.out.printf("First List is ");
    printList(first);
    // create second list 8.4
    push(&second, 4);
    push(&second, 8);
    System.out.printf("Second List is ");
    printList(second);
    // Add the two lists and see result
    res = addTwoLists(first, second);
    System.out.printf("Resultant list is ");
    printList(res);
    return 0;
    }
}
