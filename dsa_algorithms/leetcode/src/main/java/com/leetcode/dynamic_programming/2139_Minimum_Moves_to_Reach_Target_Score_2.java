package com.leetcode.dynamic_programming;

class Solution2139_2 {
    public int minMoves(int target, int maxDoubles) {
        int ans = 0;
        while (maxDoubles > 0 && target > 1) {
            ++ans;
            if (target % 2 == 1) {
                --target;
            } else {
                --maxDoubles;
                target >>= 1;
            }
        }
        ans += target - 1;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2139_2 _tcSol = new Solution2139_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 5, maxDoubles = 0");
        try {
            int target = 5;
            int maxDoubles = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(target, maxDoubles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 19, maxDoubles = 2");
        try {
            int target = 19;
            int maxDoubles = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(target, maxDoubles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = 10, maxDoubles = 4");
        try {
            int target = 10;
            int maxDoubles = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(target, maxDoubles)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}