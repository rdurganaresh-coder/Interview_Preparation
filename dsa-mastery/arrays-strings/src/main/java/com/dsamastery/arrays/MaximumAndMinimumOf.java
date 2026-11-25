package com.dsamastery.arrays;

import java.util.*;

public class MaximumAndMinimumOf {

    static class pair
    {
    int min;
    int max;
    };
    METHOD 1 (Simple Linear Search)
    /* structure is used to return two values from minMax() */
    static class pair
    {
    int min;
    int max;
    };
    static class pair getMinMax(int arr[], int n)
    {
    static class pair minmax;
    int i;
    /*If there is only one element then return it as min and max both*/
    if (n == 1)
    {
    minmax.max = arr[0];
    minmax.min = arr[0];
    return minmax;
    }
    /* If there are more than one elements, then initialize min
    and max*/
    if (arr[0] > arr[1])
    {
    minmax.max = arr[0];
    minmax.min = arr[1];
    }
    else
    {
    minmax.max = arr[1];
    minmax.min = arr[0];
    }
    for (i = 2; i<n; i++)
    {
    if (arr[i] > minmax.max)
    minmax.max = arr[i];
    else if (arr[i] < minmax.min)
    minmax.min = arr[i];
    }
    return minmax;
    }
    /* Driver program to test above function */
    int main()
    {
    int arr[] = {1000, 11, 445, 1, 330, 3000};
    int arr_size = 6;
    static class pair minmax = getMinMax (arr, arr_size);
    System.out.printf("\nMinimum element is %d", minmax.min);
    System.out.printf("\nMaximum element is %d", minmax.max);
    getchar();
    }
    METHOD 2 (Tournament Method)
    Pair MaxMin(array, array_size)
    return element as both max and min
    else if arry_size = 2
    return that pair
    else /* array_size > 2 */
    return the pair of max and min
    /* structure is used to return two values from minMax() */
    static class pair
    {
    int min;
    int max;
    };
    static class pair getMinMax(int arr[], int low, int high)
    {
    static class pair minmax, mml, mmr;
    int mid;
    /* If there is only on element */
    if (low == high)
    {
    minmax.max = arr[low];
    minmax.min = arr[low];
    return minmax;
    }
    /* If there are two elements */
    if (high == low + 1)
    {
    if (arr[low] > arr[high])
    {
    minmax.max = arr[low];
    minmax.min = arr[high];
    }
    else
    {
    minmax.max = arr[high];
    minmax.min = arr[low];
    }
    return minmax;
    }
    /* If there are more than 2 elements */
    mid = (low + high)/2;
    mml = getMinMax(arr, low, mid);
    mmr = getMinMax(arr, mid+1, high);
    /* compare minimums of two parts*/
    if (mml.min < mmr.min)
    minmax.min = mml.min;
    else
    minmax.min = mmr.min;
    /* compare maximums of two parts*/
    if (mml.max > mmr.max)
    minmax.max = mml.max;
    else
    minmax.max = mmr.max;
    return minmax;
    }
    /* Driver program to test above function */
    int main()
    {
    int arr[] = {1000, 11, 445, 1, 330, 3000};
    int arr_size = 6;
    static class pair minmax = getMinMax(arr, 0, arr_size-1);
    System.out.printf("\nMinimum element is %d", minmax.min);
    System.out.printf("\nMaximum element is %d", minmax.max);
    getchar();
    }
    METHOD 3 (Compare in Pairs)
    /* structure is used to return two values from minMax() */
    static class pair
    {
    int min;
    int max;
    };
    static class pair getMinMax(int arr[], int n)
    {
    static class pair minmax;
    int i;
    /* If array has even number of elements then
    initialize the first two elements as minimum and
    maximum */
    if (n%2 == 0)
    {
    if (arr[0] > arr[1])
    {
    minmax.max = arr[0];
    minmax.min = arr[1];
    }
    else
    {
    minmax.min = arr[0];
    minmax.max = arr[1];
    }
    i = 2; /* set the startung index for loop */
    }
    /* If array has odd number of elements then
    initialize the first element as minimum and
    maximum */
    else
    {
    minmax.min = arr[0];
    minmax.max = arr[0];
    i = 1; /* set the startung index for loop */
    }
    /* In the while loop, pick elements in pair and
    compare the pair with max and min so far */
    while (i < n-1)
    {
    if (arr[i] > arr[i+1])
    {
    if(arr[i] > minmax.max)
    minmax.max = arr[i];
    if(arr[i+1] < minmax.min)
    minmax.min = arr[i+1];
    }
    else
    {
    if (arr[i+1] > minmax.max)
    minmax.max = arr[i+1];
    if (arr[i] < minmax.min)
    minmax.min = arr[i];
    }
    i += 2; /* Increment the index by 2 as two
    elements are processed in loop */
    }
    return minmax;
    }
    /* Driver program to test above function */
    int main()
    {
    int arr[] = {1000, 11, 445, 1, 330, 3000};
    int arr_size = 6;
    static class pair minmax = getMinMax (arr, arr_size);
    System.out.printf("\nMinimum element is %d", minmax.min);
    System.out.printf("\nMaximum element is %d", minmax.max);
    getchar();
    }
}
