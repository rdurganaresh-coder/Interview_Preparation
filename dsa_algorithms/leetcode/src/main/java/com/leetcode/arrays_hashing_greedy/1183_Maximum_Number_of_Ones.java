package com.leetcode.arrays_hashing_greedy;

class Solution1183 {
    public int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int x = sideLength;
        int[] cnt = new int[x * x];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                int k = (i % x) * x + (j % x);
                ++cnt[k];
            }
        }
        Arrays.sort(cnt);
        int ans = 0;
        for (int i = 0; i < maxOnes; ++i) {
            ans += cnt[cnt.length - i - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1183 _tcSol = new Solution1183();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "width = 3, height = 3, sideLength = 2, maxOnes = 1");
        try {
            int width = 3;
            int height = 3;
            int sideLength = 2;
            int maxOnes = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumberOfOnes(width, height, sideLength, maxOnes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "width = 3, height = 3, sideLength = 2, maxOnes = 2");
        try {
            int width = 3;
            int height = 3;
            int sideLength = 2;
            int maxOnes = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumberOfOnes(width, height, sideLength, maxOnes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}