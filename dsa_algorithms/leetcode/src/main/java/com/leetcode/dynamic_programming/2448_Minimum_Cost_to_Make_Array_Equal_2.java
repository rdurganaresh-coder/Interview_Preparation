package com.leetcode.dynamic_programming;

class Solution2448_2 {
    public long minCost(int[] nums, int[] cost) {
        int n = nums.length;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; ++i) {
            arr[i] = new int[] {nums[i], cost[i]};
        }
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        long mid = sum(cost) / 2;
        long s = 0, ans = 0;
        for (var e : arr) {
            int x = e[0], c = e[1];
            s += c;
            if (s > mid) {
                for (var t : arr) {
                    ans += (long) Math.abs(t[0] - x) * t[1];
                }
                break;
            }
        }
        return ans;
    }

    private long sum(int[] arr) {
        long s = 0;
        for (int v : arr) {
            s += v;
        }
        return s;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2448_2 _tcSol = new Solution2448_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,5,2], cost = [2,3,1,14]");
        try {
            int[] nums = new int[]{1, 3, 5, 2};
            int[] cost = new int[]{2, 3, 1, 14};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "8");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [2,2,2,2,2], cost = [4,2,8,1,3]");
        try {
            int[] nums = new int[]{2, 2, 2, 2, 2};
            int[] cost = new int[]{4, 2, 8, 1, 3};
            System.out.println("  Output  : " + _tcShow(_tcSol.minCost(nums, cost)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}