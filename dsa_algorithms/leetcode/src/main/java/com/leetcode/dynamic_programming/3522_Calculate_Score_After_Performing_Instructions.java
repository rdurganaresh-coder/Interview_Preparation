package com.leetcode.dynamic_programming;

class Solution3522 {
    public long calculateScore(String[] instructions, int[] values) {
        int n = values.length;
        boolean[] vis = new boolean[n];
        long ans = 0;
        int i = 0;

        while (i >= 0 && i < n && !vis[i]) {
            vis[i] = true;
            if (instructions[i].charAt(0) == 'a') {
                ans += values[i];
                i += 1;
            } else {
                i = i + values[i];
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
        Solution3522 _tcSol = new Solution3522();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "instructions = [\"jump\",\"add\",\"add\",\"jump\",\"add\",\"jump\"], values = [2,1,3,1,-2,-3]");
        try {
            String[] instructions = new String[]{"jump", "add", "add", "jump", "add", "jump"};
            int[] values = new int[]{2, 1, 3, 1, -2, -3};
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateScore(instructions, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "instructions = [\"jump\",\"add\",\"add\"], values = [3,1,1]");
        try {
            String[] instructions = new String[]{"jump", "add", "add"};
            int[] values = new int[]{3, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateScore(instructions, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "instructions = [\"jump\"], values = [0]");
        try {
            String[] instructions = new String[]{"jump"};
            int[] values = new int[]{0};
            System.out.println("  Output  : " + _tcShow(_tcSol.calculateScore(instructions, values)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
