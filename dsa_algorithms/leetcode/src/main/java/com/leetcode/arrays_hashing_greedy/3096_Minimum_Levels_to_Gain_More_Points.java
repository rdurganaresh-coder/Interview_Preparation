package com.leetcode.arrays_hashing_greedy;

class Solution3096 {
    public int minimumLevels(int[] possible) {
        int s = 0;
        for (int x : possible) {
            s += x == 0 ? -1 : 1;
        }
        int t = 0;
        for (int i = 1; i < possible.length; ++i) {
            t += possible[i - 1] == 0 ? -1 : 1;
            if (t > s - t) {
                return i;
            }
        }
        return -1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3096 _tcSol = new Solution3096();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "possible = [1,0,1,0]");
        try {
            int[] possible = new int[]{1, 0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLevels(possible)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "possible = [1,1,1,1,1]");
        try {
            int[] possible = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLevels(possible)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "possible = [0,0]");
        try {
            int[] possible = new int[]{0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumLevels(possible)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}