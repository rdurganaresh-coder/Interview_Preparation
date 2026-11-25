package com.dsamastery.arrays;

import java.util.*;

public class LeadersInAnArray {

    Method 1 (Simple)
    /*C++ Function to print leaders in an array */
    void printLeaders(int arr[], int size)
    {
    for (int i = 0; i < size; i++)
    {
    int j;
    for (j = i+1; j < size; j++)
    {
    if (arr[i] <= arr[j])
    break;
    }
    if (j == size) // the loop didn't break
    System.out.print(arr[i] << " ");
    }
    }
    /* Driver program to test above function */
    int main()
    {
    int arr[] = {16, 17, 4, 3, 5, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    printLeaders(arr, n);
    return 0;
    }
    Method 2 (Scan from right)
    /* C++ Function to print leaders in an array */
    void printLeaders(int arr[], int size)
    {
    int max_from_right = arr[size-1];
    /* Rightmost element is always leader */
    System.out.print(max_from_right << " ");
    for (int i = size-2; i >= 0; i--)
    {
    if (max_from_right < arr[i])
    {
    max_from_right = arr[i];
    System.out.print(max_from_right << " ");
    }
    }
    }
    /* Driver program to test above function*/
    int main()
    {
    int arr[] = {16, 17, 4, 3, 5, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    printLeaders(arr, n);
    return 0;
    }
}
