package com.leetcode.arrays_hashing_greedy;

class Solution2335 {
    public int fillCups(int[] amount) {
        int ans = 0;
        while (amount[0] + amount[1] + amount[2] > 0) {
            Arrays.sort(amount);
            ++ans;
            amount[2]--;
            amount[1] = Math.max(0, amount[1] - 1);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2335 _tcSol = new Solution2335();
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