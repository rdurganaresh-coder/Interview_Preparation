package com.leetcode.dynamic_programming;

class Solution1013 {
    public boolean canThreePartsEqualSum(int[] arr) {
        int s = Arrays.stream(arr).sum();
        if (s % 3 != 0) {
            return false;
        }
        s /= 3;
        int cnt = 0, t = 0;
        for (int x : arr) {
            t += x;
            if (t == s) {
                cnt++;
                t = 0;
            }
        }
        return cnt >= 3;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1013 _tcSol = new Solution1013();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [0,2,1,-6,6,-7,9,1,2,0,1]");
        try {
            int[] arr = new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.canThreePartsEqualSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [0,2,1,-6,6,7,9,-1,2,0,1]");
        try {
            int[] arr = new int[]{0, 2, 1, -6, 6, 7, 9, -1, 2, 0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.canThreePartsEqualSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [3,3,6,5,-2,2,5,1,-9,4]");
        try {
            int[] arr = new int[]{3, 3, 6, 5, -2, 2, 5, 1, -9, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canThreePartsEqualSum(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();
    }
}
