package com.dsamastery.misc;

import java.util.*;

public class TimeComplexityWhereLoop {

    void fun(int n)
    {
    int j = 1, i = 0;
    while (i < n)
    {
    // Some O(1) task
    i = i + j;
    j++;
    }
    }
}
