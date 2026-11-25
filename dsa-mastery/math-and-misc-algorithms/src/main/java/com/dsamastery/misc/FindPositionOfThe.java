package com.dsamastery.misc;

import java.util.*;

public class FindPositionOfThe {

    // C program to find position of only set bit in a given number
    // A utility function to check whether n is power of 2 or not. See http://goo.gl/17Arj
    int isPowerOfTwo(unsigned n)
    { return n && (! (n & (n-1)) ); }
    // Returns position of the only set bit in 'n'
    int findPosition(unsigned n)
    {
    if (!isPowerOfTwo(n))
    return -1;
    unsigned i = 1, pos = 1;
    // Iterate through bits of n till we find a set bit
    // i&n will be non-zero only when 'i' and 'n' have a set bit
    // at same position
    while (!(i & n))
    {
    // Unset current bit and set the next bit in 'i'
    i = i << 1;
    // increment position
    ++pos;
    }
    return pos;
    }
    // Driver program to test above function
    int main(void)
    {
    int n = 16;
    int pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 12;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 128;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    return 0;
    }
    // C program to find position of only set bit in a given number
    // A utility function to check whether n is power of 2 or not
    int isPowerOfTwo(unsigned n)
    { return n && (! (n & (n-1)) ); }
    // Returns position of the only set bit in 'n'
    int findPosition(unsigned n)
    {
    if (!isPowerOfTwo(n))
    return -1;
    unsigned count = 0;
    // One by one move the only set bit to right till it reaches end
    while (n)
    {
    n = n >> 1;
    // increment count of shifts
    ++count;
    }
    return count;
    }
    // Driver program to test above function
    int main(void)
    {
    int n = 0;
    int pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 12;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 128;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    return 0;
    }
    unsigned int Log2n(unsigned int n)
    {
    return (n > 1)? 1 + Log2n(n/2): 0;
    }
    int isPowerOfTwo(unsigned n)
    {
    return n && (! (n & (n-1)) );
    }
    int findPosition(unsigned n)
    {
    if (!isPowerOfTwo(n))
    return -1;
    return Log2n(n) + 1;
    }
    // Driver program to test above function
    int main(void)
    {
    int n = 0;
    int pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 12;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    n = 128;
    pos = findPosition(n);
    (pos == -1)? System.out.printf("n = %d, Invalid number\n", n):
    System.out.printf("n = %d, Position %d \n", n, pos);
    return 0;
    }
}
