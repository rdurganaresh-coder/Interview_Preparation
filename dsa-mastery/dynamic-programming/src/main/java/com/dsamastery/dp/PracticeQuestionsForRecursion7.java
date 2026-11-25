package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    int fun ( int n, int *fp )
    {
    int t, f;
    if ( n <= 1 )
    {
    *fp = 1;
    return 1;
    }
    t = fun ( n-1, fp );
    f = t + *fp;
    *fp = t;
    return f;
    }
    int main()
    {
    int x = 15;
    System.out.printf("%d\n",fun(5, &x));
    return 0;
    }
    / \
    / \
    / \
    / \
    void fun(int n)
    {
    if(n > 0)
    {
    fun(n-1);
    System.out.printf("%d ", n);
    fun(n-1);
    }
    }
    int main()
    {
    fun(4);
    return 0;
    }
    fun(4)
}
