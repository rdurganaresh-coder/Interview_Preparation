package com.leetcode.arrays_hashing_greedy;

class Solution1674 {
    public int minMoves(int[] nums, int limit) {
        int[] d = new int[2 * limit + 2];
        int n = nums.length;
        for (int i = 0; i < n / 2; ++i) {
            int x = Math.min(nums[i], nums[n - i - 1]);
            int y = Math.max(nums[i], nums[n - i - 1]);
            d[2] += 2;
            d[x + 1] -= 2;
            d[x + 1] += 1;
            d[x + y] -= 1;
            d[x + y + 1] += 1;
            d[y + limit + 1] -= 1;
            d[y + limit + 1] += 2;
        }
        int ans = n;
        for (int i = 2, s = 0; i < d.length; ++i) {
            s += d[i];
            ans = Math.min(ans, s);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1674 _tcSol = new Solution1674();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,4,3], limit = 4");
        try {
            int[] nums = new int[]{1, 2, 4, 3};
            int limit = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2,1], limit = 2");
        try {
            int[] nums = new int[]{1, 2, 2, 1};
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,1,2], limit = 2");
        try {
            int[] nums = new int[]{1, 2, 1, 2};
            int limit = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.minMoves(nums, limit)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}