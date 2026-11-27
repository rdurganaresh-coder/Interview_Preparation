package com.leetcode.strings;

class Solution3170 {
    public String clearStars(String s) {
        Deque<Integer>[] g = new Deque[26];
        Arrays.setAll(g, k -> new ArrayDeque<>());
        int n = s.length();
        boolean[] rem = new boolean[n];
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '*') {
                rem[i] = true;
                for (int j = 0; j < 26; ++j) {
                    if (!g[j].isEmpty()) {
                        rem[g[j].pop()] = true;
                        break;
                    }
                }
            } else {
                g[s.charAt(i) - 'a'].push(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            if (!rem[i]) {
                sb.append(s.charAt(i));
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
        Solution3170 _tcSol = new Solution3170();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"aaba*\"");
        try {
            String s = "aaba*";
            System.out.println("  Output  : " + _tcShow(_tcSol.clearStars(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"aab\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abc\"");
        try {
            String s = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.clearStars(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();
    }
}