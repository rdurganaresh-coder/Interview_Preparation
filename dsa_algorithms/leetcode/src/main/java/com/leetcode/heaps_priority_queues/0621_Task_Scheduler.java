package com.leetcode.heaps_priority_queues;

class Solution0621 {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        int x = 0;
        for (char c : tasks) {
            c -= 'A';
            ++cnt[c];
            x = Math.max(x, cnt[c]);
        }
        int s = 0;
        for (int v : cnt) {
            if (v == x) {
                ++s;
            }
        }
        return Math.max(tasks.length, (x - 1) * (n + 1) + s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0621 _tcSol = new Solution0621();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tasks = [\"A\",\"A\",\"A\",\"B\",\"B\",\"B\"], n = 2");
        try {
            char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
            int n = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastInterval(tasks, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tasks = [\"A\",\"C\",\"A\",\"B\",\"D\",\"B\"], n = 1");
        try {
            char[] tasks = new char[]{'A', 'C', 'A', 'B', 'D', 'B'};
            int n = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastInterval(tasks, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tasks = [\"A\",\"A\",\"A\", \"B\",\"B\",\"B\"], n = 3");
        try {
            char[] tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
            int n = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.leastInterval(tasks, n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}