package com.dsamastery.stacksqueues;

import java.util.*;

public class SortAStackUsing {

    sortStack(stack S)
    temp = pop(S);
    sortStack(S);
    sortedInsert(S, temp);
    sortedInsert(Stack S, element)
    push(S, elem)
    else
    sortedInsert(S, element)
    push(S, temp)
    // C program to sort a stack using recursion
    // Stack is represented using linked list
    static class stack
    {
    int data;
    static class stack *next;
    };
    // Utility function to initialize stack
    void initStack(static class stack **s)
    {
    *s = null;
    }
    // Utility function to chcek if stack is empty
    int isEmpty(static class stack *s)
    {
    if (s == null)
    return 1;
    return 0;
    }
    // Utility function to push an item to stack
    void push(static class stack **s, int x)
    {
    static class stack *p = (static class stack *)malloc(sizeof(*p));
    if (p == null)
    {
    fprintf(stderr, "Memory allocation failed.\n");
    return;
    }
    p.data = x;
    p.next = *s;
    *s = p;
    }
    // Utility function to remove an item from stack
    int pop(static class stack **s)
    {
    int x;
    static class stack *temp;
    x = (*s)->data;
    temp = *s;
    (*s) = (*s)->next;
    free(temp);
    return x;
    }
    // Function to find top item
    int top(static class stack *s)
    {
    return (s.data);
    }
    // Recursive function to insert an item x in sorted way
    void sortedInsert(static class stack **s, int x)
    {
    // Base case: Either stack is empty or newly inserted
    // item is greater than top (more than all existing)
    if (isEmpty(*s) || x > top(*s))
    {
    push(s, x);
    return;
    }
    // If top is greater, remove the top item and recur
    int temp = pop(s);
    sortedInsert(s, x);
    // Put back the top item removed earlier
    push(s, temp);
    }
    // Function to sort stack
    void sortStack(static class stack **s)
    {
    // If stack is not empty
    if (!isEmpty(*s))
    {
    // Remove the top item
    int x = pop(s);
    // Sort remaining stack
    sortStack(s);
    // Push the top item back in sorted stack
    sortedInsert(s, x);
    }
    }
    // Utility function to print contents of stack
    void printStack(static class stack *s)
    {
    while (s)
    {
    System.out.printf("%d ", s.data);
    s = s.next;
    }
    System.out.printf("\n");
    }
    // Driver Program
    int main(void)
    {
    static class stack *top;
    initStack(&top);
    push(&top, 30);
    push(&top, -5);
    push(&top, 18);
    push(&top, 14);
    push(&top, -3);
    System.out.printf("Stack elements before sorting:\n");
    printStack(top);
    sortStack(&top);
    System.out.printf("\n\n");
    System.out.printf("Stack elements after sorting:\n");
    printStack(top);
    return 0;
    }
}
