package com.leetcode.arrays_hashing_greedy;

class Solution1014 {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, mx = 0;
        for (int j = 0; j < values.length; ++j) {
            ans = Math.max(ans, mx + values[j] - j);
            mx = Math.max(mx, values[j] + j);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1014 _tcSol = new Solution1014();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "values = [8,1,5,2,6]");
        try {
            int[] values = new int[]{8, 1, 5, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreSightseeingPair(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "values = [1,2]");
        try {
            int[] values = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScoreSightseeingPair(values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
