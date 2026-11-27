package com.leetcode.arrays_hashing_greedy;

class Solution0525 {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> d = new HashMap<>();
        d.put(0, -1);
        int ans = 0, s = 0;
        for (int i = 0; i < nums.length; ++i) {
            s += nums[i] == 1 ? 1 : -1;
            if (d.containsKey(s)) {
                ans = Math.max(ans, i - d.get(s));
            } else {
                d.put(s, i);
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
        Solution0525 _tcSol = new Solution0525();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [0,1]");
        try {
            int[] nums = new int[]{0, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [0,1,0]");
        try {
            int[] nums = new int[]{0, 1, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "2");
        System.out.println();

        System.out.println("Test 3");
        System.out.println("  Input   : " + "nums = [0,1,1,1,1,1,0,0,0]");
        try {
            int[] nums = new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0};
            System.out.println("  Output  : " + _tcShow(_tcSol.findMaxLength(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "6");
        System.out.println();
    }
}