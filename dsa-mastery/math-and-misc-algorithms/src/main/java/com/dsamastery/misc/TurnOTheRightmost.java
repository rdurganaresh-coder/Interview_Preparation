package com.dsamastery.misc;

import java.util.*;

public class TurnOTheRightmost {

    /* unsets the rightmost set bit of n and returns the result */
    int fun(unsigned int n)
    {
    return n&(n-1);
    }
    /* Driver program to test above function */
    int main()
    {
    int n = 7;
    System.out.printf("The number after unsetting the rightmost set bit %d", fun(n));
    getchar();
    return 0;
    }
}
