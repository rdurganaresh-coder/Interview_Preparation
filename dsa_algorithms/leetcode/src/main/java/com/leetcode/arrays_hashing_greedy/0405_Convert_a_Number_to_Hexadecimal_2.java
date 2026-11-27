package com.leetcode.arrays_hashing_greedy;

class Solution0405_2 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 7; i >= 0; --i) {
            int x = (num >> (4 * i)) & 0xf;
            if (sb.length() > 0 || x != 0) {
                char c = x < 10 ? (char) (x + '0') : (char) (x - 10 + 'a');
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
        Solution0405_2 _tcSol = new Solution0405_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 26");
        try {
            int num = 26;
            System.out.println("  Output  : " + _tcShow(_tcSol.toHex(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"1a\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = -1");
        try {
            int num = -1;
            System.out.println("  Output  : " + _tcShow(_tcSol.toHex(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"ffffffff\"");
        System.out.println();
    }
}