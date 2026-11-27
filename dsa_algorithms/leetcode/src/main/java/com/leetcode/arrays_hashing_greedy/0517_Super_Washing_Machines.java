package com.leetcode.arrays_hashing_greedy;

class Solution0517 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int s = 0;
        for (int x : machines) {
            s += x;
        }
        if (s % n != 0) {
            return -1;
        }
        int k = s / n;
        s = 0;
        int ans = 0;
        for (int x : machines) {
            x -= k;
            s += x;
            ans = Math.max(ans, Math.max(Math.abs(s), x));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0517 _tcSol = new Solution0517();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "machines = [1,0,5]");
        try {
            int[] machines = new int[]{1, 0, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinMoves(machines)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "machines = [0,3,0]");
        try {
            int[] machines = new int[]{0, 3, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinMoves(machines)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "machines = [0,2,0]");
        try {
            int[] machines = new int[]{0, 2, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMinMoves(machines)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}