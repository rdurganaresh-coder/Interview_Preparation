package com.dsamastery.arrays;

import java.util.*;

public class SortAnArrayIn {

    Input: arr[] = {10, 5, 6, 3, 2, 20, 100, 80}
    Input: arr[] = {20, 10, 8, 6, 4, 2}
    Input: arr[] = {2, 4, 6, 8, 10, 20}
    Input: arr[] = {3, 6, 5, 10, 7, 20}
    // A C++ program to sort an array in wave form using a sorting function
    // A utility method to swap two numbers.
    void swap(int *x, int *y)
    {
    int temp = *x;
    *x = *y;
    *y = temp;
    }
    // This function sorts arr[0..n-1] in wave form, i.e.,
    // arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= arr[5]..
    void sortInWave(int arr[], int n)
    {
    // Sort the input array
    sort(arr, arr+n);
    // Swap adjacent elements
    for (int i=0; i<n-1; i += 2)
    swap(&arr[i], &arr[i+1]);
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {10, 90, 49, 2, 1, 5, 23};
    int n = sizeof(arr)/sizeof(arr[0]);
    sortInWave(arr, n);
    for (int i=0; i<n; i++)
    System.out.print(arr[i] << " ");
    return 0;
    }
    // A O(n) program to sort an input array in wave form
    // A utility method to swap two numbers.
    void swap(int *x, int *y)
    {
    int temp = *x;
    *x = *y;
    *y = temp;
    }
    // This function sorts arr[0..n-1] in wave form, i.e., arr[0] >=
    // arr[1] <= arr[2] >= arr[3] <= arr[4] >= arr[5] ....
    void sortInWave(int arr[], int n)
    {
    // Traverse all even elements
    for (int i = 0; i < n; i+=2)
    {
    // If current even element is smaller than previous
    if (i>0 && arr[i-1] > arr[i] )
    swap(&arr[i], &arr[i-1]);
    // If current even element is smaller than next
    if (i<n-1 && arr[i] < arr[i+1] )
    swap(&arr[i], &arr[i + 1]);
    }
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {10, 90, 49, 2, 1, 5, 23};
    int n = sizeof(arr)/sizeof(arr[0]);
    sortInWave(arr, n);
    for (int i=0; i<n; i++)
    System.out.print(arr[i] << " ");
    return 0;
    }
    if (i> 0 and arr[i] < arr[i-1]):
    if (i < n-1 and arr[i] < arr[i+1]):
}
