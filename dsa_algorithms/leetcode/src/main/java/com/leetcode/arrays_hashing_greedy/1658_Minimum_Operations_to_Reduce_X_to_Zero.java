package com.leetcode.arrays_hashing_greedy;

class Solution1658 {
    public int minOperations(int[] nums, int x) {
        int s = -x;
        for (int v : nums) {
            s += v;
        }
        Map<Integer, Integer> vis = new HashMap<>();
        vis.put(0, -1);
        int mx = -1, t = 0;
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            t += nums[i];
            vis.putIfAbsent(t, i);
            if (vis.containsKey(t - s)) {
                mx = Math.max(mx, i - vis.get(t - s));
            }
        }
        return mx == -1 ? -1 : n - mx;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1658 _tcSol = new Solution1658();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,4,2,3], x = 5");
        try {
            int[] nums = new int[]{1, 1, 4, 2, 3};
            int x = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,6,7,8,9], x = 4");
        try {
            int[] nums = new int[]{5, 6, 7, 8, 9};
            int x = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [3,2,20,1,1,3], x = 10");
        try {
            int[] nums = new int[]{3, 2, 20, 1, 1, 3};
            int x = 10;
            System.out.println("  Output  : " + _tcShow(_tcSol.minOperations(nums, x)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "5");
        System.out.println();
    }
}