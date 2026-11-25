package com.dsamastery.misc;

import java.util.*;

public class SwapBitsInA {

    swapped with 3 bits starting from 6th position (from right side)
    swapped with 2 bits starting from 4th position (from right side)
    int swapBits(unsigned int x, unsigned int p1, unsigned int p2, unsigned int n)
    {
    /* Move all bits of first set to rightmost side */
    unsigned int set1 = (x >> p1) & ((1U << n) - 1);
    /* Moce all bits of second set to rightmost side */
    unsigned int set2 = (x >> p2) & ((1U << n) - 1);
    /* XOR the two sets */
    unsigned int xor = (set1 ^ set2);
    /* Put the xor bits back to their original positions */
    xor = (xor << p1) | (xor << p2);
    /* XOR the 'xor' with the original number so that the
    two sets are swapped */
    unsigned int result = x ^ xor;
    return result;
    }
    /* Drier program to test above function*/
    int main()
    {
    int res = swapBits(28, 0, 3, 2);
    System.out.printf("\nResult = %d ", res);
    return 0;
    }
    int swapBits(unsigned int x, unsigned int p1, unsigned int p2, unsigned int n)
    {
    /* xor contains xor of two sets */
    unsigned int xor = ((x >> p1) ^ (x >> p2)) & ((1U << n) - 1);
    /* To swap two sets, we need to again XOR the xor with original sets */
    return x ^ ((xor << p1) | (xor << p2));
    }
}
