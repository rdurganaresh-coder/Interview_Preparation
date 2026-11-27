package com.leetcode.sliding_window_two_pointers;

class Solution1040 {
    public int[] numMovesStonesII(int[] stones) {
        Arrays.sort(stones);
        int n = stones.length;
        int mi = n;
        int mx = Math.max(stones[n - 1] - stones[1] + 1, stones[n - 2] - stones[0] + 1) - (n - 1);
        for (int i = 0, j = 0; j < n; ++j) {
            while (stones[j] - stones[i] + 1 > n) {
                ++i;
            }
            if (j - i + 1 == n - 1 && stones[j] - stones[i] == n - 2) {
                mi = Math.min(mi, 2);
            } else {
                mi = Math.min(mi, n - (j - i + 1));
            }
        }
        return new int[] {mi, mx};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1040 _tcSol = new Solution1040();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [7,4,9]");
        try {
            int[] stones = new int[]{7, 4, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMovesStonesII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [6,5,4,3,10]");
        try {
            int[] stones = new int[]{6, 5, 4, 3, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.numMovesStonesII(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();
    }
}