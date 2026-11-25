package com.dsamastery.arrays;

import java.util.*;

public class FindAPairWith {

    // The function assumes that the array is sorted
    boolean findPair(int arr[], int size, int n)
    {
    // Initialize positions of two elements
    int i = 0;
    int j = 1;
    // Search for a pair
    while (i<size && j<size)
    {
    if (i != j && arr[j]-arr[i] == n)
    {
    System.out.printf("Pair Found: (%d, %d)", arr[i], arr[j]);
    return true;
    }
    else if (arr[j]-arr[i] < n)
    j++;
    else
    i++;
    }
    System.out.printf("No such pair");
    return false;
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {1, 8, 30, 40, 100};
    int size = sizeof(arr)/sizeof(arr[0]);
    int n = 60;
    findPair(arr, size, n);
    return 0;
    }
}
