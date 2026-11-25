package com.dsamastery.dp;

import java.util.*;

public class FindNumberOfSolutions {

    // A naive recursive C++ program to find number of non-negative
    // solutions for a given linear equation
    // Recursive function thet returns count of solutions for given
    // rhs value and coefficients coeff[start..end]
    int countSol(int coeff[], int start, int end, int rhs)
    {
    // Base case
    if (rhs == 0)
    return 1;
    int result = 0; // Initialize count of solutions
    // One by subtract all smaller or equal coefficiants and recur
    for (int i=start; i<=end; i++)
    if (coeff[i] <= rhs)
    result += countSol(coeff, i, end, rhs-coeff[i]);
    return result;
    }
    // Driver program
    int main()
    {
    int coeff[] = {2, 2, 5};
    int rhs = 4;
    int n = sizeof(coeff)/sizeof(coeff[0]);
    System.out.print(countSol(coeff, 0, n-1, rhs));
    return 0;
    }
    // A Dynamic programming based C++ program to find number of
    // non-negative solutions for a given linear equation
    // Returns counr of solutions for given rhs and coefficients
    // coeff[0..n-1]
    int countSol(int coeff[], int n, int rhs)
    {
    // Create and initialize a table to store results of
    // subproblems
    int dp[rhs+1];
    memset(dp, 0, sizeof(dp));
    dp[0] = 1;
    // Fill table in bottom up manner
    for (int i=0; i<n; i++)
    for (int j=coeff[i]; j<=rhs; j++)
    dp[j] += dp[j-coeff[i]];
    return dp[rhs];
    }
    // Driver program
    int main()
    {
    int coeff[] = {2, 2, 5};
    int rhs = 4;
    int n = sizeof(coeff)/sizeof(coeff[0]);
    System.out.print(countSol(coeff, n, rhs));
    return 0;
    }
    Time Complexity of above solution is O(n * rhs)
}
