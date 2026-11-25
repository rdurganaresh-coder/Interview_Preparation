package com.dsamastery.arrays;

import java.util.*;

public class DynamicProgramming {

    arr[] = {1, 5, 11, 5}
    The array can be partitioned as {1, 5, 5} and {11}
    arr[] = {1, 5, 3}
    isSubsetSum (arr, n-1, sum/2 - arr[n-1])
    // A recursive solution for partition problem
    // A utility function that returns true if there is a subset of arr[]
    // with sun equal to given sum
    boolean isSubsetSum (int arr[], int n, int sum)
    {
    // Base Cases
    if (sum == 0)
    return true;
    if (n == 0 && sum != 0)
    return false;
    // If last element is greater than sum, then ignore it
    if (arr[n-1] > sum)
    return isSubsetSum (arr, n-1, sum);
    /* else, check if sum can be obtained by any of the following
    (a) including the last element
    (b) excluding the last element
    */
    return isSubsetSum (arr, n-1, sum) || isSubsetSum (arr, n-1, sum-arr[n-1]);
    }
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    boolean findPartiion (int arr[], int n)
    {
    // Calculate sum of the elements in array
    int sum = 0;
    for (int i = 0; i < n; i++)
    sum += arr[i];
    // If sum is odd, there cannot be two subsets with equal sum
    if (sum%2 != 0)
    return false;
    // Find if there is subset with sum equal to half of total sum
    return isSubsetSum (arr, n, sum/2);
    }
    // Driver program to test above function
    int main()
    {
    int arr[] = {3, 1, 5, 9, 12};
    int n = sizeof(arr)/sizeof(arr[0]);
    if (findPartiion(arr, n) == true)
    System.out.printf("Can be divided into two subsets of equal sum");
    else
    System.out.printf("Can not be divided into two subsets of equal sum");
    getchar();
    return 0;
    }
    // A Dynamic Programming solution to partition problem
    // Returns true if arr[] can be partitioned in two subsets of
    // equal sum, otherwise false
    boolean findPartiion (int arr[], int n)
    {
    int sum = 0;
    int i, j;
    // Caculcate sun of all elements
    for (i = 0; i < n; i++)
    sum += arr[i];
    if (sum%2 != 0)
    return false;
    boolean part[sum/2+1][n+1];
    // initialize top row as true
    for (i = 0; i <= n; i++)
    part[0][i] = true;
    // initialize leftmost column, except part[0][0], as 0
    for (i = 1; i <= sum/2; i++)
    part[i][0] = false;
    // Fill the partition table in botton up manner
    for (i = 1; i <= sum/2; i++)
    {
    for (j = 1; j <= n; j++)
    {
    part[i][j] = part[i][j-1];
    if (i >= arr[j-1])
    part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
    }
    }
    /* // uncomment this part to print table
    for (i = 0; i <= sum/2; i++)
    {
    for (j = 0; j <= n; j++)
    System.out.printf("%4d", part[i][j]);
    System.out.printf("\n");
    } */
    return part[sum/2][n];
    }
    // Driver program to test above funtion
    int main()
    {
    int arr[] = {3, 1, 1, 2, 2, 1};
    int n = sizeof(arr)/sizeof(arr[0]);
    if (findPartiion(arr, n) == true)
    System.out.printf("Can be divided into two subsets of equal sum");
    else
    System.out.printf("Can not be divided into two subsets of equal sum");
    getchar();
    return 0;
    }
}
