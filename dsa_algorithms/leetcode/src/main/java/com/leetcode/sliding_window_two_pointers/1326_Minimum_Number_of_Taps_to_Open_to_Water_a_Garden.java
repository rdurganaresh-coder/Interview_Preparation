package com.leetcode.sliding_window_two_pointers;

class Solution1326 {
    public int minTaps(int n, int[] ranges) {
        int[] last = new int[n + 1];
        for (int i = 0; i < n + 1; ++i) {
            int l = Math.max(0, i - ranges[i]), r = i + ranges[i];
            last[l] = Math.max(last[l], r);
        }
        int ans = 0, mx = 0, pre = 0;
        for (int i = 0; i < n; ++i) {
            mx = Math.max(mx, last[i]);
            if (mx <= i) {
                return -1;
            }
            if (pre == i) {
                ++ans;
                pre = mx;
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
        Solution1326 _tcSol = new Solution1326();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 5, ranges = [3,4,1,1,0,0]");
        try {
            int n = 5;
            int[] ranges = new int[]{3, 4, 1, 1, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTaps(n, ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, ranges = [0,0,0,0]");
        try {
            int n = 3;
            int[] ranges = new int[]{0, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minTaps(n, ranges)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}