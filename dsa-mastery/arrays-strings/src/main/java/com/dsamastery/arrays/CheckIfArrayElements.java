package com.dsamastery.arrays;

import java.util.*;

public class CheckIfArrayElements {

    Method 1 (Use Sorting)
    Method 2 (Use visited array)
    /* Helper functions to get minimum and maximum in an array */
    int getMin(int arr[], int n);
    int getMax(int arr[], int n);
    /* The function checks if the array elements are consecutive
    If elements are consecutive, then returns true, else returns
    false */
    boolean areConsecutive(int arr[], int n)
    {
    if ( n < 1 )
    return false;
    /* 1) Get the minimum element in array */
    int min = getMin(arr, n);
    /* 2) Get the maximum element in array */
    int max = getMax(arr, n);
    /* 3) max - min + 1 is equal to n, then only check all elements */
    if (max - min + 1 == n)
    {
    /* Create a temp array to hold visited flag of all elements.
    Note that, calloc is used here so that all values are initialized
    as false */
    boolean *visited = (boolean *) calloc (n, sizeof(boolean));
    int i;
    for (i = 0; i < n; i++)
    {
    /* If we see an element again, then return false */
    if ( visited[arr[i] - min] != false )
    return false;
    /* If visited first time, then mark the element as visited */
    visited[arr[i] - min] = true;
    }
    /* If all elements occur once, then return true */
    return true;
    }
    return false; // if (max - min + 1 != n)
    }
    /* UTILITY FUNCTIONS */
    int getMin(int arr[], int n)
    {
    int min = arr[0];
    for (int i = 1; i < n; i++)
    if (arr[i] < min)
    min = arr[i];
    return min;
    }
    int getMax(int arr[], int n)
    {
    int max = arr[0];
    for (int i = 1; i < n; i++)
    if (arr[i] > max)
    max = arr[i];
    return max;
    }
    /* Driver program to test above functions */
    int main()
    {
    int arr[]= {5, 4, 2, 3, 1, 6};
    int n = sizeof(arr)/sizeof(arr[0]);
    if(areConsecutive(arr, n) == true)
    System.out.printf(" Array elements are consecutive ");
    else
    System.out.printf(" Array elements are not consecutive ");
    getchar();
    return 0;
    }
    Method 3 (Mark visited array elements as negative)
    each index i (where 0 #include<stdio.h> #include<stdlib.h> /* Helper functions to get minimum and
    maximum in an array */ int getMin(int arr[], int n); int getMax(int arr[], int n); /* The function checks if
    the array elements are consecutive If elements are consecutive, then returns true, else returns false */ boolean
    areConsecutive(int arr[], int n) { if ( n < 1 ) return false; /* 1) Get the minimum element in array */ int
    min = getMin(arr, n); /* 2) Get the maximum element in array */ int max = getMax(arr, n); /* 3) max –
    min + 1 is equal to n then only check all elements */ if (max – min + 1 == n) { int i; for(i = 0; i < n; i++)
    { int j; if (arr[i] < 0) j = -arr[i] – min; else j = arr[i] – min; // if the value at index j is negative then // there
    is repitition if (arr[j] > 0) arr[j] = -arr[j]; else return false; } /* If we do not see a negative value then all
    elements are distinct */ return true; } return false; // if (max – min + 1 != n) } /* UTILITY FUNCTIONS
    */ int getMin(int arr[], int n) { int min = arr[0]; for (int i = 1; i < n; i++) if (arr[i] < min) min = arr[i];
    return min; } int getMax(int arr[], int n) { int max = arr[0]; for (int i = 1; i < n; i++) if (arr[i] > max) max
    = arr[i]; return max; } /* Driver program to test above functions */ int main() { int arr[]= {1, 4, 5, 3, 2, 6};
    int n = sizeof(arr)/sizeof(arr[0]); if(areConsecutive(arr, n) == true) System.out.printf(” Array elements are consecutive
    “); else System.out.printf(” Array elements are not consecutive ”); getchar(); return 0; }
}
