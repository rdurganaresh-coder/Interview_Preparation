package com.dsamastery.linkedlists;

import java.util.*;

public class FlattenAMultilevelLinked {

    static class list
    {
    int data;
    static class list *next;
    static class list *child;
    };
    tmp = cur.child;
    while (tmp.next != null)
    tmp = tmp.next;
    tail = tmp;
    // Program to flatten list with next and child pointers
    // Macro to find number of elements in array
    // A linked list node has data, next pointer and child pointer
    static class node
    {
    int data;
    static class node *next;
    static class node *child;
    };
    // A utility function to create a linked list with n nodes. The data
    // of nodes is taken from arr[]. All child pointers are set as null
    static class node *createList(int *arr, int n)
    {
    static class node *head = null;
    static class node *p;
    int i;
    for (i = 0; i < n; ++i) {
    if (head == null)
    head = p = (static class node *)malloc(sizeof(*p));
    else {
    p.next = (static class node *)malloc(sizeof(*p));
    p = p.next;
    }
    p.data = arr[i];
    p.next = p.child = null;
    }
    return head;
    }
    // A utility function to print all nodes of a linked list
    void printList(static class node *head)
    {
    while (head != null) {
    System.out.printf("%d ", head.data);
    head = head.next;
    }
    System.out.printf("\n");
    }
    // This function creates the input list. The created list is same
    // as shown in the above figure
    static class node *createList(void)
    {
    int arr1[] = {10, 5, 12, 7, 11};
    int arr2[] = {4, 20, 13};
    int arr3[] = {17, 6};
    int arr4[] = {9, 8};
    int arr5[] = {19, 15};
    int arr6[] = {2};
    int arr7[] = {16};
    int arr8[] = {3};
    /* create 8 linked lists */
    static class node *head1 = createList(arr1, SIZE(arr1));
    static class node *head2 = createList(arr2, SIZE(arr2));
    static class node *head3 = createList(arr3, SIZE(arr3));
    static class node *head4 = createList(arr4, SIZE(arr4));
    static class node *head5 = createList(arr5, SIZE(arr5));
    static class node *head6 = createList(arr6, SIZE(arr6));
    static class node *head7 = createList(arr7, SIZE(arr7));
    static class node *head8 = createList(arr8, SIZE(arr8));
    /* modify child pointers to create the list shown above */
    head1.child = head2;
    head1.next.next.next.child = head3;
    head3.child = head4;
    head4.child = head5;
    head2.next.child = head6;
    head2.next.next.child = head7;
    head7.child = head8;
    /* Return head pointer of first linked list. Note that all nodes are
    reachable from head1 */
    return head1;
    }
    /* The main function that flattens a multilevel linked list */
    void flattenList(static class node *head)
    {
    /*Base case*/
    if (head == null)
    return;
    static class node *tmp;
    /* Find tail node of first level linked list */
    static class node *tail = head;
    while (tail.next != null)
    tail = tail.next;
    // One by one traverse through all nodes of first level
    // linked list till we reach the tail node
    static class node *cur = head;
    while (cur != tail)
    {
    // If current node has a child
    if (cur.child)
    {
    // then append the child at the end of current list
    tail.next = cur.child;
    // and update the tail to new last node
    tmp = cur.child;
    while (tmp.next)
    tmp = tmp.next;
    tail = tmp;
    }
    // Change current node
    cur = cur.next;
    }
    }
    // A driver program to test above functions
    int main(void)
    {
    static class node *head = null;
    head = createList();
    flattenList(head);
    printList(head);
    return 0;
    }
}
