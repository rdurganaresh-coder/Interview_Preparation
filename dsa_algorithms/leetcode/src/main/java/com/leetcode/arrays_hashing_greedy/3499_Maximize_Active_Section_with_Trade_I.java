package com.leetcode.arrays_hashing_greedy;

class Solution3499 {
    public int maxActiveSectionsAfterTrade(String s) {
        int n = s.length();
        int ans = 0, i = 0;
        int pre = Integer.MIN_VALUE, mx = 0;

        while (i < n) {
            int j = i + 1;
            while (j < n && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            int cur = j - i;
            if (s.charAt(i) == '1') {
                ans += cur;
            } else {
                mx = Math.max(mx, pre + cur);
                pre = cur;
            }
            i = j;
        }

        ans += mx;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3499 _tcSol = new Solution3499();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"01\"");
        try {
            String s = "01";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"0100\"");
        try {
            String s = "0100";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1000100\"");
        try {
            String s = "1000100";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "s = \"01010\"");
        try {
            String s = "01010";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxActiveSectionsAfterTrade(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}