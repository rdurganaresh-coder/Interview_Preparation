package com.leetcode.arrays_hashing_greedy;

class Solution1399 {
    public int countLargestGroup(int n) {
        int[] cnt = new int[40];
        int ans = 0, mx = 0;
        for (int i = 1; i <= n; ++i) {
            int s = 0;
            for (int x = i; x > 0; x /= 10) {
                s += x % 10;
            }
            ++cnt[s];
            if (mx < cnt[s]) {
                mx = cnt[s];
                ans = 1;
            } else if (mx == cnt[s]) {
                ++ans;
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
        Solution1399 _tcSol = new Solution1399();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 13");
        try {
            int n = 13;
            System.out.println("  Output  : " + _tcShow(_tcSol.countLargestGroup(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2");
        try {
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countLargestGroup(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}