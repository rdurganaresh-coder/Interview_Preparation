package com.leetcode.arrays_hashing_greedy;

class Solution1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> pos = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; ++i) {
            pos.put(arr2[i], i);
        }
        int[][] arr = new int[arr1.length][0];
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = new int[] {arr1[i], pos.getOrDefault(arr1[i], arr2.length + arr1[i])};
        }
        Arrays.sort(arr, (a, b) -> a[1] - b[1]);
        for (int i = 0; i < arr.length; ++i) {
            arr1[i] = arr[i][0];
        }
        return arr1;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1122 _tcSol = new Solution1122();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]");
        try {
            int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
            int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.relativeSortArray(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2,2,2,1,4,3,3,9,6,7,19]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]");
        try {
            int[] arr1 = new int[]{28, 6, 22, 8, 44, 17};
            int[] arr2 = new int[]{22, 28, 8, 6};
            System.out.println("  Output  : " + _tcShow(_tcSol.relativeSortArray(arr1, arr2)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[22,28,8,6,17,44]");
        System.out.println();
    }
}