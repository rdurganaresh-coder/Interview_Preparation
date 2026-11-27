package com.leetcode.arrays_hashing_greedy;

class Solution2938 {
    public long minimumSteps(String s) {
        long ans = 0;
        int cnt = 0;
        int n = s.length();
        for (int i = n - 1; i >= 0; --i) {
            if (s.charAt(i) == '1') {
                ++cnt;
                ans += n - i - cnt;
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
        Solution2938 _tcSol = new Solution2938();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"101\"");
        try {
            String s = "101";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSteps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"100\"");
        try {
            String s = "100";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSteps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"0111\"");
        try {
            String s = "0111";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumSteps(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}