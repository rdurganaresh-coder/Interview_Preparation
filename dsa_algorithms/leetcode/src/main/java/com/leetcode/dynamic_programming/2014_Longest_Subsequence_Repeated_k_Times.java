package com.leetcode.dynamic_programming;

class Solution2014 {
    private char[] s;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.s = s.toCharArray();
        int[] cnt = new int[26];
        for (char c : this.s) {
            cnt[c - 'a']++;
        }

        List<Character> cs = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; ++c) {
            if (cnt[c - 'a'] >= k) {
                cs.add(c);
            }
        }
        Deque<String> q = new ArrayDeque<>();
        q.offer("");
        String ans = "";
        while (!q.isEmpty()) {
            String cur = q.poll();
            for (char c : cs) {
                String nxt = cur + c;
                if (check(nxt, k)) {
                    ans = nxt;
                    q.offer(nxt);
                }
            }
        }
        return ans;
    }

    private boolean check(String t, int k) {
        int i = 0;
        for (char c : s) {
            if (c == t.charAt(i)) {
                i++;
                if (i == t.length()) {
                    if (--k == 0) {
                        return true;
                    }
                    i = 0;
                }
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
        Solution2014 _tcSol = new Solution2014();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"letsleetcode\", k = 2");
        try {
            String s = "letsleetcode";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequenceRepeatedK(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"let\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"bb\", k = 2");
        try {
            String s = "bb";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequenceRepeatedK(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"b\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"ab\", k = 2");
        try {
            String s = "ab";
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.longestSubsequenceRepeatedK(s, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}