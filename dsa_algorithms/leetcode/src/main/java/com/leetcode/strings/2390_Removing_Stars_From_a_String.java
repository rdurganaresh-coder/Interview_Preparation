package com.leetcode.strings;

class Solution2390 {
    public String removeStars(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '*') {
                ans.deleteCharAt(ans.length() - 1);
            } else {
                ans.append(s.charAt(i));
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
        Solution2390 _tcSol = new Solution2390();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"leet**cod*e\"");
        try {
            String s = "leet**cod*e";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeStars(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"lecoe\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"erase*****\"");
        try {
            String s = "erase*****";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeStars(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}