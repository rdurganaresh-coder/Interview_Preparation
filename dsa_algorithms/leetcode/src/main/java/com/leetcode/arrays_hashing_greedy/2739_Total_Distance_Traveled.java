package com.leetcode.arrays_hashing_greedy;

class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0, cur = 0;
        while (mainTank > 0) {
            cur++;
            ans += 10;
            mainTank--;
            if (cur % 5 == 0 && additionalTank > 0) {
                additionalTank--;
                mainTank++;
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
        Solution2739 _tcSol = new Solution2739();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mainTank = 5, additionalTank = 10");
        try {
            int mainTank = 5;
            int additionalTank = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceTraveled(mainTank, additionalTank)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "60");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mainTank = 1, additionalTank = 2");
        try {
            int mainTank = 1;
            int additionalTank = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.distanceTraveled(mainTank, additionalTank)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}