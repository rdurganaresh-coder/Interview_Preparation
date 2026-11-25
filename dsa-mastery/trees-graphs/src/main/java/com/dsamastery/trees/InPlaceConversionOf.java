package com.dsamastery.trees;

import java.util.*;

public class InPlaceConversionOf {

    / \
    / \
    / \ / \
    / \
    / \
    Method 1 (Simple)
    Method 2 (Tricky)
    /* A Doubly Linked List node that will also be used as a tree node */
    static class Node
    {
    int data;
    // For tree, next pointer can be used as right subtree pointer
    static class Node* next;
    // For tree, prev pointer can be used as left subtree pointer
    static class Node* prev;
    };
    // A utility function to count nodes in a Linked List
    int countNodes(static class Node *head);
    static class Node* sortedListToBSTRecur(static class Node **head_ref, int n);
    /* This function counts the number of nodes in Linked List and then calls
    sortedListToBSTRecur() to construct BST */
    static class Node* sortedListToBST(static class Node *head)
    {
    /*Count the number of nodes in Linked List */
    int n = countNodes(head);
    /* Construct BST */
    return sortedListToBSTRecur(&head, n);
    }
    /* The main function that constructs balanced BST and returns root of it.
    head_ref --> Pointer to pointer to head node of Doubly linked list
    n --> No. of nodes in the Doubly Linked List */
    static class Node* sortedListToBSTRecur(static class Node **head_ref, int n)
    {
    /* Base Case */
    if (n <= 0)
    return null;
    /* Recursively construct the left subtree */
    static class Node *left = sortedListToBSTRecur(head_ref, n/2);
    /* head_ref now refers to middle node, make middle node as root of BST*/
    static class Node *root = *head_ref;
    // Set pointer to left subtree
    root.prev = left;
    /* Change head pointer of Linked List for parent recursive calls */
    *head_ref = (*head_ref)->next;
    /* Recursively construct the right subtree and link it with root
    The number of nodes in right subtree is total nodes - nodes in
    left subtree - 1 (for root) */
    root.next = sortedListToBSTRecur(head_ref, n-n/2-1);
    return root;
    }
    /* UTILITY FUNCTIONS */
    /* A utility function that returns count of nodes in a given Linked List */
    int countNodes(static class Node *head)
    {
    int count = 0;
    static class Node *temp = head;
    while(temp)
    {
    temp = temp.next;
    count++;
    }
    return count;
    }
    /* Function to insert a node at the beginging of the Doubly Linked List */
    void push(static class Node** head_ref, int new_data)
    {
    /* allocate node */
    static class Node* new_node =
    (static class Node*) malloc(sizeof(static class Node));
    /* put in the data */
    new_node.data = new_data;
    /* since we are adding at the begining,
    prev is always null */
    new_node.prev = null;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* change prev of head node to new node */
    if((*head_ref) != null)
    (*head_ref)->prev = new_node ;
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Function to print nodes in a given linked list */
    void printList(static class Node *node)
    {
    while(node!=null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* A utility function to print preorder traversal of BST */
    void preOrder(static class Node* node)
    {
    if (node == null)
    return;
    System.out.printf("%d ", node.data);
    preOrder(node.prev);
    preOrder(node.next);
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class Node* head = null;
    /* Let us create a sorted linked list to test the functions
    Created linked list will be 7.6.5.4.3.2.1 */
    push(&head, 7);
    push(&head, 6);
    push(&head, 5);
    push(&head, 4);
    push(&head, 3);
    push(&head, 2);
    push(&head, 1);
    System.out.printf("\n Given Linked List ");
    printList(head);
    /* Convert List to BST */
    static class Node *root = sortedListToBST(head);
    System.out.printf("\n PreOrder Traversal of constructed BST ");
    preOrder(root);
    return 0;
    }
}
