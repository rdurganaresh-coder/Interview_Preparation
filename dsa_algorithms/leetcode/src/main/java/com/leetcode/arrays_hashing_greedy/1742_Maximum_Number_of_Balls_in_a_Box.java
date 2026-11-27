package com.leetcode.arrays_hashing_greedy;

class Solution1742 {
    public int countBalls(int lowLimit, int highLimit) {
        int[] cnt = new int[50];
        for (int i = lowLimit; i <= highLimit; ++i) {
            int y = 0;
            for (int x = i; x > 0; x /= 10) {
                y += x % 10;
            }
            ++cnt[y];
        }
        return Arrays.stream(cnt).max().getAsInt();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1742 _tcSol = new Solution1742();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "lowLimit = 1, highLimit = 10");
        try {
            int lowLimit = 1;
            int highLimit = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.countBalls(lowLimit, highLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "lowLimit = 5, highLimit = 15");
        try {
            int lowLimit = 5;
            int highLimit = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.countBalls(lowLimit, highLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "lowLimit = 19, highLimit = 28");
        try {
            int lowLimit = 19;
            int highLimit = 28;
            System.out.println("  Output  : " + _tcShow(_tcSol.countBalls(lowLimit, highLimit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}