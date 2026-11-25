package com.dsamastery.misc;

import java.util.*;

public class RotateBitsOfA {

    /*Function to left rotate n by d bits*/
    int leftRotate(int n, unsigned int d)
    {
    /* In n<<d, last d bits are 0. To put first 3 bits of n at
    last, do bitwise or of n<<d with n >>(INT_BITS - d) */
    return (n << d)|(n >> (INT_BITS - d));
    }
    /*Function to right rotate n by d bits*/
    int rightRotate(int n, unsigned int d)
    {
    /* In n>>d, first d bits are 0. To put last 3 bits of at
    first, do bitwise or of n>>d with n <<(INT_BITS - d) */
    return (n >> d)|(n << (INT_BITS - d));
    }
    /* Driver program to test above functions */
    int main()
    {
    int n = 16;
    int d = 2;
    System.out.printf("Left Rotation of %d by %d is ", n, d);
    System.out.printf("%d", leftRotate(n, d));
    System.out.printf("\nRight Rotation of %d by %d is ", n, d);
    System.out.printf("%d", rightRotate(n, d));
    getchar();
    }
}
