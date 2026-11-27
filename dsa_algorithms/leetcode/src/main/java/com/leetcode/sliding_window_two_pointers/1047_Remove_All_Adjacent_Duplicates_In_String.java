package com.leetcode.sliding_window_two_pointers;

class Solution1047 {
    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
                sb.deleteCharAt(sb.length() - 1);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1047 _tcSol = new Solution1047();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abbaca\"");
        try {
            String s = "abbaca";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicates(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ca\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"azxxzy\"");
        try {
            String s = "azxxzy";
            System.out.println("  Output  : " + _tcShow(_tcSol.removeDuplicates(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ay\"");
        System.out.println();
    }
}