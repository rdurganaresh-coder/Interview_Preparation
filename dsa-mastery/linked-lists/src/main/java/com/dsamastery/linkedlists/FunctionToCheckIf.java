package com.dsamastery.linkedlists;

import java.util.*;

public class FunctionToCheckIf {

    METHOD 1 (Use a Stack)
    METHOD 2 (By reversing the list)
    /* Program to check if a linked list is palindrome */
    /* Link list node */
    static class node
    {
    char data;
    static class node* next;
    };
    void reverse(static class node**);
    boolean compareLists(static class node*, static class node *);
    /* Function to check if given linked list is
    palindrome or not */
    boolean isPalindrome(static class node *head)
    {
    static class node *slow_ptr = head, *fast_ptr = head;
    static class node *second_half, *prev_of_slow_ptr = head;
    static class node *midnode = null; // To handle odd size list
    boolean res = true; // initialize result
    if (head!=null && head.next!=null)
    {
    /* Get the middle of the list. Move slow_ptr by 1
    and fast_ptrr by 2, slow_ptr will have the middle
    node */
    while (fast_ptr != null && fast_ptr.next != null)
    {
    fast_ptr = fast_ptr.next.next;
    /*We need previous of the slow_ptr for
    linked lists with odd elements */
    prev_of_slow_ptr = slow_ptr;
    slow_ptr = slow_ptr.next;
    }
    /* fast_ptr would become null when there are even elements in list.
    And not null for odd elements. We need to skip the middle node
    for odd case and store it somewhere so that we can restore the
    original list*/
    if (fast_ptr != null)
    {
    midnode = slow_ptr;
    slow_ptr = slow_ptr.next;
    }
    // Now reverse the second half and compare it with first half
    second_half = slow_ptr;
    prev_of_slow_ptr.next = null; // null terminate first half
    reverse(&second_half); // Reverse the second half
    res = compareLists(head, second_half); // compare
    /* Construct the original list back */
    reverse(&second_half); // Reverse the second half again
    if (midnode != null) // If there was a mid node (odd size case) which
    // was not part of either first half or second half.
    {
    prev_of_slow_ptr.next = midnode;
    midnode.next = second_half;
    }
    else prev_of_slow_ptr.next = second_half;
    }
    return res;
    }
    /* Function to reverse the linked list Note that this
    function may change the head */
    void reverse(static class node** head_ref)
    {
    static class node* prev = null;
    static class node* current = *head_ref;
    static class node* next;
    while (current != null)
    {
    next = current.next;
    current.next = prev;
    prev = current;
    current = next;
    }
    *head_ref = prev;
    }
    /* Function to check if two input lists have same data*/
    boolean compareLists(static class node* head1, static class node *head2)
    {
    static class node* temp1 = head1;
    static class node* temp2 = head2;
    while (temp1 && temp2)
    {
    if (temp1.data == temp2.data)
    {
    temp1 = temp1.next;
    temp2 = temp2.next;
    }
    else return 0;
    }
    /* Both are empty reurn 1*/
    if (temp1 == null && temp2 == null)
    return 1;
    /* Will reach here when one is null
    and other is not */
    return 0;
    }
    /* Push a node to linked list. Note that this function
    changes the head */
    void push(static class node** head_ref, char new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to pochar to the new node */
    (*head_ref) = new_node;
    }
    // A utility function to print a given linked list
    void printList(static class node *ptr)
    {
    while (ptr != null)
    {
    System.out.printf("%c.", ptr.data);
    ptr = ptr.next;
    }
    System.out.printf("null\n");
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    char str[] = "abacaba";
    int i;
    for (i = 0; str[i] != '\0'; i++)
    {
    push(&head, str[i]);
    printList(head);
    isPalindrome(head)? System.out.printf("Is Palindrome\n\n"):
    System.out.printf("Not Palindrome\n\n");
    }
    return 0;
    }
    Time Complexity O(n)
    METHOD 3 (Using Recursion)
    // Recursive program to check if a given linked list is palindrome
    /* Link list node */
    static class node
    {
    char data;
    static class node* next;
    };
    // Initial parameters to this function are &head and head
    boolean isPalindromeUtil(static class node **left, static class node *right)
    {
    /* stop recursion when right becomes null */
    if (right == null)
    return true;
    /* If sub-list is not palindrome then no need to
    check for current left and right, return false */
    boolean isp = isPalindromeUtil(left, right.next);
    if (isp == false)
    return false;
    /* Check values at current left and right */
    boolean isp1 = (right.data == (*left)->data);
    /* Move left to next node */
    *left = (*left)->next;
    return isp1;
    }
    // A wrapper over isPalindromeUtil()
    boolean isPalindrome(static class node *head)
    {
    isPalindromeUtil(&head, head);
    }
    /* Push a node to linked list. Note that this function
    changes the head */
    void push(static class node** head_ref, char new_data)
    {
    /* allocate node */
    static class node* new_node =
    (static class node*) malloc(sizeof(static class node));
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*head_ref);
    /* move the head to pochar to the new node */
    (*head_ref) = new_node;
    }
    // A utility function to print a given linked list
    void printList(static class node *ptr)
    {
    while (ptr != null)
    {
    System.out.printf("%c.", ptr.data);
    ptr = ptr.next;
    }
    System.out.printf("null\n");
    }
    /* Drier program to test above function*/
    int main()
    {
    /* Start with the empty list */
    static class node* head = null;
    char str[] = "abacaba";
    int i;
    for (i = 0; str[i] != '\0'; i++)
    {
    push(&head, str[i]);
    printList(head);
    isPalindrome(head)? System.out.printf("Is Palindrome\n\n"):
    System.out.printf("Not Palindrome\n\n");
    }
    return 0;
    }
}
