package com.leetcode.arrays_hashing_greedy;

class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int k = 0;
        int[] dist = new int[4];
        for (int i = 0; i < instructions.length(); ++i) {
            char c = instructions.charAt(i);
            if (c == 'L') {
                k = (k + 1) % 4;
            } else if (c == 'R') {
                k = (k + 3) % 4;
            } else {
                ++dist[k];
            }
        }
        return (dist[0] == dist[2] && dist[1] == dist[3]) || (k != 0);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1041 _tcSol = new Solution1041();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "instructions = \"GGLLGG\"");
        try {
            String instructions = "GGLLGG";
            System.out.println("  Output  : " + _tcShow(_tcSol.isRobotBounded(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "instructions = \"GG\"");
        try {
            String instructions = "GG";
            System.out.println("  Output  : " + _tcShow(_tcSol.isRobotBounded(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "instructions = \"GL\"");
        try {
            String instructions = "GL";
            System.out.println("  Output  : " + _tcShow(_tcSol.isRobotBounded(instructions)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}