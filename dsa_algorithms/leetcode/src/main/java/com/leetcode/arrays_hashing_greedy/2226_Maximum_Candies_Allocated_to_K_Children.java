package com.leetcode.arrays_hashing_greedy;

class Solution2226 {
    public int maximumCandies(int[] candies, long k) {
        int l = 0, r = Arrays.stream(candies).max().getAsInt();
        while (l < r) {
            int mid = (l + r + 1) >> 1;
            long cnt = 0;
            for (int x : candies) {
                cnt += x / mid;
            }
            if (cnt >= k) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2226 _tcSol = new Solution2226();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "candies = [5,8,6], k = 3");
        try {
            int[] candies = new int[]{5, 8, 6};
            long k = 3L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCandies(candies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "candies = [2,5], k = 11");
        try {
            int[] candies = new int[]{2, 5};
            long k = 11L;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumCandies(candies, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
