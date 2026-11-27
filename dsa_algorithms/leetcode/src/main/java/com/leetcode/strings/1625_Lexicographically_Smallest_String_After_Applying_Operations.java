package com.leetcode.strings;

class Solution1625 {
    public String findLexSmallestString(String s, int a, int b) {
        Deque<String> q = new ArrayDeque<>();
        q.offer(s);
        Set<String> vis = new HashSet<>();
        vis.add(s);
        String ans = s;
        int n = s.length();
        while (!q.isEmpty()) {
            s = q.poll();
            if (ans.compareTo(s) > 0) {
                ans = s;
            }
            char[] cs = s.toCharArray();
            for (int i = 1; i < n; i += 2) {
                cs[i] = (char) (((cs[i] - '0' + a) % 10) + '0');
            }
            String t1 = String.valueOf(cs);
            String t2 = s.substring(n - b) + s.substring(0, n - b);
            for (String t : List.of(t1, t2)) {
                if (vis.add(t)) {
                    q.offer(t);
                }
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
        Solution1625 _tcSol = new Solution1625();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"5525\", a = 9, b = 2");
        try {
            String s = "5525";
            int a = 9;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2050\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"74\", a = 5, b = 1");
        try {
            String s = "74";
            int a = 5;
            int b = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"24\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"0011\", a = 4, b = 2");
        try {
            String s = "0011";
            int a = 4;
            int b = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findLexSmallestString(s, a, b)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0011\"");
        System.out.println();
    }
}