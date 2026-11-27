package com.leetcode.arrays_hashing_greedy;

class Solution1471 {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int m = arr[(arr.length - 1) >> 1];
        List<Integer> nums = new ArrayList<>();
        for (int v : arr) {
            nums.add(v);
        }
        nums.sort((a, b) -> {
            int x = Math.abs(a - m);
            int y = Math.abs(b - m);
            return x == y ? b - a : y - x;
        });
        int[] ans = new int[k];
        for (int i = 0; i < k; ++i) {
            ans[i] = nums.get(i);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1471 _tcSol = new Solution1471();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "arr = [1,2,3,4,5], k = 2");
        try {
            int[] arr = new int[]{1, 2, 3, 4, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getStrongest(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,1]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "arr = [1,1,3,5,5], k = 2");
        try {
            int[] arr = new int[]{1, 1, 3, 5, 5};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.getStrongest(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,5]");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "arr = [6,7,11,7,6,8], k = 5");
        try {
            int[] arr = new int[]{6, 7, 11, 7, 6, 8};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.getStrongest(arr, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[11,8,6,6,7]");
        System.out.println();
    }
}