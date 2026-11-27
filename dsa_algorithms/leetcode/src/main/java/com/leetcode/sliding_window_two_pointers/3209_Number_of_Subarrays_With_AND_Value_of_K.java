package com.leetcode.sliding_window_two_pointers;

class Solution3209 {
    public long countSubarrays(int[] nums, int k) {
        long ans = 0;
        Map<Integer, Integer> pre = new HashMap<>();
        for (int x : nums) {
            Map<Integer, Integer> cur = new HashMap<>();
            for (var e : pre.entrySet()) {
                int y = e.getKey(), v = e.getValue();
                cur.merge(x & y, v, Integer::sum);
            }
            cur.merge(x, 1, Integer::sum);
            ans += cur.getOrDefault(k, 0);
            pre = cur;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution3209 _tcSol = new Solution3209();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 1");
        try {
            int[] nums = new int[]{1, 1, 1};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,2], k = 1");
        try {
            int[] nums = new int[]{1, 1, 2};
            int k = 1;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "3");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 2");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.countSubarrays(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}