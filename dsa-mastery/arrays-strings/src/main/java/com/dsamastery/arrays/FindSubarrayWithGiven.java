package com.dsamastery.arrays;

import java.util.*;

public class FindSubarrayWithGiven {

    Method 1 (Simple)
    /* A simple program to print subarray with sum as given sum */
    /* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
    otherwise returns false. Also, prints the result */
    int subArraySum(int arr[], int n, int sum)
    {
    int curr_sum, i, j;
    // Pick a starting point
    for (i = 0; i < n; i++)
    {
    curr_sum = arr[i];
    // try all subarrays starting with 'i'
    for (j = i+1; j <= n; j++)
    {
    if (curr_sum == sum)
    {
    System.out.printf("Sum found between indexes %d and %d", i, j-1);
    return 1;
    }
    if (curr_sum > sum || j == n)
    break;
    curr_sum = curr_sum + arr[j];
    }
    }
    System.out.printf("No subarray found");
    return 0;
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
    int n = sizeof(arr)/sizeof(arr[0]);
    int sum = 23;
    subArraySum(arr, n, sum);
    return 0;
    }
    Method 2 (Eﬃcient)
    /* An efficient program to print subarray with sum as given sum */
    /* Returns true if the there is a subarray of arr[] with sum equal to 'sum'
    otherwise returns false. Also, prints the result */
    int subArraySum(int arr[], int n, int sum)
    {
    /* Initialize curr_sum as value of first element
    and starting point as 0 */
    int curr_sum = arr[0], start = 0, i;
    /* Add elements one by one to curr_sum and if the curr_sum exceeds the
    sum, then remove starting element */
    for (i = 1; i <= n; i++)
    {
    // If curr_sum exceeds the sum, then remove the starting elements
    while (curr_sum > sum && start < i-1)
    {
    curr_sum = curr_sum - arr[start];
    start++;
    }
    // If curr_sum becomes equal to sum, then return true
    if (curr_sum == sum)
    {
    System.out.printf("Sum found between indexes %d and %d", start, i-1);
    return 1;
    }
    // Add this element to curr_sum
    if (i < n)
    curr_sum = curr_sum + arr[i];
    }
    // If we reach here, then no subarray
    System.out.printf("No subarray found");
    return 0;
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {15, 2, 4, 8, 9, 5, 10, 23};
    int n = sizeof(arr)/sizeof(arr[0]);
    int sum = 23;
    subArraySum(arr, n, sum);
    return 0;
    }
}
