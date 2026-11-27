package com.leetcode.arrays_hashing_greedy;

class Solution0754 {
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0, k = 0;
        while (true) {
            if (s >= target && (s - target) % 2 == 0) {
                return k;
            }
            ++k;
            s += k;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0754 _tcSol = new Solution0754();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = 2");
        try {
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachNumber(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = 3");
        try {
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.reachNumber(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}