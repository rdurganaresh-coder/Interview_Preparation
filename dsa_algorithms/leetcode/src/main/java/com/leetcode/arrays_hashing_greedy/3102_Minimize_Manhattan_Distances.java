package com.leetcode.arrays_hashing_greedy;

class Solution3102 {
    public int minimumDistance(int[][] points) {
        TreeMap<Integer, Integer> tm1 = new TreeMap<>();
        TreeMap<Integer, Integer> tm2 = new TreeMap<>();
        for (int[] p : points) {
            int x = p[0], y = p[1];
            tm1.merge(x + y, 1, Integer::sum);
            tm2.merge(x - y, 1, Integer::sum);
        }
        int ans = Integer.MAX_VALUE;
        for (int[] p : points) {
            int x = p[0], y = p[1];
            if (tm1.merge(x + y, -1, Integer::sum) == 0) {
                tm1.remove(x + y);
            }
            if (tm2.merge(x - y, -1, Integer::sum) == 0) {
                tm2.remove(x - y);
            }
            ans = Math.min(
                ans, Math.max(tm1.lastKey() - tm1.firstKey(), tm2.lastKey() - tm2.firstKey()));
            tm1.merge(x + y, 1, Integer::sum);
            tm2.merge(x - y, 1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3102 _tcSol = new Solution3102();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[3,10],[5,15],[10,2],[4,4]]");
        try {
            int[][] points = new int[][]{new int[]{3, 10}, new int[]{5, 15}, new int[]{10, 2}, new int[]{4, 4}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDistance(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "12");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[1,1],[1,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{1, 1}, new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumDistance(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}