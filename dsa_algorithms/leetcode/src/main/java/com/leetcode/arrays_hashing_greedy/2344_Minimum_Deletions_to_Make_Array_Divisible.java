package com.leetcode.arrays_hashing_greedy;

class Solution2344 {
    public int minOperations(int[] nums, int[] numsDivide) {
        int x = 0;
        for (int v : numsDivide) {
            x = gcd(x, v);
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; ++i) {
            if (x % nums[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2344 _tcSol = new Solution2344();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,3,2,4,3], numsDivide = [9,6,9,3,15]");
        try {
            int[] nums = new int[]{2, 3, 2, 4, 3};
            int[] numsDivide = new int[]{9, 6, 9, 3, 15};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, numsDivide)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,3,6], numsDivide = [8,2,6,10]");
        try {
            int[] nums = new int[]{4, 3, 6};
            int[] numsDivide = new int[]{8, 2, 6, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, numsDivide)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}