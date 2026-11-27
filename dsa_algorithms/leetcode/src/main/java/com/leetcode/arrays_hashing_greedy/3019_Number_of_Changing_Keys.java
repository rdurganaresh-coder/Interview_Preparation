package com.leetcode.arrays_hashing_greedy;

class Solution3019 {
    public int countKeyChanges(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); ++i) {
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(i - 1))) {
                ++ans;
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3019 _tcSol = new Solution3019();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aAbBcC\"");
        try {
            String s = "aAbBcC";
            System.out.println("  Output  : " + _tcShow(_tcSol.countKeyChanges(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"AaAaAaaA\"");
        try {
            String s = "AaAaAaaA";
            System.out.println("  Output  : " + _tcShow(_tcSol.countKeyChanges(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}