package com.dsamastery.arrays;

import java.util.*;

public class RearrangeAnArraySuch {

    Input: arr[] = {1, 3, 0, 2};
    Output: arr[] = {2, 0, 3, 1};
    Input: arr[] = {2, 0, 1, 4, 5, 3};
    Output: arr[] = {1, 2, 0, 5, 3, 4};
    Input: arr[] = {0, 1, 2, 3};
    Output: arr[] = {0, 1, 2, 3};
    Input: arr[] = {3, 2, 1, 0};
    Output: arr[] = {3, 2, 1, 0};
    // A simple C program to rearrange contents of arr[]
    // such that arr[j] becomes j if arr[i] is j
    // A simple method to rearrange 'arr[0..n-1]' so that 'arr[j]'
    // becomes 'i' if 'arr[i]' is 'j'
    void rearrangeNaive(int arr[], int n)
    {
    // Create an auxiliary array of same size
    int temp[n], i;
    // Store result in temp[]
    for (i=0; i<n; i++)
    temp[arr[i]] = i;
    // Copy temp back to arr[]
    for (i=0; i<n; i++)
    arr[i] = temp[i];
    }
    // A utility function to print contents of arr[0..n-1]
    void printArray(int arr[], int n)
    {
    int i;
    for (i=0; i<n; i++)
    System.out.printf("%d ", arr[i]);
    System.out.printf("\n");
    }
    // Drive program
    int main()
    {
    int arr[] = {1, 3, 0, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Given array is \n");
    printArray(arr, n);
    rearrangeNaive(arr, n);
    System.out.printf("Modified array is \n");
    printArray(arr, n);
    return 0;
    }
    // This function works only when output is a permutation
    // with one cycle.
    void rearrangeUtil(int arr[], int n)
    {
    // 'val' is the value to be stored at 'arr[i]'
    int val = 0; // The next value is determined
    // using current index
    int i = arr[0]; // The next index is determined
    // using current value
    // While all elements in cycle are not processed
    while (i != 0)
    {
    // Store value at index as it is going to be
    // used as next index
    int new_i = arr[i];
    // Update arr[]
    arr[i] = val;
    // Update value and index for next iteration
    val = i;
    i = new_i;
    }
    arr[0] = val; // Update the value at arr[0]
    }
    // A space efficient C program to rearrange contents of
    // arr[] such that arr[j] becomes j if arr[i] is j
    // A utility function to rearrange elements in the cycle
    // starting at arr[i]. This function assumes values in
    // arr[] be from 1 to n. It changes arr[j-1] to i+1
    // if arr[i-1] is j+1
    void rearrangeUtil(int arr[], int n, int i)
    {
    // 'val' is the value to be stored at 'arr[i]'
    int val = -(i+1); // The next value is determined
    // using current index
    i = arr[i] - 1; // The next index is determined
    // using current value
    // While all elements in cycle are not processed
    while (arr[i] > 0)
    {
    // Store value at index as it is going to be
    // used as next index
    int new_i = arr[i] - 1;
    // Update arr[]
    arr[i] = val;
    // Update value and index for next iteration
    val = -(i + 1);
    i = new_i;
    }
    }
    // A space efficient method to rearrange 'arr[0..n-1]'
    // so that 'arr[j]' becomes 'i' if 'arr[i]' is 'j'
    void rearrange(int arr[], int n)
    {
    // Increment all values by 1, so that all elements
    // can be made negative to mark them as visited
    int i;
    for (i=0; i<n; i++)
    arr[i]++;
    // Process all cycles
    for (i=0; i<n; i++)
    {
    // Process cycle starting at arr[i] if this cycle is
    // not already processed
    if (arr[i] > 0)
    rearrangeUtil(arr, n, i);
    }
    // Change sign and values of arr[] to get the original
    // values back, i.e., values in range from 0 to n-1
    for (i=0; i<n; i++)
    arr[i] = (-arr[i]) - 1;
    }
    // A utility function to print contents of arr[0..n-1]
    void printArray(int arr[], int n)
    {
    int i;
    for (i=0; i<n; i++)
    System.out.printf("%d ", arr[i]);
    System.out.printf("\n");
    }
    // Drive program
    int main()
    {
    int arr[] = {2, 0, 1, 4, 5, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Given array is \n");
    printArray(arr, n);
    rearrange(arr, n);
    System.out.printf("Modified array is \n");
    printArray(arr, n);
    return 0;
    }
}
