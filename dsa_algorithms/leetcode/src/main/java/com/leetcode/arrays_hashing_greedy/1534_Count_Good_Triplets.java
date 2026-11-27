package com.leetcode.arrays_hashing_greedy;

class Solution1534 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = j + 1; k < n; ++k) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b
                        && Math.abs(arr[i] - arr[k]) <= c) {
                        ++ans;
                    }
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
        Solution1534 _tcSol = new Solution1534();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [3,0,1,1,9,7], a = 7, b = 2, c = 3");
        try {
            int[] arr = new int[]{3, 0, 1, 1, 9, 7};
            int a = 7;
            int b = 2;
            int c = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodTriplets(arr, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,2,2,3], a = 0, b = 0, c = 1");
        try {
            int[] arr = new int[]{1, 1, 2, 2, 3};
            int a = 0;
            int b = 0;
            int c = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countGoodTriplets(arr, a, b, c)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}