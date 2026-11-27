package com.leetcode.strings;

class Solution0833 {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        var d = new int[n];
        Arrays.fill(d, -1);
        for (int k = 0; k < indices.length; ++k) {
            int i = indices[k];
            if (s.startsWith(sources[k], i)) {
                d[i] = k;
            }
        }
        var ans = new StringBuilder();
        for (int i = 0; i < n;) {
            if (d[i] >= 0) {
                ans.append(targets[d[i]]);
                i += sources[d[i]].length();
            } else {
                ans.append(s.charAt(i++));
            }
        }
        return ans.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0833 _tcSol = new Solution0833();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abcd\", indices = [0, 2], sources = [\"a\", \"cd\"], targets = [\"eee\", \"ffff\"]");
        try {
            String s = "abcd";
            int[] indices = new int[]{0, 2};
            String[] sources = new String[]{"a", "cd"};
            String[] targets = new String[]{"eee", "ffff"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findReplaceString(s, indices, sources, targets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"eeebffff\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"abcd\", indices = [0, 2], sources = [\"ab\",\"ec\"], targets = [\"eee\",\"ffff\"]");
        try {
            String s = "abcd";
            int[] indices = new int[]{0, 2};
            String[] sources = new String[]{"ab", "ec"};
            String[] targets = new String[]{"eee", "ffff"};
            System.out.println("  Output  : " + _tcShow(_tcSol.findReplaceString(s, indices, sources, targets)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"eeecd\"");
        System.out.println();
    }
}