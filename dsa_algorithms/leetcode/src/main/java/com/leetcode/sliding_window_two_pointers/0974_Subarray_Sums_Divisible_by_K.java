package com.leetcode.sliding_window_two_pointers;

class Solution0974 {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        int ans = 0, s = 0;
        for (int x : nums) {
            s = ((s + x) % k + k) % k;
            ans += cnt.getOrDefault(s, 0);
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
        Solution0974 _tcSol = new Solution0974();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,5,0,-2,-3,1], k = 5");
        try {
            int[] nums = new int[]{4, 5, 0, -2, -3, 1};
            int k = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysDivByK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "7");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5], k = 9");
        try {
            int[] nums = new int[]{5};
            int k = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.subarraysDivByK(nums, k)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}