package com.dsamastery.misc;

import java.util.*;

public class WriteAnECient {

    /* Function to reverse bits of num */
    unsigned int reverseBits(unsigned int num)
    {
    unsigned int NO_OF_BITS = sizeof(num) * 8;
    unsigned int reverse_num = 0, i, temp;
    for (i = 0; i < NO_OF_BITS; i++)
    {
    temp = (num & (1 << i));
    if(temp)
    reverse_num |= (1 << ((NO_OF_BITS - 1) - i));
    }
    return reverse_num;
    }
    /* Driver function to test above function */
    int main()
    {
    unsigned int x = 2;
    System.out.printf("%u", reverseBits(x));
    getchar();
    }
    unsigned int reverseBits(unsigned int num)
    {
    unsigned int NO_OF_BITS = sizeof(num) * 8;
    unsigned int reverse_num = 0;
    int i;
    for (i = 0; i < NO_OF_BITS; i++)
    {
    if((num & (1 << i)))
    reverse_num |= 1 << ((NO_OF_BITS - 1) - i);
    }
    return reverse_num;
    }
    unsigned int reverseBits(unsigned int num)
    {
    unsigned int count = sizeof(num) * 8 - 1;
    unsigned int reverse_num = num;
    num >>= 1;
    while(num)
    {
    reverse_num <<= 1;
    reverse_num |= num & 1;
    num >>= 1;
    count--;
    }
    reverse_num <<= count;
    return reverse_num;
    }
    int main()
    {
    unsigned int x = 1;
    System.out.printf("%u", reverseBits(x));
    getchar();
    }
}
