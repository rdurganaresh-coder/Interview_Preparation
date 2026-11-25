package com.dsamastery.misc;

import java.util.*;

public class ComputeTheMinimumOr {

    /* The obvious approach to find minimum (involves branching) */
    int min(int x, int y)
    {
    return (x < y) ? x : y
    }
    Method 1(Use XOR and comparison operator)
    /*Function to find minimum of x and y*/
    int min(int x, int y)
    {
    return y ^ ((x ^ y) & -(x < y));
    }
    /*Function to find maximum of x and y*/
    int max(int x, int y)
    {
    return x ^ ((x ^ y) & -(x < y));
    }
    /* Driver program to test above functions */
    int main()
    {
    int x = 15;
    int y = 6;
    System.out.printf("Minimum of %d and %d is ", x, y);
    System.out.printf("%d", min(x, y));
    System.out.printf("\nMaximum of %d and %d is ", x, y);
    System.out.printf("%d", max(x, y));
    getchar();
    }
    Method 2(Use subtraction and shift)
    /*Function to find minimum of x and y*/
    int min(int x, int y)
    {
    return y + ((x - y) & ((x - y) >>
    (sizeof(int) * CHAR_BIT - 1)));
    }
    /*Function to find maximum of x and y*/
    int max(int x, int y)
    {
    return x - ((x - y) & ((x - y) >>
    (sizeof(int) * CHAR_BIT - 1)));
    }
    /* Driver program to test above functions */
    int main()
    {
    int x = 15;
    int y = 6;
    System.out.printf("Minimum of %d and %d is ", x, y);
    System.out.printf("%d", min(x, y));
    System.out.printf("\nMaximum of %d and %d is ", x, y);
    System.out.printf("%d", max(x, y));
    getchar();
    }
}
