package com.leetcode.arrays_hashing_greedy;

class Solution2403_2 {
    public long minimumTime(int[] power) {
        int n = power.length;
        long[] f = new long[1 << n];
        Arrays.fill(f, Long.MAX_VALUE);
        f[0] = 0;
        for (int mask = 1; mask < 1 << n; ++mask) {
            int gain = Integer.bitCount(mask);
            for (int i = 0; i < n; ++i) {
                if ((mask >> i & 1) == 1) {
                    f[mask] = Math.min(f[mask], f[mask ^ 1 << i] + (power[i] + gain - 1) / gain);
                }
            }
        }
        return f[(1 << n) - 1];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2403_2 _tcSol = new Solution2403_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "power = [3,1,4]");
        try {
            int[] power = new int[]{3, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "power = [1,1,4]");
        try {
            int[] power = new int[]{1, 1, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "power = [1,2,4,9]");
        try {
            int[] power = new int[]{1, 2, 4, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.minimumTime(power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}
