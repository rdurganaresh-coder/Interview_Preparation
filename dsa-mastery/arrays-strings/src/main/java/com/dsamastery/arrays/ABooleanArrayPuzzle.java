package com.dsamastery.arrays;

import java.util.*;

public class ABooleanArrayPuzzle {

    void changeToZero(int a[2])
    {
    a[ a[1] ] = a[ !a[1] ];
    }
    int main()
    {
    int a[] = {1, 0};
    changeToZero(a);
    System.out.printf(" arr[0] = %d \n", a[0]);
    System.out.printf(" arr[1] = %d ", a[1]);
    getchar();
    return 0;
    }
    void changeToZero(int a[2])
    {
    a[ !a[0] ] = a[ !a[1] ]
    }
    void changeToZero(int a[2])
    {
    a[ a[1] ] = a[ a[0] ]
    }
    void changeToZero(int a[2])
    {
    a[0] = a[a[0]];
    a[1] = a[0];
    }
}
