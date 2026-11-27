package com.leetcode.arrays_hashing_greedy;

class Solution0697 {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        int degree = 0;
        for (int i = 0; i < nums.length; ++i) {
            int v = nums[i];
            cnt.put(v, cnt.getOrDefault(v, 0) + 1);
            degree = Math.max(degree, cnt.get(v));
            if (!left.containsKey(v)) {
                left.put(v, i);
            }
            right.put(v, i);
        }
        int ans = 1000000;
        for (int v : nums) {
            if (cnt.get(v) == degree) {
                int t = right.get(v) - left.get(v) + 1;
                if (ans > t) {
                    ans = t;
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
        Solution0697 _tcSol = new Solution0697();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [1,2,2,3,1]");
        try {
            int[] nums = new int[]{1, 2, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestSubArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,2,2,3,1,4,2]");
        try {
            int[] nums = new int[]{1, 2, 2, 3, 1, 4, 2};
            System.out.println("  Output  : " + _tcShow(_tcSol.findShortestSubArray(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}