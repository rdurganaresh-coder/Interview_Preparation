package com.dsamastery.misc;

import java.util.*;

public class WriteACProgram {

    /* Function to get parity of number n. It returns 1
    if n has odd parity, and returns 0 if n has even
    parity */
    boolean getParity(unsigned int n)
    {
    boolean parity = 0;
    while (n)
    {
    parity = !parity;
    n = n & (n - 1);
    }
    return parity;
    }
    /* Driver program to test getParity() */
    int main()
    {
    unsigned int n = 7;
    System.out.printf("Parity of no %d = %s", n,
    (getParity(n)? "odd": "even"));
    getchar();
    return 0;
    }
}
