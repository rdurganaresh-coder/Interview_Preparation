package com.dsamastery.linkedlists;

import java.util.*;

public class SortedLinkedListTo {

    / \
    / \
    / \ / \
    / \
    / \
    Method 1 (Simple)
    Method 2 (Tricky)
    /* Link list node */
    static class LNode
    {
    int data;
    static class LNode* next;
    };
    /* A Binary Tree node */
    static class TNode
    {
    int data;
    static class TNode* left;
    static class TNode* right;
    };
    static class TNode* newNode(int data);
    int countLNodes(static class LNode *head);
    static class TNode* sortedListToBSTRecur(static class LNode **head_ref, int n);
    /* This function counts the number of nodes in Linked List and then calls
    sortedListToBSTRecur() to construct BST */
    static class TNode* sortedListToBST(static class LNode *head)
    {
    /*Count the number of nodes in Linked List */
    int n = countLNodes(head);
    /* Construct BST */
    return sortedListToBSTRecur(&head, n);
    }
    /* The main function that constructs balanced BST and returns root of it.
    head_ref --> Pointer to pointer to head node of linked list
    n --> No. of nodes in Linked List */
    static class TNode* sortedListToBSTRecur(static class LNode **head_ref, int n)
    {
    /* Base Case */
    if (n <= 0)
    return null;
    /* Recursively construct the left subtree */
    static class TNode *left = sortedListToBSTRecur(head_ref, n/2);
    /* Allocate memory for root, and link the above constructed left
    subtree with root */
    static class TNode *root = newNode((*head_ref)->data);
    root.left = left;
    /* Change head pointer of Linked List for parent recursive calls */
    *head_ref = (*head_ref)->next;
    /* Recursively construct the right subtree and link it with root
    The number of nodes in right subtree is total nodes - nodes in
    left subtree - 1 (for root) which is n-n/2-1*/
    root.right = sortedListToBSTRecur(head_ref, n-n/2-1);
    return root;
    }
    /* UTILITY FUNCTIONS */
    /* A utility function that returns count of nodes in a given Linked List */
    int countLNodes(static class LNode *head)
    {
    int count = 0;
    static class LNode *temp = head;
    while(temp)
    {
    temp = temp.next;
    count++;
    }
    return count;
    }
    /* Function to insert a node at the beginging of the linked list */
    void push(static class LNode** head_ref, int new_data)
    {
    /* allocate node */
    static class LNode* new_node =
    (static class LNode*) malloc(sizeof(static class LNode));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to point to the new node */
    (*head_ref) = new_node;
    }
    /* Function to print nodes in a given linked list */
    void printList(static class LNode *node)
    {
    while(node!=null)
    {
    System.out.printf("%d ", node.data);
    node = node.next;
    }
    }
    /* Helper function that allocates a new node with the
    given data and null left and right pointers. */
    static class TNode* newNode(int data)
    {
    static class TNode* node = (static class TNode*)
    malloc(sizeof(static class TNode));
    node.data = data;
    node.left = null;
    node.right = null;
    return node;
    }
    /* A utility function to print preorder traversal of BST */
    void preOrder(static class TNode* node)
    {
    if (node == null)
    return;
    System.out.printf("%d ", node.data);
    preOrder(node.left);
    preOrder(node.right);
    }
    /* Drier program to test above functions*/
    int main()
    {
    /* Start with the empty list */
    static class LNode* head = null;
    /* Let us create a sorted linked list to test the functions
    Created linked list will be 1.2.3.4.5.6.7 */
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
    static class TNode *root = sortedListToBST(head);
    System.out.printf("\n PreOrder Traversal of constructed BST ");
    preOrder(root);
    return 0;
    }
}
