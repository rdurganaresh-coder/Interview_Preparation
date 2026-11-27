package com.leetcode.bit_manipulation_math;

class Solution2283 {
    public boolean digitCount(String num) {
        int[] cnt = new int[10];
        int n = num.length();
        for (int i = 0; i < n; ++i) {
            ++cnt[num.charAt(i) - '0'];
        }
        for (int i = 0; i < n; ++i) {
            if (num.charAt(i) - '0' != cnt[i]) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2283 _tcSol = new Solution2283();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"1210\"");
        try {
            String num = "1210";
            System.out.println("  Output  : " + _tcShow(_tcSol.digitCount(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"030\"");
        try {
            String num = "030";
            System.out.println("  Output  : " + _tcShow(_tcSol.digitCount(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}