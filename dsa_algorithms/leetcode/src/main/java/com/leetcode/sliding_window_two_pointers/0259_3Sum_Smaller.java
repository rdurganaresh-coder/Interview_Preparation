package com.leetcode.sliding_window_two_pointers;

class Solution0259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        for (int i = 0; i + 2 < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x < target) {
                    ans += k - j;
                    ++j;
                } else {
                    --k;
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
        Solution0259 _tcSol = new Solution0259();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-2,0,1,3], target = 2");
        try {
            int[] nums = new int[]{-2, 0, 1, 3};
            int target = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumSmaller(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [], target = 0");
        try {
            int[] nums = new int[]{};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumSmaller(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0], target = 0");
        try {
            int[] nums = new int[]{0};
            int target = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumSmaller(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
