package com.leetcode.sliding_window_two_pointers;

class Solution2379 {
    public int minimumRecolors(String blocks, int k) {
        int cnt = 0;
        for (int i = 0; i < k; ++i) {
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
        }
        int ans = cnt;
        for (int i = k; i < blocks.length(); ++i) {
            cnt += blocks.charAt(i) == 'W' ? 1 : 0;
            cnt -= blocks.charAt(i - k) == 'W' ? 1 : 0;
            ans = Math.min(ans, cnt);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2379 _tcSol = new Solution2379();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "blocks = \"WBBWWBBWBW\", k = 7");
        try {
            String blocks = "WBBWWBBWBW";
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRecolors(blocks, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "blocks = \"WBWBBBW\", k = 2");
        try {
            String blocks = "WBWBBBW";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumRecolors(blocks, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}