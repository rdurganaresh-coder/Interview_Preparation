package com.leetcode.arrays_hashing_greedy;

class Solution1590 {
    public int minSubarray(int[] nums, int p) {
        int k = 0;
        for (int x : nums) {
            k = (k + x) % p;
        }
        if (k == 0) {
            return 0;
        }
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);
        int n = nums.length;
        int ans = n;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            int target = (cur - k + p) % p;
            if (last.containsKey(target)) {
                ans = Math.min(ans, i - last.get(target));
            }
            last.put(cur, i);
        }
        return ans == n ? -1 : ans;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution1590 _tcSol = new Solution1590();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [3,1,4,2], p = 6");
        try {
            int[] nums = new int[]{3, 1, 4, 2};
            int p = 6;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubarray(nums, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "1");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [6,3,5,2], p = 9");
        try {
            int[] nums = new int[]{6, 3, 5, 2};
            int p = 9;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubarray(nums, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [1,2,3], p = 3");
        try {
            int[] nums = new int[]{1, 2, 3};
            int p = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubarray(nums, p)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "0");
        System.out.println();
    }
}