package com.leetcode.strings;

class Solution2496 {
    public int maximumValue(String[] strs) {
        int ans = 0;
        for (var s : strs) {
            ans = Math.max(ans, f(s));
        }
        return ans;
    }

    private int f(String s) {
        int x = 0;
        for (int i = 0, n = s.length(); i < n; ++i) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                return n;
            }
            x = x * 10 + (c - '0');
        }
        return x;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2496 _tcSol = new Solution2496();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "strs = [\"alic3\",\"bob\",\"3\",\"4\",\"00000\"]");
        try {
            String[] strs = new String[]{"alic3", "bob", "3", "4", "00000"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumValue(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "strs = [\"1\",\"01\",\"001\",\"0001\"]");
        try {
            String[] strs = new String[]{"1", "01", "001", "0001"};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumValue(strs)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}