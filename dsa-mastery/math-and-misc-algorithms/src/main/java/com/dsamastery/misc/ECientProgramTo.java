package com.dsamastery.misc;

import java.util.*;

public class ECientProgramTo {

    for (i = n - 1, sum = 1; i > 0; --i )
    sum = 1 + x * sum / i;
    // Efficient program to calculate e raise to the power x
    //Returns approximate value of e^x using sum of first n terms of Taylor Series
    float exponential(int n, float x)
    {
    float sum = 1.0f; // initialize sum of series
    for (int i = n - 1; i > 0; --i )
    sum = 1 + x * sum / i;
    return sum;
    }
    // Driver program to test above function
    int main()
    {
    int n = 10;
    float x = 1.0f;
    System.out.printf("e^x = %f", exponential(n, x));
    return 0;
    }
}
