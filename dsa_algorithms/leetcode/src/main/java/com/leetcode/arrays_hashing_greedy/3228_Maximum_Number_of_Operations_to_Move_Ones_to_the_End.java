package com.leetcode.arrays_hashing_greedy;

class Solution3228 {
    public int maxOperations(String s) {
        int ans = 0, cnt = 0;
        int n = s.length();
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '1') {
                ++cnt;
            } else if (i > 0 && s.charAt(i - 1) == '1') {
                ans += cnt;
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
        Solution3228 _tcSol = new Solution3228();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"1001101\"");
        try {
            String s = "1001101";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"00111\"");
        try {
            String s = "00111";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}