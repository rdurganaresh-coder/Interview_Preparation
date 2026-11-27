package com.leetcode.arrays_hashing_greedy;

class Solution1679_2 {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int ans = 0;
        for (int x : nums) {
            if (cnt.containsKey(k - x)) {
                ++ans;
                if (cnt.merge(k - x, -1, Integer::sum) == 0) {
                    cnt.remove(k - x);
                }
            } else {
                cnt.merge(x, 1, Integer::sum);
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
        Solution1679_2 _tcSol = new Solution1679_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3,4], k = 5");
        try {
            int[] nums = new int[]{1, 2, 3, 4};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,1,3,4,3], k = 6");
        try {
            int[] nums = new int[]{3, 1, 3, 4, 3};
            int k = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxOperations(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}