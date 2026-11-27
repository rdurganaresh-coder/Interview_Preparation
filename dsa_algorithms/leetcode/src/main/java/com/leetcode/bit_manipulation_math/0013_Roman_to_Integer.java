package com.leetcode.bit_manipulation_math;

class Solution0013 {
    public int romanToInt(String s) {
        String cs = "IVXLCDM";
        int[] vs = {1, 5, 10, 50, 100, 500, 1000};
        Map<Character, Integer> d = new HashMap<>();
        for (int i = 0; i < vs.length; ++i) {
            d.put(cs.charAt(i), vs[i]);
        }
        int n = s.length();
        int ans = d.get(s.charAt(n - 1));
        for (int i = 0; i < n - 1; ++i) {
            int sign = d.get(s.charAt(i)) < d.get(s.charAt(i + 1)) ? -1 : 1;
            ans += sign * d.get(s.charAt(i));
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0013 _tcSol = new Solution0013();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "s = \"III\"");
        try {
            String s = "III";
            System.out.println("  Output  : " + _tcShow(_tcSol.romanToInt(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "s = \"LVIII\"");
        try {
            String s = "LVIII";
            System.out.println("  Output  : " + _tcShow(_tcSol.romanToInt(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "58");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "s = \"MCMXCIV\"");
        try {
            String s = "MCMXCIV";
            System.out.println("  Output  : " + _tcShow(_tcSol.romanToInt(s)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1994");
        System.out.println();
    }
}