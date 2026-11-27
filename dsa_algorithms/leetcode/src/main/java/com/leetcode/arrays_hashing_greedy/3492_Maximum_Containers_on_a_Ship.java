package com.leetcode.arrays_hashing_greedy;

class Solution3492 {
    public int maxContainers(int n, int w, int maxWeight) {
        return Math.min(n * n * w, maxWeight) / w;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3492 _tcSol = new Solution3492();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = 2, w = 3, maxWeight = 15");
        try {
            int n = 2;
            int w = 3;
            int maxWeight = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxContainers(n, w, maxWeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = 3, w = 5, maxWeight = 20");
        try {
            int n = 3;
            int w = 5;
            int maxWeight = 20;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxContainers(n, w, maxWeight)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}
