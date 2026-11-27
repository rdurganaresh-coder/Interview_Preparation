package com.leetcode.sql_database;

class Solution1386 {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Integer> d = new HashMap<>();
        for (var e : reservedSeats) {
            int i = e[0], j = e[1];
            d.merge(i, 1 << (10 - j), (x, y) -> x | y);
        }
        int[] masks = {0b0111100000, 0b0000011110, 0b0001111000};
        int ans = (n - d.size()) * 2;
        for (int x : d.values()) {
            for (int mask : masks) {
                if ((x & mask) == 0) {
                    x |= mask;
                    ++ans;
                }
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
        Solution1386 _tcSol = new Solution1386();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 3, reservedSeats = [[1,2],[1,3],[1,8],[2,6],[3,1],[3,10]]");
        try {
            int n = 3;
            int[][] reservedSeats = new int[][]{new int[]{1, 2}, new int[]{1, 3}, new int[]{1, 8}, new int[]{2, 6}, new int[]{3, 1}, new int[]{3, 10}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfFamilies(n, reservedSeats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 2, reservedSeats = [[2,1],[1,8],[2,6]]");
        try {
            int n = 2;
            int[][] reservedSeats = new int[][]{new int[]{2, 1}, new int[]{1, 8}, new int[]{2, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfFamilies(n, reservedSeats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 4, reservedSeats = [[4,3],[1,4],[4,6],[1,7]]");
        try {
            int n = 4;
            int[][] reservedSeats = new int[][]{new int[]{4, 3}, new int[]{1, 4}, new int[]{4, 6}, new int[]{1, 7}};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfFamilies(n, reservedSeats)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}