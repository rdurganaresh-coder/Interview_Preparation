package com.leetcode.arrays_hashing_greedy;

class Solution1385 {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int ans = 0;
        for (int x : arr1) {
            int i = Arrays.binarySearch(arr2, x - d);
            i = i < 0 ? -i - 1 : i;
            if (i == arr2.length || arr2[i] > x + d) {
                ++ans;
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
        Solution1385 _tcSol = new Solution1385();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [4,5,8], arr2 = [10,9,1,8], d = 2");
        try {
            int[] arr1 = new int[]{4, 5, 8};
            int[] arr2 = new int[]{10, 9, 1, 8};
            int d = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheDistanceValue(arr1, arr2, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [1,4,2,3], arr2 = [-4,-3,6,10,20,30], d = 3");
        try {
            int[] arr1 = new int[]{1, 4, 2, 3};
            int[] arr2 = new int[]{-4, -3, 6, 10, 20, 30};
            int d = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheDistanceValue(arr1, arr2, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr1 = [2,1,100,3], arr2 = [-5,-2,10,-3,7], d = 6");
        try {
            int[] arr1 = new int[]{2, 1, 100, 3};
            int[] arr2 = new int[]{-5, -2, 10, -3, 7};
            int d = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.findTheDistanceValue(arr1, arr2, d)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();
    }
}
