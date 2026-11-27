package com.leetcode.strings;

class Solution0748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] cnt = new int[26];
        for (int i = 0; i < licensePlate.length(); ++i) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                cnt[Character.toLowerCase(c) - 'a']++;
            }
        }
        String ans = "";
        for (String w : words) {
            if (!ans.isEmpty() && w.length() >= ans.length()) {
                continue;
            }
            int[] t = new int[26];
            for (int i = 0; i < w.length(); ++i) {
                t[w.charAt(i) - 'a']++;
            }
            boolean ok = true;
            for (int i = 0; i < 26; ++i) {
                if (t[i] < cnt[i]) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                ans = w;
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
        Solution0748 _tcSol = new Solution0748();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "licensePlate = \"1s3 PSt\", words = [\"step\",\"steps\",\"stripe\",\"stepple\"]");
        try {
            String licensePlate = "1s3 PSt";
            String[] words = new String[]{"step", "steps", "stripe", "stepple"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestCompletingWord(licensePlate, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"steps\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "licensePlate = \"1s3 456\", words = [\"looks\",\"pest\",\"stew\",\"show\"]");
        try {
            String licensePlate = "1s3 456";
            String[] words = new String[]{"looks", "pest", "stew", "show"};
            System.out.println("  Output  : " + _tcShow(_tcSol.shortestCompletingWord(licensePlate, words)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"pest\"");
        System.out.println();
    }
}