package com.leetcode.arrays_hashing_greedy;

class Solution1423 {
    public int maxScore(int[] cardPoints, int k) {
        int s = 0, n = cardPoints.length;
        for (int i = n - k; i < n; ++i) {
            s += cardPoints[i];
        }
        int ans = s;
        for (int i = 0; i < k; ++i) {
            s += cardPoints[i] - cardPoints[n - k + i];
            ans = Math.max(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1423 _tcSol = new Solution1423();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cardPoints = [1,2,3,4,5,6,1], k = 3");
        try {
            int[] cardPoints = new int[]{1, 2, 3, 4, 5, 6, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(cardPoints, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cardPoints = [2,2,2], k = 2");
        try {
            int[] cardPoints = new int[]{2, 2, 2};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(cardPoints, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "cardPoints = [9,7,7,9,7,7,9], k = 7");
        try {
            int[] cardPoints = new int[]{9, 7, 7, 9, 7, 7, 9};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxScore(cardPoints, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "55");
        System.out.println();
    }
}