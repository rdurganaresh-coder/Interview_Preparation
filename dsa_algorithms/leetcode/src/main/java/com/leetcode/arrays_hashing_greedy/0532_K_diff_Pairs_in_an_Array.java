package com.leetcode.arrays_hashing_greedy;

class Solution0532 {
    public int findPairs(int[] nums, int k) {
        Set<Integer> ans = new HashSet<>();
        Set<Integer> vis = new HashSet<>();
        for (int x : nums) {
            if (vis.contains(x - k)) {
                ans.add(x - k);
            }
            if (vis.contains(x + k)) {
                ans.add(x);
            }
            vis.add(x);
        }
        return ans.size();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0532 _tcSol = new Solution0532();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,4,1,5], k = 2");
        try {
            int[] nums = new int[]{3, 1, 4, 1, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3,4,5], k = 1");
        try {
            int[] nums = new int[]{1, 2, 3, 4, 5};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,3,1,5,4], k = 0");
        try {
            int[] nums = new int[]{1, 3, 1, 5, 4};
            int k = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.findPairs(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
