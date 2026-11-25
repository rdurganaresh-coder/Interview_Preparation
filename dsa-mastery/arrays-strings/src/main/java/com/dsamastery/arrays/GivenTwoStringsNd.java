package com.dsamastery.arrays;

import java.util.*;

public class GivenTwoStringsNd {

    // Recursive C++ program to check if a string is subsequence of another string
    // Returns true if str1[] is a subsequence of str2[]. m is
    // length of str1 and n is length of str2
    boolean isSubSequence(char str1[], char str2[], int m, int n)
    {
    // Base Cases
    if (m == 0) return true;
    if (n == 0) return false;
    // If last characters of two strings are matching
    if (str1[m-1] == str2[n-1])
    return isSubSequence(str1, str2, m-1, n-1);
    // If last characters are not matching
    return isSubSequence(str1, str2, m, n-1);
    }
    // Driver program to test methods of graph class
    int main()
    {
    char str1[] = "gksrek";
    char str2[] = "geeksforgeeks";
    int m = strlen(str1);
    int n = strlen(str2);
    isSubSequence(str1, str2, m, n)? cout << "Yes ":
    System.out.print("No");
    return 0;
    }
    // Iterative C++ program to check if a string is subsequence of another string
    // Returns true if str1[] is a subsequence of str2[]. m is
    // length of str1 and n is length of str2
    boolean isSubSequence(char str1[], char str2[], int m, int n)
    {
    int j = 0; // For index of str1 (or subsequence
    // Traverse str2 and str1, and compare current character
    // of str2 with first unmatched char of str1, if matched
    // then move ahead in str1
    for (int i=0; i<n&&j<m; i++)
    if (str1[j] == str2[i])
    j++;
    // If all characters of str1 were found in str2
    return (j==m);
    }
    // Driver program to test methods of graph class
    int main()
    {
    char str1[] = "gksrek";
    char str2[] = "geeksforgeeks";
    int m = strlen(str1);
    int n = strlen(str2);
    isSubSequence(str1, str2, m, n)? cout << "Yes ":
    System.out.print("No");
    return 0;
    }
}
