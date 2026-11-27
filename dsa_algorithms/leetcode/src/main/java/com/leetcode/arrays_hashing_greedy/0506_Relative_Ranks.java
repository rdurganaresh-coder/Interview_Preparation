package com.leetcode.arrays_hashing_greedy;

class Solution0506 {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i1, i2) -> score[i2] - score[i1]);
        String[] ans = new String[n];
        String[] top3 = new String[] {"Gold Medal", "Silver Medal", "Bronze Medal"};
        for (int i = 0; i < n; ++i) {
            ans[idx[i]] = i < 3 ? top3[i] : String.valueOf(i + 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0506 _tcSol = new Solution0506();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "score = [5,4,3,2,1]");
        try {
            int[] score = new int[]{5, 4, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRelativeRanks(score)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Gold Medal\",\"Silver Medal\",\"Bronze Medal\",\"4\",\"5\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "score = [10,3,8,9,4]");
        try {
            int[] score = new int[]{10, 3, 8, 9, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findRelativeRanks(score)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"Gold Medal\",\"5\",\"Bronze Medal\",\"Silver Medal\",\"4\"]");
        System.out.println();
    }
}