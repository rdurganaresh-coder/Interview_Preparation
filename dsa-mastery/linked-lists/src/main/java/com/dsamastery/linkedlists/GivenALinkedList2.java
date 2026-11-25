package com.dsamastery.linkedlists;

import java.util.*;

public class GivenALinkedList {

    The given linked list represents a horizontal line from (0,10)
    // C program to remove intermediate points in a linked list that represents
    // horizontal and vertical line segments
    // Node has 3 fields including x, y coordinates and a pointer to next node
    static class node
    {
    int x, y;
    static class node *next;
    };
    /* Function to insert a node at the beginning */
    void push(static class node ** head_ref, int x,int y)
    {
    static class node* new_node = (static class node*) malloc(sizeof(static class node));
    new_node.x = x;
    new_node.y = y;
    new_node.next = (*head_ref);
    (*head_ref) = new_node;
    }
    /* Utility function to print a singly linked list */
    void printList(static class node *head)
    {
    static class node *temp = head;
    while (temp != null)
    {
    System.out.printf("(%d,%d)-> ", temp.x,temp.y);
    temp = temp.next;
    }
    System.out.printf("\n");
    }
    // Utility function to remove Next from linked list and link nodes
    // after it to head
    void deleteNode(static class node *head, static class node *Next)
    {
    head.next = Next.next;
    Next.next = null;
    free(Next);
    }
    // This function deletes middle nodes in a sequence of horizontal and
    // vertical line segments represented by linked list.
    static class node* deleteMiddle(static class node *head)
    {
    // If only one node or no node...Return back
    if (head==null || head.next ==null || head.next.next==null)
    return head;
    static class node* Next = head.next;
    static class node *NextNext = Next.next ;
    // Check if this is a vertical line or horizontal line
    if (head.x == Next.x)
    {
    // Find middle nodes with same x value, and delete them
    while (NextNext !=null && Next.x==NextNext.x)
    {
    deleteNode(head, Next);
    // Update Next and NextNext for next iteration
    Next = NextNext;
    NextNext = NextNext.next;
    }
    }
    else if (head.y==Next.y) // If horizontal line
    {
    // Find middle nodes with same y value, and delete them
    while (NextNext !=null && Next.y==NextNext.y)
    {
    deleteNode(head, Next);
    // Update Next and NextNext for next iteration
    Next = NextNext;
    NextNext = NextNext.next;
    }
    }
    else // Adjacent points must have either same x or same y
    {
    puts("Given linked list is not valid");
    return null;
    }
    // Recur for next segment
    deleteMiddle(head.next);
    return head;
    }
    // Driver program to tsst above functions
    int main()
    {
    static class node *head = null;
    push(&head, 40,5);
    push(&head, 20,5);
    push(&head, 10,5);
    push(&head, 10,8);
    push(&head, 10,10);
    push(&head, 3,10);
    push(&head, 1,10);
    push(&head, 0,10);
    System.out.printf("Given Linked List: \n");
    printList(head);
    if (deleteMiddle(head) != null);
    {
    System.out.printf("Modified Linked List: \n");
    printList(head);
    }
    return 0;
    }
}
