package com.leetcode.arrays_hashing_greedy;

class Solution0657 {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char c : moves.toCharArray()) {
            switch (c) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'L' -> x--;
                case 'R' -> x++;
            }
        }
        return x == 0 && y == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0657 _tcSol = new Solution0657();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "moves = \"UD\"");
        try {
            String moves = "UD";
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeCircle(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "moves = \"LL\"");
        try {
            String moves = "LL";
            System.out.println("  Output  : " + _tcShow(_tcSol.judgeCircle(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
