package com.leetcode.sliding_window_two_pointers;

class Solution1624 {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] d = new int[26];
        Arrays.fill(d, -1);
        int ans = -1;
        for (int i = 0; i < s.length(); ++i) {
            int j = s.charAt(i) - 'a';
            if (d[j] == -1) {
                d[j] = i;
            } else {
                ans = Math.max(ans, i - d[j] - 1);
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
        Solution1624 _tcSol = new Solution1624();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aa\"");
        try {
            String s = "aa";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLengthBetweenEqualCharacters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abca\"");
        try {
            String s = "abca";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLengthBetweenEqualCharacters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"cbzxy\"");
        try {
            String s = "cbzxy";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxLengthBetweenEqualCharacters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}
