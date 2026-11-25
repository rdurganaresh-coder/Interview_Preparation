package com.dsamastery.dp;

import java.util.*;

public class NumberOfPathsWith {

    {3, 2, 1}
    };
    If (m == 0 and n == 0)
    return 1 if mat[0][0] == k else return 0
    pathCount(m, n-1, k - mat[m][n])
    // A Naive Recursive C++ program to count paths with exactly
    // 'k' coins
    // Recursive function to count paths with sum k from
    // (0, 0) to (m, n)
    int pathCountRec(int mat[][C], int m, int n, int k)
    {
    // Base cases
    if (m < 0 || n < 0) return 0;
    if (m==0 && n==0) return (k == mat[m][n]);
    // (m, n) can be reached either through (m-1, n) or
    // through (m, n-1)
    return pathCountRec(mat, m-1, n, k-mat[m][n]) +
    pathCountRec(mat, m, n-1, k-mat[m][n]);
    }
    // A wrapper over pathCountRec()
    int pathCount(int mat[][C], int k)
    {
    return pathCountRec(mat, R-1, C-1, k);
    }
    // Driver program
    int main()
    {
    int k = 12;
    int mat[R][C] = { {1, 2, 3},
    {4, 6, 5},
    {3, 2, 1}
    };
    System.out.print(pathCount(mat, k));
    return 0;
    }
    // A Dynamic Programming based C++ program to count paths with
    // exactly 'k' coins
    int dp[R][C][MAX_K];
    int pathCountDPRecDP(int mat[][C], int m, int n, int k)
    {
    // Base cases
    if (m < 0 || n < 0) return 0;
    if (m==0 && n==0) return (k == mat[m][n]);
    // If this subproblem is already solved
    if (dp[m][n][k] != -1) return dp[m][n][k];
    // (m, n) can be reached either through (m-1, n) or
    // through (m, n-1)
    dp[m][n][k] = pathCountDPRecDP(mat, m-1, n, k-mat[m][n]) +
    pathCountDPRecDP(mat, m, n-1, k-mat[m][n]);
    return dp[m][n][k];
    }
    // This function mainly initializes dp[][][] and calls
    // pathCountDPRecDP()
    int pathCountDP(int mat[][C], int k)
    {
    memset(dp, -1, sizeof dp);
    return pathCountDPRecDP(mat, R-1, C-1, k);
    }
    // Driver Program to test above functions
    int main()
    {
    int k = 12;
    int mat[R][C] = { {1, 2, 3},
    {4, 6, 5},
    {3, 2, 1}
    };
    System.out.print(pathCountDP(mat, k));
    return 0;
    }
}
