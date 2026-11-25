package com.dsamastery.misc;

import java.util.*;

public class CountSetBitsIn {

    /* Function to get no of set bits in binary
    representation of passed binary no. */
    int countSetBits(unsigned int n)
    {
    unsigned int count = 0;
    while(n)
    {
    count += n & 1;
    n >>= 1;
    }
    return count;
    }
    /* Program to test function countSetBits */
    int main()
    {
    int i = 9;
    System.out.printf("%d", countSetBits(i));
    getchar();
    return 0;
    }
    /* Function to get no of set bits in binary
    representation of passed binary no. */
    int countSetBits(int n)
    {
    unsigned int count = 0;
    while (n)
    {
    n &= (n-1) ;
    count++;
    }
    return count;
    }
    /* Program to test function countSetBits */
    int main()
    {
    int i = 9;
    System.out.printf("%d", countSetBits(i));
    getchar();
    return 0;
    }
}
