package com.leetcode.bit_manipulation_math;

class Solution2433 {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        int[] ans = new int[n];
        ans[0] = pref[0];
        for (int i = 1; i < n; ++i) {
            ans[i] = pref[i - 1] ^ pref[i];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2433 _tcSol = new Solution2433();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "pref = [5,2,0,3,1]");
        try {
            int[] pref = new int[]{5, 2, 0, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findArray(pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,7,2,3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "pref = [13]");
        try {
            int[] pref = new int[]{13};
            System.out.println("  Output  : " + _tcShow(_tcSol.findArray(pref)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[13]");
        System.out.println();
    }
}