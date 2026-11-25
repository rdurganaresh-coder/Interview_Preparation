package com.dsamastery.dp;

import java.util.*;

public class RemoveMinimumElements {

    arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200}
    We need to remove 4 elements (4, 5, 100, 200)
    arr[] = {4, 7, 5, 6}
    arr[] = {20, 7, 5, 6}
    arr[] = {20, 4, 1, 3}
    // Returns minimum number of removals to be made in
    // arr[l..h]
    minRemovals(int arr[], int l, int h)
    // A utility function to find minimum of two numbers
    int min(int a, int b) {return (a < b)? a : b;}
    // A utility function to find minimum in arr[l..h]
    int min(int arr[], int l, int h)
    {
    int mn = arr[l];
    for (int i=l+1; i<=h; i++)
    if (mn > arr[i])
    mn = arr[i];
    return mn;
    }
    // A utility function to find maximum in arr[l..h]
    int max(int arr[], int l, int h)
    {
    int mx = arr[l];
    for (int i=l+1; i<=h; i++)
    if (mx < arr[i])
    mx = arr[i];
    return mx;
    }
    // Returns the minimum number of removals from either end
    // in arr[l..h] so that 2*min becomes greater than max.
    int minRemovals(int arr[], int l, int h)
    {
    // If there is 1 or less elements, return 0
    // For a single element, 2*min > max
    // (Assumption: All elements are positive in arr[])
    if (l >= h) return 0;
    // 1) Find minimum and maximum in arr[l..h]
    int mn = min(arr, l, h);
    int mx = max(arr, l, h);
    //If the property is followed, no removals needed
    if (2*mn > mx)
    return 0;
    // Otherwise remove a character from left end and recur,
    // then remove a character from right end and recur, take
    // the minimum of two is returned
    return min(minRemovals(arr, l+1, h),
    minRemovals(arr, l, h-1)) + 1;
    }
    // Driver program to test above functions
    int main()
    {
    int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.print(minRemovals(arr, 0, n-1));
    return 0;
    }
    // A utility function to find minimum of two numbers
    int min(int a, int b) {return (a < b)? a : b;}
    // A utility function to find minimum in arr[l..h]
    int min(int arr[], int l, int h)
    {
    int mn = arr[l];
    for (int i=l+1; i<=h; i++)
    if (mn > arr[i])
    mn = arr[i];
    return mn;
    }
    // A utility function to find maximum in arr[l..h]
    int max(int arr[], int l, int h)
    {
    int mx = arr[l];
    for (int i=l+1; i<=h; i++)
    if (mx < arr[i])
    mx = arr[i];
    return mx;
    }
    // Returns the minimum number of removals from either end
    // in arr[l..h] so that 2*min becomes greater than max.
    int minRemovalsDP(int arr[], int n)
    {
    // Create a table to store solutions of subproblems
    int table[n][n], gap, i, j, mn, mx;
    // Fill table using above recursive formula. Note that the table
    // is filled in diagonal fashion (similar to http://goo.gl/PQqoS),
    // from diagonal elements to table[0][n-1] which is the result.
    for (gap = 0; gap < n; ++gap)
    {
    for (i = 0, j = gap; j < n; ++i, ++j)
    {
    mn = min(arr, i, j);
    mx = max(arr, i, j);
    table[i][j] = (2*mn > mx)? 0: min(table[i][j-1]+1,
    table[i+1][j]+1);
    }
    }
    return table[0][n-1];
    }
    // Driver program to test above functions
    int main()
    {
    int arr[] = {20, 4, 1, 3};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.print(minRemovalsDP(arr, n));
    return 0;
    }
    // A O(n*n) solution to find the minimum of elements to
    // be removed
    // Returns the minimum number of removals from either end
    // in arr[l..h] so that 2*min becomes greater than max.
    int minRemovalsDP(int arr[], int n)
    {
    // Initialize starting and ending indexes of the maximum
    // sized subarray with property 2*min > max
    int longest_start = -1, longest_end = 0;
    // Choose different elements as starting point
    for (int start=0; start<n; start++)
    {
    // Initialize min and max for the current start
    int min = INT_MAX, max = INT_MIN;
    // Choose different ending points for current start
    for (int end = start; end < n; end ++)
    {
    // Update min and max if necessary
    int val = arr[end];
    if (val < min) min = val;
    if (val > max) max = val;
    // If the property is violated, then no
    // point to continue for a bigger array
    if (2 * min <= max) break;
    // Update longest_start and longest_end if needed
    if (end - start > longest_end - longest_start ||
    longest_start == -1)
    {
    longest_start = start;
    longest_end = end;
    }
    }
    }
    // If not even a single element follow the property,
    // then return n
    if (longest_start == -1) return n;
    // Return the number of elements to be removed
    return (n - (longest_end - longest_start + 1));
    }
    // Driver program to test above functions
    int main()
    {
    int arr[] = {4, 5, 100, 9, 10, 11, 12, 15, 200};
    int n = sizeof(arr)/sizeof(arr[0]);
    System.out.print(minRemovalsDP(arr, n));
    return 0;
    }
}
