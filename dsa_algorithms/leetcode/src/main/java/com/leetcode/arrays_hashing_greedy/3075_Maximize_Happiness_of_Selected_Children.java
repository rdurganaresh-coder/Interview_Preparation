package com.leetcode.arrays_hashing_greedy;

class Solution3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long ans = 0;
        for (int i = 0, n = happiness.length; i < k; ++i) {
            int x = happiness[n - i - 1] - i;
            ans += Math.max(x, 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3075 _tcSol = new Solution3075();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "happiness = [1,2,3], k = 2");
        try {
            int[] happiness = new int[]{1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumHappinessSum(happiness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "happiness = [1,1,1,1], k = 2");
        try {
            int[] happiness = new int[]{1, 1, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumHappinessSum(happiness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "happiness = [2,3,4,5], k = 1");
        try {
            int[] happiness = new int[]{2, 3, 4, 5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumHappinessSum(happiness, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}