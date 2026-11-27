package com.leetcode.bit_manipulation_math;

class Solution1577 {
    public int numTriplets(int[] nums1, int[] nums2) {
        var cnt1 = count(nums1);
        var cnt2 = count(nums2);
        return cal(cnt1, nums2) + cal(cnt2, nums1);
    }

    private Map<Long, Integer> count(int[] nums) {
        Map<Long, Integer> cnt = new HashMap<>();
        int n = nums.length;
        for (int j = 0; j < n; ++j) {
            for (int k = j + 1; k < n; ++k) {
                long x = (long) nums[j] * nums[k];
                cnt.merge(x, 1, Integer::sum);
            }
        }
        return cnt;
    }

    private int cal(Map<Long, Integer> cnt, int[] nums) {
        int ans = 0;
        for (int x : nums) {
            long y = (long) x * x;
            ans += cnt.getOrDefault(y, 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1577 _tcSol = new Solution1577();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [7,4], nums2 = [5,2,8,9]");
        try {
            int[] nums1 = new int[]{7, 4};
            int[] nums2 = new int[]{5, 2, 8, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,1], nums2 = [1,1,1]");
        try {
            int[] nums1 = new int[]{1, 1};
            int[] nums2 = new int[]{1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [7,7,8,3], nums2 = [1,2,9,7]");
        try {
            int[] nums1 = new int[]{7, 7, 8, 3};
            int[] nums2 = new int[]{1, 2, 9, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.numTriplets(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
