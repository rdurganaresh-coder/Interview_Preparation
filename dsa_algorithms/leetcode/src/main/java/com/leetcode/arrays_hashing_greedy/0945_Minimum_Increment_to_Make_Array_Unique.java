package com.leetcode.arrays_hashing_greedy;

class Solution0945 {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int ans = 0, y = -1;
        for (int x : nums) {
            y = Math.max(y + 1, x);
            ans += y - x;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0945 _tcSol = new Solution0945();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2]");
        try {
            int[] nums = new int[]{1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementForUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [3,2,1,2,1,7]");
        try {
            int[] nums = new int[]{3, 2, 1, 2, 1, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minIncrementForUnique(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}