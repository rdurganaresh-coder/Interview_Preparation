package com.dsamastery.arrays;

import java.util.*;

public class FindSumOfAll {

    mat[][] = { {1, 1, 2}
    {3, 4, 6}
    {5, 3, 2} }
    Array of Cell Indexes: {(0, 0), (1, 1), (0, 1)}
    // A structure to represent a cell index
    static class Cell
    {
    int r; // r is row, varies from 0 to R-1
    int c; // c is column, varies from 0 to C-1
    };
    // A simple solution to find sums for a given array of cell indexes
    void printSums(int mat[][C], static class Cell arr[], int n)
    {
    // Iterate through all cell indexes
    for (int i=0; i<n; i++)
    {
    int sum = 0, r = arr[i].r, c = arr[i].c;
    // Compute sum for current cell index
    for (int j=0; j<R; j++)
    for (int k=0; k<C; k++)
    if (j != r && k != c)
    sum += mat[j][k];
    System.out.println(sum);
    }
    }
    // Driver program to test above
    int main()
    {
    int mat[][C] = {{1, 1, 2}, {3, 4, 6}, {5, 3, 2}};
    static class Cell arr[] = {{0, 0}, {1, 1}, {0, 1}};
    int n = sizeof(arr)/sizeof(arr[0]);
    printSums(mat, arr, n);
    return 0;
    }
    // An efficient C++ program to compute sum for given array of cell indexes
    // A structure to represent a cell index
    static class Cell
    {
    int r; // r is row, varies from 0 to R-1
    int c; // c is column, varies from 0 to C-1
    };
    void printSums(int mat[][C], static class Cell arr[], int n)
    {
    int sum = 0;
    int row[R] = {};
    int col[C] = {};
    // Compute sum of all elements, sum of every row and sum every column
    for (int i=0; i<R; i++)
    {
    for (int j=0; j<C; j++)
    {
    sum += mat[i][j];
    col[j] += mat[i][j];
    row[i] += mat[i][j];
    }
    }
    // Compute the desired sum for all given cell indexes
    for (int i=0; i<n; i++)
    {
    int ro = arr[i].r, co = arr[i].c;
    System.out.println(sum - row[ro] - col[co] + mat[ro][co]);
    }
    }
    // Driver program to test above function
    int main()
    {
    int mat[][C] = {{1, 1, 2}, {3, 4, 6}, {5, 3, 2}};
    static class Cell arr[] = {{0, 0}, {1, 1}, {0, 1}};
    int n = sizeof(arr)/sizeof(arr[0]);
    printSums(mat, arr, n);
    return 0;
    }
}
