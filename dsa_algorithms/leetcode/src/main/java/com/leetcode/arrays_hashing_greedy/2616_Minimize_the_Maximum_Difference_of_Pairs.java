package com.leetcode.arrays_hashing_greedy;

class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = nums[n - 1] - nums[0] + 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (count(nums, mid) >= p) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int count(int[] nums, int diff) {
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i + 1] - nums[i] <= diff) {
                ++cnt;
                ++i;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2616 _tcSol = new Solution2616();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [10,1,2,7,1,3], p = 2");
        try {
            int[] nums = new int[]{10, 1, 2, 7, 1, 3};
            int p = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeMax(nums, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,2,1,2], p = 1");
        try {
            int[] nums = new int[]{4, 2, 1, 2};
            int p = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeMax(nums, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}