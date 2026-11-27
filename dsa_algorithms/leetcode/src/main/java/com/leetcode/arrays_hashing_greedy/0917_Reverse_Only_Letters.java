package com.leetcode.arrays_hashing_greedy;

class Solution0917 {
    public String reverseOnlyLetters(String s) {
        char[] cs = s.toCharArray();
        int i = 0, j = cs.length - 1;
        while (i < j) {
            while (i < j && !Character.isLetter(cs[i])) {
                ++i;
            }
            while (i < j && !Character.isLetter(cs[j])) {
                --j;
            }
            if (i < j) {
                char t = cs[i];
                cs[i] = cs[j];
                cs[j] = t;
                ++i;
                --j;
            }
        }
        return new String(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0917 _tcSol = new Solution0917();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"ab-cd\"");
        try {
            String s = "ab-cd";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseOnlyLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"dc-ba\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"a-bC-dEf-ghIj\"");
        try {
            String s = "a-bC-dEf-ghIj";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseOnlyLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"j-Ih-gfE-dCba\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"Test1ng-Leet=code-Q!\"");
        try {
            String s = "Test1ng-Leet=code-Q!";
            System.out.println("  Output  : " + _tcShow(_tcSol.reverseOnlyLetters(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"Qedo1ct-eeLg=ntse-T!\"");
        System.out.println();
    }
}