package com.leetcode.arrays_hashing_greedy;

class Solution2611_2 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int ans = 0;
        int n = reward1.length;
        for (int i = 0; i < n; ++i) {
            ans += reward2[i];
            reward1[i] -= reward2[i];
        }
        Arrays.sort(reward1);
        for (int i = 0; i < k; ++i) {
            ans += reward1[n - i - 1];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2611_2 _tcSol = new Solution2611_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "reward1 = [1,1,3,4], reward2 = [4,4,1,1], k = 2");
        try {
            int[] reward1 = new int[]{1, 1, 3, 4};
            int[] reward2 = new int[]{4, 4, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.miceAndCheese(reward1, reward2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "reward1 = [1,1], reward2 = [1,1], k = 2");
        try {
            int[] reward1 = new int[]{1, 1};
            int[] reward2 = new int[]{1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.miceAndCheese(reward1, reward2, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}