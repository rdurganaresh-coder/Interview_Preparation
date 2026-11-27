package com.leetcode.arrays_hashing_greedy;

class Solution0483 {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        for (int len = 63; len >= 2; --len) {
            long radix = getRadix(len, num);
            if (radix != -1) {
                return String.valueOf(radix);
            }
        }
        return String.valueOf(num - 1);
    }

    private long getRadix(int len, long num) {
        long l = 2, r = num - 1;
        while (l < r) {
            long mid = l + r >>> 1;
            if (calc(mid, len) >= num)
                r = mid;
            else
                l = mid + 1;
        }
        return calc(r, len) == num ? r : -1;
    }

    private long calc(long radix, int len) {
        long p = 1;
        long sum = 0;
        for (int i = 0; i < len; ++i) {
            if (Long.MAX_VALUE - sum < p) {
                return Long.MAX_VALUE;
            }
            sum += p;
            if (Long.MAX_VALUE / p < radix) {
                p = Long.MAX_VALUE;
            } else {
                p *= radix;
            }
        }
        return sum;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0483 _tcSol = new Solution0483();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "n = \"13\"");
        try {
            String n = "13";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestGoodBase(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"3\"");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "n = \"4681\"");
        try {
            String n = "4681";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestGoodBase(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"8\"");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "n = \"1000000000000000000\"");
        try {
            String n = "1000000000000000000";
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestGoodBase(n)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "\"999999999999999999\"");
        System.out.println();
    }
}