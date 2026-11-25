package com.dsamastery.dp;

import java.util.*;

public class CountTotalNumberOf {

    // A memoization based recursive program to count numbers
    // with difference between odd and even digit sums as 1
    // A lookup table used for memoization.
    unsigned long long int lookup[50][1000][1000][2];
    // Memnoization based recursive function to count numbers
    // with even and odd digit sum difference as 1. This function
    // conisders leading zero as a digit
    unsigned long long int countRec(int digits, int esum,
    int osum, boolean isOdd, int n)
    {
    // Base Case
    if (digits == n)
    return (esum - osum == 1);
    // If current subproblem is already computed
    if (lookup[digits][esum][osum][isOdd] != -1)
    return lookup[digits][esum][osum][isOdd];
    // Initialize result
    unsigned long long int ans = 0;
    // If current digit is odd, then add it to odd sum and recur
    if (isOdd)
    for (int i = 0; i <= 9; i++)
    ans += countRec(digits+1, esum, osum+i, false, n);
    else // Add to even sum and recur
    for (int i = 0; i <= 9; i++)
    ans += countRec(digits+1, esum+i, osum, true, n);
    // Store current result in lookup table and return the same
    return lookup[digits][esum][osum][isOdd] = ans;
    }
    // This is mainly a wrapper over countRec. It
    // explicitly handles leading digit and calls
    // countRec() for remaining digits.
    unsigned long long int finalCount(int n)
    {
    // Initialize number digits considered so far
    int digits = 0;
    // Initialize all entries of lookup table
    memset(lookup, -1, sizeof lookup);
    // Initializa final answer
    unsigned long long int ans = 0;
    // Initialize even and odd sums
    int esum = 0, osum = 0;
    // Explicitly handle first digit and call recursive function
    // countRec for remaining digits. Note that the first digit
    // is considered as even digit.
    for (int i = 1; i <= 9; i++)
    ans += countRec(digits+1, esum + i, osum, true, n);
    return ans;
    }
    // Driver program
    int main()
    {
    int n = 3;
    System.out.print("Coutn of "<<n << " digit numbers is " << finalCount(n));
    return 0;
    }
}
