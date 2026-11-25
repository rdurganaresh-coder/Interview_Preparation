package com.dsamastery.misc;

import java.util.*;

public class FindWhetherAGiven {

    /* Function to check if x is power of 4*/
    boolean isPowerOfFour(int n)
    {
    if(n == 0)
    return 0;
    while(n != 1)
    {
    if(n%4 != 0)
    return 0;
    n = n/4;
    }
    return 1;
    }
    /*Driver program to test above function*/
    int main()
    {
    int test_no = 64;
    if(isPowerOfFour(test_no))
    System.out.printf("%d is a power of 4", test_no);
    else
    System.out.printf("%d is not a power of 4", test_no);
    getchar();
    }
    boolean isPowerOfFour(unsigned int n)
    {
    int count = 0;
    /*Check if there is only one bit set in n*/
    if ( n && !(n&(n-1)) )
    {
    /* count 0 bits before set bit */
    while(n > 1)
    {
    n >>= 1;
    count += 1;
    }
    /*If count is even then return true else false*/
    return (count%2 == 0)? 1 :0;
    }
    /* If there are more than 1 bit set
    then n is not a power of 4*/
    return 0;
    }
    /*Driver program to test above function*/
    int main()
    {
    int test_no = 64;
    if(isPowerOfFour(test_no))
    System.out.printf("%d is a power of 4", test_no);
    else
    System.out.printf("%d is not a power of 4", test_no);
    getchar();
    }
}
