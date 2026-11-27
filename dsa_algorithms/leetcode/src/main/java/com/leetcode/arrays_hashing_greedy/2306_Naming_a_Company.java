package com.leetcode.arrays_hashing_greedy;

class Solution2306 {
    public long distinctNames(String[] ideas) {
        Set<String> s = new HashSet<>();
        for (String v : ideas) {
            s.add(v);
        }
        int[][] f = new int[26][26];
        for (String v : ideas) {
            char[] t = v.toCharArray();
            int i = t[0] - 'a';
            for (int j = 0; j < 26; ++j) {
                t[0] = (char) (j + 'a');
                if (!s.contains(String.valueOf(t))) {
                    ++f[i][j];
                }
            }
        }
        long ans = 0;
        for (String v : ideas) {
            char[] t = v.toCharArray();
            int i = t[0] - 'a';
            for (int j = 0; j < 26; ++j) {
                t[0] = (char) (j + 'a');
                if (!s.contains(String.valueOf(t))) {
                    ans += f[j][i];
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
        Solution2306 _tcSol = new Solution2306();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "ideas = [\"coffee\",\"donuts\",\"time\",\"toffee\"]");
        try {
            String[] ideas = new String[]{"coffee", "donuts", "time", "toffee"};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctNames(ideas)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "ideas = [\"lack\",\"back\"]");
        try {
            String[] ideas = new String[]{"lack", "back"};
            System.out.println("  Output  : " + _tcShow(_tcSol.distinctNames(ideas)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}