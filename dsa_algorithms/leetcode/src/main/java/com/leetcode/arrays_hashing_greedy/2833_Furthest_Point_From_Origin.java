package com.leetcode.arrays_hashing_greedy;

class Solution2833 {
    public int furthestDistanceFromOrigin(String moves) {
        return Math.abs(count(moves, 'L') - count(moves, 'R')) + count(moves, '_');
    }

    private int count(String s, char c) {
        int cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == c) {
                ++cnt;
            }
        }
        return cnt;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2833 _tcSol = new Solution2833();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "moves = \"L_RL__R\"");
        try {
            String moves = "L_RL__R";
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestDistanceFromOrigin(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "moves = \"_R__LL_\"");
        try {
            String moves = "_R__LL_";
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestDistanceFromOrigin(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "moves = \"_______\"");
        try {
            String moves = "_______";
            System.out.println("  Output  : " + _tcShow(_tcSol.furthestDistanceFromOrigin(moves)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();
    }
}