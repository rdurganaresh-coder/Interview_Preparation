package com.leetcode.arrays_hashing_greedy;

class Solution1497 {
    public boolean canArrange(int[] arr, int k) {
        int[] cnt = new int[k];
        for (int x : arr) {
            ++cnt[(x % k + k) % k];
        }
        for (int i = 1; i < k; ++i) {
            if (cnt[i] != cnt[k - i]) {
                return false;
            }
        }
        return cnt[0] % 2 == 0;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1497 _tcSol = new Solution1497();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5,10,6,7,8,9], k = 5");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5, 10, 6, 7, 8, 9};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.canArrange(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5,6], k = 7");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6};
            int k = 7;
            System.out.println("  Output  : " + _tcShow(_tcSol.canArrange(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5,6], k = 10");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5, 6};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.canArrange(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}