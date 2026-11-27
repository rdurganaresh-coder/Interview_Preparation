package com.leetcode.arrays_hashing_greedy;

class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        if (arr.length < m * k) {
            return false;
        }
        int cnt = 0, target = (k - 1) * m;
        for (int i = m; i < arr.length; ++i) {
            if (arr[i] == arr[i - m]) {
                if (++cnt == target) {
                    return true;
                }
            } else {
                cnt = 0;
            }
        }
        return false;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1566 _tcSol = new Solution1566();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,4,4,4,4], m = 1, k = 3");
        try {
            int[] arr = new int[]{1, 2, 4, 4, 4, 4};
            int m = 1;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsPattern(arr, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,1,2,1,1,1,3], m = 2, k = 2");
        try {
            int[] arr = new int[]{1, 2, 1, 2, 1, 1, 1, 3};
            int m = 2;
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsPattern(arr, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [1,2,1,2,1,3], m = 2, k = 3");
        try {
            int[] arr = new int[]{1, 2, 1, 2, 1, 3};
            int m = 2;
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.containsPattern(arr, m, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}
