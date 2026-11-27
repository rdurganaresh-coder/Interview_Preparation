package com.leetcode.sliding_window_two_pointers;

class Solution0560 {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int ans = 0, s = 0;
        for (int x : nums) {
            s += x;
            ans += cnt.getOrDefault(s - k, 0);
            cnt.merge(s, 1, Integer::sum);
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution0560 _tcSol = new Solution0560();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,1,1], k = 2");
        try {
            int[] nums = new int[]{1, 1, 1};
            int k = 2;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,3], k = 3");
        try {
            int[] nums = new int[]{1, 2, 3};
            int k = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraySum(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();
    }
}