package com.leetcode.bit_manipulation_math;

class Solution3438 {
    public String findValidPair(String s) {
        int[] cnt = new int[10];
        for (char c : s.toCharArray()) {
            ++cnt[c - '0'];
        }
        for (int i = 1; i < s.length(); ++i) {
            int x = s.charAt(i - 1) - '0';
            int y = s.charAt(i) - '0';
            if (x != y && cnt[x] == x && cnt[y] == y) {
                return s.substring(i - 1, i + 1);
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3438 _tcSol = new Solution3438();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"2523533\"");
        try {
            String s = "2523533";
            System.out.println("  Output  : " + _tcShow(_tcSol.findValidPair(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"23\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"221\"");
        try {
            String s = "221";
            System.out.println("  Output  : " + _tcShow(_tcSol.findValidPair(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"21\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"22\"");
        try {
            String s = "22";
            System.out.println("  Output  : " + _tcShow(_tcSol.findValidPair(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}
