package com.dsamastery.sorting;

import java.util.*;

public class AProblemInMany {

    // A iterative binary search function. It returns location of x in
    // given array arr[l..r] if present, otherwise -1
    int binarySearch(int arr[], int l, int r, int x)
    {
    while (l <= r)
    {
    // find index of middle element
    int m = (l+r)/2;
    // Check if x is present at mid
    if (arr[m] == x) return m;
    // If x greater, ignore left half
    if (arr[m] < x) l = m + 1;
    // If x is smaller, ignore right half
    else r = m - 1;
    }
    // if we reach here, then element was not present
    return -1;
    }
    int mid = low + ((high - low) / 2);
    int mid = (low + high) >>> 1;
    int main()
    {
    int arr[1<<30];
    return 0;
    }
    int main()
    {
    boolean arr[1<<30];
    return 0;
    }
}
