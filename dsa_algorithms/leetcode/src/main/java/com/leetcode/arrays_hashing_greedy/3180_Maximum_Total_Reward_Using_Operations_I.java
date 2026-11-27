package com.leetcode.arrays_hashing_greedy;

class Solution3180 {
    private int[] nums;
    private Integer[] f;

    public int maxTotalReward(int[] rewardValues) {
        nums = rewardValues;
        Arrays.sort(nums);
        int n = nums.length;
        f = new Integer[nums[n - 1] << 1];
        return dfs(0);
    }

    private int dfs(int x) {
        if (f[x] != null) {
            return f[x];
        }
        int i = Arrays.binarySearch(nums, x + 1);
        i = i < 0 ? -i - 1 : i;
        int ans = 0;
        for (; i < nums.length; ++i) {
            ans = Math.max(ans, nums[i] + dfs(x + nums[i]));
        }
        return f[x] = ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3180 _tcSol = new Solution3180();
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