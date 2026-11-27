package com.leetcode.arrays_hashing_greedy;

class Solution2660 {
    public int isWinner(int[] player1, int[] player2) {
        int a = f(player1), b = f(player2);
        return a > b ? 1 : b > a ? 2 : 0;
    }

    private int f(int[] arr) {
        int s = 0;
        for (int i = 0; i < arr.length; ++i) {
            int k = (i > 0 && arr[i - 1] == 10) || (i > 1 && arr[i - 2] == 10) ? 2 : 1;
            s += k * arr[i];
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2660 _tcSol = new Solution2660();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "player1 = [5,10,3,2], player2 = [6,5,7,3]");
        try {
            int[] player1 = new int[]{5, 10, 3, 2};
            int[] player2 = new int[]{6, 5, 7, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.isWinner(player1, player2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "player1 = [3,5,7,6], player2 = [8,10,10,2]");
        try {
            int[] player1 = new int[]{3, 5, 7, 6};
            int[] player2 = new int[]{8, 10, 10, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.isWinner(player1, player2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "player1 = [2,3], player2 = [4,1]");
        try {
            int[] player1 = new int[]{2, 3};
            int[] player2 = new int[]{4, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isWinner(player1, player2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 4");
        System.out.println("  Input   : " + "player1 = [1,1,1,10,10,10,10], player2 = [10,10,10,10,1,1,1]");
        try {
            int[] player1 = new int[]{1, 1, 1, 10, 10, 10, 10};
            int[] player2 = new int[]{10, 10, 10, 10, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.isWinner(player1, player2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}