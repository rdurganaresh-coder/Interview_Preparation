package com.leetcode.arrays_hashing_greedy;

class Solution0681 {
    private int t;
    private int d;
    private String ans;
    private Set<Character> s;

    public String nextClosestTime(String time) {
        t = Integer.parseInt(time.substring(0, 2)) * 60 + Integer.parseInt(time.substring(3));
        d = Integer.MAX_VALUE;
        s = new HashSet<>();
        char mi = 'z';
        for (char c : time.toCharArray()) {
            if (c != ':') {
                s.add(c);
                if (c < mi) {
                    mi = c;
                }
            }
        }
        ans = null;
        dfs("");
        if (ans == null) {
            ans = "" + mi + mi + ":" + mi + mi;
        }
        return ans;
    }

    private void dfs(String curr) {
        if (curr.length() == 4) {
            if (!check(curr)) {
                return;
            }
            int p
                = Integer.parseInt(curr.substring(0, 2)) * 60 + Integer.parseInt(curr.substring(2));
            if (p > t && p - t < d) {
                d = p - t;
                ans = curr.substring(0, 2) + ":" + curr.substring(2);
            }
            return;
        }
        for (char c : s) {
            dfs(curr + c);
        }
    }

    private boolean check(String t) {
        int h = Integer.parseInt(t.substring(0, 2));
        int m = Integer.parseInt(t.substring(2));
        return 0 <= h && h < 24 && 0 <= m && m < 60;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0681 _tcSol = new Solution0681();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "time = \"19:34\"");
        try {
            String time = "19:34";
            System.out.println("  Output  : " + _tcShow(_tcSol.nextClosestTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"19:39\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "time = \"23:59\"");
        try {
            String time = "23:59";
            System.out.println("  Output  : " + _tcShow(_tcSol.nextClosestTime(time)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"22:22\"");
        System.out.println();
    }
}