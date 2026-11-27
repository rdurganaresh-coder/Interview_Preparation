package com.leetcode.graphs_shortest_path;

class Solution1138 {
    public String alphabetBoardPath(String target) {
        StringBuilder ans = new StringBuilder();
        int i = 0, j = 0;
        for (int k = 0; k < target.length(); ++k) {
            int v = target.charAt(k) - 'a';
            int x = v / 5, y = v % 5;
            while (j > y) {
                --j;
                ans.append('L');
            }
            while (i > x) {
                --i;
                ans.append('U');
            }
            while (j < y) {
                ++j;
                ans.append('R');
            }
            while (i < x) {
                ++i;
                ans.append('D');
            }
            ans.append("!");
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1138 _tcSol = new Solution1138();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = \"leet\"");
        try {
            String target = "leet";
            System.out.println("  Output  : " + _tcShow(_tcSol.alphabetBoardPath(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"DDR!UURRR!!DDD!\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = \"code\"");
        try {
            String target = "code";
            System.out.println("  Output  : " + _tcShow(_tcSol.alphabetBoardPath(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"RR!DDRR!UUL!R!\"");
        System.out.println();
    }
}