package com.dsamastery.dp;

import java.util.*;

public class MaximumProduct {

    maxProd(n) = max(i*(n-i), maxProdRec(n-i)*i) for all i in {1, 2, 3 .. n}
    // A Naive Recursive method to find maxium product
    // Utility function to get the maximum of two and three integers
    int max(int a, int b) { return (a > b)? a : b;}
    int max(int a, int b, int c) { return max(a, max(b, c));}
    // The main function that returns maximum product obtainable
    // from a rope of length n
    int maxProd(int n)
    {
    // Base cases
    if (n == 0 || n == 1) return 0;
    // Make a cut at different places and take the maximum of all
    int max_val = 0;
    for (int i = 1; i < n; i++)
    max_val = max(max_val, i*(n-i), maxProd(n-i)*i);
    // Return the maximum of all values
    return max_val;
    }
    /* Driver program to test above functions */
    int main()
    {
    System.out.print("Maximum Product is " << maxProd(10));
    return 0;
    }
    mP(5)
    / / \ \
    / / \ \
    // A Dynamic Programming solution for Max Product Problem
    int maxProd(int n)
    {
    int val[n+1];
    val[0] = val[1] = 0;
    // Build the table val[] in bottom up manner and return
    // the last entry from the table
    for (int i = 1; i <= n; i++)
    {
    int max_val = 0;
    for (int j = 1; j <= i/2; j++)
    max_val = max(max_val, (i-j)*j, j*val[i-j]);
    val[i] = max_val;
    }
    return val[n];
    }
    /* The main function that teturns the max possible product */
    int maxProd(int n)
    {
    // n equals to 2 or 3 must be handled explicitly
    if (n == 2 || n == 3) return (n-1);
    // Keep removing parts of size 3 while n is greater than 4
    int res = 1;
    while (n > 4)
    {
    n -= 3;
    res *= 3; // Keep multiplying 3 to res
    }
    return (n * res); // The last part multiplied by previous parts
    }
    /* Driver program to test above functions */
    int main()
    {
    System.out.print("Maximum Product is " << maxProd(10));
    return 0;
    }
}
