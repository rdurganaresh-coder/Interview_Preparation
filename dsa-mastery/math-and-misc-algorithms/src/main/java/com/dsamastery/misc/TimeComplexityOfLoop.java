package com.dsamastery.misc;

import java.util.*;

public class TimeComplexityOfLoop {

    void fun(int n, int k)
    {
    for (int i=1; i<=n; i++)
    {
    int p = pow(i, k);
    for (int j=1; j<=p; j++)
    {
    // Some O(1) work
    }
    }
    }
}
