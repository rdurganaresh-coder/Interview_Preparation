package com.leetcode.arrays_hashing_greedy;

class Solution2309_2 {
    public String greatestLetter(String s) {
        int mask1 = 0, mask2 = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (Character.isLowerCase(c)) {
                mask1 |= 1 << (c - 'a');
            } else {
                mask2 |= 1 << (c - 'A');
            }
        }
        int mask = mask1 & mask2;
        return mask > 0 ? String.valueOf((char) (31 - Integer.numberOfLeadingZeros(mask) + 'A'))
                        : "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2309_2 _tcSol = new Solution2309_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"lEeTcOdE\"");
        try {
            String s = "lEeTcOdE";
            System.out.println("  Output  : " + _tcShow(_tcSol.greatestLetter(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"E\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"arRAzFif\"");
        try {
            String s = "arRAzFif";
            System.out.println("  Output  : " + _tcShow(_tcSol.greatestLetter(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"R\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"AbCdEfGhIjK\"");
        try {
            String s = "AbCdEfGhIjK";
            System.out.println("  Output  : " + _tcShow(_tcSol.greatestLetter(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"\"");
        System.out.println();
    }
}