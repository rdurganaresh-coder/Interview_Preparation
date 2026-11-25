package com.dsamastery.arrays;

import java.util.*;

public class FindAFixedPoint {

    Input: arr[] = {-10, -5, 0, 3, 7}
    Input: arr[] = {0, 2, 5, 8, 17}
    Input: arr[] = {-10, -5, 3, 4, 7, 9}
    Method 1 (Linear Search)
    int linearSearch(int arr[], int n)
    {
    int i;
    for(i = 0; i < n; i++)
    {
    if(arr[i] == i)
    return i;
    }
    /* If no fixed point present then return -1 */
    return -1;
    }
    /* Driver program to check above functions */
    int main()
    {
    int arr[] = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Fixed Point is %d", linearSearch(arr, n));
    getchar();
    return 0;
    }
    Method 2 (Binary Search)
    int binarySearch(int arr[], int low, int high)
    {
    if(high >= low)
    {
    int mid = (low + high)/2; /*low + (high - low)/2;*/
    if(mid == arr[mid])
    return mid;
    if(mid > arr[mid])
    return binarySearch(arr, (mid + 1), high);
    else
    return binarySearch(arr, low, (mid -1));
    }
    /* Return -1 if there is no Fixed Point */
    return -1;
    }
    /* Driver program to check above functions */
    int main()
    {
    int arr[10] = {-10, -1, 0, 3, 10, 11, 30, 50, 100};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("Fixed Point is %d", binarySearch(arr, 0, n-1));
    getchar();
    return 0;
    }
}
