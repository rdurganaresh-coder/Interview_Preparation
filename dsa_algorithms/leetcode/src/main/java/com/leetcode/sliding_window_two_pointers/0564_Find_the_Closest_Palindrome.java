package com.leetcode.sliding_window_two_pointers;

import java.math.BigInteger;

class Solution0564 {
    public String nearestPalindromic(String n) {
        BigInteger x = new BigInteger(n);
        int l = n.length();
        Set<BigInteger> res = new HashSet<>();
        res.add(BigInteger.TEN.pow(l - 1).subtract(BigInteger.ONE));
        res.add(BigInteger.TEN.pow(l).add(BigInteger.ONE));
        BigInteger left = new BigInteger(n.substring(0, (l + 1) / 2));
        for (int d = -1; d <= 1; ++d) {
            BigInteger i = left.add(BigInteger.valueOf(d));
            BigInteger j = l % 2 == 0 ? i : i.divide(BigInteger.TEN);
            while (j.signum() > 0) {
                i = i.multiply(BigInteger.TEN).add(j.mod(BigInteger.TEN));
                j = j.divide(BigInteger.TEN);
            }
            res.add(i);
        }
        res.remove(x);
        BigInteger ans = null;
        for (BigInteger t : res) {
            BigInteger dist = t.subtract(x).abs();
            if (ans == null || dist.compareTo(ans.subtract(x).abs()) < 0
                || (dist.compareTo(ans.subtract(x).abs()) == 0 && t.compareTo(ans) < 0)) {
                ans = t;
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
        Solution0564 _tcSol = new Solution0564();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = \"123\"");
        try {
            String n = "123";
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestPalindromic(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"121\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = \"1\"");
        try {
            String n = "1";
            System.out.println("  Output  : " + _tcShow(_tcSol.nearestPalindromic(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"0\"");
        System.out.println();
    }
}
