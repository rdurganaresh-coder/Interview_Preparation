package com.dsamastery.misc;

import java.util.*;

public class NextPowerOf2 {

    Method 1(Using Log of the number)
    Method 2 (By getting the position of only set bit in result )
    /* If n is a power of 2 then return n */
    /* Now count has the position of set bit in result */
    unsigned int nextPowerOf2(unsigned int n)
    {
    unsigned count = 0;
    /* First n in the below condition is for the case where n is 0*/
    if (n && !(n&(n-1)))
    return n;
    while( n != 0)
    {
    n >>= 1;
    count += 1;
    }
    return 1<<count;
    }
    /* Driver program to test above function */
    int main()
    {
    unsigned int n = 0;
    System.out.printf("%d", nextPowerOf2(n));
    getchar();
    return 0;
    }
    Method 3(Shift result one by one)
    unsigned int nextPowerOf2(unsigned int n)
    {
    unsigned int p = 1;
    if (n && !(n & (n - 1)))
    return n;
    while (p < n) {
    p <<= 1;
    }
    return p;
    }
    /* Driver program to test above function */
    int main()
    {
    unsigned int n = 5;
    System.out.printf("%d", nextPowerOf2(n));
    getchar();
    return 0;
    }
    Method 4(Customized and Fast)
    /* Below solution works only if integer is 32 bits */
    n = n | (n >> 1);
    n = n | (n >> 2);
    n = n | (n >> 4);
    n = n | (n >> 8);
    n = n | (n >> 16);
    Let us try for 17(10001)
    /* Finds next power of two for n. If n itself
    is a power of two then returns n*/
    unsigned int nextPowerOf2(unsigned int n)
    {
    n--;
    n |= n >> 1;
    n |= n >> 2;
    n |= n >> 4;
    n |= n >> 8;
    n |= n >> 16;
    n++;
    return n;
    }
    /* Driver program to test above function */
    int main()
    {
    unsigned int n = 5;
    System.out.printf("%d", nextPowerOf2(n));
    getchar();
    return 0;
    }
}
