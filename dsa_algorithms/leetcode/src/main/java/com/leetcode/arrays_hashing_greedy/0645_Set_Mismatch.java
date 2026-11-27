package com.leetcode.arrays_hashing_greedy;

class Solution0645 {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int s1 = (1 + n) * n / 2;
        int s2 = 0;
        Set<Integer> set = new HashSet<>();
        int s = 0;
        for (int x : nums) {
            if (set.add(x)) {
                s2 += x;
            }
            s += x;
        }
        return new int[] {s - s2, s1 - s2};
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0645 _tcSol = new Solution0645();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,4]");
        try {
            int[] nums = new int[]{1, 2, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.findErrorNums(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,3]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findErrorNums(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2]");
        System.out.println();
    }
}