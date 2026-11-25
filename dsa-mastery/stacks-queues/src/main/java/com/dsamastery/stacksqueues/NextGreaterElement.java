package com.dsamastery.stacksqueues;

import java.util.*;

public class NextGreaterElement {

    Method 1 (Simple)
    // Simple C program to print next greater elements
    // in a given array
    /* prints element and NGE pair for all elements of
    arr[] of size n */
    void printNGE(int arr[], int n)
    {
    int next, i, j;
    for (i=0; i<n; i++)
    {
    next = -1;
    for (j = i+1; j<n; j++)
    {
    if (arr[i] < arr[j])
    {
    next = arr[j];
    break;
    }
    }
    System.out.printf("%d -- %d\n", arr[i], next);
    }
    }
    int main()
    {
    int arr[]= {11, 13, 21, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    printNGE(arr, n);
    getchar();
    return 0;
    }
    printNGE(arr)
    Method 2 (Using Stack)
    // A Stack based C program to find next greater element
    // for all array elements.
    // stack structure
    static class stack
    {
    int top;
    int items[STACKSIZE];
    };
    // Stack Functions to be used by printNGE()
    void push(static class stack *ps, int x)
    {
    if (ps.top == STACKSIZE-1)
    {
    System.out.printf("Error: stack overflow\n");
    getchar();
    exit(0);
    }
    else
    {
    ps.top += 1;
    int top = ps.top;
    ps.items [top] = x;
    }
    }
    boolean isEmpty(static class stack *ps)
    {
    return (ps.top == -1)? true : false;
    }
    int pop(static class stack *ps)
    {
    int temp;
    if (ps.top == -1)
    {
    System.out.printf("Error: stack underflow \n");
    getchar();
    exit(0);
    }
    else
    {
    int top = ps.top;
    temp = ps.items [top];
    ps.top -= 1;
    return temp;
    }
    }
    /* prints element and NGE pair for all elements of
    arr[] of size n */
    void printNGE(int arr[], int n)
    {
    int i = 0;
    static class stack s;
    s.top = -1;
    int element, next;
    /* push the first element to stack */
    push(&s, arr[0]);
    // iterate for rest of the elements
    for (i=1; i<n; i++)
    {
    next = arr[i];
    if (isEmpty(&s) == false)
    {
    // if stack is not empty, then pop an element from stack
    element = pop(&s);
    /* If the popped element is smaller than next, then
    a) print the pair
    b) keep popping while elements are smaller and
    stack is not empty */
    while (element < next)
    {
    System.out.printf("\n %d --> %d", element, next);
    if(isEmpty(&s) == true)
    break;
    element = pop(&s);
    }
    /* If element is greater than next, then push
    the element back */
    if (element > next)
    push(&s, element);
    }
    /* push next to stack so that we can find
    next greater for it */
    push(&s, next);
    }
    /* After iterating over the loop, the remaining
    elements in stack do not have the next greater
    element, so print -1 for them */
    while (isEmpty(&s) == false)
    {
    element = pop(&s);
    next = -1;
    System.out.printf("\n %d -- %d", element, next);
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[]= {11, 13, 21, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    printNGE(arr, n);
    getchar();
    return 0;
    }
    return stack
    return len(stack) == 0
    print("Error : stack underflow")
    else:
    return stack.pop()
    push(s, arr[0])
    push(s, element)
    push(s, next)
    printNGE(arr)
}
