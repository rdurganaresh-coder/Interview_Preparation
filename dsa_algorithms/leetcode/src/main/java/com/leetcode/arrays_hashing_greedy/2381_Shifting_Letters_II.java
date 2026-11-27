package com.leetcode.arrays_hashing_greedy;

class Solution2381 {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] d = new int[n + 1];
        for (int[] e : shifts) {
            if (e[2] == 0) {
                e[2]--;
            }
            d[e[0]] += e[2];
            d[e[1] + 1] -= e[2];
        }
        for (int i = 1; i <= n; ++i) {
            d[i] += d[i - 1];
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            int j = (s.charAt(i) - 'a' + d[i] % 26 + 26) % 26;
            ans.append((char) ('a' + j));
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2381 _tcSol = new Solution2381();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", shifts = [[0,1,0],[1,2,1],[0,2,1]]");
        try {
            String s = "abc";
            int[][] shifts = new int[][]{new int[]{0, 1, 0}, new int[]{1, 2, 1}, new int[]{0, 2, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftingLetters(s, shifts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ace\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"dztz\", shifts = [[0,0,0],[1,1,1]]");
        try {
            String s = "dztz";
            int[][] shifts = new int[][]{new int[]{0, 0, 0}, new int[]{1, 1, 1}};
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftingLetters(s, shifts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"catz\"");
        System.out.println();
    }
}