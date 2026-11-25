package com.dsamastery.linkedlists;

import java.util.*;

public class PointToNextHigher {

    // C program to populate arbit pointers to next higher value
    // using merge sort
    /* Link list node */
    static class node
    {
    int data;
    static class node* next, *arbit;
    };
    /* function prototypes */
    static class node* SortedMerge(static class node* a, static class node* b);
    void FrontBackSplit(static class node* source,
    static class node** frontRef, static class node** backRef);
    /* sorts the linked list formed by arbit pointers
    (does not change next pointer or data) */
    void MergeSort(static class node** headRef)
    {
    static class node* head = *headRef;
    static class node* a, *b;
    /* Base case -- length 0 or 1 */
    if ((head == null) || (head.arbit == null))
    return;
    /* Split head into 'a' and 'b' sublists */
    FrontBackSplit(head, &a, &b);
    /* Recursively sort the sublists */
    MergeSort(&a);
    MergeSort(&b);
    /* answer = merge the two sorted lists together */
    *headRef = SortedMerge(a, b);
    }
    /* See http://geeksforgeeks.org/?p=3622 for details of this
    function */
    static class node* SortedMerge(static class node* a, static class node* b)
    {
    static class node* result = null;
    /* Base cases */
    if (a == null)
    return (b);
    else if (b==null)
    return (a);
    /* Pick either a or b, and recur */
    if (a.data <= b.data)
    {
    result = a;
    result.arbit = SortedMerge(a.arbit, b);
    }
    else
    {
    result = b;
    result.arbit = SortedMerge(a, b.arbit);
    }
    return (result);
    }
    /* Split the nodes of the given list into front and back halves,
    and return the two lists using the reference parameters.
    If the length is odd, the extra node should go in the front list.
    Uses the fast/slow pointer strategy. */
    void FrontBackSplit(static class node* source,
    static class node** frontRef, static class node** backRef)
    {
    static class node* fast, *slow;
    if (source==null || source.arbit==null)
    {
    /* length < 2 cases */
    *frontRef = source;
    *backRef = null;
    return;
    }
    slow = source, fast = source.arbit;
    /* Advance 'fast' two nodes, and advance 'slow' one node */
    while (fast != null)
    {
    fast = fast.arbit;
    if (fast != null)
    {
    slow = slow.arbit;
    fast = fast.arbit;
    }
    }
    /* 'slow' is before the midpoint in the list, so split it in two
    at that point. */
    *frontRef = source;
    *backRef = slow.arbit;
    slow.arbit = null;
    }
    /* Function to insert a node at the beginging of the linked list */
    void push(static class node** head_ref, int new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    new_node.arbit = null;
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    // Utility function to print result linked list
    void printListafter(static class node *node, static class node *anode)
    {
    System.out.printf("Traversal using Next Pointer\n");
    while (node!=null)
    {
    System.out.printf("%d, ", node.data);
    node = node.next;
    }
    System.out.printf("\nTraversal using Arbit Pointer\n");
    while (anode!=null)
    {
    System.out.printf("%d, ", anode.data);
    anode = anode.arbit;
    }
    }
    // This function populates arbit pointer in every node to the
    // next higher value. And returns pointer to the node with
    // minimum value
    static class node* populateArbit(static class node *head)
    {
    // Copy next pointers to arbit pointers
    static class node *temp = head;
    while (temp != null)
    {
    temp.arbit = temp.next;
    temp = temp.next;
    }
    // Do merge sort for arbitrary pointers
    MergeSort(&head);
    // Return head of arbitrary pointer linked list
    return head;
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    /* Let us create the list shown above */
    push(&head, 3);
    push(&head, 2);
    push(&head, 10);
    push(&head, 5);
    /* Sort the above created Linked List */
    static class node *ahead = populateArbit(head);
    System.out.printf("\nResult Linked List is: \n");
    printListafter(head, ahead);
    getchar();
    return 0;
    }
}
