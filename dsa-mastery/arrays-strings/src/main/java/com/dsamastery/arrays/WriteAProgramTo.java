package com.dsamastery.arrays;

import java.util.*;

public class WriteAProgramTo {

    /* Function to reverse arr[] from start to end*/
    void rvereseArray(int arr[], int start, int end)
    {
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
    /* Utility that prints out an array on a line */
    void printArray(int arr[], int size)
    {
    int i;
    for (i=0; i < size; i++)
    System.out.printf("%d ", arr[i]);
    System.out.printf("\n");
    }
    /* Driver function to test above functions */
    int main()
    {
    int arr[] = {1, 2, 3, 4, 5, 6};
    printArray(arr, 6);
    rvereseArray(arr, 0, 5);
    System.out.printf("Reversed array is \n");
    printArray(arr, 6);
    getchar();
    return 0;
    }
    /* Function to reverse arr[] from start to end*/
    void rvereseArray(int arr[], int start, int end)
    {
    int temp;
    if(start >= end)
    return;
    temp = arr[start];
    arr[start] = arr[end];
    arr[end] = temp;
    rvereseArray(arr, start+1, end-1);
    }
    /* Utility that prints out an array on a line */
    void printArray(int arr[], int size)
    {
    int i;
    for (i=0; i < size; i++)
    System.out.printf("%d ", arr[i]);
    System.out.printf("\n");
    }
    /* Driver function to test above functions */
    int main()
    {
    int arr[] = {1, 2, 3, 4, 5};
    printArray(arr, 5);
    rvereseArray(arr, 0, 4);
    System.out.printf("Reversed array is \n");
    printArray(arr, 5);
    getchar();
    return 0;
    }
}
