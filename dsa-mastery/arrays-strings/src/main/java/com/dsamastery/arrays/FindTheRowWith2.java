package com.dsamastery.arrays;

import java.util.*;

public class FindTheRowWith {

    /* A function to find the index of first index of 1 in a boolean array arr[] */
    int first(boolean arr[], int low, int high)
    {
    if(high >= low)
    {
    // get the middle index
    int mid = low + (high - low)/2;
    // check if the element at middle index is first 1
    if ( ( mid == 0 || arr[mid-1] == 0) && arr[mid] == 1)
    return mid;
    // if the element is 0, recur for right side
    else if (arr[mid] == 0)
    return first(arr, (mid + 1), high);
    else // If element is not first 1, recur for left side
    return first(arr, low, (mid -1));
    }
    return -1;
    }
    // The main function that returns index of row with maximum number of 1s.
    int rowWithMax1s(boolean mat[R][C])
    {
    int max_row_index = 0, max = -1; // Initialize max values
    // Traverse for each row and count number of 1s by finding the index
    // of first 1
    int i, index;
    for (i = 0; i < R; i++)
    {
    index = first (mat[i], 0, C-1);
    if (index != -1 && C-index > max)
    {
    max = C - index;
    max_row_index = i;
    }
    }
    return max_row_index;
    }
    /* Driver program to test above functions */
    int main()
    {
    boolean mat[R][C] = { {0, 0, 0, 1},
    {0, 1, 1, 1},
    {1, 1, 1, 1},
    {0, 0, 0, 0}
    };
    System.out.printf("Index of row with maximum 1s is %d \n", rowWithMax1s(mat));
    return 0;
    }
    // The main function that returns index of row with maximum number of 1s.
    int rowWithMax1s(boolean mat[R][C])
    {
    int i, index;
    // Initialize max using values from first row.
    int max_row_index = 0;
    int max = C - first(mat[0], 0, C-1);
    // Traverse for each row and count number of 1s by finding the index
    // of first 1
    for (i = 1; i < R; i++)
    {
    // Count 1s in this row only if this row has more 1s than
    // max so far
    if (mat[i][C-max-1] == 1)
    {
    // Note the optimization here also
    index = first (mat[i], 0, C-max);
    if (index != -1 && C-index > max)
    {
    max = C - index;
    max_row_index = i;
    }
    }
    }
    return max_row_index;
    }
    // The main function that returns index of row with maximum number of 1s.
    int rowWithMax1s(boolean mat[R][C])
    {
    // Initialize first row as row with max 1s
    int max_row_index = 0;
    // The function first() returns index of first 1 in row 0.
    // Use this index to initialize the index of leftmost 1 seen so far
    int j = first(mat[0], 0, C-1) - 1;
    if (j == -1) // if 1 is not present in first row
    j = C - 1;
    for (int i = 1; i < R; i++)
    {
    // Move left until a 0 is found
    while (j >= 0 && mat[i][j] == 1)
    {
    j = j-1; // Update the index of leftmost 1 seen so far
    max_row_index = i; // Update max_row_index
    }
    }
    return max_row_index;
    }
}
