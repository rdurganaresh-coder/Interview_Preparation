package com.leetcode.arrays_hashing_greedy;

class Solution1318 {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int x = a >> i & 1, y = b >> i & 1, z = c >> i & 1;
            ans += z == 0 ? x + y : (x == 0 && y == 0 ? 1 : 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1318 _tcSol = new Solution1318();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "a = 2, b = 6, c = 5");
        try {
            int a = 2;
            int b = 6;
            int c = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "a = 4, b = 2, c = 7");
        try {
            int a = 4;
            int b = 2;
            int c = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "a = 1, b = 2, c = 3");
        try {
            int a = 1;
            int b = 2;
            int c = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minFlips(a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}