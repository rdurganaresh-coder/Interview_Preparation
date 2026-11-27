package com.leetcode.arrays_hashing_greedy;

class Solution3184 {
    public int countCompleteDayPairs(int[] hours) {
        int[] cnt = new int[24];
        int ans = 0;
        for (int x : hours) {
            ans += cnt[(24 - x % 24) % 24];
            ++cnt[x % 24];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3184 _tcSol = new Solution3184();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "hours = [12,12,30,24,24]");
        try {
            int[] hours = new int[]{12, 12, 30, 24, 24};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteDayPairs(hours)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "hours = [72,48,24,3]");
        try {
            int[] hours = new int[]{72, 48, 24, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteDayPairs(hours)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}