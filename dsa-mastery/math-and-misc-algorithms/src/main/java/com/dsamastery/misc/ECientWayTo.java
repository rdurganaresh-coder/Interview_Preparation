package com.dsamastery.misc;

import java.util.*;

public class ECientWayTo {

    int multiplyBySeven(unsigned int n)
    {
    /* Note the inner bracket here. This is needed
    because precedence of '-' operator is higher
    than '<<' */
    return ((n<<3) - n);
    }
    /* Driver program to test above function */
    int main()
    {
    unsigned int n = 4;
    System.out.printf("%u", multiplyBySeven(n));
    getchar();
    return 0;
    }
}
