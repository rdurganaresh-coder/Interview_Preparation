package com.leetcode.strings;

class Solution1415_2 {
    public String getHappyString(int n, int k) {
        if (k > 3 * (1 << (n - 1))) {
            return "";
        }
        String cs = "abc";
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int remain = 1 << (n - i - 1);
            for (char c : cs.toCharArray()) {
                if (ans.length() > 0 && ans.charAt(ans.length() - 1) == c) {
                    continue;
                }
                if (k <= remain) {
                    ans.append(c);
                    break;
                }
                k -= remain;
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1415_2 _tcSol = new Solution1415_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 1, k = 3");
        try {
            int n = 1;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"c\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 1, k = 4");
        try {
            int n = 1;
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 3, k = 9");
        try {
            int n = 3;
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.getHappyString(n, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"cab\"");
        System.out.println();
    }
}
