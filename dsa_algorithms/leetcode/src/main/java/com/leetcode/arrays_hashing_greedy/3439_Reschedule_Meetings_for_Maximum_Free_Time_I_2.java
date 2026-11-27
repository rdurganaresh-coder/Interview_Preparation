package com.leetcode.arrays_hashing_greedy;

class Solution3439_2 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = endTime.length;
        IntUnaryOperator f = i -> {
            if (i == 0) {
                return startTime[0];
            }
            if (i == n) {
                return eventTime - endTime[n - 1];
            }
            return startTime[i] - endTime[i - 1];
        };
        int ans = 0, s = 0;
        for (int i = 0; i <= n; i++) {
            s += f.applyAsInt(i);
            if (i >= k) {
                ans = Math.max(ans, s);
                s -= f.applyAsInt(i - k);
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
        Solution3439_2 _tcSol = new Solution3439_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "eventTime = 5, k = 1, startTime = [1,3], endTime = [2,5]");
        try {
            int eventTime = 5;
            int k = 1;
            int[] startTime = new int[]{1, 3};
            int[] endTime = new int[]{2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, k, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "eventTime = 10, k = 1, startTime = [0,2,9], endTime = [1,4,10]");
        try {
            int eventTime = 10;
            int k = 1;
            int[] startTime = new int[]{0, 2, 9};
            int[] endTime = new int[]{1, 4, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, k, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "eventTime = 5, k = 2, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]");
        try {
            int eventTime = 5;
            int k = 2;
            int[] startTime = new int[]{0, 1, 2, 3, 4};
            int[] endTime = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, k, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
