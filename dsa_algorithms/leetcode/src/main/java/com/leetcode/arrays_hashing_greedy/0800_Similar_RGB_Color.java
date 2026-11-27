package com.leetcode.arrays_hashing_greedy;

class Solution0800 {
    public String similarRGB(String color) {
        String a = color.substring(1, 3), b = color.substring(3, 5), c = color.substring(5, 7);
        return "#" + f(a) + f(b) + f(c);
    }

    private String f(String x) {
        int q = Integer.parseInt(x, 16);
        q = q / 17 + (q % 17 > 8 ? 1 : 0);
        return String.format("%02x", 17 * q);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0800 _tcSol = new Solution0800();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "color = \"#09f166\"");
        try {
            String color = "#09f166";
            System.out.println("  Output  : " + _tcShow(_tcSol.similarRGB(color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"#11ee66\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "color = \"#4e3fe1\"");
        try {
            String color = "#4e3fe1";
            System.out.println("  Output  : " + _tcShow(_tcSol.similarRGB(color)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"#5544dd\"");
        System.out.println();
    }
}