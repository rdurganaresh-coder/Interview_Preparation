package com.leetcode.arrays_hashing_greedy;

class Solution3002 {
    public int maximumSetSize(int[] nums1, int[] nums2) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        for (int x : nums1) {
            s1.add(x);
        }
        for (int x : nums2) {
            s2.add(x);
        }
        int n = nums1.length;
        int a = 0, b = 0, c = 0;
        for (int x : s1) {
            if (!s2.contains(x)) {
                ++a;
            }
        }
        for (int x : s2) {
            if (!s1.contains(x)) {
                ++b;
            } else {
                ++c;
            }
        }
        a = Math.min(a, n / 2);
        b = Math.min(b, n / 2);
        return Math.min(a + b + c, n);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3002 _tcSol = new Solution3002();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,1,2], nums2 = [1,1,1,1]");
        try {
            int[] nums1 = new int[]{1, 2, 1, 2};
            int[] nums2 = new int[]{1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSetSize(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]");
        try {
            int[] nums1 = new int[]{1, 2, 3, 4, 5, 6};
            int[] nums2 = new int[]{2, 3, 2, 3, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSetSize(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums1 = [1,1,2,2,3,3], nums2 = [4,4,5,5,6,6]");
        try {
            int[] nums1 = new int[]{1, 1, 2, 2, 3, 3};
            int[] nums2 = new int[]{4, 4, 5, 5, 6, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSetSize(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}