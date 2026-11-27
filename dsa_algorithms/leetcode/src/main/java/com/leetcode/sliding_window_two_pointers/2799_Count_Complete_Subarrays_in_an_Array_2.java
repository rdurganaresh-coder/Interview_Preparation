package com.leetcode.sliding_window_two_pointers;

class Solution2799_2 {
    public int countCompleteSubarrays(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>();
        for (int x : nums) {
            d.put(x, 1);
        }
        int cnt = d.size();
        int ans = 0, n = nums.length;
        d.clear();
        for (int i = 0, j = 0; j < n; ++j) {
            d.merge(nums[j], 1, Integer::sum);
            while (d.size() == cnt) {
                ans += n - j;
                if (d.merge(nums[i], -1, Integer::sum) == 0) {
                    d.remove(nums[i]);
                }
                ++i;
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
        Solution2799_2 _tcSol = new Solution2799_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,3,1,2,2]");
        try {
            int[] nums = new int[]{1, 3, 1, 2, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "4");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [5,5,5,5]");
        try {
            int[] nums = new int[]{5, 5, 5, 5};
            System.out.println("  Output  : " + _tcShow(_tcSol.countCompleteSubarrays(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "10");
        System.out.println();
    }
}