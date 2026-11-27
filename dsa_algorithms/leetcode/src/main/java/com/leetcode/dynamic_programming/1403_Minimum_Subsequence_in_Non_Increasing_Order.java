package com.leetcode.dynamic_programming;

class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        int s = Arrays.stream(nums).sum();
        int t = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            t += nums[i];
            ans.add(nums[i]);
            if (t > s - t) {
                break;
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
        Solution1403 _tcSol = new Solution1403();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,10,9,8]");
        try {
            int[] nums = new int[]{4, 3, 10, 9, 8};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubsequence(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[10,9]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [4,4,7,6,7]");
        try {
            int[] nums = new int[]{4, 4, 7, 6, 7};
            System.out.println("  Output  : " + _tcShow(_tcSol.minSubsequence(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[7,7,6]");
        System.out.println();
    }
}