package com.leetcode.sliding_window_two_pointers;

class Solution1526 {
    public int minNumberOperations(int[] target) {
        int f = target[0];
        for (int i = 1; i < target.length; ++i) {
            if (target[i] > target[i - 1]) {
                f += target[i] - target[i - 1];
            }
        }
        return f;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1526 _tcSol = new Solution1526();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = [1,2,3,2,1]");
        try {
            int[] target = new int[]{1, 2, 3, 2, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOperations(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = [3,1,1,2]");
        try {
            int[] target = new int[]{3, 1, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOperations(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "target = [3,1,5,4,2]");
        try {
            int[] target = new int[]{3, 1, 5, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.minNumberOperations(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}