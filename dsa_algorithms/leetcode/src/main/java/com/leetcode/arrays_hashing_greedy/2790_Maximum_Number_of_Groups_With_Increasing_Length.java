package com.leetcode.arrays_hashing_greedy;

class Solution2790 {
    public int maxIncreasingGroups(List<Integer> usageLimits) {
        Collections.sort(usageLimits);
        int k = 0;
        long s = 0;
        for (int x : usageLimits) {
            s += x;
            if (s > k) {
                ++k;
                s -= k;
            }
        }
        return k;
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
        Solution2790 _tcSol = new Solution2790();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "usageLimits = [1,2,5]");
        try {
            List<Integer> usageLimits = _tcL(1, 2, 5);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingGroups(usageLimits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "usageLimits = [2,1,2]");
        try {
            List<Integer> usageLimits = _tcL(2, 1, 2);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingGroups(usageLimits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "usageLimits = [1,1]");
        try {
            List<Integer> usageLimits = _tcL(1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIncreasingGroups(usageLimits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}