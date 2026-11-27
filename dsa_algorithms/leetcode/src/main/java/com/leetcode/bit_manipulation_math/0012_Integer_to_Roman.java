package com.leetcode.bit_manipulation_math;

class Solution0012 {
    public String intToRoman(int num) {
        List<String> cs
            = List.of("M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I");
        List<Integer> vs = List.of(1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1);
        StringBuilder ans = new StringBuilder();
        for (int i = 0, n = cs.size(); i < n; ++i) {
            while (num >= vs.get(i)) {
                num -= vs.get(i);
                ans.append(cs.get(i));
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
        Solution0012 _tcSol = new Solution0012();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 3749");
        try {
            int num = 3749;
            System.out.println("  Output  : " + _tcShow(_tcSol.intToRoman(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"MMMDCCXLIX\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 58");
        try {
            int num = 58;
            System.out.println("  Output  : " + _tcShow(_tcSol.intToRoman(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"LVIII\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "num = 1994");
        try {
            int num = 1994;
            System.out.println("  Output  : " + _tcShow(_tcSol.intToRoman(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"MCMXCIV\"");
        System.out.println();
    }
}