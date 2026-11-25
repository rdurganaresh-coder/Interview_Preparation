package com.dsamastery.stacksqueues;

import java.util.*;

public class ReverseAStackUsing {

    isEmpty(S)
    push(S)
    pop(S)
    void insertAtBottom(static class sNode** top_ref, int item)
    {
    int temp;
    if(isEmpty(*top_ref))
    {
    push(top_ref, item);
    }
    else
    {
    /* Hold all items in Function Call Stack until we reach end of
    the stack. When the stack becomes empty, the isEmpty(*top_ref)
    becomes true, the above if part is executed and the item is
    inserted at the bottom */
    temp = pop(top_ref);
    insertAtBottom(top_ref, item);
    /* Once the item is inserted at the bottom, push all the
    items held in Function Call Stack */
    push(top_ref, temp);
    }
    }
    //Below is the function that reverses the given stack using insertAtBottom()
    void reverse(static class sNode** top_ref)
    {
    int temp;
    if(!isEmpty(*top_ref))
    {
    /* Hold all items in Function Call Stack until we reach end of
    the stack */
    temp = pop(top_ref);
    reverse(top_ref);
    /* Insert all the items (held in Function Call Stack) one by one
    from the bottom to top. Every item is inserted at the bottom */
    insertAtBottom(top_ref, temp);
    }
    }
    //Below is a complete running program for testing above functions.
    /* structure of a stack node */
    static class sNode
    {
    char data;
    static class sNode *next;
    };
    /* Function Prototypes */
    void push(static class sNode** top_ref, int new_data);
    int pop(static class sNode** top_ref);
    boolean isEmpty(static class sNode* top);
    void print(static class sNode* top);
    /* Driveer program to test above functions */
    int main()
    {
    static class sNode *s = null;
    push(&s, 4);
    push(&s, 3);
    push(&s, 2);
    push(&s, 1);
    System.out.printf("\n Original Stack ");
    print(s);
    reverse(&s);
    System.out.printf("\n Reversed Stack ");
    print(s);
    getchar();
    }
    /* Function to check if the stack is empty */
    boolean isEmpty(static class sNode* top)
    {
    return (top == null)? 1 : 0;
    }
    /* Function to push an item to stack*/
    void push(static class sNode** top_ref, int new_data)
    {
    /* allocate node */
    static class sNode* new_node =
    (static class sNode*) malloc(sizeof(static class sNode));
    if(new_node == null)
    {
    System.out.printf("Stack overflow \n");
    getchar();
    exit(0);
    }
    /* put in the data */
    new_node.data = new_data;
    /* link the old list off the new node */
    new_node.next = (*top_ref);
    /* move the head to point to the new node */
    (*top_ref) = new_node;
    }
    /* Function to pop an item from stack*/
    int pop(static class sNode** top_ref)
    {
    char res;
    static class sNode *top;
    /*If stack is empty then error */
    if(*top_ref == null)
    {
    System.out.printf("Stack overflow \n");
    getchar();
    exit(0);
    }
    else
    {
    top = *top_ref;
    res = top.data;
    *top_ref = top.next;
    free(top);
    return res;
    }
    }
    /* Functrion to pront a linked list */
    void print(static class sNode* top)
    {
    System.out.printf("\n");
    while(top != null)
    {
    System.out.printf(" %d ", top.data);
    top = top.next;
    }
    }
}
