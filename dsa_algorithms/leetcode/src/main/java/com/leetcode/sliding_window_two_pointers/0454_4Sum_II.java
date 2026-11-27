package com.leetcode.sliding_window_two_pointers;

class Solution0454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                cnt.merge(a + b, 1, Integer::sum);
            }
        }
        int ans = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                ans += cnt.getOrDefault(-(c + d), 0);
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
        Solution0454 _tcSol = new Solution0454();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]");
        try {
            int[] nums1 = new int[]{1, 2};
            int[] nums2 = new int[]{-2, -1};
            int[] nums3 = new int[]{-1, 2};
            int[] nums4 = new int[]{0, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.fourSumCount(nums1, nums2, nums3, nums4)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]");
        try {
            int[] nums1 = new int[]{0};
            int[] nums2 = new int[]{0};
            int[] nums3 = new int[]{0};
            int[] nums4 = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.fourSumCount(nums1, nums2, nums3, nums4)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}