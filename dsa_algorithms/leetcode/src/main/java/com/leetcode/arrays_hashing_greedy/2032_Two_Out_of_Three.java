package com.leetcode.arrays_hashing_greedy;

class Solution2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] s1 = get(nums1), s2 = get(nums2), s3 = get(nums3);
        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= 100; ++i) {
            if (s1[i] + s2[i] + s3[i] > 1) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int[] get(int[] nums) {
        int[] s = new int[101];
        for (int num : nums) {
            s[num] = 1;
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2032 _tcSol = new Solution2032();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,1,3,2], nums2 = [2,3], nums3 = [3]");
        try {
            int[] nums1 = new int[]{1, 1, 3, 2};
            int[] nums2 = new int[]{2, 3};
            int[] nums3 = new int[]{3};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoOutOfThree(nums1, nums2, nums3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[3,2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [3,1], nums2 = [2,3], nums3 = [1,2]");
        try {
            int[] nums1 = new int[]{3, 1};
            int[] nums2 = new int[]{2, 3};
            int[] nums3 = new int[]{1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoOutOfThree(nums1, nums2, nums3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3,1]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,2,2], nums2 = [4,3,3], nums3 = [5]");
        try {
            int[] nums1 = new int[]{1, 2, 2};
            int[] nums2 = new int[]{4, 3, 3};
            int[] nums3 = new int[]{5};
            System.out.println("  Output  : " + _tcShow(_tcSol.twoOutOfThree(nums1, nums2, nums3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}