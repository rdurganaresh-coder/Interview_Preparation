package com.leetcode.arrays_hashing_greedy;

class Solution1524 {
    public int numOfSubarrays(int[] arr) {
        int[] cnt = {1, 0};
        int ans = 0, s = 0;
        final int mod = (int) 1e9 + 7;
        for (int x : arr) {
            s = (s + x) % 2;
            ans = (ans + cnt[s ^ 1]) % mod;
            ++cnt[s];
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1524 _tcSol = new Solution1524();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,3,5]");
        try {
            int[] arr = new int[]{1, 3, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [2,4,6]");
        try {
            int[] arr = new int[]{2, 4, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5,6,7]");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.numOfSubarrays(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "16");
        System.out.println();
    }
}
