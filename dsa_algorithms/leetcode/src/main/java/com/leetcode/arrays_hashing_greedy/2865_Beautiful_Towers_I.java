package com.leetcode.arrays_hashing_greedy;

class Solution2865 {
    public long maximumSumOfHeights(List<Integer> maxHeights) {
        long ans = 0;
        int n = maxHeights.size();
        for (int i = 0; i < n; ++i) {
            int y = maxHeights.get(i);
            long t = y;
            for (int j = i - 1; j >= 0; --j) {
                y = Math.min(y, maxHeights.get(j));
                t += y;
            }
            y = maxHeights.get(i);
            for (int j = i + 1; j < n; ++j) {
                y = Math.min(y, maxHeights.get(j));
                t += y;
            }
            ans = Math.max(ans, t);
        }
        return ans;
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
        Solution2865 _tcSol = new Solution2865();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "heights = [5,3,4,1,1]");
        try {
            List<Integer> maxHeights = _tcL(5, 3, 4, 1, 1);
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumOfHeights(maxHeights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "heights = [6,5,3,9,2,7]");
        try {
            List<Integer> maxHeights = _tcL(6, 5, 3, 9, 2, 7);
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumOfHeights(maxHeights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "22");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "heights = [3,2,5,5,2,3]");
        try {
            List<Integer> maxHeights = _tcL(3, 2, 5, 5, 2, 3);
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumSumOfHeights(maxHeights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "18");
        System.out.println();
    }
}