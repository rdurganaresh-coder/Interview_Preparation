package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    int fun1(int x, int y)
    {
    if(x == 0)
    return y;
    else
    return fun1(x - 1, x + y);
    }
    void fun2(int arr[], int start_index, int end_index)
    {
    if(start_index >= end_index)
    return;
    int min_index;
    int temp;
    /* Assume that minIndex() returns index of minimum value in
    array arr[start_index...end_index] */
    min_index = minIndex(arr, start_index, end_index);
    temp = arr[start_index];
    arr[start_index] = arr[min_index];
    arr[min_index] = temp;
    fun2(arr, start_index + 1, end_index);
    }
}
