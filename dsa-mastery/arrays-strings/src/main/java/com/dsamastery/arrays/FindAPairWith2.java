package com.dsamastery.arrays;

import java.util.*;

public class FindAPairWith {

    METHOD 1 (Use Sorting)
    hasArrayTwoCandidates (A[], ar_size, sum)
    A = {-8, 1, 4, 6, 10, 45}
    void quickSort(int *, int, int);
    boolean hasArrayTwoCandidates(int A[], int arr_size, int sum)
    {
    int l, r;
    /* Sort the elements */
    quickSort(A, 0, arr_size-1);
    /* Now look for the two candidates in the sorted
    array*/
    l = 0;
    r = arr_size-1;
    while (l < r)
    {
    if(A[l] + A[r] == sum)
    return 1;
    else if(A[l] + A[r] < sum)
    l++;
    else // A[i] + A[j] > sum
    r--;
    }
    return 0;
    }
    /* Driver program to test above function */
    int main()
    {
    int A[] = {1, 4, 45, 6, 10, -8};
    int n = 16;
    int arr_size = 6;
    if( hasArrayTwoCandidates(A, arr_size, n))
    System.out.printf("Array has two elements with sum 16");
    else
    System.out.printf("Array doesn't have two elements with sum 16 ");
    getchar();
    return 0;
    }
    /* FOLLOWING FUNCTIONS ARE ONLY FOR SORTING
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
    quickSort(A,0,arr_size-1)
    if (A[l] + A[r] == sum):
    return 1
    else:
    return 0
    quickSort(A,si,pi-1)
    quickSort(A,pi+1,ei)
    return i+1
    if (hasArrayTwoCandidates(A, len(A), n)):
    print("Array has two elements with the given sum")
    else:
    print("Array doesn't have two elements with the given sum")
    METHOD 2 (Use Hash Map)
    1) Initialize Binary Hash Map M[] = {0, 0, …}
    void printPairs(int arr[], int arr_size, int sum)
    {
    int i, temp;
    boolean binMap[MAX] = {0}; /*initialize hash map as 0*/
    for (i = 0; i < arr_size; i++)
    {
    temp = sum - arr[i];
    if (temp >= 0 && binMap[temp] == 1)
    System.out.printf("Pair with given sum %d is (%d, %d) \n",
    sum, arr[i], temp);
    binMap[arr[i]] = 1;
    }
    }
    /* Driver program to test above function */
    int main()
    {
    int A[] = {1, 4, 45, 6, 10, 8};
    int n = 16;
    int arr_size = sizeof(A)/sizeof(A[0]);
    printPairs(A, arr_size, n);
    getchar();
    return 0;
    }
    // Java implementation using Hashing
    import java.io.*;
    class PairSum
    {
    private static final int MAX = 100000; // Max size of Hashmap
    static void printpairs(int arr[],int sum)
    {
    //Declares and initializes the whole array as false
    boolean[] binmap = new boolean[MAX];
    for (int i=0; i<arr.length; ++i)
    {
    int temp = sum-arr[i];
    //checking for condition
    if (temp>=0 && binmap[temp])
    {
    System.out.println("Pair with given sum " +
    sum + " is (" + arr[i] +
    ", "+temp+")");
    }
    binmap[arr[i]] = true;
    }
    }
    // Main to test the above function
    public static void main (String[] args)
    {
    int A[] = {1, 4, 45, 6, 10, 8};
    int n = 16;
    printpairs(A, n);
    }
    }
    // This article is contributed by Aakash Hasija
    if (temp>=0 and binmap[temp]==1):
    Pair with given sum 16 is (10, 6)
}
