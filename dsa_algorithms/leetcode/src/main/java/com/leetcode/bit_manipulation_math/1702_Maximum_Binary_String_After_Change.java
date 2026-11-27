package com.leetcode.bit_manipulation_math;

class Solution1702 {
    public String maximumBinaryString(String binary) {
        int k = binary.indexOf('0');
        if (k == -1) {
            return binary;
        }
        int n = binary.length();
        for (int i = k + 1; i < n; ++i) {
            if (binary.charAt(i) == '0') {
                ++k;
            }
        }
        char[] ans = binary.toCharArray();
        Arrays.fill(ans, '1');
        ans[k] = '0';
        return String.valueOf(ans);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1702 _tcSol = new Solution1702();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "binary = \"000110\"");
        try {
            String binary = "000110";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBinaryString(binary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"111011\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "binary = \"01\"");
        try {
            String binary = "01";
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumBinaryString(binary)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"01\"");
        System.out.println();
    }
}