package com.leetcode.arrays_hashing_greedy;

class Solution2410_2 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int j = 0, m = players.length;
        for (int t : trainers) {
            if (j < m && players[j] <= t) {
                ++j;
            }
        }
        return j;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2410_2 _tcSol = new Solution2410_2();
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
