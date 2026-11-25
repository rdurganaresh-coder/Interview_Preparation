package com.dsamastery.linkedlists;

import java.util.*;

public class DetectAndRemoveLoop {

    Method 1 (Check one by one)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to remove loop. Used by detectAndRemoveLoop() */
    void removeLoop(static class node *, static class node *);
    /* This function detects and removes loop in the list
    If loop was there in the list then it returns 1,
    otherwise returns 0 */
    int detectAndRemoveLoop(static class node *list)
    {
    static class node *slow_p = list, *fast_p = list;
    while (slow_p && fast_p && fast_p.next)
    {
    slow_p = slow_p.next;
    fast_p = fast_p.next.next;
    /* If slow_p and fast_p meet at some point then there
    is a loop */
    if (slow_p == fast_p)
    {
    removeLoop(slow_p, list);
    /* Return 1 to indicate that loop is found */
    return 1;
    }
    }
    /* Return 0 to indeciate that ther is no loop*/
    return 0;
    }
    /* Function to remove loop.
    loop_node --> Pointer to one of the loop nodes
    head --> Pointer to the start node of the linked list */
    void removeLoop(static class node *loop_node, static class node *head)
    {
    static class node *ptr1;
    static class node *ptr2;
    /* Set a pointer to the beging of the Linked List and
    move it one by one to find the first node which is
    part of the Linked List */
    ptr1 = head;
    while (1)
    {
    /* Now start a pointer from loop_node and check if it ever
    reaches ptr2 */
    ptr2 = loop_node;
    while (ptr2.next != loop_node && ptr2.next != ptr1)
    ptr2 = ptr2.next;
    /* If ptr2 reahced ptr1 then there is a loop. So break the
    loop */
    if (ptr2.next == ptr1)
    break;
    /* If ptr2 did't reach ptr1 then try the next node after ptr1 */
    ptr1 = ptr1.next;
    }
    /* After the end of loop ptr2 is the last node of the loop. So
    make next of ptr2 as null */
    ptr2.next = null;
    }
    /* Function to print linked list */
    void printList(static class node *node)
    {
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    static class node *newNode(int key)
    {
    static class node *temp = new static class node;
    temp.data = key;
    temp.next = null;
    return temp;
    }
    /* Drier program to test above function*/
    int main()
    {
    static class node *head = newNode(50);
    head.next = newNode(20);
    head.next.next = newNode(15);
    head.next.next.next = newNode(4);
    head.next.next.next.next = newNode(10);
    /* Create a loop for testing */
    head.next.next.next.next.next = head.next.next;
    detectAndRemoveLoop(head);
    System.out.printf("Linked List after removing loop \n");
    printList(head);
    return 0;
    }
    Method 2 (Better Solution)
    /* Link list node */
    static class node
    {
    int data;
    static class node* next;
    };
    /* Function to remove loop. */
    void removeLoop(static class node *, static class node *);
    /* This function detects and removes loop in the list
    If loop was there in the list then it returns 1,
    otherwise returns 0 */
    int detectAndRemoveLoop(static class node *list)
    {
    static class node *slow_p = list, *fast_p = list;
    while (slow_p && fast_p && fast_p.next)
    {
    slow_p = slow_p.next;
    fast_p = fast_p.next.next;
    /* If slow_p and fast_p meet at some point then there
    is a loop */
    if (slow_p == fast_p)
    {
    removeLoop(slow_p, list);
    /* Return 1 to indicate that loop is found */
    return 1;
    }
    }
    /* Return 0 to indeciate that ther is no loop*/
    return 0;
    }
    /* Function to remove loop.
    loop_node --> Pointer to one of the loop nodes
    head --> Pointer to the start node of the linked list */
    void removeLoop(static class node *loop_node, static class node *head)
    {
    static class node *ptr1 = loop_node;
    static class node *ptr2 = loop_node;
    // Count the number of nodes in loop
    unsigned int k = 1, i;
    while (ptr1.next != ptr2)
    {
    ptr1 = ptr1.next;
    k++;
    }
    // Fix one pointer to head
    ptr1 = head;
    // And the other pointer to k nodes after head
    ptr2 = head;
    for (i = 0; i < k; i++)
    ptr2 = ptr2.next;
    /* Move both pointers at the same pace,
    they will meet at loop starting node */
    while (ptr2 != ptr1)
    {
    ptr1 = ptr1.next;
    ptr2 = ptr2.next;
    }
    // Get pointer to the last node
    ptr2 = ptr2.next;
    while (ptr2.next != ptr1)
    ptr2 = ptr2.next;
    /* Set the next node of the loop ending node
    to fix the loop */
    ptr2.next = null;
    }
    /* Function to print linked list */
    void printList(static class node *node)
    {
    while (node != null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    static class node *newNode(int key)
    {
    static class node *temp = new static class node;
    temp.data = key;
    temp.next = null;
    return temp;
    }
    /* Drier program to test above function*/
    int main()
    {
    static class node *head = newNode(50);
    head.next = newNode(20);
    head.next.next = newNode(15);
    head.next.next.next = newNode(4);
    head.next.next.next.next = newNode(10);
    /* Create a loop for testing */
    head.next.next.next.next.next = head.next.next;
    detectAndRemoveLoop(head);
    System.out.printf("Linked List after removing loop \n");
    printList(head);
    return 0;
    }
    Method 3 (Optimized Method 2: Without Counting Nodes in Loop)
    // C++ program to detect and remove loop
    static class Node
    {
    int key;
    static class Node *next;
    };
    Node *newNode(int key)
    {
    Node *temp = new Node;
    temp.key = key;
    temp.next = null;
    return temp;
    }
    // A utility function to print a linked list
    void printList(Node *head)
    {
    while (head != null)
    {
    System.out.print(head.key << " ");
    head = head.next;
    }
    System.out.print(endl);
    }
    void detectAndRemoveLoop(Node *head)
    {
    Node *slow = head;
    Node *fast = head.next;
    // Search for loop using slow and fast pointers
    while (fast && fast.next)
    {
    if (slow == fast)
    break;
    slow = slow.next;
    fast = fast.next.next;
    }
    /* If loop exists */
    if (slow == fast)
    {
    slow = head;
    while (slow != fast.next)
    {
    slow = slow.next;
    fast = fast.next;
    }
    /* since fast.next is the looping point */
    fast.next = null; /* remove loop */
    }
    }
    /* Drier program to test above function*/
    int main()
    {
    Node *head = newNode(50);
    head.next = newNode(20);
    head.next.next = newNode(15);
    head.next.next.next = newNode(4);
    head.next.next.next.next = newNode(10);
    /* Create a loop for testing */
    head.next.next.next.next.next = head.next.next;
    detectAndRemoveLoop(head);
    System.out.printf("Linked List after removing loop \n");
    printList(head);
    return 0;
    }
}
