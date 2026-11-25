package com.dsamastery.arrays;

import java.util.*;

public class SortAnArrayAccording {

    Input: A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8}
    A2[] = {2, 1, 8, 3}
    Output: A1[] = {2, 2, 1, 1, 8, 8, 3, 5, 6, 7, 9}
    Method 1 (Using Sorting and Binary Search)
    // A C++ program to sort an array according to the order defined
    // by another array
    /* A Binary Search based function to find index of FIRST occurrence
    of x in arr[]. If x is not present, then it returns -1 */
    int first(int arr[], int low, int high, int x, int n)
    {
    if (high >= low)
    {
    int mid = low + (high-low)/2; /* (low + high)/2; */
    if ((mid == 0 || x > arr[mid-1]) && arr[mid] == x)
    return mid;
    if (x > arr[mid])
    return first(arr, (mid + 1), high, x, n);
    return first(arr, low, (mid -1), x, n);
    }
    return -1;
    }
    // Sort A1[0..m-1] according to the order defined by A2[0..n-1].
    void sortAccording(int A1[], int A2[], int m, int n)
    {
    // The temp array is used to store a copy of A1[] and visited[]
    // is used mark the visited elements in temp[].
    int temp[m], visited[m];
    for (int i=0; i<m; i++)
    {
    temp[i] = A1[i];
    visited[i] = 0;
    }
    // Sort elements in temp
    sort(temp, temp + m);
    int ind = 0; // for index of output which is sorted A1[]
    // Consider all elements of A2[], find them in temp[]
    // and copy to A1[] in order.
    for (int i=0; i<n; i++)
    {
    // Find index of the first occurrence of A2[i] in temp
    int f = first(temp, 0, m-1, A2[i], m);
    // If not present, no need to proceed
    if (f == -1) continue;
    // Copy all occurrences of A2[i] to A1[]
    for (int j = f; (j<m && temp[j]==A2[i]); j++)
    {
    A1[ind++] = temp[j];
    visited[j] = 1;
    }
    }
    // Now copy all items of temp[] which are not present in A2[]
    for (int i=0; i<m; i++)
    if (visited[i] == 0)
    A1[ind++] = temp[i];
    }
    // Utility function to print an array
    void printArray(int arr[], int n)
    {
    for (int i=0; i<n; i++)
    System.out.print(arr[i] << " ");
    System.out.print(endl);
    }
    // Driver program to test above function.
    int main()
    {
    int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
    int A2[] = {2, 1, 8, 3};
    int m = sizeof(A1)/sizeof(A1[0]);
    int n = sizeof(A2)/sizeof(A2[0]);
    System.out.print("Sorted array is \n");
    sortAccording(A1, A2, m, n);
    printArray(A1, m);
    return 0;
    }
    Method 2 (Using Self-Balancing Binary Search Tree)
    Method 3 (Use Hashing)
    Method 4 (By Writing a Customized Compare Method)
    // A C++ program to sort an array according to the order defined
    // by another array
    // A2 is made global here so that it can be accesed by compareByA2()
    // The syntax of qsort() allows only two parameters to compareByA2()
    int A2[5];
    int size = 5; // size of A2[]
    int search(int key)
    {
    int i=0, idx = 0;
    for (i=0; i<size; i++)
    if (A2[i] == key)
    return i;
    return -1;
    }
    // A custom comapre method to compare elements of A1[] according
    // to the order defined by A2[].
    int compareByA2(const void * a, const void * b)
    {
    int idx1 = search(*(int*)a);
    int idx2 = search(*(int*)b);
    if (idx1 != -1 && idx2 != -1)
    return idx1 - idx2;
    else if(idx1 != -1)
    return -1;
    else if(idx2 != -1)
    return 1;
    else
    return ( *(int*)a - *(int*)b );
    }
    // This method mainly uses qsort to sort A1[] according to A2[]
    void sortA1ByA2(int A1[], int size1)
    {
    qsort(A1, size1, sizeof (int), compareByA2);
    }
    // Driver program to test above function
    int main(int argc, char *argv[])
    {
    int A1[] = {2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8, 7, 5, 6, 9, 7, 5};
    //A2[] = {2, 1, 8, 3, 4};
    A2[0] = 2;
    A2[1] = 1;
    A2[2] = 8;
    A2[3] = 3;
    A2[4] = 4;
    int size1 = sizeof(A1)/sizeof(A1[0]);
    sortA1ByA2(A1, size1);
    System.out.printf("Sorted Array is ");
    int i;
    for (i=0; i<size1; i++)
    System.out.printf("%d ", A1[i]);
    return 0;
    }
}
