package com.leetcode.arrays_hashing_greedy;

class Solution0349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        boolean[] s = new boolean[1001];
        for (int x : nums1) {
            s[x] = true;
        }
        List<Integer> ans = new ArrayList<>();
        for (int x : nums2) {
            if (s[x]) {
                ans.add(x);
                s[x] = false;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0349 _tcSol = new Solution0349();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums1 = [1,2,2,1], nums2 = [2,2]");
        try {
            int[] nums1 = new int[]{1, 2, 2, 1};
            int[] nums2 = new int[]{2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersection(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums1 = [4,9,5], nums2 = [9,4,9,8,4]");
        try {
            int[] nums1 = new int[]{4, 9, 5};
            int[] nums2 = new int[]{9, 4, 9, 8, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.intersection(nums1, nums2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[9,4]");
        System.out.println();
    }
}