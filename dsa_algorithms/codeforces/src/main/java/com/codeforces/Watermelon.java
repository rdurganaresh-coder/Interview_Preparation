package com.codeforces;

import java.util.Scanner;

public class Watermelon {
    public static String solve(int w) {
        return (w > 2 && w % 2 == 0) ? "YES" : "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            System.out.println(solve(sc.nextInt()));
        }
    }
}
