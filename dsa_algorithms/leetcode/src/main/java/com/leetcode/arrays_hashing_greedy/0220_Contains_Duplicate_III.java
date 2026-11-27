package com.leetcode.arrays_hashing_greedy;

class Solution0220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> ts = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long x = ts.ceiling((long) nums[i] - (long) valueDiff);
            if (x != null && x <= (long) nums[i] + (long) valueDiff) {
                return true;
            }
            ts.add((long) nums[i]);
            if (i >= indexDiff) {
                ts.remove((long) nums[i - indexDiff]);
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0220 _tcSol = new Solution0220();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,1], indexDiff = 3, valueDiff = 0");
        try {
            int[] nums = new int[]{1, 2, 3, 1};
            int indexDiff = 3;
            int valueDiff = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,5,9,1,5,9], indexDiff = 2, valueDiff = 3");
        try {
            int[] nums = new int[]{1, 5, 9, 1, 5, 9};
            int indexDiff = 2;
            int valueDiff = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsNearbyAlmostDuplicate(nums, indexDiff, valueDiff)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}