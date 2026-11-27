package com.leetcode.arrays_hashing_greedy;

class Solution2802 {
    public String kthLuckyNumber(int k) {
        int n = 1;
        while (k > 1 << n) {
            k -= 1 << n;
            ++n;
        }
        StringBuilder ans = new StringBuilder();
        while (n-- > 0) {
            if (k <= 1 << n) {
                ans.append('4');
            } else {
                ans.append('7');
                k -= 1 << n;
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
        Solution2802 _tcSol = new Solution2802();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "k = 4");
        try {
            int k = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLuckyNumber(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"47\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "k = 10");
        try {
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLuckyNumber(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"477\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "k = 1000");
        try {
            int k = 1000;
            System.out.println("  Output  : " + _tcShow(_tcSol.kthLuckyNumber(k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"777747447\"");
        System.out.println();
    }
}