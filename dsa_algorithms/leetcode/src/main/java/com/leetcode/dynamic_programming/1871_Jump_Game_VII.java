package com.leetcode.dynamic_programming;

class Solution1871 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        int[] pre = new int[n + 1];
        pre[1] = 1;
        boolean[] f = new boolean[n];
        f[0] = true;
        for (int i = 1; i < n; ++i) {
            if (s.charAt(i) == '0') {
                int l = Math.max(0, i - maxJump);
                int r = i - minJump;
                f[i] = l <= r && pre[r + 1] - pre[l] > 0;
            }
            pre[i + 1] = pre[i] + (f[i] ? 1 : 0);
        }
        return f[n - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1871 _tcSol = new Solution1871();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"011010\", minJump = 2, maxJump = 3");
        try {
            String s = "011010";
            int minJump = 2;
            int maxJump = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canReach(s, minJump, maxJump)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"01101110\", minJump = 2, maxJump = 3");
        try {
            String s = "01101110";
            int minJump = 2;
            int maxJump = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.canReach(s, minJump, maxJump)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}