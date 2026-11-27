package com.leetcode.strings;

class Solution2896_2 {
    public int minOperations(String s1, String s2, int x) {
        int n = s1.length();
        int inf = 50_000;
        int one = inf, two = inf, last = inf;
        int done = 0;
        for (int i = 0; i < n; i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                one = Math.min(one, last);
                last = last + 1;
                two = two + 1;
                continue;
            }
            if (done < n) {
                one = Math.min(two + 1, done + x);
                last = Math.min(two + x, done);
                done = two = inf;
                continue;
            }
            done = Math.min(one + x, last + 1);
            two = one;
            one = last = inf;
            continue;
        }
        return done == inf ? -1 : done;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2896_2 _tcSol = new Solution2896_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s1 = \"1100011000\", s2 = \"0101001010\", x = 2");
        try {
            String s1 = "1100011000";
            String s2 = "0101001010";
            int x = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s1, s2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s1 = \"10110\", s2 = \"00011\", x = 4");
        try {
            String s1 = "10110";
            String s2 = "00011";
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(s1, s2, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}