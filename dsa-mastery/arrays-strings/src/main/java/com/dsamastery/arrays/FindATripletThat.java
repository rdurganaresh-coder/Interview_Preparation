package com.dsamastery.arrays;

import java.util.*;

public class FindATripletThat {

    Method 1 (Naive)
    // returns true if there is triplet with sum equal
    // to 'sum' present in A[]. Also, prints the triplet
    boolean find3Numbers(int A[], int arr_size, int sum)
    {
    int l, r;
    // Fix the first element as A[i]
    for (int i = 0; i < arr_size-2; i++)
    {
    // Fix the second element as A[j]
    for (int j = i+1; j < arr_size-1; j++)
    {
    // Now look for the third number
    for (int k = j+1; k < arr_size; k++)
    {
    if (A[i] + A[j] + A[k] == sum)
    {
    System.out.printf("Triplet is %d, %d, %d", A[i], A[j], A[k]);
    return true;
    }
    }
    }
    }
    // If we reach here, then no triplet was found
    return false;
    }
    /* Driver program to test above function */
    int main()
    {
    int A[] = {1, 4, 45, 6, 10, 8};
    int sum = 22;
    int arr_size = sizeof(A)/sizeof(A[0]);
    find3Numbers(A, arr_size, sum);
    getchar();
    return 0;
    }
    Method 2 (Use Sorting)
    // A utility function to sort an array using Quicksort
    void quickSort(int *, int, int);
    // returns true if there is triplet with sum equal
    // to 'sum' present in A[]. Also, prints the triplet
    boolean find3Numbers(int A[], int arr_size, int sum)
    {
    int l, r;
    /* Sort the elements */
    quickSort(A, 0, arr_size-1);
    /* Now fix the first element one by one and find the
    other two elements */
    for (int i = 0; i < arr_size - 2; i++)
    {
    // To find the other two elements, start two index variables
    // from two corners of the array and move them toward each
    // other
    l = i + 1; // index of the first element in the remaining elements
    r = arr_size-1; // index of the last element
    while (l < r)
    {
    if( A[i] + A[l] + A[r] == sum)
    {
    System.out.printf("Triplet is %d, %d, %d", A[i], A[l], A[r]);
    return true;
    }
    else if (A[i] + A[l] + A[r] < sum)
    l++;
    else // A[i] + A[l] + A[r] > sum
    r--;
    }
    }
    // If we reach here, then no triplet was found
    return false;
    }
    /* FOLLOWING 2 FUNCTIONS ARE ONLY FOR SORTING
    PURPOSE */
    void exchange(int *a, int *b)
    {
    int temp;
    temp = *a;
    *a = *b;
    *b = temp;
    }
    int partition(int A[], int si, int ei)
    {
    int x = A[ei];
    int i = (si - 1);
    int j;
    for (j = si; j <= ei - 1; j++)
    {
    if(A[j] <= x)
    {
    i++;
    exchange(&A[i], &A[j]);
    }
    }
    exchange (&A[i + 1], &A[ei]);
    return (i + 1);
    }
    /* Implementation of Quick Sort
    A[] --> Array to be sorted
    si --> Starting index
    ei --> Ending index
    */
    void quickSort(int A[], int si, int ei)
    {
    int pi; /* Partitioning index */
    if(si < ei)
    {
    pi = partition(A, si, ei);
    quickSort(A, si, pi - 1);
    quickSort(A, pi + 1, ei);
    }
    }
    /* Driver program to test above function */
    int main()
    {
    int A[] = {1, 4, 45, 6, 10, 8};
    int sum = 22;
    int arr_size = sizeof(A)/sizeof(A[0]);
    find3Numbers(A, arr_size, sum);
    getchar();
    return 0;
    }
}
