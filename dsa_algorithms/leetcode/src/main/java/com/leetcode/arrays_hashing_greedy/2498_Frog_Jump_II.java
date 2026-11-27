package com.leetcode.arrays_hashing_greedy;

class Solution2498 {
    public int maxJump(int[] stones) {
        int ans = stones[1] - stones[0];
        for (int i = 2; i < stones.length; ++i) {
            ans = Math.max(ans, stones[i] - stones[i - 2]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2498 _tcSol = new Solution2498();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [0,2,5,6,7]");
        try {
            int[] stones = new int[]{0, 2, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxJump(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [0,3,9]");
        try {
            int[] stones = new int[]{0, 3, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxJump(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();
    }
}