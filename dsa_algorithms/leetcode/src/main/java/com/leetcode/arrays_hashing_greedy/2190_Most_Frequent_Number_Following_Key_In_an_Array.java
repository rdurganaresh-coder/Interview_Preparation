package com.leetcode.arrays_hashing_greedy;

class Solution2190 {
    public int mostFrequent(int[] nums, int key) {
        int[] cnt = new int[1001];
        int ans = 0, mx = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == key) {
                if (mx < ++cnt[nums[i + 1]]) {
                    mx = cnt[nums[i + 1]];
                    ans = nums[i + 1];
                }
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2190 _tcSol = new Solution2190();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,100,200,1,100], key = 1");
        try {
            int[] nums = new int[]{1, 100, 200, 1, 100};
            int key = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequent(nums, key)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "100");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,3], key = 2");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 3};
            int key = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.mostFrequent(nums, key)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}