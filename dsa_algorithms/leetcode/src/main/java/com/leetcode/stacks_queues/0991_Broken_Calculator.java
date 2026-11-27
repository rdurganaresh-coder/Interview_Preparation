package com.leetcode.stacks_queues;

class Solution0991 {
    public int brokenCalc(int startValue, int target) {
        int ans = 0;
        while (startValue < target) {
            if ((target & 1) == 1) {
                target++;
            } else {
                target >>= 1;
            }
            ans += 1;
        }
        ans += startValue - target;
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0991 _tcSol = new Solution0991();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "startValue = 2, target = 3");
        try {
            int startValue = 2;
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.brokenCalc(startValue, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "startValue = 5, target = 8");
        try {
            int startValue = 5;
            int target = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.brokenCalc(startValue, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "startValue = 3, target = 10");
        try {
            int startValue = 3;
            int target = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.brokenCalc(startValue, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}