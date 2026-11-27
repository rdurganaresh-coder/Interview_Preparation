package com.leetcode.arrays_hashing_greedy;

class Solution1776 {
    public double[] getCollisionTimes(int[][] cars) {
        int n = cars.length;
        double[] ans = new double[n];
        Arrays.fill(ans, -1.0);
        Deque<Integer> stk = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; --i) {
            while (!stk.isEmpty()) {
                int j = stk.peek();
                if (cars[i][1] > cars[j][1]) {
                    double t = (cars[j][0] - cars[i][0]) * 1.0 / (cars[i][1] - cars[j][1]);
                    if (ans[j] < 0 || t <= ans[j]) {
                        ans[i] = t;
                        break;
                    }
                }
                stk.pop();
            }
            stk.push(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1776 _tcSol = new Solution1776();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "cars = [[1,2],[2,1],[4,3],[7,2]]");
        try {
            int[][] cars = new int[][]{new int[]{1, 2}, new int[]{2, 1}, new int[]{4, 3}, new int[]{7, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCollisionTimes(cars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1.00000,-1.00000,3.00000,-1.00000]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "cars = [[3,4],[5,4],[6,3],[9,1]]");
        try {
            int[][] cars = new int[][]{new int[]{3, 4}, new int[]{5, 4}, new int[]{6, 3}, new int[]{9, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.getCollisionTimes(cars)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2.00000,1.00000,1.50000,-1.00000]");
        System.out.println();
    }
}