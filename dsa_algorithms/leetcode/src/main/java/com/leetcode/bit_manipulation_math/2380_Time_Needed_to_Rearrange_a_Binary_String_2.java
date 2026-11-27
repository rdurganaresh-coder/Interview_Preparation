package com.leetcode.bit_manipulation_math;

class Solution2380_2 {
    public int secondsToRemoveOccurrences(String s) {
        int ans = 0, cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                ++cnt;
            } else if (cnt > 0) {
                ans = Math.max(ans + 1, cnt);
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
        Solution2380_2 _tcSol = new Solution2380_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"0110101\"");
        try {
            String s = "0110101";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondsToRemoveOccurrences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"11100\"");
        try {
            String s = "11100";
            System.out.println("  Output  : " + _tcShow(_tcSol.secondsToRemoveOccurrences(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}