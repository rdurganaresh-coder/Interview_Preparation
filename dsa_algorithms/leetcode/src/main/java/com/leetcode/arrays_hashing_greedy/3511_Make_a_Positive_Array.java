package com.leetcode.arrays_hashing_greedy;

class Solution3511 {
    public int makeArrayPositive(int[] nums) {
        int ans = 0;
        long preMx = 0, s = 0;
        for (int l = -1, r = 0; r < nums.length; r++) {
            int x = nums[r];
            s += x;
            if (r - l > 2 && s <= preMx) {
                ans++;
                l = r;
                preMx = s = 0;
            } else if (r - l >= 2) {
                preMx = Math.max(preMx, s - x - nums[r - 1]);
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
        Solution3511 _tcSol = new Solution3511();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [-10,15,-12]");
        try {
            int[] nums = new int[]{-10, 15, -12};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [-1,-2,3,-1,2,6]");
        try {
            int[] nums = new int[]{-1, -2, 3, -1, 2, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3]");
        try {
            int[] nums = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.makeArrayPositive(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
