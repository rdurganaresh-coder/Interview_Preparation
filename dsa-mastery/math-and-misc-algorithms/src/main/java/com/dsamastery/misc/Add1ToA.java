package com.dsamastery.misc;

import java.util.*;

public class Add1ToA {

    int addOne(int x)
    {
    int m = 1;
    /* Flip all the set bits until we find a 0 */
    while( x & m )
    {
    x = x^m;
    m <<= 1;
    }
    /* flip the rightmost 0 bit */
    x = x^m;
    return x;
    }
    /* Driver program to test above functions*/
    int main()
    {
    System.out.printf("%d", addOne(13));
    getchar();
    return 0;
    }
    int addOne(int x)
    {
    return (-(~x));
    }
    /* Driver program to test above functions*/
    int main()
    {
    System.out.printf("%d", addOne(13));
    getchar();
    return 0;
    }
}
