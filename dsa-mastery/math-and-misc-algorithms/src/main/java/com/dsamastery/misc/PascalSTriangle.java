package com.dsamastery.misc;

import java.util.*;

public class PascalSTriangle {

    // A simple O(n^3) program for Pascal's Triangle
    // See http://www.geeksforgeeks.org/archives/25621 for details of this function
    int binomialCoeff(int n, int k);
    // Function to print first n lines of Pascal's Triangle
    void printPascal(int n)
    {
    // Iterate through every line and print entries in it
    for (int line = 0; line < n; line++)
    {
    // Every line has number of integers equal to line number
    for (int i = 0; i <= line; i++)
    System.out.printf("%d ", binomialCoeff(line, i));
    System.out.printf("\n");
    }
    }
    // See http://www.geeksforgeeks.org/archives/25621 for details of this function
    int binomialCoeff(int n, int k)
    {
    int res = 1;
    if (k > n - k)
    k = n - k;
    for (int i = 0; i < k; ++i)
    {
    res *= (n - i);
    res /= (i + 1);
    }
    return res;
    }
    // Driver program to test above function
    int main()
    {
    int n = 7;
    printPascal(n);
    return 0;
    }
    // A O(n^2) time and O(n^2) extra space method for Pascal's Triangle
    void printPascal(int n)
    {
    int arr[n][n]; // An auxiliary array to store generated pscal triangle values
    // Iterate through every line and print integer(s) in it
    for (int line = 0; line < n; line++)
    {
    // Every line has number of integers equal to line number
    for (int i = 0; i <= line; i++)
    {
    // First and last values in every row are 1
    if (line == i || i == 0)
    arr[line][i] = 1;
    else // Other values are sum of values just above and left of above
    arr[line][i] = arr[line-1][i-1] + arr[line-1][i];
    System.out.printf("%d ", arr[line][i]);
    }
    System.out.printf("\n");
    }
    }
    // A O(n^2) time and O(1) extra space function for Pascal's Triangle
    void printPascal(int n)
    {
    for (int line = 1; line <= n; line++)
    {
    int C = 1; // used to represent C(line, i)
    for (int i = 1; i <= line; i++)
    {
    System.out.printf("%d ", C); // The first value in a line is always 1
    C = C * (line - i) / i;
    }
    System.out.printf("\n");
    }
    }
}
