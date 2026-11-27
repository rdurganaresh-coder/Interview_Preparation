package com.leetcode.arrays_hashing_greedy;

class Solution0294_2 {
    private int n;
    private int[] sg;

    public boolean canWin(String currentState) {
        n = currentState.length();
        sg = new int[n + 1];
        Arrays.fill(sg, -1);
        int i = 0;
        int ans = 0;
        while (i < n) {
            int j = i;
            while (j < n && currentState.charAt(j) == '+') {
                ++j;
            }
            ans ^= win(j - i);
            i = j + 1;
        }
        return ans > 0;
    }

    private int win(int i) {
        if (sg[i] != -1) {
            return sg[i];
        }
        boolean[] vis = new boolean[n];
        for (int j = 0; j < i - 1; ++j) {
            vis[win(j) ^ win(i - j - 2)] = true;
        }
        for (int j = 0; j < n; ++j) {
            if (!vis[j]) {
                sg[i] = j;
                return j;
            }
        }
        return 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0294_2 _tcSol = new Solution0294_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "currentState = \"++++\"");
        try {
            String currentState = "++++";
            System.out.println("  Output  : " + _tcShow(_tcSol.canWin(currentState)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "currentState = \"+\"");
        try {
            String currentState = "+";
            System.out.println("  Output  : " + _tcShow(_tcSol.canWin(currentState)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}