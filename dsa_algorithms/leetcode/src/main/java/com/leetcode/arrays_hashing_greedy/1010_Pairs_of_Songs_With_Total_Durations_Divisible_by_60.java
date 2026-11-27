package com.leetcode.arrays_hashing_greedy;

class Solution1010 {
    public int numPairsDivisibleBy60(int[] time) {
        int[] cnt = new int[60];
        int ans = 0;
        for (int x : time) {
            x %= 60;
            int y = (60 - x) % 60;
            ans += cnt[y];
            ++cnt[x];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1010 _tcSol = new Solution1010();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = [30,20,150,100,40]");
        try {
            int[] time = new int[]{30, 20, 150, 100, 40};
            System.out.println("  Output  : " + _tcShow(_tcSol.numPairsDivisibleBy60(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = [60,60,60]");
        try {
            int[] time = new int[]{60, 60, 60};
            System.out.println("  Output  : " + _tcShow(_tcSol.numPairsDivisibleBy60(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}
