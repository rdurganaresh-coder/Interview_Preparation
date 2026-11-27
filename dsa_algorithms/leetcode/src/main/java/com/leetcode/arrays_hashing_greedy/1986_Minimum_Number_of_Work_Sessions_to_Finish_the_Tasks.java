package com.leetcode.arrays_hashing_greedy;

class Solution1986 {
    public int minSessions(int[] tasks, int sessionTime) {
        int n = tasks.length;
        boolean[] ok = new boolean[1 << n];
        for (int i = 1; i < 1 << n; ++i) {
            int t = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    t += tasks[j];
                }
            }
            ok[i] = t <= sessionTime;
        }
        int[] f = new int[1 << n];
        Arrays.fill(f, 1 << 30);
        f[0] = 0;
        for (int i = 1; i < 1 << n; ++i) {
            for (int j = i; j > 0; j = (j - 1) & i) {
                if (ok[j]) {
                    f[i] = Math.min(f[i], f[i ^ j] + 1);
                }
            }
        }
        return f[(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1986 _tcSol = new Solution1986();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [1,2,3], sessionTime = 3");
        try {
            int[] tasks = new int[]{1, 2, 3};
            int sessionTime = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSessions(tasks, sessionTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [3,1,3,1,1], sessionTime = 8");
        try {
            int[] tasks = new int[]{3, 1, 3, 1, 1};
            int sessionTime = 8;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSessions(tasks, sessionTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tasks = [1,2,3,4,5], sessionTime = 15");
        try {
            int[] tasks = new int[]{1, 2, 3, 4, 5};
            int sessionTime = 15;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSessions(tasks, sessionTime)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}