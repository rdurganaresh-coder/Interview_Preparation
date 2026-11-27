package com.leetcode.arrays_hashing_greedy;

class Solution1366 {
    public String rankTeams(String[] votes) {
        int m = votes[0].length();
        int[][] cnt = new int[26][m + 1];
        for (var vote : votes) {
            for (int i = 0; i < m; ++i) {
                ++cnt[vote.charAt(i) - 'A'][i];
            }
        }
        Character[] s = new Character[m];
        for (int i = 0; i < m; ++i) {
            s[i] = votes[0].charAt(i);
        }
        Arrays.sort(s, (a, b) -> {
            int i = a - 'A', j = b - 'A';
            for (int k = 0; k < m; ++k) {
                if (cnt[i][k] != cnt[j][k]) {
                    return cnt[j][k] - cnt[i][k];
                }
            }
            return a - b;
        });
        StringBuilder ans = new StringBuilder();
        for (var c : s) {
            ans.append(c);
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1366 _tcSol = new Solution1366();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "votes = [\"ABC\",\"ACB\",\"ABC\",\"ACB\",\"ACB\"]");
        try {
            String[] votes = new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"};
            System.out.println("  Output  : " + _tcShow(_tcSol.rankTeams(votes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ACB\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "votes = [\"WXYZ\",\"XYZW\"]");
        try {
            String[] votes = new String[]{"WXYZ", "XYZW"};
            System.out.println("  Output  : " + _tcShow(_tcSol.rankTeams(votes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"XWYZ\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "votes = [\"ZMNAGUEDSJYLBOPHRQICWFXTVK\"]");
        try {
            String[] votes = new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
            System.out.println("  Output  : " + _tcShow(_tcSol.rankTeams(votes)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ZMNAGUEDSJYLBOPHRQICWFXTVK\"");
        System.out.println();
    }
}
