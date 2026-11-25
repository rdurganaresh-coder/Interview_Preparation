package com.dsamastery.misc;

import java.util.*;

public class CheckIfBinaryRepresentation {

    return false.
    isPalindrome(x)
    // This function returns true if k'th bit in x is set (or 1).
    // For example if x (0010) is 2 and k is 2, then it returns true
    boolean isKthBitSet(unsigned int x, unsigned int k)
    {
    return (x & (1 << (k-1)))? true: false;
    }
    // This function returns true if binary representation of x is
    // palindrome. For example (1000...001) is paldindrome
    boolean isPalindrome(unsigned int x)
    {
    int l = 1; // Initialize left position
    int r = sizeof(unsigned int)*8; // initialize right position
    // One by one compare bits
    while (l < r)
    {
    if (isKthBitSet(x, l) != isKthBitSet(x, r))
    return false;
    l++; r--;
    }
    return true;
    }
    // Driver program to test above function
    int main()
    {
    unsigned int x = 1<<15 + 1<<16;
    System.out.println(isPalindrome(x));
    x = 1<<31 + 1;
    System.out.println(isPalindrome(x));
    return 0;
    }
}
