package com.leetcode.sliding_window_two_pointers;

class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }
        int cnt = s.size();
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            s.clear();
            for (int j = i; j < n; ++j) {
                s.add(nums[j]);
                if (s.size() == cnt) {
                    ++ans;
                }
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
        Solution2799 _tcSol = new Solution2799();
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