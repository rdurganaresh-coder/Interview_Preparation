package com.dsamastery.dp;

import java.util.*;

public class PrintAPatternWithout {

    // C++ program to print pattern that first reduces 5 one
    // by one, then adds 5. Without any loop
    // Recursive function to print the pattern.
    // n indicates input value
    // m indicates current value to be printed
    // flag indicates whether we need to add 5 or
    // subtract 5. Initially flag is true.
    void printPattern(int n, int m, boolean flag)
    {
    // Print m.
    System.out.print(m << " ");
    // If we are moving back toward the n and
    // we have reached there, then we are done
    if (flag == false && n ==m)
    return;
    // If we are moving toward 0 or negative.
    if (flag)
    {
    // If m is greater, then 5, recur with true flag
    if (m-5 > 0)
    printPattern(n, m-5, true);
    else // recur with false flag
    printPattern(n, m-5, false);
    }
    else // If flag is false.
    printPattern(n, m+5, false);
    }
    // Driver Program
    int main()
    {
    int n = 16;
    printPattern(n, n, true);
    return 0;
    }
    // C++ program to print pattern that first reduces 5 one
    // by one, then adds 5. Without any loop an extra variable.
    // Recursive function to print the pattern without any extra
    // variable
    void printPattern(int n)
    {
    // Base case (When n becomes 0 or negative)
    if (n ==0 || n<0)
    {
    System.out.print(n << " ");
    return;
    }
    // First print decreasing order
    System.out.print(n << " ");
    printPattern(n-5);
    // Then print increasing order
    System.out.print(n << " ");
    }
    // Driver Program
    int main()
    {
    int n = 16;
    printPattern(n);
    return 0;
    }
}
