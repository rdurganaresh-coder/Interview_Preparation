package com.leetcode.arrays_hashing_greedy;

class Solution3440 {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0] = startTime[0];
        suf[n - 1] = eventTime - endTime[n - 1];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], startTime[i] - endTime[i - 1]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suf[i] = Math.max(suf[i + 1], startTime[i + 1] - endTime[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int l = (i == 0) ? 0 : endTime[i - 1];
            int r = (i == n - 1) ? eventTime : startTime[i + 1];
            int w = endTime[i] - startTime[i];
            ans = Math.max(ans, r - l - w);

            if (i > 0 && pre[i - 1] >= w) {
                ans = Math.max(ans, r - l);
            } else if (i + 1 < n && suf[i + 1] >= w) {
                ans = Math.max(ans, r - l);
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
        Solution3440 _tcSol = new Solution3440();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "eventTime = 5, startTime = [1,3], endTime = [2,5]");
        try {
            int eventTime = 5;
            int[] startTime = new int[]{1, 3};
            int[] endTime = new int[]{2, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "eventTime = 10, startTime = [0,7,9], endTime = [1,8,10]");
        try {
            int eventTime = 10;
            int[] startTime = new int[]{0, 7, 9};
            int[] endTime = new int[]{1, 8, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "eventTime = 10, startTime = [0,3,7,9], endTime = [1,4,8,10]");
        try {
            int eventTime = 10;
            int[] startTime = new int[]{0, 3, 7, 9};
            int[] endTime = new int[]{1, 4, 8, 10};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "eventTime = 5, startTime = [0,1,2,3,4], endTime = [1,2,3,4,5]");
        try {
            int eventTime = 5;
            int[] startTime = new int[]{0, 1, 2, 3, 4};
            int[] endTime = new int[]{1, 2, 3, 4, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.maxFreeTime(eventTime, startTime, endTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
