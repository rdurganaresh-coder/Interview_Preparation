package com.dsamastery.stacksqueues;

import java.util.*;

public class ImplementTwoStacksIn {

    Method 1 (Divide the space in two halves)
    Method 2 (A space eﬃcient implementation)
    class twoStacks
    {
    int *arr;
    int size;
    int top1, top2;
    public:
    twoStacks(int n) // constructor
    {
    size = n;
    arr = new int[n];
    top1 = -1;
    top2 = size;
    }
    // Method to push an element x to stack1
    void push1(int x)
    {
    // There is at least one empty space for new element
    if (top1 < top2 - 1)
    {
    top1++;
    arr[top1] = x;
    }
    else
    {
    System.out.print("Stack Overflow");
    exit(1);
    }
    }
    // Method to push an element x to stack2
    void push2(int x)
    {
    // There is at least one empty space for new element
    if (top1 < top2 - 1)
    {
    top2--;
    arr[top2] = x;
    }
    else
    {
    System.out.print("Stack Overflow");
    exit(1);
    }
    }
    // Method to pop an element from first stack
    int pop1()
    {
    if (top1 >= 0 )
    {
    int x = arr[top1];
    top1--;
    return x;
    }
    else
    {
    System.out.print("Stack UnderFlow");
    exit(1);
    }
    }
    // Method to pop an element from second stack
    int pop2()
    {
    if (top2 < size)
    {
    int x = arr[top2];
    top2++;
    return x;
    }
    else
    {
    System.out.print("Stack UnderFlow");
    exit(1);
    }
    }
    };
    /* Driver program to test twStacks class */
    int main()
    {
    twoStacks ts(5);
    ts.push1(5);
    ts.push2(10);
    ts.push2(15);
    ts.push1(11);
    ts.push2(7);
    System.out.print("Popped element from stack1 is " << ts.pop1());
    ts.push2(40);
    System.out.print("\nPopped element from stack2 is " << ts.pop2());
    return 0;
    }
    class twoStacks:
    else:
    print("Stack Overflow ")
    exit()
    else :
    print("Stack Overflow ")
    exit(1)
    return x
    else:
    print("Stack Underflow ")
    exit(1)
    return x
    else:
    print("Stack Underflow ")
    exit()
}
