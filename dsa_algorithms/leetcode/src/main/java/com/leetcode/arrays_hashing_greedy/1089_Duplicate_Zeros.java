package com.leetcode.arrays_hashing_greedy;

class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = -1, k = 0;
        while (k < n) {
            ++i;
            k += arr[i] > 0 ? 1 : 2;
        }
        int j = n - 1;
        if (k == n + 1) {
            arr[j--] = 0;
            --i;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            if (arr[i] == 0) {
                arr[--j] = arr[i];
            }
            --i;
            --j;
        }
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1089 _tcSol = new Solution1089();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,0,2,3,0,4,5,0]");
        try {
            int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
            _tcSol.duplicateZeros(arr);
            System.out.println("  Output  : " + _tcShow(arr));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,0,0,2,3,0,0,4]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,2,3]");
        try {
            int[] arr = new int[]{1, 2, 3};
            _tcSol.duplicateZeros(arr);
            System.out.println("  Output  : " + _tcShow(arr));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,2,3]");
        System.out.println();
    }
}