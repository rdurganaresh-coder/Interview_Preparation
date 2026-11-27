package com.leetcode.dynamic_programming;

class Solution2019 {
    public int scoreOfStudents(String s, int[] answers) {
        int n = s.length();
        int x = cal(s);
        int m = (n + 1) >> 1;
        Set<Integer>[][] f = new Set[m][m];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < m; ++j) {
                f[i][j] = new HashSet<>();
            }
            f[i][i].add(s.charAt(i << 1) - '0');
        }
        for (int i = m - 1; i >= 0; --i) {
            for (int j = i; j < m; ++j) {
                for (int k = i; k < j; ++k) {
                    for (int l : f[i][k]) {
                        for (int r : f[k + 1][j]) {
                            char op = s.charAt(k << 1 | 1);
                            if (op == '+' && l + r <= 1000) {
                                f[i][j].add(l + r);
                            } else if (op == '*' && l * r <= 1000) {
                                f[i][j].add(l * r);
                            }
                        }
                    }
                }
            }
        }
        int[] cnt = new int[1001];
        for (int ans : answers) {
            ++cnt[ans];
        }
        int ans = 5 * cnt[x];
        for (int i = 0; i <= 1000; ++i) {
            if (i != x && f[0][m - 1].contains(i)) {
                ans += 2 * cnt[i];
            }
        }
        return ans;
    }

    private int cal(String s) {
        int res = 0, pre = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); i += 2) {
            char op = s.charAt(i);
            int cur = s.charAt(i + 1) - '0';
            if (op == '*') {
                pre *= cur;
            } else {
                res += pre;
                pre = cur;
            }
        }
        res += pre;
        return res;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2019 _tcSol = new Solution2019();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"7+3*1*2\", answers = [20,13,42]");
        try {
            String s = "7+3*1*2";
            int[] answers = new int[]{20, 13, 42};
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfStudents(s, answers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"3+5*2\", answers = [13,0,10,13,13,16,16]");
        try {
            String s = "3+5*2";
            int[] answers = new int[]{13, 0, 10, 13, 13, 16, 16};
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfStudents(s, answers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "19");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"6+0*1\", answers = [12,9,6,4,8,6]");
        try {
            String s = "6+0*1";
            int[] answers = new int[]{12, 9, 6, 4, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.scoreOfStudents(s, answers)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}