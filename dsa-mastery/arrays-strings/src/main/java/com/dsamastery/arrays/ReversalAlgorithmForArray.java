package com.dsamastery.arrays;

import java.util.*;

public class ReversalAlgorithmForArray {

    Method 4(The Reversal Algorithm)
    rotate(arr[], d, n)
    reverse(arr[], 1, d) ;
    reverse(arr[], d + 1, n);
    reverse(arr[], l, n);
    Reverse A to get ArB. /* Ar is reverse of A */
    Reverse B to get ArBr. /* Br is reverse of B */
    /*Utility function to print an array */
    void printArray(int arr[], int size);
    /* Utility function to reverse arr[] from start to end */
    void rvereseArray(int arr[], int start, int end);
    /* Function to left rotate arr[] of size n by d */
    void leftRotate(int arr[], int d, int n)
    {
    rvereseArray(arr, 0, d-1);
    rvereseArray(arr, d, n-1);
    rvereseArray(arr, 0, n-1);
    }
    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    void printArray(int arr[], int size)
    {
    int i;
    for(i = 0; i < size; i++)
    System.out.printf("%d ", arr[i]);
    System.out.printf("%\n ");
    }
    /*Function to reverse arr[] from index start to end*/
    void rvereseArray(int arr[], int start, int end)
    {
    int i;
    int temp;
    while(start < end)
    {
    temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    start++;
    end--;
    }
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[] = {1, 2, 3, 4, 5, 6, 7};
    leftRotate(arr, 2, 7);
    printArray(arr, 7);
    getchar();
    return 0;
    }
}
