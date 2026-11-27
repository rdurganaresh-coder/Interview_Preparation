package com.leetcode.arrays_hashing_greedy;

class Solution2335_2 {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        if (amount[0] + amount[1] <= amount[2]) {
            return amount[2];
        }
        return (amount[0] + amount[1] + amount[2] + 1) / 2;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2335_2 _tcSol = new Solution2335_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "amount = [1,4,2]");
        try {
            int[] amount = new int[]{1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.fillCups(amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "amount = [5,4,4]");
        try {
            int[] amount = new int[]{5, 4, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.fillCups(amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "amount = [5,0,0]");
        try {
            int[] amount = new int[]{5, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.fillCups(amount)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}