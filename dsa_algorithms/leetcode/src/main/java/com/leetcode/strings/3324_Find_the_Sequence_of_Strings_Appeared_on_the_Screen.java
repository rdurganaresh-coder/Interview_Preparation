package com.leetcode.strings;

class Solution3324 {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        for (char c : target.toCharArray()) {
            String s = ans.isEmpty() ? "" : ans.get(ans.size() - 1);
            for (char a = 'a'; a <= c; ++a) {
                String t = s + a;
                ans.add(t);
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
        Solution3324 _tcSol = new Solution3324();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "target = \"abc\"");
        try {
            String target = "abc";
            System.out.println("  Output  : " + _tcShow(_tcSol.stringSequence(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"aa\",\"ab\",\"aba\",\"abb\",\"abc\"]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "target = \"he\"");
        try {
            String target = "he";
            System.out.println("  Output  : " + _tcShow(_tcSol.stringSequence(target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[\"a\",\"b\",\"c\",\"d\",\"e\",\"f\",\"g\",\"h\",\"ha\",\"hb\",\"hc\",\"hd\",\"he\"]");
        System.out.println();
    }
}
