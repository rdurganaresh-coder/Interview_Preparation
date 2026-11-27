package com.leetcode.bit_manipulation_math;

class Solution3143 {
    public int maxPointsInsideSquare(int[][] points, String s) {
        TreeMap<Integer, List<Integer>> g = new TreeMap<>();
        for (int i = 0; i < points.length; ++i) {
            int x = points[i][0], y = points[i][1];
            int key = Math.max(Math.abs(x), Math.abs(y));
            g.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }
        boolean[] vis = new boolean[26];
        int ans = 0;
        for (var idx : g.values()) {
            for (int i : idx) {
                int j = s.charAt(i) - 'a';
                if (vis[j]) {
                    return ans;
                }
                vis[j] = true;
            }
            ans += idx.size();
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3143 _tcSol = new Solution3143();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "points = [[2,2],[-1,-2],[-4,4],[-3,1],[3,-3]], s = \"abdca\"");
        try {
            int[][] points = new int[][]{new int[]{2, 2}, new int[]{-1, -2}, new int[]{-4, 4}, new int[]{-3, 1}, new int[]{3, -3}};
            String s = "abdca";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPointsInsideSquare(points, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "points = [[1,1],[-2,-2],[-2,2]], s = \"abb\"");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{-2, -2}, new int[]{-2, 2}};
            String s = "abb";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPointsInsideSquare(points, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "points = [[1,1],[-1,-1],[2,-2]], s = \"ccd\"");
        try {
            int[][] points = new int[][]{new int[]{1, 1}, new int[]{-1, -1}, new int[]{2, -2}};
            String s = "ccd";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxPointsInsideSquare(points, s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}