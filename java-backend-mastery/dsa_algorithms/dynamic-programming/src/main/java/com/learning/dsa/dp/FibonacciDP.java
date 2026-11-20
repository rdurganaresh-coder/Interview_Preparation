package com.learning.dsa.dp;

public class FibonacciDP {
    public static long fib(int n) {
        if (n <= 1) return n;
        long prev2 = 0, prev1 = 1;
        for (int i = 2; i <= n; i++) {
            long curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }

    public static void main(String[] args) {
        System.out.println("Fib(10) = " + fib(10));
    }
}
