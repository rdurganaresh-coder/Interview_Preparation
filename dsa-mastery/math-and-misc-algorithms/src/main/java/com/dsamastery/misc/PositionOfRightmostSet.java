package com.dsamastery.misc;

import java.util.*;

public class PositionOfRightmostSet {

    required one only (00010)
    unsigned int getFirstSetBitPos(int n)
    {
    return log2(n&-n)+1;
    }
    int main()
    {
    int n = 12;
    System.out.printf("%u", getFirstSetBitPos(n));
    getchar();
    return 0;
    }
}
