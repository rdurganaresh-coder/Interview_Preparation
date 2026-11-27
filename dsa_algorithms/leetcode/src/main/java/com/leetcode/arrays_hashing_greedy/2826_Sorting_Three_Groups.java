package com.leetcode.arrays_hashing_greedy;

class Solution2826 {
    public int minimumOperations(List<Integer> nums) {
        int[] f = new int[3];
        for (int x : nums) {
            int[] g = new int[3];
            if (x == 1) {
                g[0] = f[0];
                g[1] = Math.min(f[0], f[1]) + 1;
                g[2] = Math.min(f[0], Math.min(f[1], f[2])) + 1;
            } else if (x == 2) {
                g[0] = f[0] + 1;
                g[1] = Math.min(f[0], f[1]);
                g[2] = Math.min(f[0], Math.min(f[1], f[2])) + 1;
            } else {
                g[0] = f[0] + 1;
                g[1] = Math.min(f[0], f[1]) + 1;
                g[2] = Math.min(f[0], Math.min(f[1], f[2]));
            }
            f = g;
        }
        return Math.min(f[0], Math.min(f[1], f[2]));
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    @SafeVarargs
    private static <T> java.util.List<T> _tcL(T... a) {
        return new java.util.ArrayList<>(java.util.Arrays.asList(a));
    }

    public static void main(String[] args) {
        Solution2826 _tcSol = new Solution2826();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [2,1,3,2,1]");
        try {
            List<Integer> nums = _tcL(2, 1, 3, 2, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,2,1,3,3]");
        try {
            List<Integer> nums = _tcL(1, 3, 2, 1, 3, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,2,2,2,3,3]");
        try {
            List<Integer> nums = _tcL(2, 2, 2, 2, 3, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumOperations(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}