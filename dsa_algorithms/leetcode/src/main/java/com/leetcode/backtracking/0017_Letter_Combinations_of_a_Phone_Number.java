package com.leetcode.backtracking;

class Solution0017 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        ans.add("");
        String[] d = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (char i : digits.toCharArray()) {
            String s = d[i - '2'];
            List<String> t = new ArrayList<>();
            for (String a : ans) {
                for (String b : s.split("")) {
                    t.add(a + b);
                }
            }
            ans = t;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0017 _tcSol = new Solution0017();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "digits = \"23\"");
        try {
            String digits = "23";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCombinations(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "digits = \"2\"");
        try {
            String digits = "2";
            System.out.println("  Output  : " + _tcShow(_tcSol.letterCombinations(digits)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\"]");
        System.out.println();
    }
}