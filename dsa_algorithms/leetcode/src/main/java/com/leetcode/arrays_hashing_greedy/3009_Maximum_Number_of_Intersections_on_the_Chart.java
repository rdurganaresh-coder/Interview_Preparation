package com.leetcode.arrays_hashing_greedy;

class Solution3009 {
    public int maxIntersectionCount(int[] y) {
        final int n = y.length;
        int ans = 0;
        int intersectionCount = 0;
        TreeMap<Integer, Integer> line = new TreeMap<>();

        for (int i = 1; i < n; ++i) {
            final int start = 2 * y[i - 1];
            final int end = 2 * y[i] + (i == n - 1 ? 0 : y[i] > y[i - 1] ? -1 : 1);
            line.merge(Math.min(start, end), 1, Integer::sum);
            line.merge(Math.max(start, end) + 1, -1, Integer::sum);
        }

        for (final int count : line.values()) {
            intersectionCount += count;
            ans = Math.max(ans, intersectionCount);
        }

        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3009 _tcSol = new Solution3009();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "y = [1,2,1,2,1,3,2]");
        try {
            int[] y = new int[]{1, 2, 1, 2, 1, 3, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIntersectionCount(y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "y = [2,1,3,4,5]");
        try {
            int[] y = new int[]{2, 1, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxIntersectionCount(y)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
