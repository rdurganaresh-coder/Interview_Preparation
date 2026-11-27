package com.leetcode.arrays_hashing_greedy;

class Solution0948 {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int ans = 0, score = 0;
        for (int i = 0, j = tokens.length - 1; i <= j;) {
            if (power >= tokens[i]) {
                power -= tokens[i++];
                ans = Math.max(ans, ++score);
            } else if (score > 0) {
                power += tokens[j--];
                --score;
            } else {
                break;
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
        Solution0948 _tcSol = new Solution0948();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "tokens = [100], power = 50");
        try {
            int[] tokens = new int[]{100};
            int power = 50;
            System.out.println("  Output  : " + _tcShow(_tcSol.bagOfTokensScore(tokens, power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "tokens = [200,100], power = 150");
        try {
            int[] tokens = new int[]{200, 100};
            int power = 150;
            System.out.println("  Output  : " + _tcShow(_tcSol.bagOfTokensScore(tokens, power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "tokens = [100,200,300,400], power = 200");
        try {
            int[] tokens = new int[]{100, 200, 300, 400};
            int power = 200;
            System.out.println("  Output  : " + _tcShow(_tcSol.bagOfTokensScore(tokens, power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}