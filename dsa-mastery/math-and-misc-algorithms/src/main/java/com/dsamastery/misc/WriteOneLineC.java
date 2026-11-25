package com.dsamastery.misc;

import java.util.*;

public class WriteOneLineC {

    /* Function to check if x is power of 2*/
    boolean isPowerOfTwo(int n)
    {
    if (n == 0)
    return 0;
    while (n != 1)
    {
    if (n%2 != 0)
    return 0;
    n = n/2;
    }
    return 1;
    }
    /*Driver program to test above function*/
    int main()
    {
    isPowerOfTwo(31)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(17)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(16)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(2)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(18)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(1)? System.out.printf("Yes\n"): System.out.printf("No\n");
    return 0;
    }
    /* Function to check if x is power of 2*/
    boolean isPowerOfTwo (int x)
    {
    /* First x in the below expression is for the case when x is 0 */
    return x && (!(x&(x-1)));
    }
    /*Driver program to test above function*/
    int main()
    {
    isPowerOfTwo(31)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(17)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(16)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(2)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(18)? System.out.printf("Yes\n"): System.out.printf("No\n");
    isPowerOfTwo(1)? System.out.printf("Yes\n"): System.out.printf("No\n");
    return 0;
    }
}
