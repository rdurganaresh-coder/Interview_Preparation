package com.leetcode.arrays_hashing_greedy;

class Solution2403 {
    private int n;
    private int[] power;
    private Long[] f;

    public long minimumTime(int[] power) {
        n = power.length;
        this.power = power;
        f = new Long[1 << n];
        return dfs((1 << n) - 1);
    }

    private long dfs(int mask) {
        if (mask == 0) {
            return 0;
        }
        if (f[mask] != null) {
            return f[mask];
        }
        f[mask] = Long.MAX_VALUE;
        int gain = 1 + (n - Integer.bitCount(mask));
        for (int i = 0; i < n; ++i) {
            if ((mask >> i & 1) == 1) {
                f[mask] = Math.min(f[mask], dfs(mask ^ 1 << i) + (power[i] + gain - 1) / gain);
            }
        }
        return f[mask];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2403 _tcSol = new Solution2403();
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
