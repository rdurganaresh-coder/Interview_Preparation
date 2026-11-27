package com.leetcode.arrays_hashing_greedy;

class Solution2843 {
    public int countSymmetricIntegers(int low, int high) {
        int ans = 0;
        for (int x = low; x <= high; ++x) {
            ans += f(x);
        }
        return ans;
    }

    private int f(int x) {
        String s = "" + x;
        int n = s.length();
        if (n % 2 == 1) {
            return 0;
        }
        int a = 0, b = 0;
        for (int i = 0; i < n / 2; ++i) {
            a += s.charAt(i) - '0';
        }
        for (int i = n / 2; i < n; ++i) {
            b += s.charAt(i) - '0';
        }
        return a == b ? 1 : 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2843 _tcSol = new Solution2843();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "low = 1, high = 100");
        try {
            int low = 1;
            int high = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSymmetricIntegers(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "9");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "low = 1200, high = 1230");
        try {
            int low = 1200;
            int high = 1230;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSymmetricIntegers(low, high)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();
    }
}