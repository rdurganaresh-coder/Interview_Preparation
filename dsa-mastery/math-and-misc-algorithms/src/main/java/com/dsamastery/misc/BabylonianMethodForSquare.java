package com.dsamastery.misc;

import java.util.*;

public class BabylonianMethodForSquare {

    /*Returns the square root of n. Note that the function */
    float squareRoot(float n)
    {
    /*We are using n itself as initial approximation
    This can definitely be improved */
    float x = n;
    float y = 1;
    float e = 0.000001; /* e decides the accuracy level*/
    while(x - y > e)
    {
    x = (x + y)/2;
    y = n/x;
    }
    return x;
    }
    /* Driver program to test above function*/
    int main()
    {
    int n = 50;
    System.out.printf("Square root of %d is %f", n, squareRoot(n));
    getchar();
    }
    n = 4 /*n itself is used for initial approximation*/
    /*Returns the square root of n. Note that the function
    will not work for numbers which are not perfect squares*/
    unsigned int squareRoot(int n)
    {
    int x = n;
    int y = 1;
    while(x > y)
    {
    x = (x + y)/2;
    y = n/x;
    }
    return x;
    }
    /* Driver program to test above function*/
    int main()
    {
    int n = 49;
    System.out.printf(" root of %d is %d", n, squareRoot(n));
    getchar();
    }
}
