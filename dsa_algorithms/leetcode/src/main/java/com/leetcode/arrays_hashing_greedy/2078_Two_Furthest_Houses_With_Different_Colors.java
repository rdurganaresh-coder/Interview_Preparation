package com.leetcode.arrays_hashing_greedy;

class Solution2078 {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        if (colors[0] != colors[n - 1]) {
            return n - 1;
        }
        int i = 1, j = n - 2;
        while (colors[i] == colors[0]) {
            ++i;
        }
        while (colors[j] == colors[0]) {
            --j;
        }
        return Math.max(n - i - 1, j);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2078 _tcSol = new Solution2078();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "colors = [1,1,1,6,1,1,1]");
        try {
            int[] colors = new int[]{1, 1, 1, 6, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "colors = [1,8,3,8,3]");
        try {
            int[] colors = new int[]{1, 8, 3, 8, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "colors = [0,1]");
        try {
            int[] colors = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxDistance(colors)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
