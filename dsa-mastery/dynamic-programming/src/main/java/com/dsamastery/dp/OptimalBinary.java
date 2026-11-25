package com.dsamastery.dp;

import java.util.*;

public class OptimalBinary {

    Input: keys[] = {10, 12}, freq[] = {34, 50}
    Input: keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
    \ / / \
    // A naive recursive implementation of optimal binary search tree problem
    // A utility function to get sum of array elements freq[i] to freq[j]
    int sum(int freq[], int i, int j);
    // A recursive function to calculate cost of optimal binary search tree
    int optCost(int freq[], int i, int j)
    {
    // Base cases
    if (j < i) // If there are no elements in this subarray
    return 0;
    if (j == i) // If there is one element in this subarray
    return freq[i];
    // Get sum of freq[i], freq[i+1], ... freq[j]
    int fsum = sum(freq, i, j);
    // Initialize minimum value
    int min = INT_MAX;
    // One by one consider all elements as root and recursively find cost
    // of the BST, compare the cost with min and update min if needed
    for (int r = i; r <= j; ++r)
    {
    int cost = optCost(freq, i, r-1) + optCost(freq, r+1, j);
    if (cost < min)
    min = cost;
    }
    // Return minimum value
    return min + fsum;
    }
    // The main function that calculates minimum cost of a Binary Search Tree.
    // It mainly uses optCost() to find the optimal cost.
    int optimalSearchTree(int keys[], int freq[], int n)
    {
    // Here array keys[] is assumed to be sorted in increasing order.
    // If keys[] is not sorted, then add code to sort keys, and rearrange
    // freq[] accordingly.
    return optCost(freq, 0, n-1);
    }
    // A utility function to get sum of array elements freq[i] to freq[j]
    int sum(int freq[], int i, int j)
    {
    int s = 0;
    for (int k = i; k <=j; k++)
    s += freq[k];
    return s;
    }
    // Driver program to test above functions
    int main()
    {
    int keys[] = {10, 12, 20};
    int freq[] = {34, 8, 50};
    int n = sizeof(keys)/sizeof(keys[0]);
    System.out.printf("Cost of Optimal BST is %d ", optimalSearchTree(keys, freq, n));
    return 0;
    }
    // Dynamic Programming code for Optimal Binary Search Tree Problem
    // A utility function to get sum of array elements freq[i] to freq[j]
    int sum(int freq[], int i, int j);
    /* A Dynamic Programming based function that calculates minimum cost of
    a Binary Search Tree. */
    int optimalSearchTree(int keys[], int freq[], int n)
    {
    /* Create an auxiliary 2D matrix to store results of subproblems */
    int cost[n][n];
    /* cost[i][j] = Optimal cost of binary search tree that can be
    formed from keys[i] to keys[j].
    cost[0][n-1] will store the resultant cost */
    // For a single key, cost is equal to frequency of the key
    for (int i = 0; i < n; i++)
    cost[i][i] = freq[i];
    // Now we need to consider chains of length 2, 3, ... .
    // L is chain length.
    for (int L=2; L<=n; L++)
    {
    // i is row number in cost[][]
    for (int i=0; i<=n-L+1; i++)
    {
    // Get column number j from row number i and chain length L
    int j = i+L-1;
    cost[i][j] = INT_MAX;
    // Try making all keys in interval keys[i..j] as root
    for (int r=i; r<=j; r++)
    {
    // c = cost when keys[r] becomes root of this subtree
    int c = ((r > i)? cost[i][r-1]:0) +
    ((r < j)? cost[r+1][j]:0) +
    sum(freq, i, j);
    if (c < cost[i][j])
    cost[i][j] = c;
    }
    }
    }
    return cost[0][n-1];
    }
    // A utility function to get sum of array elements freq[i] to freq[j]
    int sum(int freq[], int i, int j)
    {
    int s = 0;
    for (int k = i; k <=j; k++)
    s += freq[k];
    return s;
    }
    // Driver program to test above functions
    int main()
    {
    int keys[] = {10, 12, 20};
    int freq[] = {34, 8, 50};
    int n = sizeof(keys)/sizeof(keys[0]);
    System.out.printf("Cost of Optimal BST is %d ", optimalSearchTree(keys, freq, n));
    return 0;
    }
}
