package com.leetcode.arrays_hashing_greedy;

class Solution2463 {
    private Long[][] f;
    private List<Integer> robot;
    private int[][] factory;

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        this.robot = robot;
        this.factory = factory;
        f = new Long[robot.size()][factory.length];
        return dfs(0, 0);
    }

    private long dfs(int i, int j) {
        if (i == robot.size()) {
            return 0;
        }
        if (j == factory.length) {
            return Long.MAX_VALUE / 1000;
        }
        if (f[i][j] != null) {
            return f[i][j];
        }
        long ans = dfs(i, j + 1);
        long t = 0;
        for (int k = 0; k < factory[j][1]; ++k) {
            if (i + k == robot.size()) {
                break;
            }
            t += Math.abs(robot.get(i + k) - factory[j][0]);
            ans = Math.min(ans, t + dfs(i + k + 1, j + 1));
        }
        f[i][j] = ans;
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
        Solution2463 _tcSol = new Solution2463();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "robot = [0,4,6], factory = [[2,2],[6,2]]");
        try {
            List<Integer> robot = _tcL(0, 4, 6);
            int[][] factory = new int[][]{new int[]{2, 2}, new int[]{6, 2}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalDistance(robot, factory)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "robot = [1,-1], factory = [[-2,1],[2,1]]");
        try {
            List<Integer> robot = _tcL(1, -1);
            int[][] factory = new int[][]{new int[]{-2, 1}, new int[]{2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTotalDistance(robot, factory)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}
