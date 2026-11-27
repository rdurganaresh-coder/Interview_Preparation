package com.leetcode.arrays_hashing_greedy;

class Solution2309 {
    public String greatestLetter(String s) {
        Set<Character> ss = new HashSet<>();
        for (char c : s.toCharArray()) {
            ss.add(c);
        }
        for (char a = 'Z'; a >= 'A'; --a) {
            if (ss.contains(a) && ss.contains((char) (a + 32))) {
                return String.valueOf(a);
            }
        }
        return "";
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2309 _tcSol = new Solution2309();
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