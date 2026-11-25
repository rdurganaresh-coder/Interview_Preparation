package com.dsamastery.arrays;

import java.util.*;

public class FindTheSmallestMissing {

    Method 1 (Use Binary Search)
    Method 2 (Linear Search)
    Method 3 (Use Modiﬁed Binary Search)
    int findFirstMissing(int array[], int start, int end) {
    if(start > end)
    return end + 1;
    if (start != array[start])
    return start;
    int mid = (start + end) / 2;
    if (array[mid] > mid)
    return findFirstMissing(array, start, mid);
    else
    return findFirstMissing(array, mid + 1, end);
    }
    // driver program to test above function
    int main()
    {
    int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.printf(" First missing element is %d",
    findFirstMissing(arr, 0, n-1));
    getchar();
    return 0;
    }
}
