package com.leetcode.sliding_window_two_pointers;

class Solution2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        int n = special.length;
        int ans = Math.max(special[0] - bottom, top - special[n - 1]);
        for (int i = 1; i < n; ++i) {
            ans = Math.max(ans, special[i] - special[i - 1] - 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2274 _tcSol = new Solution2274();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "bottom = 2, top = 9, special = [4,6]");
        try {
            int bottom = 2;
            int top = 9;
            int[] special = new int[]{4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxConsecutive(bottom, top, special)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "bottom = 6, top = 8, special = [7,6,8]");
        try {
            int bottom = 6;
            int top = 8;
            int[] special = new int[]{7, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxConsecutive(bottom, top, special)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}