package com.leetcode.arrays_hashing_greedy;

class Solution1151 {
    public int minSwaps(int[] data) {
        int k = 0;
        for (int v : data) {
            k += v;
        }
        int t = 0;
        for (int i = 0; i < k; ++i) {
            t += data[i];
        }
        int mx = t;
        for (int i = k; i < data.length; ++i) {
            t += data[i];
            t -= data[i - k];
            mx = Math.max(mx, t);
        }
        return k - mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1151 _tcSol = new Solution1151();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "data = [1,0,1,0,1]");
        try {
            int[] data = new int[]{1, 0, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(data)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "data = [0,0,0,1,0]");
        try {
            int[] data = new int[]{0, 0, 0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(data)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "data = [1,0,1,0,1,0,0,1,1,0,1]");
        try {
            int[] data = new int[]{1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSwaps(data)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();
    }
}