package com.dsamastery.misc;

import java.util.*;

public class SwapTwoNibblesIn {

    char in C as size of char is 1 byte in a typical C compiler. Following is C program to swap the two nibbles
    unsigned char swapNibbles(unsigned char x)
    {
    return ( (x & 0x0F)<<4 | (x & 0xF0)>>4 );
    }
    int main()
    {
    unsigned char x = 100;
    System.out.printf("%u", swapNibbles(x));
    return 0;
    }
}
