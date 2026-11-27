package com.leetcode.arrays_hashing_greedy;

class Solution2453 {
    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int v : nums) {
            v %= space;
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
        }
        int ans = 0, mx = 0;
        for (int v : nums) {
            int t = cnt.get(v % space);
            if (t > mx || (t == mx && v < ans)) {
                ans = v;
                mx = t;
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
        Solution2453 _tcSol = new Solution2453();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,7,8,1,1,5], space = 2");
        try {
            int[] nums = new int[]{3, 7, 8, 1, 1, 5};
            int space = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.destroyTargets(nums, space)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,3,5,2,4,6], space = 2");
        try {
            int[] nums = new int[]{1, 3, 5, 2, 4, 6};
            int space = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.destroyTargets(nums, space)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [6,2,5], space = 100");
        try {
            int[] nums = new int[]{6, 2, 5};
            int space = 100;
            System.out.println("  Output  : " + _tcShow(_tcSol.destroyTargets(nums, space)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}