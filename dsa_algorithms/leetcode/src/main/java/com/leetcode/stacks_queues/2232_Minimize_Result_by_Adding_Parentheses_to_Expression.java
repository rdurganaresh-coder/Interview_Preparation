package com.leetcode.stacks_queues;

class Solution2232 {
    public String minimizeResult(String expression) {
        int idx = expression.indexOf('+');
        String l = expression.substring(0, idx);
        String r = expression.substring(idx + 1);
        int m = l.length(), n = r.length();
        int mi = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                int c = Integer.parseInt(l.substring(i)) + Integer.parseInt(r.substring(0, j + 1));
                int a = i == 0 ? 1 : Integer.parseInt(l.substring(0, i));
                int b = j == n - 1 ? 1 : Integer.parseInt(r.substring(j + 1));
                int t = a * b * c;
                if (t < mi) {
                    mi = t;
                    ans = String.format("%s(%s+%s)%s", l.substring(0, i), l.substring(i),
                        r.substring(0, j + 1), r.substring(j + 1));
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
        Solution2232 _tcSol = new Solution2232();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "expression = \"247+38\"");
        try {
            String expression = "247+38";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeResult(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"2(47+38)\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "expression = \"12+34\"");
        try {
            String expression = "12+34";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeResult(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1(2+3)4\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "expression = \"999+999\"");
        try {
            String expression = "999+999";
            System.out.println("  Output  : " + _tcShow(_tcSol.minimizeResult(expression)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"(999+999)\"");
        System.out.println();
    }
}