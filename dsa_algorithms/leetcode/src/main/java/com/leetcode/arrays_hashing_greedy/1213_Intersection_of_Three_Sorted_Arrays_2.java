package com.leetcode.arrays_hashing_greedy;

class Solution1213_2 {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> ans = new ArrayList<>();
        for (int x : arr1) {
            int i = Arrays.binarySearch(arr2, x);
            int j = Arrays.binarySearch(arr3, x);
            if (i >= 0 && j >= 0) {
                ans.add(x);
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
        Solution1213_2 _tcSol = new Solution1213_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]");
        try {
            int[] arr1 = new int[]{1, 2, 3, 4, 5};
            int[] arr2 = new int[]{1, 2, 5, 7, 9};
            int[] arr3 = new int[]{1, 3, 4, 5, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.arraysIntersection(arr1, arr2, arr3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[1,5]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]");
        try {
            int[] arr1 = new int[]{197, 418, 523, 876, 1356};
            int[] arr2 = new int[]{501, 880, 1593, 1710, 1870};
            int[] arr3 = new int[]{521, 682, 1337, 1395, 1764};
            System.out.println("  Output  : " + _tcShow(_tcSol.arraysIntersection(arr1, arr2, arr3)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[]");
        System.out.println();
    }
}