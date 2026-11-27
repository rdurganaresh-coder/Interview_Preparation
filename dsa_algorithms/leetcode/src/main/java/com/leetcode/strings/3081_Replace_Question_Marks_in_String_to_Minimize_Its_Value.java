package com.leetcode.strings;

class Solution3081 {
    public String minimizeStringValue(String s) {
        int[] cnt = new int[26];
        int n = s.length();
        int k = 0;
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c == '?') {
                ++k;
            } else {
                ++cnt[c - 'a'];
            }
        }
        PriorityQueue<int[]> pq
            = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        for (int i = 0; i < 26; ++i) {
            pq.offer(new int[] {cnt[i], i});
        }
        int[] t = new int[k];
        for (int j = 0; j < k; ++j) {
            int[] p = pq.poll();
            t[j] = p[1];
            pq.offer(new int[] {p[0] + 1, p[1]});
        }
        Arrays.sort(t);

        for (int i = 0, j = 0; i < n; ++i) {
            if (cs[i] == '?') {
                cs[i] = (char) (t[j++] + 'a');
            }
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3081 _tcSol = new Solution3081();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"???\"");
        try {
            String s = "???";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeStringValue(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abc\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a?a?\"");
        try {
            String s = "a?a?";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeStringValue(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"abac\"");
        System.out.println();
    }
}