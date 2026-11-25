package com.dsamastery.arrays;

import java.util.*;

public class APancakeSortingProblem {

    // Standard Insertion Sort Loop that starts from second element
    for (i=1; i O(n)
    {
    int key = arr[i];
    // Find index of ceiling of arr[i] in arr[0..i-1] using binary search
    j = celiSearch(arr, key, 0, i-1); ----> O(logn) (See this)
    // Apply some flip operations to put arr[i] at correct place
    }
    new place, the array should be changed to {12, 15, 18, 20, 30, 35, 40, 6, 90, 80}. We apply following steps
    /* A Binary Search based function to get index of ceiling of x in
    arr[low..high] */
    int ceilSearch(int arr[], int low, int high, int x)
    {
    int mid;
    /* If x is smaller than or equal to the first element,
    then return the first element */
    if(x <= arr[low])
    return low;
    /* If x is greater than the last element, then return -1 */
    if(x > arr[high])
    return -1;
    /* get the index of middle element of arr[low..high]*/
    mid = (low + high)/2; /* low + (high – low)/2 */
    /* If x is same as middle element, then return mid */
    if(arr[mid] == x)
    return mid;
    /* If x is greater than arr[mid], then either arr[mid + 1]
    is ceiling of x, or ceiling lies in arr[mid+1...high] */
    if(arr[mid] < x)
    {
    if(mid + 1 <= high && x <= arr[mid+1])
    return mid + 1;
    else
    return ceilSearch(arr, mid+1, high, x);
    }
    /* If x is smaller than arr[mid], then either arr[mid]
    is ceiling of x or ceiling lies in arr[mid-1...high] */
    if (mid - 1 >= low && x > arr[mid-1])
    return mid;
    else
    return ceilSearch(arr, low, mid - 1, x);
    }
    /* Reverses arr[0..i] */
    void flip(int arr[], int i)
    {
    int temp, start = 0;
    while (start < i)
    {
    temp = arr[start];
    arr[start] = arr[i];
    arr[i] = temp;
    start++;
    i--;
    }
    }
    /* Function to sort an array using insertion sort, binary search and flip */
    void insertionSort(int arr[], int size)
    {
    int i, j;
    // Start from the second element and one by one insert arr[i]
    // in already sorted arr[0..i-1]
    for(i = 1; i < size; i++)
    {
    // Find the smallest element in arr[0..i-1] which is also greater than
    // or equal to arr[i]
    int j = ceilSearch(arr, 0, i-1, arr[i]);
    // Check if there was no element greater than arr[i]
    if (j != -1)
    {
    // Put arr[i] before arr[j] using following four flip operations
    flip(arr, j-1);
    flip(arr, i-1);
    flip(arr, i);
    flip(arr, j);
    }
    }
    }
    /* A utility function to print an array of size n */
    void printArray(int arr[], int n)
    {
    int i;
    for (i = 0; i < n; ++i)
    System.out.printf("%d ", arr[i]);
    }
    /* Driver program to test insertion sort */
    int main()
    {
    int arr[] = {18, 40, 35, 12, 30, 35, 20, 6, 90, 80};
    int n = sizeof(arr)/sizeof(arr[0]);
    insertionSort(arr, n);
    printArray(arr, n);
    return 0;
    }
}
