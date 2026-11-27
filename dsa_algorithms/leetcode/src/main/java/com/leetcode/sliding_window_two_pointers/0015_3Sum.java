package com.leetcode.sliding_window_two_pointers;

class Solution0015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2 && nums[i] <= 0; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int x = nums[i] + nums[j] + nums[k];
                if (x < 0) {
                    ++j;
                } else if (x > 0) {
                    --k;
                } else {
                    ans.add(List.of(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j - 1]) {
                        ++j;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        --k;
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
        Solution0015 _tcSol = new Solution0015();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-1,0,1,2,-1,-4]");
        try {
            int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[-1,-1,2],[-1,0,1]]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,1]");
        try {
            int[] nums = new int[]{0, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,0,0]");
        try {
            int[] nums = new int[]{0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.threeSum(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[[0,0,0]]");
        System.out.println();
    }
}