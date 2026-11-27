package com.leetcode.arrays_hashing_greedy;

class Solution1989 {
    public int catchMaximumAmountofPeople(int[] team, int dist) {
        int ans = 0;
        int n = team.length;
        for (int i = 0, j = 0; i < n; ++i) {
            if (team[i] == 1) {
                while (j < n && (team[j] == 1 || i - j > dist)) {
                    ++j;
                }
                if (j < n && Math.abs(i - j) <= dist) {
                    ++ans;
                    ++j;
                }
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
        Solution1989 _tcSol = new Solution1989();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "team = [0,1,0,1,0], dist = 3");
        try {
            int[] team = new int[]{0, 1, 0, 1, 0};
            int dist = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.catchMaximumAmountofPeople(team, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "team = [1], dist = 1");
        try {
            int[] team = new int[]{1};
            int dist = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.catchMaximumAmountofPeople(team, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "team = [0], dist = 1");
        try {
            int[] team = new int[]{0};
            int dist = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.catchMaximumAmountofPeople(team, dist)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}