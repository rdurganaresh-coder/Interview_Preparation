package com.dsamastery.misc;

import java.util.*;

public class ProgramToCountNumber {

    /* Size of array 64 K */
    /* Meta program that generates set bit count
    array of first 256 integers */
    /* GROUP_A - When combined with META_LOOK_UP
    generates count for 4x4 elements */
    /* GROUP_B - When combined with META_LOOK_UP
    generates count for 4x4x4 elements */
    /* GROUP_C - When combined with META_LOOK_UP
    generates count for 4x4x4x4 elements */
    /* Provide appropriate letter to generate the table */
    GROUP_##PARAMETER(0), \
    GROUP_##PARAMETER(1), \
    GROUP_##PARAMETER(1), \
    GROUP_##PARAMETER(2) \
    int countSetBits(int array[], size_t array_size)
    {
    int count = 0;
    /* META_LOOK_UP(C) - generates a table of 256 integers whose
    sequence will be number of bits in i-th position
    where 0 <= i < 256
    */
    /* A static table will be much faster to access */
    static unsigned char const look_up[] = { META_LOOK_UP(C) };
    /* No shifting funda (for better readability) */
    unsigned char *pData = null;
    for(size_t index = 0; index < array_size; index++)
    {
    /* It is fine, bypass the type system */
    pData = (unsigned char *)&array[index];
    /* Count set bits in individual bytes */
    count += look_up[pData[0]];
    count += look_up[pData[1]];
    count += look_up[pData[2]];
    count += look_up[pData[3]];
    }
    return count;
    }
    /* Driver program, generates table of random 64 K numbers */
    int main()
    {
    int index;
    int random[SIZE];
    /* Seed to the random-number generator */
    srand((unsigned)time(0));
    /* Generate random numbers. */
    for( index = 0; index < SIZE; index++ )
    {
    random[index] = rand();
    }
    System.out.printf("Total number of bits = %d\n", countSetBits(random, SIZE));
    return 0;
    }
}
