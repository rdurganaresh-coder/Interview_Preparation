package com.dsamastery.dp;

import java.util.*;

public class CountOfNDigit {

    // A recursive program to count numbers with sum
    // of digits as given 'sum'
    // Recursive function to count 'n' digit numbers
    // with sum of digits as 'sum'. This function
    // considers leading 0's also as digits, that is
    // why not directly called
    unsigned long long int countRec(int n, int sum)
    {
    // Base case
    if (n == 0)
    return sum == 0;
    // Initialize answer
    unsigned long long int ans = 0;
    // Traverse through every digit and count
    // numbers beginning with it using recursion
    for (int i=0; i<=9; i++)
    if (sum-i >= 0)
    ans += countRec(n-1, sum-i);
    return ans;
    }
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining digits.
    unsigned long long int finalCount(int n, int sum)
    {
    // Initialize final answer
    unsigned long long int ans = 0;
    // Traverse through every digit from 1 to
    // 9 and count numbers beginning with it
    for (int i = 1; i <= 9; i++)
    if (sum-i >= 0)
    ans += countRec(n-1, sum-i);
    return ans;
    }
    // Driver program
    int main()
    {
    int n = 2, sum = 5;
    System.out.print(finalCount(n, sum));
    return 0;
    }
    // A memoization based recursive program to count
    // numbers with sum of n as given 'sum'
    // A lookup table used for memoization
    unsigned long long int lookup[101][50001];
    // Memoizatiob based implementation of recursive
    // function
    unsigned long long int countRec(int n, int sum)
    {
    // Base case
    if (n == 0)
    return sum == 0;
    // If this subproblem is already evaluated,
    // return the evaluated value
    if (lookup[n][sum] != -1)
    return lookup[n][sum];
    // Initialize answer
    unsigned long long int ans = 0;
    // Traverse through every digit and
    // recursively count numbers beginning
    // with it
    for (int i=0; i<10; i++)
    if (sum-i >= 0)
    ans += countRec(n-1, sum-i);
    return lookup[n][sum] = ans;
    }
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining n.
    unsigned long long int finalCount(int n, int sum)
    {
    // Initialize all entries of lookup table
    memset(lookup, -1, sizeof lookup);
    // Initialize final answer
    unsigned long long int ans = 0;
    // Traverse through every digit from 1 to
    // 9 and count numbers beginning with it
    for (int i = 1; i <= 9; i++)
    if (sum-i >= 0)
    ans += countRec(n-1, sum-i);
    return ans;
    }
    // Driver program
    int main()
    {
    int n = 3, sum = 5;
    System.out.print(finalCount(n, sum));
    return 0;
    }
}
