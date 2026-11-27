package com.leetcode.arrays_hashing_greedy;

class Solution0447 {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for (int[] p1 : points) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int[] p2 : points) {
                int d = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                ans += cnt.getOrDefault(d, 0);
                cnt.merge(d, 1, Integer::sum);
            }
        }
        return ans << 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0447 _tcSol = new Solution0447();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[0,0],[1,0],[2,0]]");
        try {
            int[][] points = new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfBoomerangs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[2,2],[3,3]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfBoomerangs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[1,1]]");
        try {
            int[][] points = new int[][]{new int[]{1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfBoomerangs(points)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}