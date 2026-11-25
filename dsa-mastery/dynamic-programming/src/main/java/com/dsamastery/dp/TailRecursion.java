package com.dsamastery.dp;

import java.util.*;

public class TailRecursion {

    // An example of tail recursive function
    void print(int n)
    {
    if (n < 0) return;
    System.out.print(" " << n);
    // The last executed statement is recursive call
    print(n-1);
    }
    // A NON-tail-recursive function. The function is not tail
    // recursive because the value returned by fact(n-1) is used in
    // fact(n) and call to fact(n-1) is not the last thing done by fact(n)
    unsigned int fact(unsigned int n)
    {
    if (n == 0) return 1;
    return n*fact(n-1);
    }
    // Driver program to test above function
    int main()
    {
    System.out.print(fact(5));
    return 0;
    }
    // A tail recursive function to calculate factorial
    unsigned factTR(unsigned int n, unsigned int a)
    {
    if (n == 0) return a;
    return factTR(n-1, n*a);
    }
    // A wrapper over factTR
    unsigned int fact(unsigned int n)
    {
    return factTR(n, 1);
    }
    // Driver program to test above function
    int main()
    {
    System.out.print(fact(5));
    return 0;
    }
}
