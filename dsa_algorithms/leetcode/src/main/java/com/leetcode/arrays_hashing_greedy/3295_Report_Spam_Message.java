package com.leetcode.arrays_hashing_greedy;

class Solution3295 {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> s = new HashSet<>();
        for (var w : bannedWords) {
            s.add(w);
        }
        int cnt = 0;
        for (var w : message) {
            if (s.contains(w) && ++cnt >= 2) {
                return true;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3295 _tcSol = new Solution3295();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "message = [\"hello\",\"world\",\"leetcode\"], bannedWords = [\"world\",\"hello\"]");
        try {
            String[] message = new String[]{"hello", "world", "leetcode"};
            String[] bannedWords = new String[]{"world", "hello"};
            System.out.println("  Output  : " + _tcShow(_tcSol.reportSpam(message, bannedWords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "message = [\"hello\",\"programming\",\"fun\"], bannedWords = [\"world\",\"programming\",\"leetcode\"]");
        try {
            String[] message = new String[]{"hello", "programming", "fun"};
            String[] bannedWords = new String[]{"world", "programming", "leetcode"};
            System.out.println("  Output  : " + _tcShow(_tcSol.reportSpam(message, bannedWords)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
