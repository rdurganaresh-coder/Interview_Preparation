package com.leetcode.arrays_hashing_greedy;

class Solution3494 {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        long[] f = new long[n];
        for (int x : mana) {
            long tot = 0;
            for (int i = 0; i < n; ++i) {
                tot = Math.max(tot, f[i]) + skill[i] * x;
            }
            f[n - 1] = tot;
            for (int i = n - 2; i >= 0; --i) {
                f[i] = f[i + 1] - skill[i + 1] * x;
            }
        }
        return f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3494 _tcSol = new Solution3494();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "skill = [1,5,2,4], mana = [5,1,4,2]");
        try {
            int[] skill = new int[]{1, 5, 2, 4};
            int[] mana = new int[]{5, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(skill, mana)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "110");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "skill = [1,1,1], mana = [1,1,1]");
        try {
            int[] skill = new int[]{1, 1, 1};
            int[] mana = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(skill, mana)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "skill = [1,2,3,4], mana = [1,2]");
        try {
            int[] skill = new int[]{1, 2, 3, 4};
            int[] mana = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTime(skill, mana)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "21");
        System.out.println();
    }
}
