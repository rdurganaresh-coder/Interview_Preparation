package com.leetcode.arrays_hashing_greedy;

class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        // long s = Arrays.stream(nums).asLongStream().sum();
        long s = 0;
        for (int v : nums) {
            s += v;
        }
        long d = Math.abs(s - goal);
        return (int) ((d + limit - 1) / limit);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1785 _tcSol = new Solution1785();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,-1,1], limit = 3, goal = -4");
        try {
            int[] nums = new int[]{1, -1, 1};
            int limit = 3;
            int goal = -4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minElements(nums, limit, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,-10,9,1], limit = 100, goal = 0");
        try {
            int[] nums = new int[]{1, -10, 9, 1};
            int limit = 100;
            int goal = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minElements(nums, limit, goal)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}