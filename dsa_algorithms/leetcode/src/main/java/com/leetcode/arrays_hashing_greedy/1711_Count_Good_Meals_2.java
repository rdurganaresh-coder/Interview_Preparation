package com.leetcode.arrays_hashing_greedy;

class Solution1711_2 {
    private static final int MOD = (int) 1e9 + 7;

    public int countPairs(int[] deliciousness) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int d : deliciousness) {
            cnt.put(d, cnt.getOrDefault(d, 0) + 1);
        }
        long ans = 0;
        for (int i = 0; i < 22; ++i) {
            int s = 1 << i;
            for (var x : cnt.entrySet()) {
                int a = x.getKey(), m = x.getValue();
                int b = s - a;
                if (!cnt.containsKey(b)) {
                    continue;
                }
                ans += 1L * m * (a == b ? m - 1 : cnt.get(b));
            }
        }
        ans >>= 1;
        return (int) (ans % MOD);
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1711_2 _tcSol = new Solution1711_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "deliciousness = [1,3,5,7,9]");
        try {
            int[] deliciousness = new int[]{1, 3, 5, 7, 9};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(deliciousness)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "deliciousness = [1,1,1,3,3,3,7]");
        try {
            int[] deliciousness = new int[]{1, 1, 1, 3, 3, 3, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.countPairs(deliciousness)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "15");
        System.out.println();
    }
}