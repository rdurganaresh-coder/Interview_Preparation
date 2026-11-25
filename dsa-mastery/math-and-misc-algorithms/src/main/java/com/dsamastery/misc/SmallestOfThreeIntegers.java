package com.dsamastery.misc;

import java.util.*;

public class SmallestOfThreeIntegers {

    Method 1 (Repeated Subtraction)
    int smallest(int x, int y, int z)
    {
    int c = 0;
    while ( x && y && z )
    {
    x--; y--; z--; c++;
    }
    return c;
    }
    int main()
    {
    int x = 12, y = 15, z = 5;
    System.out.printf("Minimum of 3 numbers is %d", smallest(x, y, z));
    return 0;
    }
    Method 2 (Use Bit Operations)
    // See mthod 2 of http://www.geeksforgeeks.org/archives/2643
    /*Function to find minimum of x and y*/
    int min(int x, int y)
    {
    return y + ((x - y) & ((x - y) >>
    (sizeof(int) * CHAR_BIT - 1)));
    }
    /* Function to find minimum of 3 numbers x, y and z*/
    int smallest(int x, int y, int z)
    {
    return min(x, min(y, z));
    }
    int main()
    {
    int x = 12, y = 15, z = 5;
    System.out.printf("Minimum of 3 numbers is %d", smallest(x, y, z));
    return 0;
    }
    Method 3 (Use Division operator)
    // Using division operator to find minimum of three numbers
    int smallest(int x, int y, int z)
    {
    if (!(y/x)) // Same as "if (y < x)"
    return (!(y/z))? y : z;
    return (!(x/z))? x : z;
    }
    int main()
    {
    int x = 78, y = 88, z = 68;
    System.out.printf("Minimum of 3 numbers is %d", smallest(x, y, z));
    return 0;
    }
}
