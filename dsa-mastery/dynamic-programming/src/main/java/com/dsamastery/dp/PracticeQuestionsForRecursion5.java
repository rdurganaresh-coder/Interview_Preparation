package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    int fun(int a, int b)
    {
    if (b == 0)
    return 0;
    if (b % 2 == 0)
    return fun(a+a, b/2);
    return fun(a+a, b/2) + a;
    }
    int main()
    {
    System.out.printf("%d", fun(4, 3));
    getchar();
    return 0;
    }
    int fun(int a, int b)
    {
    if (b == 0)
    return 1;
    if (b % 2 == 0)
    return fun(a*a, b/2);
    return fun(a*a, b/2)*a;
    }
    int main()
    {
    System.out.printf("%d", fun(4, 3));
    getchar();
    return 0;
    }
    int fun(int n)
    {
    if (n > 100)
    return n - 10;
    return fun(fun(n+11));
    }
    int main()
    {
    System.out.printf(" %d ", fun(99));
    getchar();
    return 0;
    }
}
