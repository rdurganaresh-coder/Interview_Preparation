package com.dsamastery.arrays;

import java.util.*;

public class CountAllDistinctPairs {

    There are 2 pairs with difference 3, the pairs are {1, 4} and {5, 2}
    {8, 12}, {12, 16} and {16, 20}
    Method 1 (Simple)
    /* A simple program to count pairs with difference k*/
    int countPairsWithDiffK(int arr[], int n, int k)
    {
    int count = 0;
    // Pick all elements one by one
    for (int i = 0; i < n; i++)
    {
    // See if there is a pair of this picked element
    for (int j = i+1; j < n; j++)
    if (arr[i] - arr[j] == k || arr[j] - arr[i] == k )
    count++;
    }
    return count;
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {1, 5, 3, 4, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    int k = 3;
    cout << "Count of pairs with given diff is "
    << countPairsWithDiffK(arr, n, k);
    return 0;
    }
    Time Complexity of O(n2)
    Method 2 (Use Sorting)
    /* A sorting based program to count pairs with difference k*/
    /* Standard binary search function */
    int binarySearch(int arr[], int low, int high, int x)
    {
    if (high >= low)
    {
    int mid = low + (high - low)/2;
    if (x == arr[mid])
    return mid;
    if (x > arr[mid])
    return binarySearch(arr, (mid + 1), high, x);
    else
    return binarySearch(arr, low, (mid -1), x);
    }
    return -1;
    }
    /* Returns count of pairs with difference k in arr[] of size n. */
    int countPairsWithDiffK(int arr[], int n, int k)
    {
    int count = 0, i;
    sort(arr, arr+n); // Sort array elements
    /* code to remove duplicates from arr[] */
    // Pick a first element point
    for (i = 0; i < n-1; i++)
    if (binarySearch(arr, i+1, n-1, arr[i] + k) != -1)
    count++;
    return count;
    }
    Method 3 (Use Self-balancing BST)
    Method 4 (Use Hashing)
    /* An efficient program to count pairs with difference k when the range
    numbers is small */
    int countPairsWithDiffK(int arr[], int n, int k)
    {
    int count = 0; // Initialize count
    // Initialize empty hashmap.
    boolean hashmap[MAX] = {false};
    // Insert array elements to hashmap
    for (int i = 0; i < n; i++)
    hashmap[arr[i]] = true;
    for (int i = 0; i < n; i++)
    {
    int x = arr[i];
    if (x - k >= 0 && hashmap[x - k])
    count++;
    if (x + k < MAX && hashmap[x + k])
    count++;
    hashmap[x] = false;
    }
    return count;
    }
    Method 5 (Use Sorting)
    return count
    /* A sorting based program to count pairs with difference k*/
    /* Returns count of pairs with difference k in arr[] of size n. */
    int countPairsWithDiffK(int arr[], int n, int k)
    {
    int count = 0;
    sort(arr, arr+n); // Sort array elements
    int l = 0;
    int r = 0;
    while(r < n)
    {
    if(arr[r] - arr[l] == k)
    {
    count++;
    l++;
    r++;
    }
    else if(arr[r] - arr[l] > k)
    l++;
    else // arr[r] - arr[l] < sum
    r++;
    }
    return count;
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {1, 5, 3, 4, 2};
    int n = sizeof(arr)/sizeof(arr[0]);
    int k = 3;
    cout << "Count of pairs with given diff is "
    << countPairsWithDiffK(arr, n, k);
    return 0;
    }
}
