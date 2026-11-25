package com.dsamastery.dp;

import java.util.*;

public class CountNumberOfBinary {

    // The 3 strings are 00, 01, 10
    // The 5 strings are 000, 001, 010, 100, 101
    // C++ program to count all distinct binary strings
    // without two consecutive 1's
    int countStrings(int n)
    {
    int a[n], b[n];
    a[0] = b[0] = 1;
    for (int i = 1; i < n; i++)
    {
    a[i] = a[i-1] + b[i-1];
    b[i] = a[i-1];
    }
    return a[n-1] + b[n-1];
    }
    // Driver program to test above functions
    int main()
    {
    System.out.println(countStrings(3));
    return 0;
    }
}
