package com.leetcode.strings;

class Solution1996 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> b[0] - a[0] == 0 ? a[1] - b[1] : b[0] - a[0]);
        int ans = 0, mx = 0;
        for (var x : properties) {
            if (x[1] < mx) {
                ++ans;
            }
            mx = Math.max(mx, x[1]);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1996 _tcSol = new Solution1996();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "properties = [[5,5],[6,3],[3,6]]");
        try {
            int[][] properties = new int[][]{new int[]{5, 5}, new int[]{6, 3}, new int[]{3, 6}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWeakCharacters(properties)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "properties = [[2,2],[3,3]]");
        try {
            int[][] properties = new int[][]{new int[]{2, 2}, new int[]{3, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWeakCharacters(properties)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "properties = [[1,5],[10,4],[4,3]]");
        try {
            int[][] properties = new int[][]{new int[]{1, 5}, new int[]{10, 4}, new int[]{4, 3}};
            System.out.println("  Output  : " + _tcShow(_tcSol.numberOfWeakCharacters(properties)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}