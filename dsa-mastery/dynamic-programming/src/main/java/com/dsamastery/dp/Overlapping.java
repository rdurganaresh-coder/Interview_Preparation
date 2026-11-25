package com.dsamastery.dp;

import java.util.*;

public class Overlapping {

    /* simple recursive program for Fibonacci numbers */
    int fib(int n)
    {
    if ( n <= 1 )
    return n;
    return fib(n-1) + fib(n-2);
    }
    Recursion tree for execution of ﬁb(5)
    fib(5)
    / \
    / \ / \
    / \ / \ / \
    / \
    /* Memoized version for nth Fibonacci number */
    int lookup[MAX];
    /* Function to initialize NIL values in lookup table */
    void _initialize()
    {
    int i;
    for (i = 0; i < MAX; i++)
    lookup[i] = NIL;
    }
    /* function for nth Fibonacci number */
    int fib(int n)
    {
    if(lookup[n] == NIL)
    {
    if ( n <= 1 )
    lookup[n] = n;
    else
    lookup[n] = fib(n-1) + fib(n-2);
    }
    return lookup[n];
    }
    int main ()
    {
    int n = 40;
    _initialize();
    System.out.printf("Fibonacci number is %d ", fib(n));
    getchar();
    return 0;
    }
    /* tabulated version */
    int fib(int n)
    {
    int f[n+1];
    int i;
    f[0] = 0; f[1] = 1;
    for (i = 2; i <= n; i++)
    f[i] = f[i-1] + f[i-2];
    return f[n];
    }
    int main ()
    {
    int n = 9;
    System.out.printf("Fibonacci number is %d ", fib(n));
    getchar();
    return 0;
    }
}
