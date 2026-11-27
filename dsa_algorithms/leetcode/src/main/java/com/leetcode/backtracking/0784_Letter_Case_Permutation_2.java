package com.leetcode.backtracking;

class Solution0784_2 {
    public List<String> letterCasePermutation(String s) {
        int n = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) >= 'A') {
                ++n;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            int j = 0;
            StringBuilder t = new StringBuilder();
            for (int k = 0; k < s.length(); ++k) {
                char x = s.charAt(k);
                if (x >= 'A') {
                    x = ((i >> j) & 1) == 1 ? Character.toLowerCase(x) : Character.toUpperCase(x);
                    ++j;
                }
                t.append(x);
            }
            ans.add(t.toString());
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0784_2 _tcSol = new Solution0784_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"a1b2\"");
        try {
            String s = "a1b2";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCasePermutation(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a1b2\",\"a1B2\",\"A1b2\",\"A1B2\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"3z4\"");
        try {
            String s = "3z4";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCasePermutation(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"3z4\",\"3Z4\"]");
        System.out.println();
    }
}