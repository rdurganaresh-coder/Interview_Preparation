package com.leetcode.arrays_hashing_greedy;

class Solution1711 {
    private static final int MOD = (int) 1e9 + 7;

    public int countPairs(int[] deliciousness) {
        int mx = Arrays.stream(deliciousness).max().getAsInt() << 1;
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int d : deliciousness) {
            for (int s = 1; s <= mx; s <<= 1) {
                ans = (ans + cnt.getOrDefault(s - d, 0)) % MOD;
            }
            cnt.merge(d, 1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1711 _tcSol = new Solution1711();
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