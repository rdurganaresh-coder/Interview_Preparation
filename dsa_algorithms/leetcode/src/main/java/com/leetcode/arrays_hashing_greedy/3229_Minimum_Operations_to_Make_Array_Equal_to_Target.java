package com.leetcode.arrays_hashing_greedy;

class Solution3229 {
    public long minimumOperations(int[] nums, int[] target) {
        long f = Math.abs(target[0] - nums[0]);
        for (int i = 1; i < nums.length; ++i) {
            long x = target[i] - nums[i];
            long y = target[i - 1] - nums[i - 1];
            if (x * y > 0) {
                long d = Math.abs(x) - Math.abs(y);
                if (d > 0) {
                    f += d;
                }
            } else {
                f += Math.abs(x);
            }
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3229 _tcSol = new Solution3229();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,5,1,2], target = [4,6,2,4]");
        try {
            int[] nums = new int[]{3, 5, 1, 2};
            int[] target = new int[]{4, 6, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,2], target = [2,1,4]");
        try {
            int[] nums = new int[]{1, 3, 2};
            int[] target = new int[]{2, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}