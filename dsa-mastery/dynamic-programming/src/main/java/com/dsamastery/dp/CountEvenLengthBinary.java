package com.dsamastery.dp;

import java.util.*;

public class CountEvenLengthBinary {

    // When first and last bits are same
    // there are two cases, 00 and 11
    // When first bit is 1 and last bit is 0
    // When first bit is 0 and last bit is 1
    count(n-1, diff+1)
    // When n == 1 (2 bit sequences)
    // We can't cover difference of more than n with 2n bits
    // A Naive Recursive C++ program to count even
    // length binary sequences such that the sum of
    // first and second half bits is same
    // diff is difference between sums first n bits
    // and last n bits respectively
    int countSeq(int n, int diff)
    {
    // We can't cover difference of more
    // than n with 2n bits
    if (abs(diff) > n)
    return 0;
    // n == 1, i.e., 2 bit long sequences
    if (n == 1 && diff == 0)
    return 2;
    if (n == 1 && abs(diff) == 1)
    return 1;
    int res = // First bit is 0 & last bit is 1
    countSeq(n-1, diff+1) +
    // First and last bits are same
    2*countSeq(n-1, diff) +
    // First bit is 1 & last bit is 0
    countSeq(n-1, diff-1);
    return res;
    }
    // Driver program
    int main()
    {
    int n = 2;
    cout << "Count of sequences is "
    << countSeq(2, 0);
    return 0;
    }
    // A memoization based C++ program to count even
    // length binary sequences such that the sum of
    // first and second half bits is same
    // A lookup table to store the results of subproblems
    int lookup[MAX][MAX];
    // dif is diference between sums of first n bits
    // and last n bits i.e., dif = (Sum of first n bits) -
    // (Sum of last n bits)
    int countSeqUtil(int n, int dif)
    {
    // We can't cover diference of more
    // than n with 2n bits
    if (abs(dif) > n)
    return 0;
    // n == 1, i.e., 2 bit long sequences
    if (n == 1 && dif == 0)
    return 2;
    if (n == 1 && abs(dif) == 1)
    return 1;
    // Check if this subbproblem is already solved
    // n is added to dif to make sure index becomes
    // positive
    if (lookup[n][n+dif] != -1)
    return lookup[n][n+dif];
    int res = // First bit is 0 & last bit is 1
    countSeqUtil(n-1, dif+1) +
    // First and last bits are same
    2*countSeqUtil(n-1, dif) +
    // First bit is 1 & last bit is 0
    countSeqUtil(n-1, dif-1);
    // Store result in lookup table and return the result
    return lookup[n][n+dif] = res;
    }
    // A Wrapper over countSeqUtil(). It mainly initializes lookup
    // table, then calls countSeqUtil()
    int countSeq(int n)
    {
    // Initialize all entries of lookup table as not filled
    memset(lookup, -1, sizeof(lookup));
    // call countSeqUtil()
    return countSeqUtil(n, 0);
    }
    // Driver program
    int main()
    {
    int n = 2;
    cout << "Count of sequences is "
    << countSeq(2);
    return 0;
    }
    // A O(n) C++ program to count even length binary sequences
    // such that the sum of first and second half bits is same
    // Returns the count of even length sequences
    int countSeq(int n)
    {
    int nCr=1, res = 1;
    // Calculate SUM ((nCr)^2)
    for (int r = 1; r<=n ; r++)
    {
    // Compute nCr using nC(r-1)
    // nCr/nC(r-1) = (n+1-r)/r;
    nCr = (nCr * (n+1-r))/r;
    res += nCr*nCr;
    }
    return res;
    }
    // Driver program
    int main()
    {
    int n = 3;
    cout << "Count of sequences is "
    << countSeq(n);
    return 0;
    }
}
