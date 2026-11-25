package com.dsamastery.dp;

import java.util.*;

public class ShortestCommon {

    /* C program to find length of the shortest supersequence */
    /* Utility function to get max of 2 integers */
    int max(int a, int b) { return (a > b)? a : b; }
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs( char *X, char *Y, int m, int n);
    // Function to find length of the shortest supersequence
    // of X and Y.
    int shortestSuperSequence(char *X, char *Y)
    {
    int m = strlen(X), n = strlen(Y);
    int l = lcs(X, Y, m, n); // find lcs
    // Result is sum of input string lengths - length of lcs
    return (m + n - l);
    }
    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs( char *X, char *Y, int m, int n)
    {
    int L[m+1][n+1];
    int i, j;
    /* Following steps build L[m+1][n+1] in bottom up fashion.
    Note that L[i][j] contains length of LCS of X[0..i-1]
    and Y[0..j-1] */
    for (i=0; i<=m; i++)
    {
    for (j=0; j<=n; j++)
    {
    if (i == 0 || j == 0)
    L[i][j] = 0;
    else if (X[i-1] == Y[j-1])
    L[i][j] = L[i-1][j-1] + 1;
    else
    L[i][j] = max(L[i-1][j], L[i][j-1]);
    }
    }
    /* L[m][n] contains length of LCS for X[0..n-1] and
    Y[0..m-1] */
    return L[m][n];
    }
    /* Driver program to test above function */
    int main()
    {
    char X[] = "AGGTAB";
    char Y[] = "GXTXAYB";
    System.out.printf("Length of the shortest supersequence is %d\n",
    shortestSuperSequence(X, Y));
    return 0;
    }
    if (m == 0) return n;
    if (n == 0) return m;
    // If last characters are same, then add 1 to result and
    // recur for X[]
    if (X[m-1] == Y[n-1])
    return 1 + SCS(X, Y, m-1, n-1);
    // Else find shortest of following two
    // a) Remove last character from X and recur
    // b) Remove last character from Y and recur
    else return 1 + min( SCS(X, Y, m-1, n), SCS(X, Y, m, n-1) );
    /* A Naive recursive C++ program to find length
    of the shortest supersequence */
    int superSeq(char* X, char* Y, int m, int n)
    {
    if (!m) return n;
    if (!n) return m;
    if (X[m-1] == Y[n-1])
    return 1 + superSeq(X, Y, m-1, n-1);
    return 1 + min(superSeq(X, Y, m-1, n),
    superSeq(X, Y, m, n-1));
    }
    // Driver program to test above function
    int main()
    {
    char X[] = "AGGTAB";
    char Y[] = "GXTXAYB";
    cout << "Length of the shortest supersequence is "
    << superSeq(X, Y, strlen(X), strlen(Y));
    return 0;
    }
    /* A dynamic programming based C program to find length
    of the shortest supersequence */
    // Returns length of the shortest supersequence of X and Y
    int superSeq(char* X, char* Y, int m, int n)
    {
    int dp[m+1][n+1];
    // Fill table in bottom up manner
    for (int i = 0; i <= m; i++)
    {
    for (int j = 0; j <= n; j++)
    {
    // Below steps follow above recurrence
    if (!i)
    dp[i][j] = j;
    else if (!j)
    dp[i][j] = i;
    else if (X[i-1] == Y[j-1])
    dp[i][j] = 1 + dp[i-1][j-1];
    else
    dp[i][j] = 1 + min(dp[i-1][j], dp[i][j-1]);
    }
    }
    return dp[m][n];
    }
    // Driver program to test above function
    int main()
    {
    char X[] = "AGGTAB";
    char Y[] = "GXTXAYB";
    cout << "Length of the shortest supersequence is "
    << superSeq(X, Y, strlen(X), strlen(Y));
    return 0;
    }
}
