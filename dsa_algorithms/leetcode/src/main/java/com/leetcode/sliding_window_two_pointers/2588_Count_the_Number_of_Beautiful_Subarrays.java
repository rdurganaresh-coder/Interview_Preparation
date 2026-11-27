package com.leetcode.sliding_window_two_pointers;

class Solution2588 {
    public long beautifulSubarrays(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        cnt.put(0, 1);
        long ans = 0;
        int mask = 0;
        for (int x : nums) {
            mask ^= x;
            ans += cnt.merge(mask, 1, Integer::sum) - 1;
        }
        return ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2588 _tcSol = new Solution2588();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,1,2,4]");
        try {
            int[] nums = new int[]{4, 3, 1, 2, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,10,4]");
        try {
            int[] nums = new int[]{1, 10, 4};
            System.out.println("  Output  : " + _tcShow(_tcSol.beautifulSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}
