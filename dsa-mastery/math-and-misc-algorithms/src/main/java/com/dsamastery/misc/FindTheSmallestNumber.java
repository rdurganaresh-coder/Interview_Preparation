package com.dsamastery.misc;

import java.util.*;

public class FindTheSmallestNumber {

    // Note that 4*9 = 36 and 49 is the smallest such number
    // Note that 4*5*5 = 100 and 455 is the smallest such number
    // Note that 1*1 = 1
    // Maximum number of digits in output
    // prints the smallest number whose digits multiply to n
    void findSmallest(int n)
    {
    int i, j=0;
    int res[MAX]; // To sore digits of result in reverse order
    // Case 1: If number is smaller than 10
    if (n < 10)
    {
    System.out.printf("%d", n+10);
    return;
    }
    // Case 2: Start with 9 and try every possible digit
    for (i=9; i>1; i--)
    {
    // If current digit divides n, then store all
    // occurrences of current digit in res
    while (n%i == 0)
    {
    n = n/i;
    res[j] = i;
    j++;
    }
    }
    // If n could not be broken in form of digits (prime factors of n
    // are greater than 9)
    if (n > 10)
    {
    System.out.printf("Not possible");
    return;
    }
    // Print the result array in reverse order
    for (i=j-1; i>=0; i--)
    System.out.printf("%d", res[i]);
    }
    // Driver program to test above function
    int main()
    {
    findSmallest(7);
    System.out.printf("\n");
    findSmallest(36);
    System.out.printf("\n");
    findSmallest(13);
    System.out.printf("\n");
    findSmallest(100);
    return 0;
    }
}
