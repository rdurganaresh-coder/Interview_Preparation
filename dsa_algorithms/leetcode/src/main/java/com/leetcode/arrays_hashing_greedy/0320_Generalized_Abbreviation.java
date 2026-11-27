package com.leetcode.arrays_hashing_greedy;

class Solution0320 {
    private String word;
    private int n;

    public List<String> generateAbbreviations(String word) {
        this.word = word;
        n = word.length();
        return dfs(0);
    }

    private List<String> dfs(int i) {
        if (i >= n) {
            return List.of("");
        }
        List<String> ans = new ArrayList<>();
        for (String s : dfs(i + 1)) {
            ans.add(String.valueOf(word.charAt(i)) + s);
        }
        for (int j = i + 1; j <= n; ++j) {
            for (String s : dfs(j + 1)) {
                ans.add((j - i) + "" + (j < n ? String.valueOf(word.charAt(j)) : "") + s);
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
        Solution0320 _tcSol = new Solution0320();
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