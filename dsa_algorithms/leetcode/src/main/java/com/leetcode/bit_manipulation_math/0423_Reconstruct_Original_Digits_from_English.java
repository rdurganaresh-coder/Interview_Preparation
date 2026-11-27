package com.leetcode.bit_manipulation_math;

class Solution0423 {
    public String originalDigits(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            ++counter[c - 'a'];
        }
        int[] cnt = new int[10];
        cnt[0] = counter['z' - 'a'];
        cnt[2] = counter['w' - 'a'];
        cnt[4] = counter['u' - 'a'];
        cnt[6] = counter['x' - 'a'];
        cnt[8] = counter['g' - 'a'];

        cnt[3] = counter['h' - 'a'] - cnt[8];
        cnt[5] = counter['f' - 'a'] - cnt[4];
        cnt[7] = counter['s' - 'a'] - cnt[6];

        cnt[1] = counter['o' - 'a'] - cnt[0] - cnt[2] - cnt[4];
        cnt[9] = counter['i' - 'a'] - cnt[5] - cnt[6] - cnt[8];

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            for (int j = 0; j < cnt[i]; ++j) {
                sb.append(i);
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0423 _tcSol = new Solution0423();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"owoztneoer\"");
        try {
            String s = "owoztneoer";
            System.out.println("  Output  : " + _tcShow(_tcSol.originalDigits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"012\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"fviefuro\"");
        try {
            String s = "fviefuro";
            System.out.println("  Output  : " + _tcShow(_tcSol.originalDigits(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"45\"");
        System.out.println();
    }
}