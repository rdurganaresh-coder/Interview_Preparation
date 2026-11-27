package com.leetcode.arrays_hashing_greedy;

class Solution1189 {
    public int maxNumberOfBalloons(String text) {
        int[] cnt = new int[26];
        for (int i = 0; i < text.length(); ++i) {
            ++cnt[text.charAt(i) - 'a'];
        }
        cnt['l' - 'a'] >>= 1;
        cnt['o' - 'a'] >>= 1;
        int ans = 1 << 30;
        for (char c : "balon".toCharArray()) {
            ans = Math.min(ans, cnt[c - 'a']);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1189 _tcSol = new Solution1189();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "text = \"nlaebolko\"");
        try {
            String text = "nlaebolko";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfBalloons(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "text = \"loonbalxballpoon\"");
        try {
            String text = "loonbalxballpoon";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfBalloons(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "text = \"leetcode\"");
        try {
            String text = "leetcode";
            System.out.println("  Output  : " + _tcShow(_tcSol.maxNumberOfBalloons(text)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}