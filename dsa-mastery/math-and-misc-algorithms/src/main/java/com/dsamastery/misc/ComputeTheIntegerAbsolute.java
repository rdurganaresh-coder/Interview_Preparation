package com.dsamastery.misc;

import java.util.*;

public class ComputeTheIntegerAbsolute {

    /* This function will return absoulte value of n*/
    unsigned int getAbs(int n)
    {
    int const mask = n >> (sizeof(int) * CHAR_BIT - 1);
    return ((n + mask) ^ mask);
    }
    /* Driver program to test above function */
    int main()
    {
    int n = -6;
    System.out.printf("Absoute value of %d is %u", n, getAbs(n));
    getchar();
    return 0;
    }
    /* This function will return absoulte value of n*/
    unsigned int getAbs(int n)
    {
    int const mask = n >> (sizeof(int) * CHAR_BIT - 1);
    return ((n ^ mask) - mask);
    }
}
