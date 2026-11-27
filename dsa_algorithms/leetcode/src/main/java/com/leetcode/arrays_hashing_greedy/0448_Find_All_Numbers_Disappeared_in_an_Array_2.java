package com.leetcode.arrays_hashing_greedy;

class Solution0448_2 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int x : nums) {
            int i = Math.abs(x) - 1;
            if (nums[i] > 0) {
                nums[i] *= -1;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
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
        Solution0448_2 _tcSol = new Solution0448_2();
        System.out.println("Test 1");
        System.out.println("  Input   : " + "nums = [4,3,2,7,8,2,3,1]");
        try {
            int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDisappearedNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[5,6]");
        System.out.println();

        System.out.println("Test 2");
        System.out.println("  Input   : " + "nums = [1,1]");
        try {
            int[] nums = new int[]{1, 1};
            System.out.println("  Output  : " + _tcShow(_tcSol.findDisappearedNumbers(nums)));
        } catch (Throwable e) {
            System.out.println("  Output  : ERROR " + e);
        }
        System.out.println("  Expected: " + "[2]");
        System.out.println();
    }
}