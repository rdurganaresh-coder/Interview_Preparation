package com.leetcode.arrays_hashing_greedy;

class Solution1502 {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        int d = arr[1] - arr[0];
        for (int i = 2; i < arr.length; ++i) {
            if (arr[i] - arr[i - 1] != d) {
                return false;
            }
        }
        return true;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1502 _tcSol = new Solution1502();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,5,1]");
        try {
            int[] arr = new int[]{3, 5, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeArithmeticProgression(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "true");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,4]");
        try {
            int[] arr = new int[]{1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.canMakeArithmeticProgression(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "false");
        System.out.println();
    }
}