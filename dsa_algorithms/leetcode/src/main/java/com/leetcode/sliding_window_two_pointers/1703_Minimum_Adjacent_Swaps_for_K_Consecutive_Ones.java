package com.leetcode.sliding_window_two_pointers;

class Solution1703 {
    public int minMoves(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            if (nums[i] != 0) {
                arr.add(i);
            }
        }
        int m = arr.size();
        long[] s = new long[m + 1];
        for (int i = 0; i < m; ++i) {
            s[i + 1] = s[i] + arr.get(i);
        }
        long ans = 1L << 60;
        int x = (k + 1) / 2;
        int y = k - x;
        for (int i = x - 1; i < m - y; ++i) {
            int j = arr.get(i);
            long ls = s[i + 1] - s[i + 1 - x];
            long rs = s[i + 1 + y] - s[i + 1];
            long a = (j + j - x + 1L) * x / 2 - ls;
            long b = rs - (j + 1L + j + y) * y / 2;
            ans = Math.min(ans, a + b);
        }
        return (int) ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1703 _tcSol = new Solution1703();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,0,0,1,0,1], k = 2");
        try {
            int[] nums = new int[]{1, 0, 0, 1, 0, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,0,0,0,0,0,1,1], k = 3");
        try {
            int[] nums = new int[]{1, 0, 0, 0, 0, 0, 1, 1};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,1,0,1], k = 2");
        try {
            int[] nums = new int[]{1, 1, 0, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}