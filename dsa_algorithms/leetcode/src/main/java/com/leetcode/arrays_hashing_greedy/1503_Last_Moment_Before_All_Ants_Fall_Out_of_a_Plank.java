package com.leetcode.arrays_hashing_greedy;

class Solution1503 {
    public int getLastMoment(int n, int[] left, int[] right) {
        int ans = 0;
        for (int x : left) {
            ans = Math.max(ans, x);
        }
        for (int x : right) {
            ans = Math.max(ans, n - x);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1503 _tcSol = new Solution1503();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 4, left = [4,3], right = [0,1]");
        try {
            int n = 4;
            int[] left = new int[]{4, 3};
            int[] right = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLastMoment(n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 7, left = [], right = [0,1,2,3,4,5,6,7]");
        try {
            int n = 7;
            int[] left = new int[]{};
            int[] right = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLastMoment(n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = 7, left = [0,1,2,3,4,5,6,7], right = []");
        try {
            int n = 7;
            int[] left = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
            int[] right = new int[]{};
            System.out.println("  Output  : " + _tcShow(_tcSol.getLastMoment(n, left, right)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}