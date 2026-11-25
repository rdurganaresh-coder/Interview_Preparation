package com.dsamastery.misc;

import java.util.*;

public class HowToSwapTwo {

    Method 1 (Using Arithmetic Operators)
    int main()
    {
    int x = 10, y = 5;
    // Code to swap 'x' and 'y'
    x = x + y; // x now becomes 15
    y = x - y; // y becomes 10
    x = x - y; // x becomes 5
    System.out.printf("After Swapping: x = %d, y = %d", x, y);
    return 0;
    }
    int main()
    {
    int x = 10, y = 5;
    // Code to swap 'x' and 'y'
    x = x * y; // x now becomes 50
    y = x / y; // y becomes 10
    x = x / y; // x becomes 5
    System.out.printf("After Swapping: x = %d, y = %d", x, y);
    return 0;
    }
    Method 2 (Using Bitwise XOR)
    int main()
    {
    int x = 10, y = 5;
    // Code to swap 'x' (1010) and 'y' (0101)
    x = x ^ y; // x now becomes 15 (1111)
    y = x ^ y; // y becomes 10 (1010)
    x = x ^ y; // x becomes 5 (0101)
    System.out.printf("After Swapping: x = %d, y = %d", x, y);
    return 0;
    }
    // Bitwise XOR based method
    // Arithmetic based method
    void swap(int *xp, int *yp)
    {
    *xp = *xp ^ *yp;
    *yp = *xp ^ *yp;
    *xp = *xp ^ *yp;
    }
    int main()
    {
    int x = 10;
    swap(&x, &x);
    System.out.printf("After swap(&x, &x): x = %d", x);
    return 0;
    }
    void swap(int *xp, int *yp)
    {
    if (xp == yp) // Check if the two addresses are same
    return;
    *xp = *xp + *yp;
    *yp = *xp - *yp;
    *xp = *xp - *yp;
    }
    int main()
    {
    int x = 10;
    swap(&x, &x);
    System.out.printf("After swap(&x, &x): x = %d", x);
    return 0;
    }
}
