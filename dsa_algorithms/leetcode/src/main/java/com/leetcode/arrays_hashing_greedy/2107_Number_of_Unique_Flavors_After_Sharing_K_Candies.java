package com.leetcode.arrays_hashing_greedy;

class Solution2107 {
    public int shareCandies(int[] candies, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int n = candies.length;
        for (int i = k; i < n; ++i) {
            cnt.merge(candies[i], 1, Integer::sum);
        }
        int ans = cnt.size();
        for (int i = k; i < n; ++i) {
            cnt.merge(candies[i - k], 1, Integer::sum);
            if (cnt.merge(candies[i], -1, Integer::sum) == 0) {
                cnt.remove(candies[i]);
            }
            ans = Math.max(ans, cnt.size());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2107 _tcSol = new Solution2107();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candies = [1,2,2,3,4,3], k = 3");
        try {
            int[] candies = new int[]{1, 2, 2, 3, 4, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.shareCandies(candies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candies = [2,2,2,2,3,3], k = 2");
        try {
            int[] candies = new int[]{2, 2, 2, 2, 3, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.shareCandies(candies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "candies = [2,4,5], k = 0");
        try {
            int[] candies = new int[]{2, 4, 5};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.shareCandies(candies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}