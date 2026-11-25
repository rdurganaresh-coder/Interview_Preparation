package com.dsamastery.arrays;

import java.util.*;

public class FindDuplicatesInO {

    {
    check for sign of A[abs(A[i])] ;
    if positive then
    make it negative by A[abs(A[i])]=-A[abs(A[i])];
    else // i.e., A[abs(A[i])] is negative
    this element (ith element of list) is a repetition
    }
    void printRepeating(int arr[], int size)
    {
    int i;
    System.out.printf("The repeating elements are: \n");
    for (i = 0; i < size; i++)
    {
    if (arr[abs(arr[i])] >= 0)
    arr[abs(arr[i])] = -arr[abs(arr[i])];
    else
    System.out.printf(" %d ", abs(arr[i]));
    }
    }
    int main()
    {
    int arr[] = {1, 2, 3, 1, 3, 6, 6};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
}
