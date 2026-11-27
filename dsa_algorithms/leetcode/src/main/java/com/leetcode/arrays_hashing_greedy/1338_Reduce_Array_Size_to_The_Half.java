package com.leetcode.arrays_hashing_greedy;

class Solution1338 {
    public int minSetSize(int[] arr) {
        int mx = 0;
        for (int x : arr) {
            mx = Math.max(mx, x);
        }
        int[] cnt = new int[mx + 1];
        for (int x : arr) {
            ++cnt[x];
        }
        Arrays.sort(cnt);
        int ans = 0;
        int m = 0;
        for (int i = mx;; --i) {
            if (cnt[i] > 0) {
                m += cnt[i];
                ++ans;
                if (m * 2 >= arr.length) {
                    return ans;
                }
            }
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1338 _tcSol = new Solution1338();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,3,3,3,5,5,5,2,2,7]");
        try {
            int[] arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSetSize(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [7,7,7,7,7,7]");
        try {
            int[] arr = new int[]{7, 7, 7, 7, 7, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSetSize(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}