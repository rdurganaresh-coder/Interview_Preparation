package com.leetcode.arrays_hashing_greedy;

class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        for (int x : batteryPercentages) {
            ans += x > ans ? 1 : 0;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2960 _tcSol = new Solution2960();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "batteryPercentages = [1,1,2,1,3]");
        try {
            int[] batteryPercentages = new int[]{1, 1, 2, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTestedDevices(batteryPercentages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "batteryPercentages = [0,1,2]");
        try {
            int[] batteryPercentages = new int[]{0, 1, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTestedDevices(batteryPercentages)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}