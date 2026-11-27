package com.leetcode.arrays_hashing_greedy;

class Solution2021 {
    public int brightestPosition(int[][] lights) {
        TreeMap<Integer, Integer> d = new TreeMap<>();
        for (var x : lights) {
            int l = x[0] - x[1], r = x[0] + x[1];
            d.merge(l, 1, Integer::sum);
            d.merge(r + 1, -1, Integer::sum);
        }
        int ans = 0, s = 0, mx = 0;
        for (var x : d.entrySet()) {
            int v = x.getValue();
            s += v;
            if (mx < s) {
                mx = s;
                ans = x.getKey();
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2021 _tcSol = new Solution2021();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "lights = [[-3,2],[1,2],[3,3]]");
        try {
            int[][] lights = new int[][]{new int[]{-3, 2}, new int[]{1, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.brightestPosition(lights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "lights = [[1,0],[0,1]]");
        try {
            int[][] lights = new int[][]{new int[]{1, 0}, new int[]{0, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.brightestPosition(lights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "lights = [[1,2]]");
        try {
            int[][] lights = new int[][]{new int[]{1, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.brightestPosition(lights)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}