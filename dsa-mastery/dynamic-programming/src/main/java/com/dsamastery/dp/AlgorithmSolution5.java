package com.dsamastery.dp;

import java.util.*;

public class AlgorithmSolution {

    obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
    cutRod(n) = max(price[i] + cutRod(n-i-1)) for all i in {0, 1 .. n-1}
    // A Naive recursive solution for Rod cutting problem
    // A utility function to get the maximum of two integers
    int max(int a, int b) { return (a > b)? a : b;}
    /* Returns the best obtainable price for a rod of length n and
    price[] as prices of different pieces */
    int cutRod(int price[], int n)
    {
    if (n <= 0)
    return 0;
    int max_val = INT_MIN;
    // Recursively cut the rod in different pieces and compare different
    // configurations
    for (int i = 0; i<n; i++)
    max_val = max(max_val, price[i] + cutRod(price, n-i-1));
    return max_val;
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    int size = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Maximum Obtainable Value is %d\n", cutRod(arr, size));
    getchar();
    return 0;
    }
    cR(4)
    / / \ \
    / / \ \
    // A Dynamic Programming solution for Rod cutting problem
    // A utility function to get the maximum of two integers
    int max(int a, int b) { return (a > b)? a : b;}
    /* Returns the best obtainable price for a rod of length n and
    price[] as prices of different pieces */
    int cutRod(int price[], int n)
    {
    int val[n+1];
    val[0] = 0;
    int i, j;
    // Build the table val[] in bottom up manner and return the last entry
    // from the table
    for (i = 1; i<=n; i++)
    {
    int max_val = INT_MIN;
    for (j = 0; j < i; j++)
    max_val = max(max_val, price[j] + val[i-j-1]);
    val[i] = max_val;
    }
    return val[n];
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {1, 5, 8, 9, 10, 17, 17, 20};
    int size = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Maximum Obtainable Value is %d\n", cutRod(arr, size));
    getchar();
    return 0;
    }
    return val[n]
}
