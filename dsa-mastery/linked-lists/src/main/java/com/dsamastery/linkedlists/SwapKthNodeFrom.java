package com.dsamastery.linkedlists;

import java.util.*;

public class SwapKthNodeFrom {

    // A C++ program to swap Kth node from beginning with kth node from end
    // A Linked List node
    static class node
    {
    int data;
    static class node *next;
    };
    /* Utility function to insert a node at the beginning */
    void push(static class node **head_ref, int new_data)
    {
    static class node *new_node = (static class node *) malloc(sizeof(static class node));
    new_node.data = new_data;
    new_node.next = (*head_ref);
    (*head_ref) = new_node;
    }
    /* Utility function for displaying linked list */
    void printList(static class node *node)
    {
    while (node != null)
    {
    System.out.print(node.data << " ");
    node = node.next;
    }
    System.out.print(endl);
    }
    /* Utility function for calculating length of linked list */
    int countNodes(static class node *s)
    {
    int count = 0;
    while (s != null)
    {
    count++;
    s = s.next;
    }
    return count;
    }
    /* Function for swapping kth nodes from both ends of linked list */
    void swapKth(static class node **head_ref, int k)
    {
    // Count nodes in linked list
    int n = countNodes(*head_ref);
    // Check if k is valid
    if (n < k) return;
    // If x (kth node from start) and y(kth node from end) are same
    if (2*k - 1 == n) return;
    // Find the kth node from beginning of linked list. We also find
    // previous of kth node because we need to update next pointer of
    // the previous.
    node *x = *head_ref;
    node *x_prev = null;
    for (int i = 1; i < k; i++)
    {
    x_prev = x;
    x = x.next;
    }
    // Similarly, find the kth node from end and its previous. kth node
    // from end is (n-k+1)th node from beginning
    node *y = *head_ref;
    node *y_prev = null;
    for (int i = 1; i < n-k+1; i++)
    {
    y_prev = y;
    y = y.next;
    }
    // If x_prev exists, then new next of it will be y. Consider the case
    // when y.next is x, in this case, x_prev and y are same. So the statement
    // "x_prev.next = y" creates a self loop. This self loop will be broken
    // when we change y.next.
    if (x_prev)
    x_prev.next = y;
    // Same thing applies to y_prev
    if (y_prev)
    y_prev.next = x;
    // Swap next pointers of x and y. These statements also break self
    // loop if x.next is y or y.next is x
    node *temp = x.next;
    x.next = y.next;
    y.next = temp;
    // Change head pointers when k is 1 or n
    if (k == 1)
    *head_ref = y;
    if (k == n)
    *head_ref = x;
    }
    // Driver program to test above functions
    int main()
    {
    // Let us create the following linked list for testing
    // 1.2.3.4.5.6.7.8
    static class node *head = null;
    for (int i = 8; i >= 1; i--)
    push(&head, i);
    System.out.print("Original Linked List: ");
    printList(head);
    for (int k = 1; k < 10; k++)
    {
    swapKth(&head, k);
    System.out.println("\nModified List for k = " << k);
    printList(head);
    }
    return 0;
    }
}
