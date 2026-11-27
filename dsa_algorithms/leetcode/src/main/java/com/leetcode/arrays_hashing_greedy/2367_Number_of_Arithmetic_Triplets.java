package com.leetcode.arrays_hashing_greedy;

class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (nums[j] - nums[i] == diff && nums[k] - nums[j] == diff) {
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
        Solution2367 _tcSol = new Solution2367();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1,4,6,7,10], diff = 3");
        try {
            int[] nums = new int[]{0, 1, 4, 6, 7, 10};
            int diff = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.arithmeticTriplets(nums, diff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,5,6,7,8,9], diff = 2");
        try {
            int[] nums = new int[]{4, 5, 6, 7, 8, 9};
            int diff = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.arithmeticTriplets(nums, diff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}