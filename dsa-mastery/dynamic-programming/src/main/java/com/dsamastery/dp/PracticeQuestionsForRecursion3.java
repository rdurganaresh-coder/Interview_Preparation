package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    void fun1(int n)
    {
    int i = 0;
    if (n > 1)
    fun1(n-1);
    for (i = 0; i < n; i++)
    System.out.printf(" * ");
    }
    void fun2(int n)
    {
    if (n <= 0)
    return;
    if (n > LIMIT)
    return;
    System.out.printf("%d ", n);
    fun2(2*n);
    System.out.printf("%d ", n);
    }
}
