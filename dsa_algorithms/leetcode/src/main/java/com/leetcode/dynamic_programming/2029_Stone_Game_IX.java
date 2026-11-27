package com.leetcode.dynamic_programming;

class Solution2029 {
    public boolean stoneGameIX(int[] stones) {
        int[] c1 = new int[3];
        for (int x : stones) {
            c1[x % 3]++;
        }
        int[] c2 = {c1[0], c1[2], c1[1]};
        return check(c1) || check(c2);
    }

    private boolean check(int[] cnt) {
        if (--cnt[1] < 0) {
            return false;
        }
        int r = 1 + Math.min(cnt[1], cnt[2]) * 2 + cnt[0];
        if (cnt[1] > cnt[2]) {
            --cnt[1];
            ++r;
        }
        return r % 2 == 1 && cnt[1] != cnt[2];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2029 _tcSol = new Solution2029();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "stones = [2,1]");
        try {
            int[] stones = new int[]{2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIX(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "stones = [2]");
        try {
            int[] stones = new int[]{2};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIX(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "stones = [5,1,2,4,3]");
        try {
            int[] stones = new int[]{5, 1, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.stoneGameIX(stones)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}