package com.leetcode.arrays_hashing_greedy;

class Solution3206 {
    public int numberOfAlternatingGroups(int[] colors) {
        int k = 3;
        int n = colors.length;
        int ans = 0, cnt = 0;
        for (int i = 0; i < n << 1; ++i) {
            if (i > 0 && colors[i % n] == colors[(i - 1) % n]) {
                cnt = 1;
            } else {
                ++cnt;
            }
            ans += i >= n && cnt >= k ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3206 _tcSol = new Solution3206();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = [1,1,1]");
        try {
            int[] colors = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfAlternatingGroups(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = [0,1,0,0,1]");
        try {
            int[] colors = new int[]{0, 1, 0, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfAlternatingGroups(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}