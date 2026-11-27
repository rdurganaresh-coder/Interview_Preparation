package com.leetcode.arrays_hashing_greedy;

class Solution1535 {
    public int getWinner(int[] arr, int k) {
        int mx = arr[0];
        for (int i = 1, cnt = 0; i < arr.length; ++i) {
            if (mx < arr[i]) {
                mx = arr[i];
                cnt = 1;
            } else {
                ++cnt;
            }
            if (cnt == k) {
                break;
            }
        }
        return mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1535 _tcSol = new Solution1535();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,1,3,5,4,6,7], k = 2");
        try {
            int[] arr = new int[]{2, 1, 3, 5, 4, 6, 7};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getWinner(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [3,2,1], k = 10");
        try {
            int[] arr = new int[]{3, 2, 1};
            int k = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.getWinner(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}