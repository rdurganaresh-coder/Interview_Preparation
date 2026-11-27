package com.leetcode.arrays_hashing_greedy;

class Solution2410 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int m = players.length, n = trainers.length;
        for (int i = 0, j = 0; i < m; ++i, ++j) {
            while (j < n && trainers[j] < players[i]) {
                ++j;
            }
            if (j == n) {
                return i;
            }
        }
        return m;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2410 _tcSol = new Solution2410();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "players = [4,7,9], trainers = [8,2,5,8]");
        try {
            int[] players = new int[]{4, 7, 9};
            int[] trainers = new int[]{8, 2, 5, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.matchPlayersAndTrainers(players, trainers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "players = [1,1,1], trainers = [10]");
        try {
            int[] players = new int[]{1, 1, 1};
            int[] trainers = new int[]{10};
            System.out.println("  Output  : " + _tcShow(_tcSol.matchPlayersAndTrainers(players, trainers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
