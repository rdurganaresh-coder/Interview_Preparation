package com.leetcode.bit_manipulation_math;

class Solution1888 {
    public int minFlips(String s) {
        int n = s.length();
        String target = "01";
        int cnt = 0;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != target.charAt(i & 1)) {
                ++cnt;
            }
        }
        int ans = Math.min(cnt, n - cnt);
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) != target.charAt(i & 1)) {
                --cnt;
            }
            if (s.charAt(i) != target.charAt((i + n) & 1)) {
                ++cnt;
            }
            ans = Math.min(ans, Math.min(cnt, n - cnt));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1888 _tcSol = new Solution1888();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"111000\"");
        try {
            String s = "111000";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"010\"");
        try {
            String s = "010";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"1110\"");
        try {
            String s = "1110";
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}