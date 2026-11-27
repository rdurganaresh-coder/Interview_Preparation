package com.leetcode.arrays_hashing_greedy;

class Solution0320_2 {
    public List<String> generateAbbreviations(String word) {
        int n = word.length();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            StringBuilder s = new StringBuilder();
            int cnt = 0;
            for (int j = 0; j < n; ++j) {
                if ((i >> j & 1) == 1) {
                    ++cnt;
                } else {
                    if (cnt > 0) {
                        s.append(cnt);
                        cnt = 0;
                    }
                    s.append(word.charAt(j));
                }
            }
            if (cnt > 0) {
                s.append(cnt);
            }
            ans.add(s.toString());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0320_2 _tcSol = new Solution0320_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "word = \"word\"");
        try {
            String word = "word";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateAbbreviations(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"4\",\"3d\",\"2r1\",\"2rd\",\"1o2\",\"1o1d\",\"1or1\",\"1ord\",\"w3\",\"w2d\",\"w1r1\",\"w1rd\",\"wo2\",\"wo1d\",\"wor1\",\"word\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "word = \"a\"");
        try {
            String word = "a";
            System.out.println("  Output  : " + _tcShow(_tcSol.generateAbbreviations(word)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"1\",\"a\"]");
        System.out.println();
    }
}