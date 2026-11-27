package com.leetcode.arrays_hashing_greedy;

class Solution2611 {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] idx = new Integer[n];
        Arrays.setAll(idx, i -> i);
        Arrays.sort(idx, (i, j) -> reward1[j] - reward2[j] - (reward1[i] - reward2[i]));
        int ans = 0;
        for (int i = 0; i < k; ++i) {
            ans += reward1[idx[i]];
        }
        for (int i = k; i < n; ++i) {
            ans += reward2[idx[i]];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2611 _tcSol = new Solution2611();
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