package com.leetcode.arrays_hashing_greedy;

class Solution1426 {
    public int countElements(int[] arr) {
        int[] cnt = new int[1001];
        for (int x : arr) {
            ++cnt[x];
        }
        int ans = 0;
        for (int x = 0; x < 1000; ++x) {
            if (cnt[x + 1] > 0) {
                ans += cnt[x];
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
        Solution1426 _tcSol = new Solution1426();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3]");
        try {
            int[] arr = new int[]{1, 2, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.countElements(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,3,3,5,5,7,7]");
        try {
            int[] arr = new int[]{1, 1, 3, 3, 5, 5, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.countElements(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}