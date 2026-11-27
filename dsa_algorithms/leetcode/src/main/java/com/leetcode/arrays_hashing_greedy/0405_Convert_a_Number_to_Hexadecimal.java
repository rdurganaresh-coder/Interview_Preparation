package com.leetcode.arrays_hashing_greedy;

class Solution0405 {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int x = num & 15;
            if (x < 10) {
                sb.append(x);
            } else {
                sb.append((char) (x - 10 + 'a'));
            }
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0405 _tcSol = new Solution0405();
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