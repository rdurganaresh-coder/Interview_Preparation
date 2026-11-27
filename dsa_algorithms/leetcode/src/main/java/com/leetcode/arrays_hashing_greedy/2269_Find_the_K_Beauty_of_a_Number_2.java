package com.leetcode.arrays_hashing_greedy;

class Solution2269_2 {
    public int divisorSubstrings(int num, int k) {
        int x = 0, p = 1;
        int t = num;
        for (; k > 0; --k) {
            int v = t % 10;
            t /= 10;
            x = p * v + x;
            p *= 10;
        }
        int ans = x != 0 && num % x == 0 ? 1 : 0;
        for (p /= 10; t > 0; t /= 10) {
            x /= 10;
            int v = t % 10;
            x = p * v + x;
            ans += (x != 0 && num % x == 0 ? 1 : 0);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2269_2 _tcSol = new Solution2269_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 240, k = 2");
        try {
            int num = 240;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorSubstrings(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = 430043, k = 2");
        try {
            int num = 430043;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.divisorSubstrings(num, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}