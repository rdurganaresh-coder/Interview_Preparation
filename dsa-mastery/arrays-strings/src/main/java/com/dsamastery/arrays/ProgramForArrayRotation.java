package com.dsamastery.arrays;

import java.util.*;

public class ProgramForArrayRotation {

    METHOD 1 (Use temp array)
    Time complexity O(n)
    METHOD 2 (Rotate one by one)
    leftRotate(arr[], d, n)
    /*Function to left Rotate arr[] of size n by 1*/
    void leftRotatebyOne(int arr[], int n);
    /*Function to left rotate arr[] of size n by d*/
    void leftRotate(int arr[], int d, int n)
    {
    int i;
    for (i = 0; i < d; i++)
    leftRotatebyOne(arr, n);
    }
    void leftRotatebyOne(int arr[], int n)
    {
    int i, temp;
    temp = arr[0];
    for (i = 0; i < n-1; i++)
    arr[i] = arr[i+1];
    arr[i] = temp;
    }
    /* utility function to print an array */
    void printArray(int arr[], int size)
    {
    int i;
    for(i = 0; i < size; i++)
    System.out.printf("%d ", arr[i]);
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
    METHOD 3 (A Juggling Algorithm)
    Let arr[] be {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12}
    arr[] after this step --> {4 2 3 7 5 6 10 8 9 1 11 12}
    arr[] after this step --> {4 5 3 7 8 6 10 11 9 1 2 12}
    arr[] after this step --> {4 5 6 7 8 9 10 11 12 1 2 3}
    /* function to print an array */
    void printArray(int arr[], int size);
    /*Fuction to get gcd of a and b*/
    int gcd(int a,int b);
    /*Function to left rotate arr[] of siz n by d*/
    void leftRotate(int arr[], int d, int n)
    {
    int i, j, k, temp;
    for (i = 0; i < gcd(d, n); i++)
    {
    /* move i-th values of blocks */
    temp = arr[i];
    j = i;
    while(1)
    {
    k = j + d;
    if (k >= n)
    k = k - n;
    if (k == i)
    break;
    arr[j] = arr[k];
    j = k;
    }
    arr[j] = temp;
    }
    }
    /*UTILITY FUNCTIONS*/
    /* function to print an array */
    void printArray(int arr[], int size)
    {
    int i;
    for(i = 0; i < size; i++)
    System.out.printf("%d ", arr[i]);
    }
    /*Fuction to get gcd of a and b*/
    int gcd(int a,int b)
    {
    if(b==0)
    return a;
    else
    return gcd(b, a%b);
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
