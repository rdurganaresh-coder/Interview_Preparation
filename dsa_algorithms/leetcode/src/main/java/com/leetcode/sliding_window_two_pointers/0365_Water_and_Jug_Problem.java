package com.leetcode.sliding_window_two_pointers;

class Solution0365 {
    private Set<Long> vis = new HashSet<>();
    private int x, y, z;

    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        x = jug1Capacity;
        y = jug2Capacity;
        z = targetCapacity;
        return dfs(0, 0);
    }

    private boolean dfs(int i, int j) {
        long st = f(i, j);
        if (!vis.add(st)) {
            return false;
        }
        if (i == z || j == z || i + j == z) {
            return true;
        }
        if (dfs(x, j) || dfs(i, y) || dfs(0, j) || dfs(i, 0)) {
            return true;
        }
        int a = Math.min(i, y - j);
        int b = Math.min(j, x - i);
        return dfs(i - a, j + a) || dfs(i + b, j - b);
    }

    private long f(int i, int j) {
        return i * 1000000L + j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0365 _tcSol = new Solution0365();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "x = 3, y = 5, target = 4");
        try {
            int jug1Capacity = 3;
            int jug2Capacity = 5;
            int targetCapacity = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "x = 2, y = 6, target = 5");
        try {
            int jug1Capacity = 2;
            int jug2Capacity = 6;
            int targetCapacity = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "x = 1, y = 2, target = 3");
        try {
            int jug1Capacity = 1;
            int jug2Capacity = 2;
            int targetCapacity = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canMeasureWater(jug1Capacity, jug2Capacity, targetCapacity)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}