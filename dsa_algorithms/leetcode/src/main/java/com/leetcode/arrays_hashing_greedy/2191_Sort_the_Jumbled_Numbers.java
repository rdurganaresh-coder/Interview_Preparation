package com.leetcode.arrays_hashing_greedy;

class Solution2191 {
    private int[] mapping;

    public int[] sortJumbled(int[] mapping, int[] nums) {
        this.mapping = mapping;
        int n = nums.length;
        int[][] arr = new int[n][0];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {f(nums[i]), i};
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] ans = new int[n];
        for (int i = 0; i < n; ++i) {
            ans[i] = nums[arr[i][1]];
        }
        return ans;
    }

    private int f(int x) {
        if (x == 0) {
            return mapping[0];
        }
        int y = 0;
        for (int k = 1; x > 0; x /= 10) {
            int v = mapping[x % 10];
            y = k * v + y;
            k *= 10;
        }
        return y;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2191 _tcSol = new Solution2191();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "mapping = [8,9,4,0,2,1,3,5,7,6], nums = [991,338,38]");
        try {
            int[] mapping = new int[]{8, 9, 4, 0, 2, 1, 3, 5, 7, 6};
            int[] nums = new int[]{991, 338, 38};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortJumbled(mapping, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[338,38,991]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "mapping = [0,1,2,3,4,5,6,7,8,9], nums = [789,456,123]");
        try {
            int[] mapping = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
            int[] nums = new int[]{789, 456, 123};
            System.out.println("  Output  : " + _tcShow(_tcSol.sortJumbled(mapping, nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[123,456,789]");
        System.out.println();
    }
}