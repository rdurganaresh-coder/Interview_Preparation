package com.leetcode.arrays_hashing_greedy;

class Solution2214 {
    public long minimumHealth(int[] damage, int armor) {
        long s = 0;
        int mx = damage[0];
        for (int v : damage) {
            s += v;
            mx = Math.max(mx, v);
        }
        return s - Math.min(mx, armor) + 1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2214 _tcSol = new Solution2214();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "damage = [2,7,4,3], armor = 4");
        try {
            int[] damage = new int[]{2, 7, 4, 3};
            int armor = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHealth(damage, armor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "damage = [2,5,3,4], armor = 7");
        try {
            int[] damage = new int[]{2, 5, 3, 4};
            int armor = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHealth(damage, armor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "damage = [3,3,3], armor = 0");
        try {
            int[] damage = new int[]{3, 3, 3};
            int armor = 0;
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumHealth(damage, armor)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}