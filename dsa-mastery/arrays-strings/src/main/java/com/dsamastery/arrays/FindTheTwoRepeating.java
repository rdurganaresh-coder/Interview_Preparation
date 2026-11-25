package com.dsamastery.arrays;

import java.util.*;

public class FindTheTwoRepeating {

    Method 1 (Basic)
    void printRepeating(int arr[], int size)
    {
    int i, j;
    System.out.printf(" Repeating elements are ");
    for(i = 0; i < size; i++)
    for(j = i+1; j < size; j++)
    if(arr[i] == arr[j])
    System.out.printf(" %d ", arr[i]);
    }
    int main()
    {
    int arr[] = {4, 2, 4, 5, 2, 3, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
    Method 2 (Use Count array)
    void printRepeating(int arr[], int size)
    {
    int *count = (int *)calloc(sizeof(int), (size - 2));
    int i;
    System.out.printf(" Repeating elements are ");
    for(i = 0; i < size; i++)
    {
    if(count[arr[i]] == 1)
    System.out.printf(" %d ", arr[i]);
    else
    count[arr[i]]++;
    }
    }
    int main()
    {
    int arr[] = {4, 2, 4, 5, 2, 3, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
    Method 3 (Make two equations)
    /* function to get factorial of n */
    int fact(int n);
    void printRepeating(int arr[], int size)
    {
    int S = 0; /* S is for sum of elements in arr[] */
    int P = 1; /* P is for product of elements in arr[] */
    int x, y; /* x and y are two repeating elements */
    int D; /* D is for difference of x and y, i.e., x-y*/
    int n = size - 2, i;
    /* Calculate Sum and Product of all elements in arr[] */
    for(i = 0; i < size; i++)
    {
    S = S + arr[i];
    P = P*arr[i];
    }
    S = S - n*(n+1)/2; /* S is x + y now */
    P = P/fact(n); /* P is x*y now */
    D = sqrt(S*S - 4*P); /* D is x - y now */
    x = (D + S)/2;
    y = (S - D)/2;
    System.out.printf("The two Repeating elements are %d & %d", x, y);
    }
    int fact(int n)
    {
    return (n == 0)? 1 : n*fact(n-1);
    }
    int main()
    {
    int arr[] = {4, 2, 4, 5, 2, 3, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
    Method 4 (Use XOR)
    void printRepeating(int arr[], int size)
    {
    int xor = arr[0]; /* Will hold xor of all elements */
    int set_bit_no; /* Will have only single set bit of xor */
    int i;
    int n = size - 2;
    int x = 0, y = 0;
    /* Get the xor of all elements in arr[] and {1, 2 .. n} */
    for(i = 1; i < size; i++)
    xor ^= arr[i];
    for(i = 1; i <= n; i++)
    xor ^= i;
    /* Get the rightmost set bit in set_bit_no */
    set_bit_no = xor & ~(xor-1);
    /* Now divide elements in two sets by comparing rightmost set
    bit of xor with bit at same position in each element. */
    for(i = 0; i < size; i++)
    {
    if(arr[i] & set_bit_no)
    x = x ^ arr[i]; /*XOR of first set in arr[] */
    else
    y = y ^ arr[i]; /*XOR of second set in arr[] */
    }
    for(i = 1; i <= n; i++)
    {
    if(i & set_bit_no)
    x = x ^ i; /*XOR of first set in arr[] and {1, 2, ...n }*/
    else
    y = y ^ i; /*XOR of second set in arr[] and {1, 2, ...n } */
    }
    System.out.printf("\n The two repeating elements are %d & %d ", x, y);
    }
    int main()
    {
    int arr[] = {4, 2, 4, 5, 2, 3, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
    Method 5 (Use array elements as index)
    {
    check for sign of A[abs(A[i])] ;
    if positive then
    make it negative by A[abs(A[i])]=-A[abs(A[i])];
    else // i.e., A[abs(A[i])] is negative
    this element (ith element of list) is a repetition
    }
    Example: A[] = {1, 1, 2, 3, 2}
    i=0;
    Array now becomes {1, -1, 2, 3, 2}
    i=1;
    i=2;
    Array now becomes {1, -1, -2, 3, 2}
    i=3;
    Array now becomes {1, -1, -2, -3, 2}
    i=4;
    void printRepeating(int arr[], int size)
    {
    int i;
    System.out.printf("\n The repeating elements are");
    for(i = 0; i < size; i++)
    {
    if(arr[abs(arr[i])] > 0)
    arr[abs(arr[i])] = -arr[abs(arr[i])];
    else
    System.out.printf(" %d ", abs(arr[i]));
    }
    }
    int main()
    {
    int arr[] = {1, 3, 2, 2, 1};
    int arr_size = sizeof(arr)/sizeof(arr[0]);
    printRepeating(arr, arr_size);
    getchar();
    return 0;
    }
}
