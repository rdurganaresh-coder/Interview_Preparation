package com.leetcode.arrays_hashing_greedy;

class Solution2165 {
    public long smallestNumber(long num) {
        boolean neg = num < 0;
        num = Math.abs(num);
        int[] cnt = new int[10];
        while (num > 0) {
            ++cnt[(int) (num % 10)];
            num /= 10;
        }
        long ans = 0;
        if (neg) {
            for (int i = 9; i >= 0; --i) {
                while (cnt[i] > 0) {
                    ans = ans * 10 + i;
                    --cnt[i];
                }
            }
            return -ans;
        }
        if (cnt[0] > 0) {
            for (int i = 1; i < 10; ++i) {
                if (cnt[i] > 0) {
                    --cnt[i];
                    ans = i;
                    break;
                }
            }
        }
        for (int i = 0; i < 10; ++i) {
            while (cnt[i] > 0) {
                ans = ans * 10 + i;
                --cnt[i];
            }
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2165 _tcSol = new Solution2165();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "num = 310");
        try {
            long num = 310L;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "103");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "num = -7605");
        try {
            long num = -7605L;
            System.out.println("  Output  : " + _tcShow(_tcSol.smallestNumber(num)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-7650");
        System.out.println();
    }
}
