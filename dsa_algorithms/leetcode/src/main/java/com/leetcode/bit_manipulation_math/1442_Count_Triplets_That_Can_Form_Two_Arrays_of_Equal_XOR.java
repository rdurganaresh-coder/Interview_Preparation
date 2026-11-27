package com.leetcode.bit_manipulation_math;

class Solution1442 {
    public int countTriplets(int[] arr) {
        int ans = 0, n = arr.length;
        for (int i = 0; i < n; ++i) {
            int s = arr[i];
            for (int k = i + 1; k < n; ++k) {
                s ^= arr[k];
                if (s == 0) {
                    ans += k - i;
                }
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
        Solution1442 _tcSol = new Solution1442();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [2,3,1,6,7]");
        try {
            int[] arr = new int[]{2, 3, 1, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTriplets(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,1,1,1]");
        try {
            int[] arr = new int[]{1, 1, 1, 1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.countTriplets(arr)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}
