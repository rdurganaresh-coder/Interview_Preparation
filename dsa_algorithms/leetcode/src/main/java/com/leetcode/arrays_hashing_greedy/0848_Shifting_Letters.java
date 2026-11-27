package com.leetcode.arrays_hashing_greedy;

class Solution0848 {
    public String shiftingLetters(String s, int[] shifts) {
        char[] cs = s.toCharArray();
        int n = cs.length;
        long t = 0;
        for (int i = n - 1; i >= 0; --i) {
            t += shifts[i];
            int j = (int) ((cs[i] - 'a' + t) % 26);
            cs[i] = (char) ('a' + j);
        }
        return String.valueOf(cs);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0848 _tcSol = new Solution0848();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"abc\", shifts = [3,5,9]");
        try {
            String s = "abc";
            int[] shifts = new int[]{3, 5, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftingLetters(s, shifts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"rpl\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"aaa\", shifts = [1,2,3]");
        try {
            String s = "aaa";
            int[] shifts = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.shiftingLetters(s, shifts)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"gfd\"");
        System.out.println();
    }
}