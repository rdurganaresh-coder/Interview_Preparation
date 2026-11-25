package com.dsamastery.misc;

import java.util.*;

public class BinaryRepresentationOfA {

    void bin(unsigned n)
    {
    unsigned i;
    for (i = 1 << 31; i > 0; i = i / 2)
    (n & i)? System.out.printf("1"): System.out.printf("0");
    }
    int main(void)
    {
    bin(7);
    System.out.printf("\n");
    bin(4);
    }
    void bin(unsigned n)
    {
    /* step 1 */
    if (n > 1)
    bin(n/2);
    /* step 2 */
    System.out.printf("%d", n % 2);
    }
    int main(void)
    {
    bin(7);
    System.out.printf("\n");
    bin(4);
    }
}
