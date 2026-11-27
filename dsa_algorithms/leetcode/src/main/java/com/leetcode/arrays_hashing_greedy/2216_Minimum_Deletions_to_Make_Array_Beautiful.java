package com.leetcode.arrays_hashing_greedy;

class Solution2216 {
    public int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                ++ans;
            } else {
                ++i;
            }
        }
        ans += (n - ans) % 2;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2216 _tcSol = new Solution2216();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,2,3,5]");
        try {
            int[] nums = new int[]{1, 1, 2, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletion(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2,2,3,3]");
        try {
            int[] nums = new int[]{1, 1, 2, 2, 3, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minDeletion(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}