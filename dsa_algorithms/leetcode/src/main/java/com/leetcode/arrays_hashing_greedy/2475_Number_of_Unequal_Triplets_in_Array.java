package com.leetcode.arrays_hashing_greedy;

class Solution2475 {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        ++ans;
                    }
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
        Solution2475 _tcSol = new Solution2475();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,4,2,4,3]");
        try {
            int[] nums = new int[]{4, 4, 2, 4, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.unequalTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,1,1]");
        try {
            int[] nums = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.unequalTriplets(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}