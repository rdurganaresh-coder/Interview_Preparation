package com.leetcode.sliding_window_two_pointers;

class Solution1946 {
    public String maximumNumber(String num, int[] change) {
        char[] s = num.toCharArray();
        boolean changed = false;
        for (int i = 0; i < s.length; ++i) {
            char d = (char) (change[s[i] - '0'] + '0');
            if (changed && d < s[i]) {
                break;
            }
            if (d > s[i]) {
                changed = true;
                s[i] = d;
            }
        }
        return new String(s);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1946 _tcSol = new Solution1946();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = \"132\", change = [9,8,5,0,3,6,4,2,6,8]");
        try {
            String num = "132";
            int[] change = new int[]{9, 8, 5, 0, 3, 6, 4, 2, 6, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumber(num, change)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"832\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = \"021\", change = [9,4,3,5,7,2,1,9,0,6]");
        try {
            String num = "021";
            int[] change = new int[]{9, 4, 3, 5, 7, 2, 1, 9, 0, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumber(num, change)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"934\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = \"5\", change = [1,4,7,5,3,2,5,6,9,4]");
        try {
            String num = "5";
            int[] change = new int[]{1, 4, 7, 5, 3, 2, 5, 6, 9, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumNumber(num, change)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"5\"");
        System.out.println();
    }
}
