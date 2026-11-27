package com.leetcode.arrays_hashing_greedy;

class Solution3186_2 {
    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        Map<Integer, Integer> cnt = new HashMap<>(n);
        int[] nxt = new int[n];
        for (int i = 0; i < n; ++i) {
            cnt.merge(power[i], 1, Integer::sum);
            int l = Arrays.binarySearch(power, power[i] + 3);
            l = l < 0 ? -l - 1 : l;
            nxt[i] = l;
        }
        long[] f = new long[n + 1];
        for (int i = n - 1; i >= 0; --i) {
            int j = i + cnt.get(power[i]);
            long a = j <= n ? f[j] : 0;
            long b = 1L * power[i] * cnt.get(power[i]) + f[nxt[i]];
            f[i] = Math.max(a, b);
        }
        return f[0];
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3186_2 _tcSol = new Solution3186_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "power = [1,1,3,4]");
        try {
            int[] power = new int[]{1, 1, 3, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalDamage(power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "power = [7,1,6,6]");
        try {
            int[] power = new int[]{7, 1, 6, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.maximumTotalDamage(power)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "13");
        System.out.println();
    }
}
