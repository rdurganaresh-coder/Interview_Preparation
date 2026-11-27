package com.leetcode.strings;

class Solution2262 {
    public long appealSum(String s) {
        long ans = 0;
        long t = 0;
        int[] pos = new int[26];
        Arrays.fill(pos, -1);
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            t += i - pos[c];
            ans += t;
            pos[c] = i;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2262 _tcSol = new Solution2262();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abbca\"");
        try {
            String s = "abbca";
            System.out.println("  Output  : " + _tcShow(_tcSol.appealSum(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "28");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"code\"");
        try {
            String s = "code";
            System.out.println("  Output  : " + _tcShow(_tcSol.appealSum(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "20");
        System.out.println();
    }
}