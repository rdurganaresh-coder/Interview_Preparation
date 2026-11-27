package com.leetcode.arrays_hashing_greedy;

class Solution0219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i - d.getOrDefault(nums[i], -1000000) <= k) {
                return true;
            }
            d.put(nums[i], i);
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0219 _tcSol = new Solution0219();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsNearbyDuplicate(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,1,1], k = 1");
        try {
            int[] nums = new int[]{1, 0, 1, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsNearbyDuplicate(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3,1,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3, 1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsNearbyDuplicate(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}