package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    void fun(int x)
    {
    if(x > 0)
    {
    fun(--x);
    System.out.printf("%d\t", x);
    fun(--x);
    }
    }
    int main()
    {
    int a = 4;
    fun(a);
    getchar();
    return 0;
    }
    fun(4);
    int fun(int a[],int n)
    {
    int x;
    if(n == 1)
    return a[0];
    else
    x = fun(a, n-1);
    if(x > a[n-1])
    return x;
    else
    return a[n-1];
    }
    int main()
    {
    int arr[] = {12, 10, 30, 50, 100};
    System.out.printf(" %d ", fun(arr, 5));
    getchar();
    return 0;
    }
    int fun(int i)
    {
    if ( i%2 ) return (i++);
    else return fun(fun( i - 1 ));
    }
    int main()
    {
    System.out.printf(" %d ", fun(200));
    getchar();
    return 0;
    }
}
