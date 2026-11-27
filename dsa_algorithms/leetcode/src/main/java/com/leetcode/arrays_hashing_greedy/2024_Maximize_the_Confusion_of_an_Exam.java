package com.leetcode.arrays_hashing_greedy;

class Solution2024 {
    private char[] s;
    private int k;

    public int maxConsecutiveAnswers(String answerKey, int k) {
        s = answerKey.toCharArray();
        this.k = k;
        return Math.max(f('T'), f('F'));
    }

    private int f(char c) {
        int l = 0, cnt = 0;
        for (char ch : s) {
            cnt += ch == c ? 1 : 0;
            if (cnt > k) {
                cnt -= s[l++] == c ? 1 : 0;
            }
        }
        return s.length - l;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2024 _tcSol = new Solution2024();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "answerKey = \"TTFF\", k = 2");
        try {
            String answerKey = "TTFF";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxConsecutiveAnswers(answerKey, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "answerKey = \"TFFT\", k = 1");
        try {
            String answerKey = "TFFT";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxConsecutiveAnswers(answerKey, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "answerKey = \"TTFTTFTT\", k = 1");
        try {
            String answerKey = "TTFTTFTT";
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.maxConsecutiveAnswers(answerKey, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}