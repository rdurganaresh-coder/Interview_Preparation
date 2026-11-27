package com.leetcode.sliding_window_two_pointers;

class Solution2875 {
    public int minSizeSubarray(int[] nums, int target) {
        long s = Arrays.stream(nums).asLongStream().sum();
        int n = nums.length;
        int a = 0;
        if (target > s) {
            a = n * (target / (int) s);
            target -= target / s * s;
        }
        if (target == s) {
            return n;
        }
        Map<Long, Integer> pos = new HashMap<>();
        pos.put(0L, -1);
        long pre = 0;
        int b = 1 << 30;
        for (int i = 0; i < n; ++i) {
            pre += nums[i];
            if (pos.containsKey(pre - target)) {
                b = Math.min(b, i - pos.get(pre - target));
            }
            if (pos.containsKey(pre - (s - target))) {
                b = Math.min(b, n - (i - pos.get(pre - (s - target))));
            }
            pos.put(pre, i);
        }
        return b == 1 << 30 ? -1 : a + b;
    }

    // ===== Generated test cases (from the problem examples) =====
    private static String _tcShow(Object o) {
        String s = java.util.Arrays.deepToString(new Object[] {o});
        return s.substring(1, s.length() - 1);
    }

    public static void main(String[] args) {
        Solution2875 _tcSol = new Solution2875();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,3], target = 5");
        try {
            int[] nums = new int[]{1, 2, 3};
            int target = 5;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSizeSubarray(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1,1,2,3], target = 4");
        try {
            int[] nums = new int[]{1, 1, 1, 2, 3};
            int target = 4;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSizeSubarray(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [2,4,6,8], target = 3");
        try {
            int[] nums = new int[]{2, 4, 6, 8};
            int target = 3;
            System.out.println("  Output  : " + _tcShow(_tcSol.minSizeSubarray(nums, target)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "-1");
        System.out.println();
    }
}