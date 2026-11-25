package com.dsamastery.arrays;

import java.util.*;

public class FindTheMaximumElement {

    Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
    Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
    Corner case (No decreasing part)
    Input: arr[] = {10, 20, 30, 40, 50}
    Corner case (No increasing part)
    Input: arr[] = {120, 100, 80, 20, 0}
    Method 1 (Linear Search)
    int findMaximum(int arr[], int low, int high)
    {
    int max = arr[low];
    int i;
    for (i = low; i <= high; i++)
    {
    if (arr[i] > max)
    max = arr[i];
    }
    return max;
    }
    /* Driver program to check above functions */
    int main()
    {
    int arr[] = {1, 30, 40, 50, 60, 70, 23, 20};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("The maximum element is %d", findMaximum(arr, 0, n-1));
    getchar();
    return 0;
    }
    Method 2 (Binary Search)
    on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
    lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}
    int findMaximum(int arr[], int low, int high)
    {
    /* Base Case: Only one element is present in arr[low..high]*/
    if (low == high)
    return arr[low];
    /* If there are two elements and first is greater then
    the first element is maximum */
    if ((high == low + 1) && arr[low] >= arr[high])
    return arr[low];
    /* If there are two elements and second is greater then
    the second element is maximum */
    if ((high == low + 1) && arr[low] < arr[high])
    return arr[high];
    int mid = (low + high)/2; /*low + (high - low)/2;*/
    /* If we reach a point where arr[mid] is greater than both of
    its adjacent elements arr[mid-1] and arr[mid+1], then arr[mid]
    is the maximum element*/
    if ( arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
    return arr[mid];
    /* If arr[mid] is greater than the next element and smaller than the previous
    element then maximum lies on left side of mid */
    if (arr[mid] > arr[mid + 1] && arr[mid] < arr[mid - 1])
    return findMaximum(arr, low, mid-1);
    else // when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
    return findMaximum(arr, mid + 1, high);
    }
    /* Driver program to check above functions */
    int main()
    {
    int arr[] = {1, 3, 50, 10, 9, 7, 6};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf("The maximum element is %d", findMaximum(arr, 0, n-1));
    getchar();
    return 0;
    }
}
