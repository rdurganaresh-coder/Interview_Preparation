package com.dsamastery.misc;

import java.util.*;

public class DetectIfTwoIntegers {

    boolean oppositeSigns(int x, int y)
    {
    return ((x ^ y) < 0);
    }
    int main()
    {
    int x = 100, y = -100;
    if (oppositeSigns(x, y) == true)
    System.out.printf("Signs are opposite");
    else
    System.out.printf("Signs are not opposite");
    return 0;
    }
    boolean oppositeSigns(int x, int y)
    {
    return (x < 0)? (y >= 0): (y < 0);
    }
    boolean oppositeSigns(int x, int y)
    {
    return ((x ^ y) >> 31);
    }
}
