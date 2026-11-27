package com.leetcode.sliding_window_two_pointers;

class Solution0016 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 1 << 30;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if (t == target) {
                    return t;
                }
                if (Math.abs(t - target) < Math.abs(ans - target)) {
                    ans = t;
                }
                if (t > target) {
                    --k;
                } else {
                    ++j;
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
        Solution0016 _tcSol = new Solution0016();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,2,1,-4], target = 1");
        try {
            int[] nums = new int[]{-1, 2, 1, -4};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumClosest(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,0,0], target = 1");
        try {
            int[] nums = new int[]{0, 0, 0};
            int target = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSumClosest(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}