package com.leetcode.arrays_hashing_greedy;

class Solution1819 {
    public int countDifferentSubsequenceGCDs(int[] nums) {
        int mx = Arrays.stream(nums).max().getAsInt();
        boolean[] vis = new boolean[mx + 1];
        for (int x : nums) {
            vis[x] = true;
        }
        int ans = 0;
        for (int x = 1; x <= mx; ++x) {
            int g = 0;
            for (int y = x; y <= mx; y += x) {
                if (vis[y]) {
                    g = gcd(g, y);
                    if (x == g) {
                        ++ans;
                        break;
                    }
                }
            }
        }
        return ans;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1819 _tcSol = new Solution1819();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [6,10,3]");
        try {
            int[] nums = new int[]{6, 10, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDifferentSubsequenceGCDs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,15,40,5,6]");
        try {
            int[] nums = new int[]{5, 15, 40, 5, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.countDifferentSubsequenceGCDs(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}