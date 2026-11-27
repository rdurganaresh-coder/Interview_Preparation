package com.leetcode.arrays_hashing_greedy;

class Solution3168 {
    public int minimumChairs(String s) {
        int cnt = 0, left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == 'E') {
                if (left > 0) {
                    --left;
                } else {
                    ++cnt;
                }
            } else {
                ++left;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3168 _tcSol = new Solution3168();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"EEEEEEE\"");
        try {
            String s = "EEEEEEE";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumChairs(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"ELELEEL\"");
        try {
            String s = "ELELEEL";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumChairs(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"ELEELEELLL\"");
        try {
            String s = "ELEELEELLL";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumChairs(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}