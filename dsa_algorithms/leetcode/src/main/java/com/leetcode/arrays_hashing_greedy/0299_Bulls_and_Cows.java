package com.leetcode.arrays_hashing_greedy;

class Solution0299 {
    public String getHint(String secret, String guess) {
        int x = 0, y = 0;
        int[] cnt1 = new int[10];
        int[] cnt2 = new int[10];
        for (int i = 0; i < secret.length(); ++i) {
            int a = secret.charAt(i) - '0', b = guess.charAt(i) - '0';
            if (a == b) {
                ++x;
            } else {
                ++cnt1[a];
                ++cnt2[b];
            }
        }
        for (int i = 0; i < 10; ++i) {
            y += Math.min(cnt1[i], cnt2[i]);
        }
        return String.format("%dA%dB", x, y);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0299 _tcSol = new Solution0299();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "secret = \"1807\", guess = \"7810\"");
        try {
            String secret = "1807";
            String guess = "7810";
            System.out.println("  Output  : " + _tcShow(_tcSol.getHint(secret, guess)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1A3B\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "secret = \"1123\", guess = \"0111\"");
        try {
            String secret = "1123";
            String guess = "0111";
            System.out.println("  Output  : " + _tcShow(_tcSol.getHint(secret, guess)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1A1B\"");
        System.out.println();
    }
}