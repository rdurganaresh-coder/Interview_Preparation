package com.dsamastery.dp;

import java.util.*;

public class PracticeQuestionsForRecursion {

    void abc(char *s)
    {
    if(s[0] == '\0')
    return;
    abc(s + 1);
    abc(s + 1);
    System.out.printf("%c", s[0]);
    }
    void abc(char *s)
    {
    if(s[0] == '\0')
    return;
    abc(s + 1);
    abc(s + 1);
    System.out.printf("%c", s[0]);
    }
    int main()
    {
    abc("xyz");
    return 0;
    }
    int fun(int count)
    {
    System.out.printf("%d\n", count);
    if(count < 3)
    {
    fun(fun(fun(++count)));
    }
    return count;
    }
    int main()
    {
    fun(1);
    return 0;
    }
}
