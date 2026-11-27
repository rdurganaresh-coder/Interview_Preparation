package com.leetcode.arrays_hashing_greedy;

class Solution3180_2 {
    public int maxTotalReward(int[] rewardValues) {
        int[] nums = Arrays.stream(rewardValues).distinct().sorted().toArray();
        int n = nums.length;
        int m = nums[n - 1] << 1;
        boolean[] f = new boolean[m];
        f[0] = true;
        for (int v : nums) {
            for (int j = 0; j < m; ++j) {
                if (0 <= j - v && j - v < v) {
                    f[j] |= f[j - v];
                }
            }
        }
        int ans = m - 1;
        while (!f[ans]) {
            --ans;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3180_2 _tcSol = new Solution3180_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "rewardValues = [1,1,3,3]");
        try {
            int[] rewardValues = new int[]{1, 1, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalReward(rewardValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "rewardValues = [1,6,4,3,2]");
        try {
            int[] rewardValues = new int[]{1, 6, 4, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxTotalReward(rewardValues)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "11");
        System.out.println();
    }
}